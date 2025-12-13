package com.eshop.cainiao;

import com.eshop.util.platform.api.client.cainiao.request.CainiaoAppClientDTO;
import com.eshop.util.platform.api.service.logistics.cainiao.CainiaoLogisticsCall;
import com.eshop.util.platform.api.service.logistics.cainiao.dto.CainiaoCloudPrintStandardTemplatesReqDTO;
import com.eshop.util.platform.api.service.logistics.cainiao.vo.CainiaoCloudPrintStandardTemplatesRespVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CainiaoLogisticsCallTest {

    @Autowired
    private CainiaoLogisticsCall cainiaoLogisticsCall;

    /**
     * 获取店铺信息
     */
    @Test
    public void cloudPrintStandardTemplates() throws Exception {
        String apiUrl = "https://link.cainiao.com/gateway/link.do";
        String appId = "942402";
        String appSecret = "fSZUeG13056KO8My1m461Y91FUEzP47I";
        String accessToken = "ZGx5Y2QzNk95UHlnc1pMT0JOU3ZSOGgreitIT0I4eGdRMHRXYkFzd2VZNlZ2Y2NQY1NTT09FUVN4cGRMb3UvYw==";

        CainiaoAppClientDTO appDTO = new CainiaoAppClientDTO();
        appDTO.setAppKey(appId);
        appDTO.setAppSecret(appSecret);
        appDTO.setApiUrl(apiUrl);
        appDTO.setAccessToken(accessToken);
        CainiaoCloudPrintStandardTemplatesReqDTO reqDTO = new CainiaoCloudPrintStandardTemplatesReqDTO();

        CainiaoCloudPrintStandardTemplatesRespVO execute = cainiaoLogisticsCall.cloudPrintStandardTemplates(appDTO, reqDTO);
        System.out.println(execute.getRespBody());
    }
}
