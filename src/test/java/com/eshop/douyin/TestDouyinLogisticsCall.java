package com.eshop.douyin;

import com.alibaba.fastjson.JSON;
import com.eshop.util.platform.api.client.douyin.request.DouyinAppClientDTO;
import com.eshop.util.platform.api.service.logistics.douyin.DouyinLogisticsCall;
import com.eshop.util.platform.api.service.logistics.douyin.dto.DouyinWaybillApplyItemReqDTO;
import com.eshop.util.platform.api.service.logistics.douyin.dto.DouyinWaybillApplyReqDTO;
import com.eshop.util.platform.api.service.logistics.douyin.vo.DouyinWaybillApplyRespVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;


@SpringBootTest
public class TestDouyinLogisticsCall {

    @Autowired
    private DouyinLogisticsCall douyinLogisticsCall;


    @Test
    void getSaleOrderList() throws Exception {
        String apiUrl = "https://openapi-fxg.jinritemai.com";
        String appKey = "7564242597683381811";
        String appSecret = "00c66ba7-ea59-42ad-9b34-b105483151b3";
        String accessToken = "hfd86q0wc81lgwk7oxkf6er00001ri95-11";
        DouyinAppClientDTO acDTO = new DouyinAppClientDTO();
        acDTO.setAppKey(appKey);
        acDTO.setAppSecret(appSecret);
        acDTO.setApiUrl(apiUrl);
        acDTO.setAccessToken(accessToken);


        String logistics_code = "shunfeng";
        String track_no = "SF3262690419302";
        DouyinWaybillApplyItemReqDTO itemReqDTO = new DouyinWaybillApplyItemReqDTO();
        itemReqDTO.setLogistics_code(logistics_code);
        itemReqDTO.setTrack_no(track_no);

        List<DouyinWaybillApplyItemReqDTO> waybill_applies = new ArrayList<>();
        waybill_applies.add(itemReqDTO);
        DouyinWaybillApplyReqDTO reqDTO = new DouyinWaybillApplyReqDTO();
        reqDTO.setWaybill_applies(waybill_applies);

        DouyinWaybillApplyRespVO respVO = douyinLogisticsCall.waybillApply(acDTO, reqDTO);

        System.out.println(respVO.getRespBody());
        System.out.println(JSON.toJSON(respVO));

        //
    }
}
