package com.eshop.order;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.eshop.entity.config.TbShop;
import com.eshop.service.config.ITbShopService;
import com.eshop.util.platform.api.service.marketing.temu.TemuActivityCall;
import com.eshop.util.platform.api.service.marketing.temu.vo.TemuActivityListRespVO;
import com.eshop.util.platform.api.structure.temu.dto.TemuAppClientDTO;
import com.eshop.util.platform.call.order.temu.TemuFullOrderCallService;
import com.eshop.util.platform.call.order.temu.dto.TemuFullOrderPurchaseOrderV2ReqDTO;
import com.eshop.util.platform.call.order.temu.vo.TemuFullOrderPurchaseOrderV2RespVO;
import com.eshop.util.shop.PlatformAppClientUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Collections;

@SpringBootTest
public class TemuFullOrderCallServiceTest {

    @Resource
    private PlatformAppClientUtils platformAppClientUtils;

    @Resource
    private ITbShopService shopService;

    @Resource
    private TemuFullOrderCallService temuFullOrderCallService;

    @Resource
    private TemuActivityCall temuActivityCall;

    @Test
    void getLogisticsShipment() throws Exception {
        String orderNo = "WB250325506705";
        Long pageNo = 1L;
        Long pageSize = 50L;
        Long shopId = 2319L;
        TbShop shopDO = shopService.getById(shopId);
        String shopLocation = "CN";
        TemuAppClientDTO clientDTO = platformAppClientUtils.getTemuAppClientDTO(shopDO, shopLocation);

        TemuFullOrderPurchaseOrderV2ReqDTO reqDTO = new TemuFullOrderPurchaseOrderV2ReqDTO();
        reqDTO.setPageSize(pageSize);
        reqDTO.setPageNo(pageNo);
        reqDTO.setSubPurchaseOrderSnList(Collections.singletonList(orderNo));

        TemuFullOrderPurchaseOrderV2RespVO respVO = temuFullOrderCallService.getPurchaseOrderV2(clientDTO, reqDTO);

        System.out.println(respVO.getRespBody());

        respVO.setRespBody(null);
        System.out.println(JSON.toJSONString(respVO, SerializerFeature.WriteMapNullValue));    }

    @Test
    void getLogisticsShipment2() throws Exception {
        Long shopId = 3127L;
        TbShop shopDO = shopService.getById(shopId);
        String shopLocation = "CN";
        TemuAppClientDTO clientDTO = platformAppClientUtils.getTemuAppClientDTO(shopDO, shopLocation);

        TemuActivityListRespVO temuActivityListRespVO = temuActivityCall.marketingActivityListGet(clientDTO, null);
        System.out.println(temuActivityListRespVO.getRespBody());
    }

}
