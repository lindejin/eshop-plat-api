package com.eshop.jd;

import com.alibaba.fastjson.JSON;
import com.eshop.util.platform.api.client.jd.request.JdLogisticsAppClientDTO;
import com.eshop.util.platform.api.service.logistics.jdl.JdlLogisticsCall;
import com.eshop.util.platform.api.service.logistics.jdl.dto.JdlJdlPullDataReqDTO;
import com.eshop.util.platform.api.service.logistics.jdl.dto.JdlWayBillInfoDTO;
import com.eshop.util.platform.api.service.logistics.jdl.vo.JdlPrePrintDataInfoVO;
import com.eshop.util.platform.api.service.logistics.jdl.vo.JdlPullDataRespVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;
import java.util.UUID;

@SpringBootTest
public class JdlLogisticsCallTest3 {

    @Autowired
    private JdlLogisticsCall jdlLogisticsCall;

    @Test
    void pullData() throws Exception {
        String orderNo = "";
        String jdWayBillCode = "";
        String cpCode = "";

        //京东顺丰 3403243018384892
        //京东圆通 3397468009253077
        //京东顺丰
//        orderNo = "3406271018419657";
//        jdWayBillCode = "SF5107701791310";
//        cpCode = "SF";
//        pullDataCurl(orderNo, jdWayBillCode, cpCode);
//
//        //京东圆通
//        orderNo = "3397468009253077";
//        jdWayBillCode = "YT3761249829349";
//        cpCode = "YTO";
//        pullDataCurl(orderNo, jdWayBillCode, cpCode);

        //京东顺丰
        orderNo = "3399481006571411";
        jdWayBillCode = "SF1561678865032";
        cpCode = "SF";
        pullDataCurl(orderNo, jdWayBillCode, cpCode);

    }

    void pullDataCurl(String orderNo, String jdWayBillCode, String cpCode) throws Exception {
        String baseUri = "https://api.jdl.com";

        String appKey = "ea2331f2018e4682a58c74e02cfd2788";
        String appSecret = "a0400547d20f472a9af39c5134ac122e";
        String accessToken = "ddf0a1d62d794b5d836b4d69202a695f";

        JdLogisticsAppClientDTO acDTO = new JdLogisticsAppClientDTO();
        acDTO.setAppKey(appKey);
        acDTO.setAppSecret(appSecret);
        acDTO.setApiUrl(baseUri);
        acDTO.setAccessToken(accessToken);

        Integer popFlag = 1;
        String key = "";
        String value = "";
        Boolean flag = true;
        if (cpCode.equalsIgnoreCase("JD")
                || cpCode.equalsIgnoreCase("JDKY")
                || cpCode.equalsIgnoreCase("JDDJ")
                || cpCode.equalsIgnoreCase("ZY")) {
            key = "ewCustomerCode";
            value = "020K93319";
        } else {
            flag = false;
            key = "eCustomerCode";
            //顺丰 687349
            if (cpCode.equalsIgnoreCase("SF")) {
                value = "687349";
            }
            //圆通 687349
            if (cpCode.equalsIgnoreCase("YTO")) {
                value = "687349";
            }

        }

        //jdWayBillCode	String	条件	JDVC12044009714	京东物流运单号，cpCode为JD（京东快递）、JDKY（京东快运）、JDDJ（京东大件）、ZY（众邮快递）时必填。长度15-30
        JdlWayBillInfoDTO infoDTO = new JdlWayBillInfoDTO();
        infoDTO.setPopFlag(popFlag);
        infoDTO.setOrderNo(orderNo);
        if (flag) {
            infoDTO.setJdWayBillCode(jdWayBillCode);
        }else {
            infoDTO.setWayBillCode(jdWayBillCode);

        }
        java.util.List<JdlWayBillInfoDTO> wayBillInfos = new ArrayList<>();
        wayBillInfos.add(infoDTO);
        /**
         * key	String	是	ewCustomerCode	cpCode为 JD\JDKY\JDDJ\ZY 时，key 的值是ewCustomerCode；
         * value	String	是	11223344	cpCode为JD\JDKY\JDDJ\ZY时，value传商家编码（京东快递传商家编码，京东快运、京东大件传事业部编码）；
         * cpCode是非京东物流的其他物流服务时，key 的值是 eCustomerCode。长度13-14
         * cpCode是非京东物流的其他物流服务时，value 传下运单时无界电子面单店铺的vendorid或vendorcode。长度1-30
         */


        java.util.Map<String, String> parameters = new HashMap<>();
        parameters.put(key, value);
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
                .map(p -> p.get(0))
                .map(JdlPrePrintDataInfoVO::getPerPrintData)
                .orElse(null);

        System.out.println("print_data:" + print_data);
    }
}
