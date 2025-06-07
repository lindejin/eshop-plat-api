package com.eshop.api2;

import com.alibaba.fastjson.JSON;
import com.eshop.config.http.OkHttpConfig;
import com.eshop.entity.config.TbShop;
import com.eshop.service.config.ITbShopService;
import com.eshop.util.platform.api.service.logistics.temu.TemuOrderPoLogisticsCall;
import com.eshop.util.platform.api.service.logistics.temu.dto.TemuLogisticsShipmentDocumentReqDTO;
import com.eshop.util.platform.api.service.logistics.temu.dto.TemuLogisticsShipmentResultReqDTO;
import com.eshop.util.platform.api.service.logistics.temu.vo.TemuLogisticsShipmentDocumentRespVO;
import com.eshop.util.platform.api.service.logistics.temu.vo.TemuLogisticsShipmentResultRespVO;
import com.eshop.util.platform.api.service.order.temu.TemuOrderV2Call;
import com.eshop.util.platform.api.service.order.temu.dto.TemuOrderDetailV2ReqDTO;
import com.eshop.util.platform.api.service.order.temu.vo.TemuOrderDetailV2RespVO;
import com.eshop.util.platform.api.structure.temu.dto.TemuAppClientDTO;
import com.eshop.util.shop.PlatformAppClientUtils;
import com.google.common.collect.ImmutableList;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

@SpringBootTest
public class TemuOrderPoLogisticsCallTest {

    @Resource
    private PlatformAppClientUtils platformAppClientUtils;

    @Resource
    private ITbShopService shopService;

    @Resource
    private TemuOrderPoLogisticsCall temuOrderPoLogisticsCall;

    @Resource
    private OkHttpClient client;

    @Test
    public void logisticsShipmentDocumentGet() throws Exception {
        Long shopId = 3110L;
        TbShop shopDO = shopService.getById(shopId);
        String shopLocation = "GL";
        TemuAppClientDTO clientDTO = platformAppClientUtils.getTemuAppClientDTO(shopDO, shopLocation);

        String documentType = "SHIPPING_LABEL_PDF";
        List<String> packageSnList = ImmutableList.of("PK-3715182006108310058");


        TemuLogisticsShipmentDocumentReqDTO reqDTO = new TemuLogisticsShipmentDocumentReqDTO();
        reqDTO.setDocumentType(documentType);
        reqDTO.setPackageSnList(packageSnList);
        TemuLogisticsShipmentDocumentRespVO respVO = temuOrderPoLogisticsCall.logisticsShipmentDocumentGet(clientDTO, reqDTO);
        System.out.println(respVO.getRespBody());
        System.out.println(JSON.toJSON(respVO));

        downloadFile(respVO.getUrl(), clientDTO, client);
    }

    @Test
    public void logisticsShipmentResultGet() throws Exception {
        Long shopId = 3110L;
        TbShop shopDO = shopService.getById(shopId);
        String shopLocation = "GL";
        TemuAppClientDTO clientDTO = platformAppClientUtils.getTemuAppClientDTO(shopDO, shopLocation);

        List<String> packageSnList = ImmutableList.of("PK-3715182006108310058");


        TemuLogisticsShipmentResultReqDTO reqDTO = new TemuLogisticsShipmentResultReqDTO();
        reqDTO.setPackageSnList(packageSnList);
        TemuLogisticsShipmentResultRespVO respVO = temuOrderPoLogisticsCall.logisticsShipmentResultGet(clientDTO, reqDTO);
        System.out.println(respVO.getRespBody());
        System.out.println(JSON.toJSON(respVO));

        System.out.println(respVO.getTrackingNumber());

    }


    public static void downloadFile(String url, TemuAppClientDTO clientDTO, OkHttpClient client) throws Exception {
        //https://openapi-b-global.temu.com/pfse/pkg-label/f68e3ecf/84ad1b48-4f9f-48cc-9df2-3ace9d19d371.pdf

        String oldChar = "https://openapi-b-global.temu.com";
        String newChar = "https://us.vogocmerp.com/openapi_temu_gl";
        url = url.replace(oldChar, newChar);
        final String APP_KEY = clientDTO.getAppKey();
        final String ACCESS_TOKEN = clientDTO.getAccessToken();
        final String APP_SECRET = clientDTO.getAppSecret();
        final String DOWNLOAD_URL = url;

        // 1. 生成必要参数
        String toaRandom = generateRandomString(32);
        String toaTimestamp = String.valueOf(System.currentTimeMillis() / 1000); // 秒级时间戳

        // 2. 计算签名
        Map<String, String> signParams = new TreeMap<>();
        signParams.put("toa-access-token", ACCESS_TOKEN);
        signParams.put("toa-app-key", APP_KEY);
        signParams.put("toa-random", toaRandom);
        signParams.put("toa-timestamp", toaTimestamp);

        String signString = buildSignString(signParams, APP_SECRET);
        String toaSign = md5(signString).toUpperCase();

        // 3. 创建OkHttp请求
//        OkHttpClient client = OkHttpConfig.create();

        Request request = new Request.Builder()
                .url(url)
                .addHeader("toa-app-key", APP_KEY)
                .addHeader("toa-access-token", ACCESS_TOKEN)
                .addHeader("toa-random", toaRandom)
                .addHeader("toa-timestamp", toaTimestamp)
                .addHeader("toa-sign", toaSign)
                .build();

        // 4. 执行请求并保存文件
        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                System.out.println(response.body().string());
                throw new Exception("下载失败: HTTP " + response.code());
            }

            // 验证是否为文件流 (可选)
            System.out.println("Content-Type:" + response.header("Content-Type"));
            if ("application/octet-stream".equals(response.header("Content-Type"))
            || "application/pdf".equals(response.header("Content-Type"))) {
                try (InputStream is = response.body().byteStream();
                     OutputStream os = new FileOutputStream("downloaded_file.pdf")) {
                    byte[] buffer = new byte[4096];
                    int bytesRead;
                    while ((bytesRead = is.read(buffer)) != -1) {
                        os.write(buffer, 0, bytesRead);
                    }
                }
                System.out.println("文件下载成功");
            } else {
                System.out.println("响应不是文件流: " + response.body().string());
            }
        }
    }

    private static String generateRandomString(int length) {
        String CHAR_POOL = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(CHAR_POOL.charAt(random.nextInt(CHAR_POOL.length())));
        }
        return sb.toString();
    }

    private static String buildSignString(Map<String, String> sortedParams, String appSecret) {
        StringBuilder sb = new StringBuilder(appSecret);
        for (Map.Entry<String, String> entry : sortedParams.entrySet()) {
            sb.append(entry.getKey()).append(entry.getValue());
        }
        sb.append(appSecret);
        return sb.toString();
    }

    private static String md5(String input) throws Exception {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] digest = md.digest(input.getBytes("UTF-8"));
        StringBuilder sb = new StringBuilder();
        for (byte b : digest) {
            sb.append(String.format("%02x", b & 0xff));
        }
        return sb.toString();
    }
}
