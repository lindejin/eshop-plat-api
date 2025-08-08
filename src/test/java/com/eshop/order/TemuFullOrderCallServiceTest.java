package com.eshop.order;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.eshop.entity.config.TbShop;
import com.eshop.service.config.ITbShopService;
import com.eshop.util.platform.api.service.marketing.temu.TemuActivityCall;
import com.eshop.util.platform.api.service.marketing.temu.vo.TemuActivityListRespVO;
import com.eshop.util.platform.api.structure.temu.dto.TemuAppClientDTO;
import com.eshop.util.platform.call.order.temu.order.TemuFullOrderCallService;
import com.eshop.util.platform.call.order.temu.order.dto.TemuFullOrderPurchaseOrderV2ReqDTO;
import com.eshop.util.platform.call.order.temu.order.vo.TemuFullOrderPurchaseOrderV2RespVO;
import com.eshop.util.platform.call.order.temu.ship.TemuOrderShipCall;
import com.eshop.util.platform.call.order.temu.ship.dto.TemuOrderShipPackageGetReqDTO;
import com.eshop.util.platform.call.order.temu.ship.dto.TemuOrderShipV2GetReqDTO;
import com.eshop.util.platform.call.order.temu.ship.vo.*;
import com.eshop.util.shop.PlatformAppClientUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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

    @Resource
    private TemuOrderShipCall temuOrderShipCall;

    @Test
    void getLogisticsShipment() throws Exception {
        String orderNo = "WB241224652164";
        Long pageNo = 1L;
        Long pageSize = 50L;
        Long shopId = 3258L;
        TbShop shopDO = shopService.getById(shopId);
        String shopLocation = "CN";
        TemuAppClientDTO clientDTO = platformAppClientUtils.getTemuAppClientDTO(shopDO, shopLocation);

        TemuFullOrderPurchaseOrderV2ReqDTO reqDTO = new TemuFullOrderPurchaseOrderV2ReqDTO();
        reqDTO.setPageSize(pageSize);
        reqDTO.setPageNo(pageNo);
        reqDTO.setSubPurchaseOrderSnList(Collections.singletonList(orderNo));

//        reqDTO.setPurchaseTimeTo(1753758770953L);
//        reqDTO.setPurchaseTimeFrom(1753748770953L);

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

    @Test
    void v2Get() throws Exception {
        String orderNo = "WB2508055677566";
        Long pageNo = 1L;
        Long pageSize = 50L;
        Long shopId = 3258L;
        TbShop shopDO = shopService.getById(shopId);
        String shopLocation = "CN";
        TemuAppClientDTO temuAcDTO = platformAppClientUtils.getTemuAppClientDTO(shopDO, shopLocation);


        TemuOrderShipV2GetReqDTO shipOrderDTO = new TemuOrderShipV2GetReqDTO();
        shipOrderDTO.setPageNo(1);
        shipOrderDTO.setPageSize(100);
        shipOrderDTO.setSubPurchaseOrderSnList(Arrays.asList(orderNo));
        TemuOrderShipV2GetRespVO shipOrder = temuOrderShipCall.v2Get(temuAcDTO, shipOrderDTO);

        System.out.println(shipOrder.getRespBody());
    }


    @Test
    void v2Get2() throws Exception {
        String orderNo = "WB2508055677566";
        Long shopId = 3258L;
        TbShop shopDO = shopService.getById(shopId);
        String shopLocation = "CN";
        TemuAppClientDTO temuAcDTO = platformAppClientUtils.getTemuAppClientDTO(shopDO, shopLocation);


        TemuOrderShipV2GetReqDTO shipOrderDTO = new TemuOrderShipV2GetReqDTO();
        shipOrderDTO.setPageNo(1);
        shipOrderDTO.setPageSize(100);
        shipOrderDTO.setSubPurchaseOrderSnList(Arrays.asList(orderNo));
        TemuOrderShipV2GetRespVO shipOrder = temuOrderShipCall.v2Get(temuAcDTO, shipOrderDTO);

        TemuOrderShipV2GetVO getVO = shipOrder.getResult().getList().get(0);
        String deliveryOrderSn = getVO.getDeliveryOrderSn();
        List<TemuOrderShipV2GetPackageVO> packageList = getVO.getPackageList();
        List<TemuOrderShipV2GetPackageDetailVO> packageDetailList = getVO.getPackageDetailList();


        TemuOrderShipPackageGetReqDTO reqDTO = new TemuOrderShipPackageGetReqDTO();
        reqDTO.setDeliveryOrderSn(deliveryOrderSn);
        TemuOrderShipPackageGetRespVO respVO = temuOrderShipCall.packageGet(temuAcDTO, reqDTO);

        List<TemuOrderShipPackageGetPackageInfoVO> packageInfo = respVO.getResult().getPackageInfo();


    }


}
