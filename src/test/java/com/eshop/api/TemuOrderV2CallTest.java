package com.eshop.api;

import com.alibaba.fastjson.JSON;
import com.eshop.entity.config.TbShop;
import com.eshop.service.config.ITbShopService;
import com.eshop.util.platform.api.service.order.temu.TemuOrderV2Call;
import com.eshop.util.platform.api.service.order.temu.dto.TemuOrderDetailV2ReqDTO;
import com.eshop.util.platform.api.service.order.temu.vo.TemuOrderDetailV2RespVO;
import com.eshop.util.platform.api.service.product.temu.TemuProductCall;
import com.eshop.util.platform.api.service.product.temu.dto.TemuGoodsDetailGetReqDTO;
import com.eshop.util.platform.api.service.product.temu.vo.TemuGoodsDetailGetRespVO;
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
    void goodsDetailGet() throws Exception {
        Long shopId = 2325L;
        TbShop shopDO = shopService.getById(shopId);
        String shopLocation = "US";
        TemuAppClientDTO clientDTO = platformAppClientUtils.getTemuAppClientDTO(shopDO, shopLocation);

        TemuOrderDetailV2ReqDTO reqDTO = new TemuOrderDetailV2ReqDTO();
        reqDTO.setParentOrderSn("PO-211-01733195300390308");
        TemuOrderDetailV2RespVO respVO = temuOrderV2Call.getOrderDetailV2(clientDTO, reqDTO);
        System.out.println(respVO.getRespBody());
        System.out.println(JSON.toJSON(respVO));
    }
}
