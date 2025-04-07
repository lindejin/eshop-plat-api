package com.eshop.util.excel;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.URLUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.eshop.entity.file.TbImg;
import com.eshop.entity.order.TbOrderProducts;
import com.eshop.entity.order.TbOrderRequestBody;
import com.eshop.service.config.ITbShopService;
import com.eshop.service.file.ITbImgService;
import com.eshop.service.order.ITbOrderProductsService;
import com.eshop.service.order.ITbOrderRequestBodyService;
import com.eshop.service.order.ITbOrderService;
import com.eshop.util.*;
import com.eshop.util.minio.MinioFileUtils;
import com.eshop.util.minio.RetCode;
import com.eshop.util.minio.SysFile;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.tika.detect.DefaultDetector;
import org.apache.tika.detect.Detector;
import org.apache.tika.io.TikaInputStream;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.mime.MediaType;
import org.apache.tika.mime.MimeType;
import org.apache.tika.mime.MimeTypes;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 线上读取下载地址
 */
@Slf4j
@SpringBootTest
public class ExcelReaderTest4 {
    /**
     * 文件下载 敦煌
     */
    public final static String FILE_DOWNLOAD_DHGATE_IMAGE_NET = "https://image.dhgate.com/";

    @Resource
    private ITbOrderProductsService iTbOrderProductsService;

    @Resource
    private RestTemplate restTemplate;

    @Resource(name = "excelTaskPool")
    private Executor excelTaskPool;

    @Autowired
    protected MinioFileUtils minioFileUtils;

    @Autowired
    protected ITbImgService iTbImgService;

    @Autowired
    protected QueryTest queryTest;

    @Autowired
    protected OrderJsonTest orderJsonTest;

    @Test
    public void testReadExcelToTbImg() throws Exception {
        List<TbOrderProducts> imgList = queryTest.getOpListConcurrently() ;
        Set<String> orderNos = imgList.stream().map(TbOrderProducts::getOrderNo).collect(Collectors.toSet());
        List<ShopeeOrderDetailRespVO> orderJSONList = orderJsonTest.getOrderJSON(orderNos);
        Map<Long, TbOrderProducts> opMap = imgList.stream().collect(Collectors.toMap(TbOrderProducts::getId, Function.identity(), (o1, o2) -> o1));
        Map<String, String> skuImgMap = getSkuImgMap(orderJSONList);
        // 2. 批量提交异步任务
        List<CompletableFuture<Void>> futures = imgList.stream()
                .map(op -> CompletableFuture.runAsync(() -> {
                    try {
                        TbOrderProducts tbOrderProducts1 = opMap.get(op.getId());
                        if (tbOrderProducts1 != null && tbOrderProducts1.getSkuImgId() != null) {
                            return;
                        }
                        Long platformSkuId = op.getPlatformSkuId();
                        String orderNo = op.getOrderNo();
                        String url = skuImgMap.get(orderNo + platformSkuId);
                        System.out.println(url);
                        if (StringUtils.isBlank(url)) {
                            return;
                        }

                        Long imgId = download(url, 3);
                        TbOrderProducts up = new TbOrderProducts();
                        up.setId(op.getId());
                        up.setSkuImgId(imgId);

                        iTbOrderProductsService.updateById(up);
                    } catch (Exception e) {
                        log.error("处理失败: URL={}, Error={}", op.getOrderNo(), e.getMessage());
                    }
                }, excelTaskPool))
                .collect(Collectors.toList());

        // 3. 等待所有任务完成（带超时）
        try {
            CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]))
                    .get(30, TimeUnit.MINUTES); // 设置总超时时间
        } catch (TimeoutException e) {
            log.warn("部分任务超时未完成");
        } finally {
//            executor.shutdown(); // 关闭线程池
        }
    }

    private Map<String, String> getSkuImgMap(List<ShopeeOrderDetailRespVO> orderJSONList) {
        Map<String, String> skuImgMap = new HashMap<>();
        try {
            for (ShopeeOrderDetailRespVO body : orderJSONList) {
                try {
                    ShopeeOrderDetailResponse response = body.getResponse();
                    if (response == null){
                        System.out.println(body.getRespBody());
                        continue;
                    }
                    if (response.getOrder_list() == null || response.getOrder_list().size() == 0){
                        continue;
                    }
                    ShopeeOrderDetailItem shopeeOrderDetailItem = response.getOrder_list().get(0);
                    String orderNo = shopeeOrderDetailItem.getOrder_sn();

                    List<ShopeeOrderDetailItemListItem> itemList = shopeeOrderDetailItem.getItem_list();

                    for (ShopeeOrderDetailItemListItem shopeeOrderDetailItemListItem : itemList) {
                        try {
                            Long modelId = shopeeOrderDetailItemListItem.getModel_id();
                            ShopeeOrderDetailImageInfo imageInfo = shopeeOrderDetailItemListItem.getImage_info();
                            String imageUrl = imageInfo.getImage_url();
                            if (modelId !=null && StringUtils.isNotBlank(imageUrl)) {
                                skuImgMap.put(orderNo + modelId, imageUrl);
                            }
                        } catch (Exception e) {

                        }
                    }
                } catch (Exception e) {

                }
            }
        } catch (Exception e) {

        }
        return skuImgMap;
    }


    public Long download(String uri, int maxRetryCount) {
        if (uri.indexOf("http") == -1) {
            uri = FILE_DOWNLOAD_DHGATE_IMAGE_NET + uri;
            uri = uri.replace("100x100", "0x0");
        }
        String tempUrl = uri;
        for (int i = 0; i < maxRetryCount; i++) {
            try {
                RestTemplate restTemplate = createRestTemplateWithTimeout();
                byte[] content = getBytes(uri, restTemplate);

                String uuid = UUID.randomUUID().toString().replaceAll("-", "");
                uri = URLUtil.getPath(uri);

                String suffix = null;
                try {
                    suffix = uri.substring(uri.lastIndexOf("."));
                } catch (Exception e) {
                    // 利用 tika 获取 文件的 MIME 类型
                    MediaType mediaType = getMediaType(content);
                    String mimeType = mediaType.toString();
                    // 利用 tika 获取 文件的扩展名
                    String extension = getExtension(mediaType);

                    String fileTye = extension;
                    if (StringUtils.isNotBlank(fileTye)) {
                        if (!fileTye.contains(".")){
                            suffix = "." + fileTye;
                        }else {
                            suffix = fileTye;
                        }
                    }
                }

                String fileName = uuid + suffix;

                String newFileName = fileName;

                RetCode<SysFile> ret = minioFileUtils.uploadFile(newFileName, content, 1, null);
                if (ret.getAck() == 0) {
                    TbImg img = generateTbImg(fileName, ret.getData().getName(), tempUrl, ret.getData().getUrl(), null);
                    iTbImgService.save(img);
                    return img.getId();
                } else {
                    throw new RuntimeException("下载图片失败！" + uri);
                }
            } catch (Exception e) {
                if (i == maxRetryCount - 1) { // if this is the last retry
                    throw new RuntimeException("http请求错误，图片下载失败！" + uri);
                }
                // else, just continue to the next iteration
            }
        }
        throw new RuntimeException("图片下载失败！尝试了 " + maxRetryCount + " 次。");
    }

    private static byte[] getBytes(String uri, RestTemplate restTemplate) {
        HttpHeaders headers = new HttpHeaders();
        // 完全模拟浏览器头
        headers.set("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36");
        headers.set("Accept", "image/webp,image/apng,image/*,*/*;q=0.8");
        headers.set("Accept-Language", "zh-CN,zh;q=0.9");
        headers.set("Referer", "https://www.example.com/"); // 设置来源页

        // 使用Try-With-Resources确保资源释放
        try {
            ResponseEntity<byte[]> response = restTemplate.exchange(
                    uri,
                    HttpMethod.GET,
                    new HttpEntity<>(headers),
                    byte[].class);

            if (response.getStatusCode() == HttpStatus.OK) {
                return response.getBody();
            }
        } catch (Exception e) {
            // 备用方案：使用Java原生HttpURLConnection
            return downloadWithFallback(uri);
        }
        return null;
    }

    private static byte[] downloadWithFallback(String imageUrl) {
        try {
            URL url = new URL(imageUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            // 复制浏览器中的所有请求头
            conn.setRequestProperty("User-Agent", "Mozilla/5.0...");
            conn.setRequestProperty("Accept", "image/webp,image/*,*/*;q=0.8");

            try (InputStream in = conn.getInputStream();
                 ByteArrayOutputStream out = new ByteArrayOutputStream()) {
                byte[] buf = new byte[8192];
                int n;
                while ((n = in.read(buf)) > 0) {
                    out.write(buf, 0, n);
                }
                return out.toByteArray();
            }
        } catch (Exception e) {
            throw new RuntimeException("所有下载方式均失败", e);
        }
    }

    private RestTemplate createRestTemplateWithTimeout() {
        return restTemplate;
    }

    /**
     * 生成文件信息
     *
     * @param originalName
     * @param newFileName
     * @param originalUri
     * @param minioUrl
     * @return
     */
    private TbImg generateTbImg(String originalName, String newFileName, String originalUri, String minioUrl, String thuMinioUrl) {
        TbImg vo = new TbImg();
        //文件名称
        vo.setFileName(newFileName);
        //文件原名称
        vo.setOriginalName(originalName);
        //设置minio图片访问地址
        vo.setMinioUrl(minioUrl);
        //原url地址(图片为url地址下载类型的,被下载地址)
        vo.setOriginalUrl(originalUri);
        vo.setGroupingId(3L);
        vo.setCreateTime(new Date());
        //图片来源类型(1:本地上传,2:url地址下载)
        vo.setSourceType(new Byte("2"));
        vo.setIsShare(new Byte("2"));
        vo.setIsDelete(new Byte("2"));
        if (ObjectUtil.isNotEmpty(thuMinioUrl)) {
            vo.setMinioThuUrl(thuMinioUrl);
        }

        return vo;
    }
    private MediaType getMediaType(byte[] workbookBytes) throws Exception {
        try (InputStream inputStream = TikaInputStream.get(new ByteArrayInputStream(workbookBytes))) {
            // 使用 Tika 的 Detector 检测文件类型
            Detector detector = new DefaultDetector();
            Metadata metadata = new Metadata();
            MediaType mediaType = detector.detect(inputStream, metadata);
            return mediaType;
        } catch (IOException e) {
            throw e;
        }
    }

    private String getExtension(MediaType mediaType) throws Exception {
        // 利用 tika 获取 文件的扩展名
        MimeTypes mimeTypes = MimeTypes.getDefaultMimeTypes();
        MimeType mimeTypeVO = mimeTypes.forName(mediaType.toString());
        String extension = mimeTypeVO.getExtension();
        return extension;
    }
}