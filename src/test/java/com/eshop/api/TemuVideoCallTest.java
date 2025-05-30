package com.eshop.api;

import com.eshop.entity.config.TbShop;
import com.eshop.order.OkImageDownloader;
import com.eshop.service.config.ITbShopService;
import com.eshop.util.platform.api.service.media.temu.TemuVideoCall;
import com.eshop.util.platform.api.service.media.temu.dto.*;
import com.eshop.util.platform.api.service.media.temu.vo.*;
import com.eshop.util.platform.api.structure.temu.dto.TemuAppClientDTO;
import com.eshop.util.shop.PlatformAppClientUtils;
import eu.medsea.mimeutil.MimeType;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@SpringBootTest
public class TemuVideoCallTest {

    @Resource
    private PlatformAppClientUtils platformAppClientUtils;

    @Resource
    private ITbShopService shopService;

    @Resource
    private TemuVideoCall temuVideoCall;

    @Resource
    private OkImageDownloader okImageDownloader;

    @Test
    void goodsVideoUploadSignGet() throws Exception {
        Long shopId = 2325L;
        TbShop shopDO = shopService.getById(shopId);
        String shopLocation = "CN";
        TemuAppClientDTO clientDTO = platformAppClientUtils.getTemuAppClientDTO(shopDO, shopLocation);

        String contentType = "video/mp4";
        Boolean isBigVideo = false;
        TemuVideoUploadSignReqDTO reqDTO = new TemuVideoUploadSignReqDTO();
        reqDTO.setIsBigVideo(isBigVideo);
        reqDTO.setContentType(contentType);
        TemuVideoUploadSignRespVO respVO = temuVideoCall.goodsVideoUploadSignGet(clientDTO, reqDTO);
        System.out.println(respVO.getRespBody());

        System.out.println(respVO.getSign());

        uploadStoreVideo(respVO.getSign());
        //{"result":{"sign":"MDqXDTtvrKDjI9JcAi8EP8JSUlFMxlTid-2dMk8VQ-WS8ywk5GOj6pIxB8jJAfj7FN4l4LAHl1-BzvrRPZA5ElXErVFosYWeAEurMsGg11cC6SKql9JgFylKmKd1Kyr-yI2qR3QLRJgkARUdZhjkxMdhsVmn9_SIwhb82RlwEgrHI1B_IGM3QhGGUtcfP6u95lN8FTSTD5z0_6PldKk5fPNUAg1pnVSLXC96jYBBPIWFNPiErypMhdi8NohkUtcI0DZpMbGunPomJNDx7OTnjE0d6XJBBemdkKbkoFGFJnbmYTyK0qSBSLr1qFHxVsf94KD7jfz4s0G5p0l__YmzxGVraqjNzL9FtnJjzmmEtk57Hc5eQTdyOmKdTwzLboNToE87f5Q5m_7ytXSPthW718kcWBH-J8LWBflgz2rPQjaOKxnGsrMbXU7jUgA_cfChGuEM7fGvxoRD8bF6JoBsYxeicngcXgJWqeKcQrUJYyYMuXsTaD40ljLLniWvdkLMnGg_4p1NWej4SWBwDOtIFs6WfF29LTHFNYCeZYjKKowPiA=="},"success":true,"requestId":"cn-65b12056-a54d-41b3-b64f-b0296cd0e30a","errorCode":1000000,"errorMsg":""}
    }


    @Test
    void uploadStoreVideo(String si) throws Exception {
        String url = "https://file.vogocm.com:9000/eshop/eshop_img/10001/20201120/10/A003.png";
        url = "https://test.vogocm.com:9010/eshop/eshop_video/2025/3/29/vg-20250329162836A007.mp4";

        byte[] bytes = okImageDownloader.downloadImageWithRetry(url);
        // 3. 数据校验
        if (bytes == null || bytes.length == 0) {
            throw new IOException("下载内容为空");
        }


        // 计算MD5
        String content_md5 = DigestUtils.md5Hex(okImageDownloader.downloadImageWithRetry(url));
        Boolean create_media = true;
        String sign = si;
        MimeType mimeType = MimeDetector.getMimeType(bytes);
        String fileName = UUID.randomUUID() + "." + mimeType.getSubType();
        String fileParam = "file";
        TemuVideoStoreVideoUploadReqDTO reqDTO = new TemuVideoStoreVideoUploadReqDTO();
        reqDTO.setCreate_media(create_media);
        reqDTO.setContent_md5(content_md5);
        reqDTO.setSign(sign);
        TemuVideoStoreVideoUploadRespVO respVO = temuVideoCall.uploadStoreVideo(bytes, fileParam, fileName, reqDTO);
//            System.out.println(respVO.getRespBody());
        System.out.println(respVO.getVid());
        System.out.println(respVO.getUrl());


        //{"url":"https://goods-vod.cdnfe.com/goods-video/201365d8925/5a377abf8d7117be4f976426929f65f4.bin","etag":"82e3db40b29b4d84259800c6cbd25b27","vid":"goods-video-tag#rnvnnj2hbxlndcjti44w6m34dgbsbt34"}

        //goods-video-tag#zfhzhjss4aksjersya8i6m3734e2daf4
        //https://goods-vod.cdnfe.com/goods-video/201365d8925/6ea24486004b099dbb2edd383d444116.mp4
    }


    @Test
    void goodsVideoUploadSignGe2() throws Exception {
        String url = "";
        url = "https://file.vogocm.com:9000/eshop/eshop_video/2025/5/16/vg-250516164931454A466417.mp4";

        url = "https://file.vogocm.com:9000/eshop/eshop_video/2025/4/28/vg-250428101733774A844368.mp4";
        byte[] bytes = okImageDownloader.downloadImageWithRetry(url);
        // 3. 数据校验
        if (bytes == null || bytes.length == 0) {
            throw new IOException("下载内容为空");
        }
        // 计算MD5
        String contentMd5 = DigestUtils.md5Hex(bytes);

        Long shopId = 2325L;
        TbShop shopDO = shopService.getById(shopId);
        String shopLocation = "CN";
        TemuAppClientDTO clientDTO = platformAppClientUtils.getTemuAppClientDTO(shopDO, shopLocation);

        String contentType = "video/mp4";
        Boolean isBigVideo = true;
        TemuVideoUploadSignReqDTO reqDTO = new TemuVideoUploadSignReqDTO();
        reqDTO.setIsBigVideo(isBigVideo);
        reqDTO.setContentType(contentType);
        TemuVideoUploadSignRespVO respVO = temuVideoCall.goodsVideoUploadSignGet(clientDTO, reqDTO);
        String commonSign = respVO.getSign();
        System.out.println("获取视频上传 sign:" + commonSign);
        TemuVideoInitRespVO initRespVO = initVideoUpload(commonSign);
        String partSign = initRespVO.getSign();
        System.out.println("获取分片上传 sign:" + partSign);

        List<TemuVideoUploadPartDTO> partDTOList = new ArrayList<>();
        MimeType mimeType = MimeDetector.getMimeType(bytes);
        String fileNameTemp = UUID.randomUUID() + "." + mimeType.getSubType();
        long fileSizeInBytes = bytes.length;
        long chunkSizeInBytes = 19L * 1024 * 1024; // 19 MB in bytes
        int totalChunks = (int) Math.ceil((double) fileSizeInBytes / chunkSizeInBytes);
        for (int i = 0; i < totalChunks; i++) {
            int finalI = i;
            byte[] partFile = Arrays.copyOfRange(bytes,
                    (int) (finalI * chunkSizeInBytes),
                    Math.min((int) ((finalI + 1) * chunkSizeInBytes), bytes.length));
            String partNum = String.valueOf(finalI + 1);
            String fileParam = "part_file";
            String fileName = UUID.randomUUID()  + ".part";
            String contentMd5Temp = null;

            TemuVideoUploadPartDTO partDTO = new TemuVideoUploadPartDTO();
            partDTO.setPartFile(partFile);
            partDTO.setFileParam(fileParam);
            partDTO.setFileName(fileName);

            partDTO.setContentMd5(contentMd5Temp);
            partDTO.setSign(partSign);
            partDTO.setPartNum(partNum);

            partDTOList.add(partDTO);
        }

        for (TemuVideoUploadPartDTO partDTO : partDTOList) {
            TemuVideoUploadPartRespVO partRespVO = uploadVideoPart(partDTO);
            System.out.println(partRespVO.getRespBody());
        }

        TemuVideoUploadCompleteRespVO completeRespVO = completeVideoUpload(partSign, contentMd5);
        System.out.println(completeRespVO.getRespBody());


        //获取视频上传 sign:MDqXDTtvrKDjI9JcAi8EP8JSUlFMxlTid-2dMk8VQ-WS8ywk5GOj6pIxB8jJAfj7FN4l4LAHl1-BzvrRPZA5ElXErVFosYWeAEurMsGg11cC6SKql9JgFylKmKd1Kyr-yI2qR3QLRJgkARUdZhjkxMdhsVmn9_SIwhb82RlwEgrHI1B_IGM3QhGGUtcfP6u95lN8FTSTD5z0_6PldKk5fPNUAg1pnVSLXC96jYBBPIWFNPiErypMhdi8NohkUtcI0DZpMbGunPomJNDx7OTnjE0dk7mb0h3b1-K4H0SeH4r5qjyK0qSBSLr1qFHxVsf94KAKZZJmqyn5O5lF3RHbID6VTdZu_IanhyRoPJYejXbe6dkrJZWj_N19-_fzaSuDmUhUxx0LxcVfoEoiirHAOl1DRURba0Tm2n6HSpt36lPKq5S6Fomy8BlJQep_VxVLS5QM7fGvxoRD8bF6JoBsYxeiLurFLgnz5FhjoKVOIf-AT08Dgsut_56WUpuJiIJAdz-T_UZFCpz29QnnEHWbJpvci4UMt1RKRdWxbMsI7QrgGw==
        //2025-05-30 14:48:29.902  INFO 25996 --- [           main] com.eshop.config.http.OkHttpConfig       : Sending request: POST https://openapi.kuajingmaihuo.com/api/galerie/large_file/v1/video/upload_init
        //2025-05-30 14:48:29.961  INFO 25996 --- [           main] com.eshop.config.http.OkHttpConfig       : Received response in 59ms: 200
        //获取分片上传 sign:1748587710853b0f17f91d085bf9a40d7321786fac3cdfb4bb4798fa59c5fe4652e0bfaa3f
        //File Type: video
        //File Extension: mp4
        //2025-05-30 14:48:30.035  INFO 25996 --- [           main] com.eshop.config.http.OkHttpConfig       : Sending request: POST https://openapi.kuajingmaihuo.com/api/galerie/large_file/v1/video/upload_part
        //2025-05-30 14:48:33.116  INFO 25996 --- [           main] com.eshop.config.http.OkHttpConfig       : Received response in 3080ms: 200
        //{"uploaded_part_num":1}
        //2025-05-30 14:48:33.118  INFO 25996 --- [           main] com.eshop.config.http.OkHttpConfig       : Sending request: POST https://openapi.kuajingmaihuo.com/api/galerie/large_file/v1/video/upload_part
        //2025-05-30 14:48:36.427  INFO 25996 --- [           main] com.eshop.config.http.OkHttpConfig       : Received response in 3309ms: 200
        //{"uploaded_part_num":2}
        //2025-05-30 14:48:36.429  INFO 25996 --- [           main] com.eshop.config.http.OkHttpConfig       : Sending request: POST https://openapi.kuajingmaihuo.com/api/galerie/large_file/v1/video/upload_part
        //2025-05-30 14:48:39.971  INFO 25996 --- [           main] com.eshop.config.http.OkHttpConfig       : Received response in 3541ms: 200
        //{"uploaded_part_num":3}
        //2025-05-30 14:48:39.971  INFO 25996 --- [           main] com.eshop.config.http.OkHttpConfig       : Sending request: POST https://openapi.kuajingmaihuo.com/api/galerie/large_file/v1/video/upload_part
        //2025-05-30 14:48:40.991  INFO 25996 --- [           main] com.eshop.config.http.OkHttpConfig       : Received response in 1019ms: 200
        //{"uploaded_part_num":4}
        //2025-05-30 14:48:40.994  INFO 25996 --- [           main] com.eshop.config.http.OkHttpConfig       : Sending request: POST https://openapi.kuajingmaihuo.com/api/galerie/large_file/v1/video/upload_complete
        //2025-05-30 14:48:41.284  INFO 25996 --- [           main] com.eshop.config.http.OkHttpConfig       : Received response in 290ms: 200
        //{"url":"https://goods-vod.cdnfe.com/goods-video/201365d8925/ded2d008d381b1cb779adcb232603068.mp4","vid":"goods-video-tag#hzv72wppszu0tjfielsj6m3v8gc4o16o"}
    }

    TemuVideoInitRespVO initVideoUpload(String sign) throws Exception {
        String contentType = "video/mp4";
        // 计算MD5
        Boolean create_media = true;
        TemuVideoInitReqDTO reqDTO = new TemuVideoInitReqDTO();
        reqDTO.setCreate_media(create_media);
        reqDTO.setContent_type(contentType);
        reqDTO.setSign(sign);
        return temuVideoCall.initVideoUpload(reqDTO);
    }

    private TemuVideoUploadPartRespVO uploadVideoPart(
            TemuVideoUploadPartDTO partDTO) throws Exception {
        TemuVideoUploadPartReqDTO reqDTO = new TemuVideoUploadPartReqDTO();
        reqDTO.setContent_md5(partDTO.getContentMd5());
        reqDTO.setSign(partDTO.getSign());
        reqDTO.setPart_num(partDTO.getPartNum());
        return temuVideoCall.uploadVideoPart(partDTO.getPartFile(), partDTO.getFileParam(), partDTO.getFileName(), reqDTO);
    }


    private TemuVideoUploadCompleteRespVO completeVideoUpload(String sign, String contentMd5) throws Exception {
        TemuVideoUploadCompleteReqDTO reqDTO = new TemuVideoUploadCompleteReqDTO();
        reqDTO.setContent_md5(contentMd5);
        reqDTO.setSign(sign);
        return temuVideoCall.completeVideoUpload(reqDTO);
    }


    @Test
    void goodsBigVideoUploadResultGet() throws Exception {
        String vid = "goods-video-tag#hzv72wppszu0tjfielsj6m3v8gc4o16o";

        Long shopId = 2325L;
        TbShop shopDO = shopService.getById(shopId);
        String shopLocation = "CN";
        TemuAppClientDTO clientDTO = platformAppClientUtils.getTemuAppClientDTO(shopDO, shopLocation);

        TemuVideoUploadResultReqDTO reqDTO = new TemuVideoUploadResultReqDTO();
        reqDTO.setVid(vid);
        TemuVideoUploadResultRespVO respVO = temuVideoCall.goodsBigVideoUploadResultGet(clientDTO, reqDTO);
        System.out.println(respVO.getRespBody());
    }
}
