package com.eshop.api2;

import com.alibaba.fastjson.JSON;
import com.eshop.entity.config.TbShop;
import com.eshop.service.config.ITbShopService;
import com.eshop.util.platform.api.service.logistics.temu.TemuOrderPoLogisticsCall;
import com.eshop.util.platform.api.service.logistics.temu.dto.TemuLogisticsShipmentCreateReqDTO;
import com.eshop.util.platform.api.service.logistics.temu.dto.TemuLogisticsShippingServicesReqDTO;
import com.eshop.util.platform.api.service.logistics.temu.dto.TemuLogisticsWarehouseListReqDTO;
import com.eshop.util.platform.api.service.logistics.temu.vo.TemuLogisticsShipmentCreateRespVO;
import com.eshop.util.platform.api.service.logistics.temu.vo.TemuLogisticsShippingServicesRespVO;
import com.eshop.util.platform.api.service.logistics.temu.vo.TemuLogisticsWarehouseListRespVO;
import com.eshop.util.platform.api.structure.temu.dto.TemuAppClientDTO;
import com.eshop.util.shop.PlatformAppClientUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class TemuOrderPoLogisticsCallTestNew {

    @Resource
    private PlatformAppClientUtils platformAppClientUtils;

    @Resource
    private ITbShopService shopService;

    @Resource
    private TemuOrderPoLogisticsCall temuOrderPoLogisticsCall;

    @Test
    void logisticsWarehouseListGet() throws Exception {
        Long shopId = 3110L;
        TbShop shopDO = shopService.getById(shopId);
        String shopLocation = "GL";
        TemuAppClientDTO gl = platformAppClientUtils.getTemuAppClientDTO(shopDO, shopLocation);

        TemuLogisticsWarehouseListReqDTO businessDto = new TemuLogisticsWarehouseListReqDTO();
        TemuLogisticsWarehouseListRespVO s = temuOrderPoLogisticsCall.logisticsWarehouseListGet(gl, businessDto);
        System.out.println(s.getRespBody());
        System.out.println(JSON.toJSON(s.getWarehouseList()));
    }
/*
{
    "result": {
        "warehouseList": [
            {
                "defaultWarehouse": true,
                "warehouseId": "WH-10971324948630058",
                "warehouseBrand": null,
                "regionId1": 160,
                "warehouseManagementType": 1,
                "warehouseName": "NYC-PH"
            }
        ]
    },
    "success": true,
    "requestId": "gl-a5c4c49b-4656-48c5-a59b-4032d45ad011",
    "errorCode": 1000000,
    "errorMsg": ""
}
 */


    /**
     * 查询在线物流方式
     * 查询对应包裹在线发货可用物流服务
     */
    @Test
    void logisticsShippingServicesGet() throws Exception {
        Long shopId = 3110L;
        TbShop shopDO = shopService.getById(shopId);
        String shopLocation = "GL";
        TemuAppClientDTO gl = platformAppClientUtils.getTemuAppClientDTO(shopDO, shopLocation);


        //订单同步的包裹号
        List<String> orderSnList = new ArrayList<>();

        //160-03454391716472051
        orderSnList.add("160-03454391716472051");

        TemuLogisticsShippingServicesReqDTO reqDTO = new TemuLogisticsShippingServicesReqDTO();
        //仓库id
        reqDTO.setWarehouseId("WH-10971324948630058");
        reqDTO.setOrderSnList(orderSnList);


        //0.21kg 30 25 10
        //重量
        reqDTO.setWeight("0.21");
        //重量单位
        reqDTO.setWeightUnit("kg");

        //长
        reqDTO.setLength("30.00");
        //宽
        reqDTO.setWidth("25.00");
        //高
        reqDTO.setHeight("10.00");
        //体积单位
        reqDTO.setDimensionUnit("cm");
        TemuLogisticsShippingServicesRespVO respVO = temuOrderPoLogisticsCall.logisticsShippingServicesGet(gl, reqDTO);
        System.out.println(respVO.getRespBody());

        System.out.println(JSON.toJSON(respVO));

        /*
{
    "result": {
        "unavailableChannelDtoList": [
        ],
        "onlineChannelDtoList": [
            {
                "estimatedText": "预估₱41; PHP; 3-12 个工作日送达",
                "estimatedCurrencyCode": "PHP",
                "infoNeeded": null,
                "signServiceName": null,
                "signServiceId": null,
                "shipLogisticsType": "standard",
                "shippingCompanyName": "J&T Express (PH)",
                "estimatedAmount": "₱41",
                "shipCompanyId": 998265498,
                "channelId": 613786973679616,
                "payWayCode": 2
            }
        ]
    },
    "success": true,
    "requestId": "gl-b9f86d6f-8e45-4d72-a85c-766faa1e3f89",
    "errorCode": 1000000,
    "errorMsg": ""
}


         */
    }

    @Test
    void logisticsShipmentCreate() throws Exception {
        Long shopId = 3110L;
        TbShop shopDO = shopService.getById(shopId);
        String shopLocation = "GL";
        TemuAppClientDTO gl = platformAppClientUtils.getTemuAppClientDTO(shopDO, shopLocation);



        TemuLogisticsShipmentCreateReqDTO reqDTO = new TemuLogisticsShipmentCreateReqDTO();
        TemuLogisticsShipmentCreateRespVO respVO = temuOrderPoLogisticsCall.logisticsShipmentCreate(gl, reqDTO);
        System.out.println(respVO.getRespBody());

        System.out.println(JSON.toJSON(respVO));
    }

}
