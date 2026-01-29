package com.eshop.jd;

import com.alibaba.fastjson.JSON;
import com.eshop.util.platform.api.client.jd.request.JdLogisticsAppClientDTO;
import com.eshop.util.platform.api.service.logistics.jdl.JdlLogisticsCall;
import com.eshop.util.platform.api.service.logistics.jdl.dto.JdlGetTemplatesReqDTO;
import com.eshop.util.platform.api.service.logistics.jdl.dto.JdlJdlPullDataReqDTO;
import com.eshop.util.platform.api.service.logistics.jdl.dto.JdlWayBillInfoDTO;
import com.eshop.util.platform.api.service.logistics.jdl.vo.JdlGetTemplatesRespVO;
import com.eshop.util.platform.api.service.logistics.jdl.vo.JdlPrePrintDataInfoVO;
import com.eshop.util.platform.api.service.logistics.jdl.vo.JdlPullDataRespVO;
import com.eshop.util.platform.api.service.logistics.taobao.vo.CainiaoWaybillIiQueryByWaybillcodeResponse;
import com.eshop.util.platform.api.service.logistics.taobao.vo.TaoBaoEbillOrderRespVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;
import java.util.UUID;

@SpringBootTest
public class JdlLogisticsCallTest2 {

    @Autowired
    private JdlLogisticsCall jdlLogisticsCall;


    @Test
    void getTemplates() throws Exception {
        String baseUri = "https://api.jdl.com";

        String appKey = "ea2331f2018e4682a58c74e02cfd2788";
        String appSecret = "a0400547d20f472a9af39c5134ac122e";
        String accessToken = "ddf0a1d62d794b5d836b4d69202a695f";

        JdLogisticsAppClientDTO acDTO = new JdLogisticsAppClientDTO();
        acDTO.setAppKey(appKey);
        acDTO.setAppSecret(appSecret);
        acDTO.setApiUrl(baseUri);
        acDTO.setAccessToken(accessToken);

        String cpCode = "";
        JdlGetTemplatesReqDTO reqDTO = new JdlGetTemplatesReqDTO();
        reqDTO.setCpCode(cpCode);
        JdlGetTemplatesRespVO respVO = jdlLogisticsCall.getTemplates(acDTO, reqDTO);

        System.out.println(respVO.getRespBody());
        System.out.println(JSON.toJSON(respVO));
    }


    @Test
    void pullData() throws Exception {
        String baseUri = "https://api.jdl.com";

        String appKey = "ea2331f2018e4682a58c74e02cfd2788";
        String appSecret = "a0400547d20f472a9af39c5134ac122e";
        String accessToken = "ddf0a1d62d794b5d836b4d69202a695f";

        JdLogisticsAppClientDTO acDTO = new JdLogisticsAppClientDTO();
        acDTO.setAppKey(appKey);
        acDTO.setAppSecret(appSecret);
        acDTO.setApiUrl(baseUri);
        acDTO.setAccessToken(accessToken);

        String cpCode = "JD";
         Integer popFlag = 1;
         String orderNo = "3389469006024998";
        //jdWayBillCode	String	条件	JDVC12044009714	京东物流运单号，cpCode为JD（京东快递）、JDKY（京东快运）、JDDJ（京东大件）、ZY（众邮快递）时必填。长度15-30
         String jdWayBillCode = "JDVC34585897824";
        JdlWayBillInfoDTO  infoDTO = new JdlWayBillInfoDTO();
        infoDTO.setPopFlag(popFlag);
        infoDTO.setOrderNo(orderNo);
        infoDTO.setJdWayBillCode(jdWayBillCode);
        java.util.List<JdlWayBillInfoDTO> wayBillInfos = new ArrayList<>();
        wayBillInfos.add(infoDTO);
        /**
         * key	String	是	ewCustomerCode	cpCode为JD\JDKY\JDDJ\ZY时，key的值是ewCustomerCode；
         * value	String	是	11223344	cpCode为JD\JDKY\JDDJ\ZY时，value传商家编码（京东快递传商家编码，京东快运、京东大件传事业部编码）；
         * cpCode是非京东物流的其他物流服务时，key的值是eCustomerCode。长度13-14
         * cpCode是非京东物流的其他物流服务时，value传下运单时无界电子面单店铺的vendorid或vendorcode。长度1-30
         */
         java.util.Map<String, String> parameters = new HashMap<>();
         parameters.put("ewCustomerCode", "020K93319");
         String objectId = UUID.randomUUID().toString();
        JdlJdlPullDataReqDTO reqDTO = new JdlJdlPullDataReqDTO();
        reqDTO.setCpCode(cpCode);
        reqDTO.setWayBillInfos(wayBillInfos);
        reqDTO.setParameters(parameters);
        reqDTO.setObjectId(objectId);
        JdlPullDataRespVO respVO = jdlLogisticsCall.pullData(acDTO, reqDTO);
        System.out.println(respVO.getRespBody());
        System.out.println(JSON.toJSON(respVO));

        String print_data = Optional.ofNullable(respVO)
                .map(JdlPullDataRespVO::getPrePrintDatas)
                .map(p->p.get(0))
                .map(JdlPrePrintDataInfoVO::getPerPrintData)
                .orElse(null);
        System.out.println(print_data);

        //{"code":"1","message":"操作成功！","objectId":"a92b4e50-a6d3-4715-b290-0f7ca7e3760f","prePrintDatas":[{"code":"1","msg":"操作成功！","packageCode":"JDVC33760951078-1-1-","perPrintData":"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","wayBillNo":"JDVC33760951078"}]}
        //{"respBody":"{\"code\":\"1\",\"message\":\"操作成功！\",\"objectId\":\"a92b4e50-a6d3-4715-b290-0f7ca7e3760f\",\"prePrintDatas\":[{\"code\":\"1\",\"msg\":\"操作成功！\",\"packageCode\":\"JDVC33760951078-1-1-\",\"perPrintData\":\"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\",\"wayBillNo\":\"JDVC33760951078\"}]}","code":"1","prePrintDatas":[{"msg":"操作成功！","code":"1","packageCode":"JDVC33760951078-1-1-","wayBillNo":"JDVC33760951078","perPrintData":"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"}],"message":"操作成功！","objectId":"a92b4e50-a6d3-4715-b290-0f7ca7e3760f"}


    }
}
