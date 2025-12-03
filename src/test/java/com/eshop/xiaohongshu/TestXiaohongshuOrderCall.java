package com.eshop.xiaohongshu;

import com.alibaba.fastjson.JSON;
import com.eshop.util.platform.api.client.xiaohongshu.request.XiaohongshuAppClientDTO;
import com.eshop.util.platform.api.service.logistics.xiaohongshu.XiaohongshuLogisticsCall;
import com.eshop.util.platform.api.service.logistics.xiaohongshu.dto.XiaohongshuEbillOrderReqDTO;
import com.eshop.util.platform.api.service.logistics.xiaohongshu.vo.XiaohongshuEbillOrderRespVO;
import com.eshop.util.platform.api.service.order.xiaohongshu.XiaohongshuOrderCall;
import com.eshop.util.platform.api.service.order.xiaohongshu.dto.XiaohongshuOrderDetailReqDTO;
import com.eshop.util.platform.api.service.order.xiaohongshu.vo.XiaohongshuOrderDetailRespVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class TestXiaohongshuOrderCall {

    @Autowired
    private XiaohongshuOrderCall xiaohongshuOrderCall;


    @Test
    public void queryEbillOrder() throws Exception {
        String apiUrl = "https://ark.xiaohongshu.com/ark/open_api/v3/common_controller";
        String appId = "698f0fae6fd04676aedd";
        String appSecret = "ea1ff5772da8a2d363976130c9199c62";
        String accessToken = "token-a67156322938498fbb24aba54d62069f-cc7df12b41c14602976fd45b130d2341";
        accessToken = "token-a67156322938498fbb24aba54d62069f-cc7df12b41c14602976fd45b130d2341";
        XiaohongshuAppClientDTO appDTO = new XiaohongshuAppClientDTO();
        appDTO.setAppId(appId);
        appDTO.setAppSecret(appSecret);
        appDTO.setApiUrl(apiUrl);
        appDTO.setAccessToken(accessToken);

        String orderId = "P780067065214122851";
        XiaohongshuOrderDetailReqDTO reqDTO = new XiaohongshuOrderDetailReqDTO();
        reqDTO.setOrderId(orderId);
        XiaohongshuOrderDetailRespVO respVO = xiaohongshuOrderCall.getOrderDetail(appDTO, reqDTO);
        System.out.println(respVO.getRespBody());
        System.out.println(JSON.toJSONString(respVO));
 }
}
