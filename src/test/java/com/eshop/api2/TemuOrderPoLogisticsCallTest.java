package com.eshop.api2;

import com.alibaba.fastjson.JSON;
import com.eshop.entity.config.TbShop;
import com.eshop.service.config.ITbShopService;
import com.eshop.util.platform.api.service.order.temu.TemuOrderV2Call;
import com.eshop.util.platform.api.service.order.temu.dto.TemuOrderDetailV2ReqDTO;
import com.eshop.util.platform.api.service.order.temu.vo.TemuOrderDetailV2RespVO;
import com.eshop.util.platform.api.structure.temu.dto.TemuAppClientDTO;
import com.eshop.util.shop.PlatformAppClientUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class TemuOrderPoLogisticsCallTest {

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
        reqDTO.setParentOrderSn("PO-160-01121117317752676");
        TemuOrderDetailV2RespVO respVO = temuOrderV2Call.getOrderDetailV2(clientDTO, reqDTO);
        System.out.println(respVO.getRespBody());
        System.out.println(JSON.toJSON(respVO));
    }
}
