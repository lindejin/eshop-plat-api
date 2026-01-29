package com.eshop.xiaohongshu;

import com.alibaba.fastjson.JSON;
import com.eshop.util.platform.api.client.xiaohongshu.request.XiaohongshuAppClientDTO;
import com.eshop.util.platform.api.service.logistics.taobao.vo.*;
import com.eshop.util.platform.api.service.logistics.xiaohongshu.XiaohongshuLogisticsCall;
import com.eshop.util.platform.api.service.logistics.xiaohongshu.dto.XiaohongshuEbillOrderReqDTO;
import com.eshop.util.platform.api.service.logistics.xiaohongshu.dto.XiaohongshuEbillTemplatesReqDTO;
import com.eshop.util.platform.api.service.logistics.xiaohongshu.vo.XiaohongshuEbillOrderRespVO;
import com.eshop.util.platform.api.service.logistics.xiaohongshu.vo.XiaohongshuEbillOrderVO;
import com.eshop.util.platform.api.service.logistics.xiaohongshu.vo.XiaohongshuEbillTemplatesRespVO;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;


@SpringBootTest
public class TestXiaohongshuLogisticsCall2 {

    @Autowired
    private XiaohongshuLogisticsCall xiaohongshuLogisticsCall;


    @Test
    public void queryEbillOrder() throws Exception {
        String apiUrl = "https://ark.xiaohongshu.com/ark/open_api/v3/common_controller";
        String appId = "698f0fae6fd04676aedd";
        String appSecret = "ea1ff5772da8a2d363976130c9199c62";
        String accessToken = "token-a67156322938498fbb24aba54d62069f-cc7df12b41c14602976fd45b130d2341";
        accessToken = "token-a67156322938498fbb24aba54d62069f-cc7df12b41c14602976fd45b130d2341";
        accessToken = "token-a11989065f264df18016b221889c1de9-598c178b43b6419083cffb512991cc4f";

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

        String print_data = Optional.ofNullable(respVO)
                .map(XiaohongshuEbillOrderRespVO::getData)
                .map(XiaohongshuEbillOrderVO::getPrintData)
                .orElse(null);
        System.out.println(JSON.parseObject(print_data));
    }


    @Test
    public void queryEbillTemplates() throws Exception {
        String apiUrl = "https://ark.xiaohongshu.com/ark/open_api/v3/common_controller";
        String appId = "698f0fae6fd04676aedd";
        String appSecret = "ea1ff5772da8a2d363976130c9199c62";
        String accessToken = "token-a67156322938498fbb24aba54d62069f-cc7df12b41c14602976fd45b130d2341";
        accessToken = "token-a11989065f264df18016b221889c1de9-598c178b43b6419083cffb512991cc4f";

        XiaohongshuAppClientDTO appDTO = new XiaohongshuAppClientDTO();
        appDTO.setAppId(appId);
        appDTO.setAppSecret(appSecret);
        appDTO.setApiUrl(apiUrl);
        appDTO.setAccessToken(accessToken);

//        String cpCode = "shunfeng";
        Integer billVersion = 2;
        String type = "ark";
        XiaohongshuEbillTemplatesReqDTO reqDTO = new XiaohongshuEbillTemplatesReqDTO();
//        reqDTO.setCpCode(cpCode);
        reqDTO.setType(type);
        reqDTO.setBillVersion(billVersion);
        XiaohongshuEbillTemplatesRespVO respVO = xiaohongshuLogisticsCall.queryEbillTemplates(appDTO, reqDTO);
        System.out.println(respVO.getRespBody());
        System.out.println(JSON.toJSONString(respVO));

        //
       }
}
