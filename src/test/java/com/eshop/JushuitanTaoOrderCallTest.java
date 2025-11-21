package com.eshop;

import com.alibaba.fastjson.JSON;
import com.eshop.util.platform.api.client.jushuitan.request.JushuitanAppClientDTO;
import com.eshop.util.platform.api.client.jushuitan.request.QimenCustomAppClientDTO;
import com.eshop.util.platform.api.service.order.jushuitan.JushuitanOrderCall;
import com.eshop.util.platform.api.service.order.jushuitan.JushuitanTaoOrderCall;
import com.eshop.util.platform.api.service.order.jushuitan.dto.JushuitanOrderListReqDTO;
import com.eshop.util.platform.api.service.order.jushuitan.dto.JushuitanTaoOrderListReqDTO;
import com.eshop.util.platform.api.service.order.jushuitan.vo.JushuitanOrderListRespVO;
import com.eshop.util.platform.api.service.order.jushuitan.vo.JushuitanTaoOrderListRespVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class JushuitanTaoOrderCallTest {

    @Autowired
    private JushuitanTaoOrderCall jushuitanTaoOrderCall;


    @Test
    void TaoOrderCallGetOrderList() throws Exception {

        /**
         * 可替换为您的应用的appKey
         * 聚水潭注释 奇门的appKey
         */
        String appKey = "23060081";
        /**
         * 可替换为您的应用的appSecret
         * 聚水潭注释 奇门的密钥
         */
        String appSecret= "";
        /**
         * 必须替换为授权得到的真实有效sessionKey
         * 聚水潭注释 非必填参数 可以不传
         */
        String sessionKey= "";
        /**
         * 用户需要透传的targetAppkey，主要用于安全验签，
         * 验签的目的是防止黑客恶意调用你的服务，确保服务发起来源来自奇门云网关。
         */
        String targetAppKey= "23060081";
        /**
         * 奇门调用地址
         * 聚水潭注释 请求容器URL
         */
        String apiUrl= "http://a1q40taq0j.api.taobao.com/router/qm";

        QimenCustomAppClientDTO appDTO = new QimenCustomAppClientDTO();
        appDTO.setAppKey(appKey);
        appDTO.setAppSecret(appSecret);
        appDTO.setSessionKey(sessionKey);
        appDTO.setTargetAppKey(targetAppKey);
        appDTO.setApiUrl(apiUrl);


        //page_index	int	是	1	页码
         Integer page_index = 1;
        //page_size	int	是	25	页数，最大100
         Integer page_size = 50;
        JushuitanTaoOrderListReqDTO reqDTO = new JushuitanTaoOrderListReqDTO();
        reqDTO.setPage_index(page_index);
        reqDTO.setPage_size(page_size);

        //start_time	string		2019-01-02 00:00:00	开始时间
         String start_time = "2019-01-02 00:00:00";
        //end_time	string		2019-01-02 00:00:00	结束时间
         String end_time= "2019-01-02 00:00:00";

        //订单状态不必填 因为需要拉取多个状态 这里不做限制

        JushuitanTaoOrderListRespVO respVO = jushuitanTaoOrderCall.getOrderList(appDTO, reqDTO);
        System.out.println(respVO.getRespBody());
        System.out.println(JSON.toJSON(respVO));
    }

}