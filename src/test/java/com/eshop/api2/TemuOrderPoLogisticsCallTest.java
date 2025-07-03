package com.eshop.api2;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.eshop.config.http.OkHttpConfig;
import com.eshop.entity.config.TbShop;
import com.eshop.service.config.ITbShopService;
import com.eshop.util.platform.api.service.logistics.temu.TemuOrderPoLogisticsCall;
import com.eshop.util.platform.api.service.logistics.temu.dto.*;
import com.eshop.util.platform.api.service.logistics.temu.vo.*;
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
import java.util.*;
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

//    @Test
//    public void logisticsShipmentDocumentGet() throws Exception {
//        Long shopId = 3110L;
//        TbShop shopDO = shopService.getById(shopId);
//        String shopLocation = "GL";
//        TemuAppClientDTO clientDTO = platformAppClientUtils.getTemuAppClientDTO(shopDO, shopLocation);
//
//        String documentType = "SHIPPING_LABEL_PDF";
//        List<String> packageSnList = ImmutableList.of("PK-3715182006108310058");
//
//
//        TemuLogisticsShipmentDocumentReqDTO reqDTO = new TemuLogisticsShipmentDocumentReqDTO();
//        reqDTO.setDocumentType(documentType);
//        reqDTO.setPackageSnList(packageSnList);
//        TemuLogisticsShipmentDocumentRespVO respVO = temuOrderPoLogisticsCall.logisticsShipmentDocumentGet(clientDTO, reqDTO);
//        System.out.println(respVO.getRespBody());
//        System.out.println(JSON.toJSON(respVO));
//
//        downloadFile(respVO.getUrl(), clientDTO, client);
//    }

    /**
     * 声明发货结果
     */
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

        /*
{
    "respBody": "{\"result\":{\"packageInfoResultList\":[{\"estimatedText\":\"预估₱71.75; PHP; 3-12 work days送达\",\"estimatedCurrencyCode\":\"PHP\",\"extendWeight\":null,\"packageDeliveryType\":2,\"dimensionUnit\":\"cm\",\"solutionText\":null,\"warehouseName\":\"NYC-PH\",\"failReasonText\":null,\"reservationSn\":null,\"subPackageSnList\":[],\"mainPackageSn\":\"PK-3715182006108310058\",\"signServiceId\":null,\"shipLogisticsType\":\"standard\",\"subPackageType\":\"MAIN\",\"trackingNumber\":\"JT0003192713969\",\"channelId\":613786973679616,\"height\":\"1.00\",\"extendWeightUnit\":null,\"pickupStartTime\":null,\"shippingLabelStatus\":1,\"canChangeToManualSend\":true,\"pickupEndTime\":null,\"packageSn\":\"PK-3715182006108310058\",\"length\":\"30.00\",\"warningMessage\":[],\"weight\":\"0.15\",\"shipCompanyId\":998265498,\"warehouseId\":\"WH-10971324948630058\",\"orderSendInfoList\":[{\"quantity\":1,\"orderSn\":\"160-01121136323192676\",\"parentOrderSn\":\"PO-160-01121117317752676\",\"goodsId\":601101395075042,\"skuId\":17599646421135}],\"width\":\"25.00\",\"shippingCompanyName\":\"J&T Express (PH)\",\"estimatedAmount\":\"₱71.75\",\"weightUnit\":\"kg\"}]},\"success\":true,\"requestId\":\"gl-a042eab8-db7f-42a5-a9ee-9c95f0e06ae9\",\"errorCode\":1000000,\"errorMsg\":\"\"}",
    "result": {
        "packageInfoResultList": [
            {
                "estimatedText": "预估₱71.75; PHP; 3-12 work days送达",
                "estimatedCurrencyCode": "PHP",
                "dimensionUnit": "cm",
                "packageDeliveryType": 2,
                "warehouseName": "NYC-PH",
                "subPackageSnList": [
                ],
                "mainPackageSn": "PK-3715182006108310058",
                "shipLogisticsType": "standard",
                "subPackageType": "MAIN",
                "trackingNumber": "JT0003192713969",
                "channelId": 613786973679616,
                "height": "1.00",
                "canChangeToManualSend": true,
                "shippingLabelStatus": 1,
                "length": "30.00",
                "packageSn": "PK-3715182006108310058",
                "warningMessage": [
                ],
                "weight": "0.15",
                "shipCompanyId": 998265498,
                "warehouseId": "WH-10971324948630058",
                "orderSendInfoList": [
                    {
                        "quantity": 1,
                        "orderSn": "160-01121136323192676",
                        "goodsId": 601101395075042,
                        "parentOrderSn": "PO-160-01121117317752676",
                        "skuId": 17599646421135
                    }
                ],
                "width": "25.00",
                "shippingCompanyName": "J&T Express (PH)",
                "estimatedAmount": "₱71.75",
                "weightUnit": "kg"
            }
        ]
    },
    "success": true,
    "errorCode": 1000000,
    "trackingNumber": "JT0003192713969",
    "errorMsg": ""
}
         */

    }


//    public static void downloadFile(String url, TemuAppClientDTO clientDTO, OkHttpClient client) throws Exception {
//        //https://openapi-b-global.temu.com/pfse/pkg-label/f68e3ecf/84ad1b48-4f9f-48cc-9df2-3ace9d19d371.pdf
//
//        String oldChar = "https://openapi-b-global.temu.com";
//        String newChar = "https://us.vogocmerp.com/openapi_temu_gl";
//        url = url.replace(oldChar, newChar);
//        final String APP_KEY = clientDTO.getAppKey();
//        final String ACCESS_TOKEN = clientDTO.getAccessToken();
//        final String APP_SECRET = clientDTO.getAppSecret();
//        final String DOWNLOAD_URL = url;
//
//        // 1. 生成必要参数
//        String toaRandom = generateRandomString(32);
//        String toaTimestamp = String.valueOf(System.currentTimeMillis() / 1000); // 秒级时间戳
//
//        // 2. 计算签名
//        Map<String, String> signParams = new TreeMap<>();
//        signParams.put("toa-access-token", ACCESS_TOKEN);
//        signParams.put("toa-app-key", APP_KEY);
//        signParams.put("toa-random", toaRandom);
//        signParams.put("toa-timestamp", toaTimestamp);
//
//        String signString = buildSignString(signParams, APP_SECRET);
//        String toaSign = md5(signString).toUpperCase();
//
//        // 3. 创建OkHttp请求
////        OkHttpClient client = OkHttpConfig.create();
//
//        Request request = new Request.Builder()
//                .url(url)
//                .addHeader("toa-app-key", APP_KEY)
//                .addHeader("toa-access-token", ACCESS_TOKEN)
//                .addHeader("toa-random", toaRandom)
//                .addHeader("toa-timestamp", toaTimestamp)
//                .addHeader("toa-sign", toaSign)
//                .build();
//
//        // 4. 执行请求并保存文件
//        try (Response response = client.newCall(request).execute()) {
//            if (!response.isSuccessful()) {
//                System.out.println(response.body().string());
//                throw new Exception("下载失败: HTTP " + response.code());
//            }
//
//            // 验证是否为文件流 (可选)
//            System.out.println("Content-Type:" + response.header("Content-Type"));
//            if ("application/octet-stream".equals(response.header("Content-Type"))
//            || "application/pdf".equals(response.header("Content-Type"))) {
//                try (InputStream is = response.body().byteStream();
//                     OutputStream os = new FileOutputStream("downloaded_file.pdf")) {
//                    byte[] buffer = new byte[4096];
//                    int bytesRead;
//                    while ((bytesRead = is.read(buffer)) != -1) {
//                        os.write(buffer, 0, bytesRead);
//                    }
//                }
//                System.out.println("文件下载成功");
//            } else {
//                System.out.println("响应不是文件流: " + response.body().string());
//            }
//        }
//    }

//    private static String generateRandomString(int length) {
//        String CHAR_POOL = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
//        Random random = new Random();
//        StringBuilder sb = new StringBuilder(length);
//        for (int i = 0; i < length; i++) {
//            sb.append(CHAR_POOL.charAt(random.nextInt(CHAR_POOL.length())));
//        }
//        return sb.toString();
//    }
//
//    private static String buildSignString(Map<String, String> sortedParams, String appSecret) {
//        StringBuilder sb = new StringBuilder(appSecret);
//        for (Map.Entry<String, String> entry : sortedParams.entrySet()) {
//            sb.append(entry.getKey()).append(entry.getValue());
//        }
//        sb.append(appSecret);
//        return sb.toString();
//    }
//
//    private static String md5(String input) throws Exception {
//        MessageDigest md = MessageDigest.getInstance("MD5");
//        byte[] digest = md.digest(input.getBytes("UTF-8"));
//        StringBuilder sb = new StringBuilder();
//        for (byte b : digest) {
//            sb.append(String.format("%02x", b & 0xff));
//        }
//        return sb.toString();
//    }

    /**
     * 查询可用发货仓库
     */
    @Test
    void logisticsWarehouseListGet() throws Exception {
        Long shopId = 3110L;
        TbShop shopDO = shopService.getById(shopId);
        String shopLocation = "GL";
        TemuAppClientDTO gl = platformAppClientUtils.getTemuAppClientDTO(shopDO, shopLocation);


        TemuLogisticsWarehouseListReqDTO businessDto = new TemuLogisticsWarehouseListReqDTO();
        TemuLogisticsWarehouseListRespVO s = temuOrderPoLogisticsCall.logisticsWarehouseListGet(gl, businessDto);
        System.out.println(s.getRespBody());
        System.out.println(JSON.toJSON(s.getWarehouseList()));

        /*
{
    "result": {
        "warehouseList": [
            {
                "defaultWarehouse": true,
                "warehouseId": "WH-10971324948630058",
                "warehouseBrand": null,
                "regionId1": 160,
                "warehouseManagementType": 1,
                "warehouseName": "NYC-PH"
            }
        ]
    },
    "success": true,
    "requestId": "gl-a112097a-101f-48c0-87cb-e51f048b074d",
    "errorCode": 1000000,
    "errorMsg": ""
}
         */
    }


    @Test
    void logisticsShipLogisticsTypeGet() throws Exception {
        Long shopId = 3110L;
        TbShop shopDO = shopService.getById(shopId);
        String shopLocation = "GL";
        TemuAppClientDTO gl = platformAppClientUtils.getTemuAppClientDTO(shopDO, shopLocation);


        TemuLogisticsShipLogisticsTypeReqDTO businessDto = new TemuLogisticsShipLogisticsTypeReqDTO();
        businessDto.setRegionId(160L);
        TemuLogisticsShipLogisticsTypeRespVO s = temuOrderPoLogisticsCall.logisticsShipLogisticsTypeGet(gl, businessDto);
        System.out.println(s.getRespBody());
        System.out.println(JSON.toJSON(s.getShipLogisticsTypeInfoDTOList()));

        //{
        //    "result": {
        //        "regionId": 160,
        //        "shipLogisticsTypeInfoDTOList": [
        //            {
        //                "shipLogisticsType": "standard",
        //                "shippingCompanyName": "J&T Express (PH)",
        //                "shipCompanyId": 998265498
        //            }
        //        ]
        //    },
        //    "success": true,
        //    "requestId": "gl-d530f4a2-d666-4e0a-8a5b-bb5e8f083cf8",
        //    "errorCode": 1000000,
        //    "errorMsg": ""
        //}
    }

    /**
     * 查询在线物流方式
     * 查询对应包裹在线发货可用物流服务
     */
    @Test
    void logisticsShippingServicesGet() throws Exception {
        Long shopId = 3110L;
        TbShop shopDO = shopService.getById(shopId);
        String shopLocation = "GL";
        TemuAppClientDTO gl = platformAppClientUtils.getTemuAppClientDTO(shopDO, shopLocation);


        //订单同步的包裹号
        List<String> orderSnList = new ArrayList<>()    ;
        orderSnList.add("160-01121136323192676");

        TemuLogisticsShippingServicesReqDTO reqDTO = new TemuLogisticsShippingServicesReqDTO();
        //仓库id
        reqDTO.setWarehouseId("WH-10971324948630058");
        reqDTO.setOrderSnList(orderSnList);
        //重量
        reqDTO.setWeight("0.15");
        //重量单位
        reqDTO.setWeightUnit("kg");

        //长
        reqDTO.setLength("30.00");
        //宽
        reqDTO.setWidth("25.00");
        //高
        reqDTO.setHeight("1.00");
        //体积单位
        reqDTO.setDimensionUnit("cm");
        TemuLogisticsShippingServicesRespVO respVO = temuOrderPoLogisticsCall.logisticsShippingServicesGet(gl, reqDTO);
        System.out.println(respVO.getRespBody());

        System.out.println(JSON.toJSON(respVO));
        /*
{
    "result": {
        "unavailableChannelDtoList": [
        ],
        "onlineChannelDtoList": [
            {
                "estimatedText": "预估₱71.75; PHP; 3-12 个工作日送达",
                "estimatedCurrencyCode": "PHP",
                "infoNeeded": null,
                "signServiceName": null,
                "signServiceId": null,
                "shipLogisticsType": "standard",
                "shippingCompanyName": "J&T Express (PH)",
                "estimatedAmount": "₱71.75",
                "channelId": 613786973679616,
                "shipCompanyId": 998265498,
                "payWayCode": 2
            }
        ]
    },
    "success": true,
    "requestId": "gl-bed1e47f-159a-4e13-ae89-5de95016110f",
    "errorCode": 1000000,
    "errorMsg": ""
}
         */
    }
}
