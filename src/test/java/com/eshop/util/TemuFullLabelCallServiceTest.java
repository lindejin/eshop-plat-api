package com.eshop.util;

import com.alibaba.fastjson.JSONObject;
import com.eshop.entity.config.TbShop;
import com.eshop.service.config.ITbShopService;
import com.eshop.util.platform.api.service.order.temu.TemuOrderPoCall;
import com.eshop.util.platform.api.structure.temu.dto.TemuAppClientDTO;
import com.eshop.util.platform.call.order.temu.TemuFullLabelCallService;
import com.eshop.util.platform.call.order.temu.dto.TemuFullGoodsCustomLabelReqDTO;
import com.eshop.util.platform.call.order.temu.dto.TemuFullGoodsLabelV2ReqDTO;
import com.eshop.util.platform.call.order.temu.dto.TemuFullLogisticsBoxMarkInfoReqDTO;
import com.eshop.util.platform.call.order.temu.vo.TemuFullGoodsCustomLabelRespVO;
import com.eshop.util.platform.call.order.temu.vo.TemuFullGoodsLabelV2RespVO;
import com.eshop.util.platform.call.order.temu.vo.TemuFullLogisticsBoxMarkInfoRespVO;
import com.eshop.util.shop.PlatformAppClientUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class TemuFullLabelCallServiceTest {

    @Resource
    private PlatformAppClientUtils platformAppClientUtils;

    @Resource
    private ITbShopService shopService;

    @Resource
    private TemuFullLabelCallService temuFullLabelCallService;

    @Test
    void getGoodsLabelV2() throws Exception {
        TbShop shopDO = shopService.getById(2319L);
        TemuAppClientDTO cn = platformAppClientUtils.getTemuAppClientDTO(shopDO, "CN");

        List<Long> productSkuIdList = new ArrayList<>();
        productSkuIdList.add(4255040281L);
        TemuFullGoodsLabelV2ReqDTO params = new TemuFullGoodsLabelV2ReqDTO();
        params.setProductSkuIdList(productSkuIdList);
        params.setPageSize(100L);
        params.setPage(1L);
        params.setReturn_data_key("true");
        TemuFullGoodsLabelV2RespVO respVO = temuFullLabelCallService.getGoodsLabelV2(cn, params);
        System.out.println(respVO);
        System.out.println(respVO.getRespBody());

        String url = "https://openapi.kuajingmaihuo.com/tool/print?dataKey=";

        JSONObject jsonObject = JSONObject.parseObject(respVO.getRespBody());
        String result = jsonObject.getString("result");
        System.out.println(url+result);
    }

    @Test
    void getGoodsLabelV2false() throws Exception {
        TbShop shopDO = shopService.getById(2319L);
        TemuAppClientDTO cn = platformAppClientUtils.getTemuAppClientDTO(shopDO, "CN");

        List<Long> productSkuIdList = new ArrayList<>();
        productSkuIdList.add(4255040281L);
        TemuFullGoodsLabelV2ReqDTO params = new TemuFullGoodsLabelV2ReqDTO();
        params.setProductSkuIdList(productSkuIdList);
        params.setPageSize(100L);
        params.setPage(1L);
        params.setReturn_data_key("false");
        TemuFullGoodsLabelV2RespVO respVO = temuFullLabelCallService.getGoodsLabelV2(cn, params);
        System.out.println(respVO);
        System.out.println(respVO.getRespBody());

        String url = "https://openapi.kuajingmaihuo.com/tool/print?dataKey=";

        JSONObject jsonObject = JSONObject.parseObject(respVO.getRespBody());
        String result = jsonObject.getString("result");
        System.out.println(url+result);
    }

    @Test
    void getGoodsCustomLabel() throws Exception {
        TbShop shopDO = shopService.getById(2319L);
        TemuAppClientDTO cn = platformAppClientUtils.getTemuAppClientDTO(shopDO, "CN");

        List<Long> productSkuIdList = new ArrayList<>();
        productSkuIdList.add(4255040281L);
        TemuFullGoodsCustomLabelReqDTO params = new TemuFullGoodsCustomLabelReqDTO();
        params.setProductSkuIdList(productSkuIdList);
        params.setPageSize(100L);
        params.setPage(1L);
        params.setReturn_data_key("true");
        TemuFullGoodsCustomLabelRespVO respVO = temuFullLabelCallService.getGoodsCustomLabel(cn, params);
        System.out.println(respVO);
        System.out.println(respVO.getRespBody());

        String url = "https://openapi.kuajingmaihuo.com/tool/print?dataKey=";

        JSONObject jsonObject = JSONObject.parseObject(respVO.getRespBody());
        String result = jsonObject.getString("result");
        System.out.println(url+result);
    }

    @Test
    void getGoodsCustomLabelfalse() throws Exception {
        TbShop shopDO = shopService.getById(2319L);
        TemuAppClientDTO cn = platformAppClientUtils.getTemuAppClientDTO(shopDO, "CN");

        List<Long> productSkuIdList = new ArrayList<>();
        productSkuIdList.add(4255040281L);
        TemuFullGoodsCustomLabelReqDTO params = new TemuFullGoodsCustomLabelReqDTO();
        params.setProductSkuIdList(productSkuIdList);
        params.setPageSize(100L);
        params.setPage(1L);
//        params.setReturn_data_key("false");
        TemuFullGoodsCustomLabelRespVO respVO = temuFullLabelCallService.getGoodsCustomLabel(cn, params);
        System.out.println(respVO);
        System.out.println(respVO.getRespBody());
    }

    @Test
    void getLogisticsBoxMarkInfo() throws Exception {
        TbShop shopDO = shopService.getById(2319L);
        TemuAppClientDTO cn = platformAppClientUtils.getTemuAppClientDTO(shopDO, "CN");

        List<String> deliveryOrderSnList = new ArrayList<>();
        deliveryOrderSnList.add("FH2504140586555");
        TemuFullLogisticsBoxMarkInfoReqDTO params = new TemuFullLogisticsBoxMarkInfoReqDTO();
        params.setReturn_data_key("true");
        params.setDeliveryOrderSnList(deliveryOrderSnList);
        TemuFullLogisticsBoxMarkInfoRespVO respVO = temuFullLabelCallService.getLogisticsBoxMarkInfo(cn, params);
        System.out.println(respVO);
        System.out.println(respVO.getRespBody());

        String url = "https://openapi.kuajingmaihuo.com/tool/print?dataKey=";

        JSONObject jsonObject = JSONObject.parseObject(respVO.getRespBody());
        String result = jsonObject.getString("result");
        System.out.println(url+result);
    }

    @Test
    void getLogisticsBoxMarkInfo2() throws Exception {
        TbShop shopDO = shopService.getById(2319L);
        TemuAppClientDTO cn = platformAppClientUtils.getTemuAppClientDTO(shopDO, "CN");

        List<String> deliveryOrderSnList = new ArrayList<>();
        deliveryOrderSnList.add("FH2504140586555");
        TemuFullLogisticsBoxMarkInfoReqDTO params = new TemuFullLogisticsBoxMarkInfoReqDTO();
        params.setReturn_data_key("false");
        params.setDeliveryOrderSnList(deliveryOrderSnList);
        TemuFullLogisticsBoxMarkInfoRespVO respVO = temuFullLabelCallService.getLogisticsBoxMarkInfo(cn, params);
        System.out.println(respVO);
        System.out.println(respVO.getRespBody());
    }
}
