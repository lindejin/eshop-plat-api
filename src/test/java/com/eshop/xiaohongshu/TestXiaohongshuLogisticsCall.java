package com.eshop.xiaohongshu;

import com.alibaba.fastjson.JSON;
import com.eshop.util.platform.api.client.xiaohongshu.request.XiaohongshuAppClientDTO;
import com.eshop.util.platform.api.service.logistics.xiaohongshu.XiaohongshuLogisticsCall;
import com.eshop.util.platform.api.service.logistics.xiaohongshu.dto.XiaohongshuEbillOrderReqDTO;
import com.eshop.util.platform.api.service.logistics.xiaohongshu.dto.XiaohongshuEbillTemplatesReqDTO;
import com.eshop.util.platform.api.service.logistics.xiaohongshu.vo.XiaohongshuEbillOrderRespVO;
import com.eshop.util.platform.api.service.logistics.xiaohongshu.vo.XiaohongshuEbillTemplatesRespVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class TestXiaohongshuLogisticsCall {

    @Autowired
    private XiaohongshuLogisticsCall xiaohongshuLogisticsCall;


    @Test
    public void queryEbillOrder() throws Exception {
        String apiUrl = "https://ark.xiaohongshu.com/ark/open_api/v3/common_controller";
        String appId = "698f0fae6fd04676aedd";
        String appSecret = "ea1ff5772da8a2d363976130c9199c62";
        String accessToken = "token-a67156322938498fbb24aba54d62069f-cc7df12b41c14602976fd45b130d2341";
        accessToken = "token-a67156322938498fbb24aba54d62069f-cc7df12b41c14602976fd45b130d2341";
        accessToken = "token-d51658b29a5e4f72b88e59704533aa99-2a01232750604c51b707c6bb68cf519a";

        XiaohongshuAppClientDTO appDTO = new XiaohongshuAppClientDTO();
        appDTO.setAppId(appId);
        appDTO.setAppSecret(appSecret);
        appDTO.setApiUrl(apiUrl);
        appDTO.setAccessToken(accessToken);

        String waybillCode = "SF3262394347823";
        waybillCode = "SF5120640091734";
        String cpCode = "shunfeng";
        Integer billVersion = 2;
        XiaohongshuEbillOrderReqDTO reqDTO = new XiaohongshuEbillOrderReqDTO();
        reqDTO.setWaybillCode(waybillCode);
        reqDTO.setCpCode(cpCode);
        reqDTO.setBillVersion(billVersion);
        XiaohongshuEbillOrderRespVO respVO = xiaohongshuLogisticsCall.queryEbillOrder(appDTO, reqDTO);
        System.out.println(respVO.getRespBody());
        System.out.println(JSON.toJSONString(respVO));

        //运单号为空数据
        //{"error_code":500,"error_msg":"Internal Server Error","success":false}
        //{"error_code":500,"error_msg":"Internal Server Error","respBody":"{\"error_code\":500,\"error_msg\":\"Internal Server Error\",\"success\":false}","success":false}

        //输入 waybillCode cpCode
        //{"error_msg":"旧版已下线，请使用新版电子面单（旧版剩余面单辛苦联系快递网点进行迁移）","data":null,"success":false,"error_code":4033004}
        //{"error_code":4033004,"error_msg":"旧版已下线，请使用新版电子面单（旧版剩余面单辛苦联系快递网点进行迁移）","respBody":"{\"error_msg\":\"旧版已下线，请使用新版电子面单（旧版剩余面单辛苦联系快递网点进行迁移）\",\"data\":null,\"success\":false,\"error_code\":4033004}","success":false}


        //输入 waybillCode cpCode=SF 并指定新版面单 billVersion
        //{"error_msg":"面单不存在","data":null,"success":false,"error_code":0}
        //{"error_code":0,"error_msg":"面单不存在","respBody":"{\"error_msg\":\"面单不存在\",\"data\":null,\"success\":false,\"error_code\":0}","success":false}

        //输入 waybillCode cpCode=shunfeng 并指定新版面单 billVersion
        //{"error_msg":null,"data":{"parentWaybillCode":"","customerPrintData":"","waybillCode":"SF3262394347823","printData":"{\"encryptedData\":\"AES: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\",\"templateURL\":\"https://cloudprint.xiaohongshu.com/template/standard/23/1\",\"ver\":\"waybill_print_xiaohongshu_secret\"}","extraInfo":"{}"},"success":true,"error_code":0}
        //{"data":{"customerPrintData":"","extraInfo":"{}","parentWaybillCode":"","printData":"{\"encryptedData\":\"AES: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\",\"templateURL\":\"https://cloudprint.xiaohongshu.com/template/standard/23/1\",\"ver\":\"waybill_print_xiaohongshu_secret\"}","waybillCode":"SF3262394347823"},"error_code":0,"respBody":"{\"error_msg\":null,\"data\":{\"parentWaybillCode\":\"\",\"customerPrintData\":\"\",\"waybillCode\":\"SF3262394347823\",\"printData\":\"{\\\"encryptedData\\\":\\\"AES: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\\\",\\\"templateURL\\\":\\\"https://cloudprint.xiaohongshu.com/template/standard/23/1\\\",\\\"ver\\\":\\\"waybill_print_xiaohongshu_secret\\\"}\",\"extraInfo\":\"{}\"},\"success\":true,\"error_code\":0}","success":true}
    }



    @Test
    public void queryEbillTemplates() throws Exception {
        String apiUrl = "https://ark.xiaohongshu.com/ark/open_api/v3/common_controller";
        String appId = "698f0fae6fd04676aedd";
        String appSecret = "ea1ff5772da8a2d363976130c9199c62";
        String accessToken = "token-a67156322938498fbb24aba54d62069f-cc7df12b41c14602976fd45b130d2341";
        accessToken = "token-d51658b29a5e4f72b88e59704533aa99-2a01232750604c51b707c6bb68cf519a";

        XiaohongshuAppClientDTO appDTO = new XiaohongshuAppClientDTO();
        appDTO.setAppId(appId);
        appDTO.setAppSecret(appSecret);
        appDTO.setApiUrl(apiUrl);
        appDTO.setAccessToken(accessToken);

//        String cpCode = "shunfeng";
        Integer billVersion = 2;
        XiaohongshuEbillTemplatesReqDTO reqDTO = new XiaohongshuEbillTemplatesReqDTO();
//        reqDTO.setCpCode(cpCode);
        reqDTO.setBillVersion(billVersion);
        XiaohongshuEbillTemplatesRespVO respVO = xiaohongshuLogisticsCall.queryEbillTemplates(appDTO, reqDTO);
        System.out.println(respVO.getRespBody());
        System.out.println(JSON.toJSONString(respVO));

        //
       }
}
