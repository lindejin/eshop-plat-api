package com.eshop.api;

import com.alibaba.fastjson.JSON;
import com.eshop.entity.config.TbShop;
import com.eshop.service.config.ITbShopService;
import com.eshop.util.platform.api.service.order.temu.TemuOrderV2Call;
import com.eshop.util.platform.api.service.order.temu.dto.TemuOrderDetailV2ReqDTO;
import com.eshop.util.platform.api.service.order.temu.dto.TemuOrderPoLogisticsShipmentV2ReqDTO;
import com.eshop.util.platform.api.service.order.temu.dto.TemuOrderPoOrderShippingInfoV2ReqDTO;
import com.eshop.util.platform.api.service.order.temu.vo.TemuOrderDetailV2RespVO;
import com.eshop.util.platform.api.service.order.temu.vo.TemuOrderPoLogisticsShipmentV2RespVO;
import com.eshop.util.platform.api.service.order.temu.vo.TemuOrderPoOrderShippingInfoV2RespVO;
import com.eshop.util.platform.api.structure.temu.dto.TemuAppClientDTO;
import com.eshop.util.shop.PlatformAppClientUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class TemuOrderV2CallTest {

    @Resource
    private PlatformAppClientUtils platformAppClientUtils;

    @Resource
    private ITbShopService shopService;

    @Resource
    private TemuOrderV2Call temuOrderV2Call;


    @Test
    void getOrderDetailV2() throws Exception {
        Long shopId = 3110L;
        TbShop shopDO = shopService.getById(shopId);
        String shopLocation = "GL";
        TemuAppClientDTO clientDTO = platformAppClientUtils.getTemuAppClientDTO(shopDO, shopLocation);

        TemuOrderDetailV2ReqDTO reqDTO = new TemuOrderDetailV2ReqDTO();
        reqDTO.setParentOrderSn("PO-160-09101158113912953");
        TemuOrderDetailV2RespVO respVO = temuOrderV2Call.getOrderDetailV2(clientDTO, reqDTO);
        System.out.println(respVO.getRespBody());
        System.out.println(JSON.toJSON(respVO));
    }


    @Test
    void getOrderShippingInfoV2() throws Exception {
        Long shopId = 3110L;
        TbShop shopDO = shopService.getById(shopId);
        String shopLocation = "GL";
        TemuAppClientDTO clientDTO = platformAppClientUtils.getTemuAppClientDTO(shopDO, shopLocation);

        TemuOrderPoOrderShippingInfoV2ReqDTO reqDTO = new TemuOrderPoOrderShippingInfoV2ReqDTO();
        reqDTO.setParentOrderSn("PO-160-09101158113912953");
        TemuOrderPoOrderShippingInfoV2RespVO respVO = temuOrderV2Call.getOrderShippingInfoV2(clientDTO, reqDTO);
        System.out.println(respVO.getRespBody());
        System.out.println(JSON.toJSON(respVO));
    }



    @Test
    void getLogisticsShipmentV2() throws Exception {
        Long shopId = 3110L;
        TbShop shopDO = shopService.getById(shopId);
        String shopLocation = "GL";
        TemuAppClientDTO clientDTO = platformAppClientUtils.getTemuAppClientDTO(shopDO, shopLocation);

        TemuOrderPoLogisticsShipmentV2ReqDTO reqDTO = new TemuOrderPoLogisticsShipmentV2ReqDTO();
        reqDTO.setParentOrderSn("PO-160-09101158113912953");
        reqDTO.setOrderSn("160-09101262971512953");
        TemuOrderPoLogisticsShipmentV2RespVO respVO = temuOrderV2Call.getLogisticsShipmentV2(clientDTO, reqDTO);
        System.out.println(respVO.getRespBody());
        System.out.println(JSON.toJSON(respVO));
    }
}
