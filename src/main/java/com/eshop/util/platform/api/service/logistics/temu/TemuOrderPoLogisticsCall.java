package com.eshop.util.platform.api.service.logistics.temu;

import com.alibaba.fastjson.JSONObject;
import com.eshop.util.platform.api.structure.temu.dto.TemuAppClientDTO;

public interface TemuOrderPoLogisticsCall {

    /**
     * 查询卖家发货仓库基础信息接口
     * US/EU
     */
    String logisticsWarehouseListGet(TemuAppClientDTO publicDto, JSONObject businessDto) throws Exception;

    /**
     * 查询可用物流服务接口
     * US/EU
     */
    String logisticsShippingServicesGet(TemuAppClientDTO publicDto, JSONObject businessDto) throws Exception;

    /**
     * 物流在线发货下单接口
     * US/EU
     */
    String logisticsShipmentCreate(TemuAppClientDTO publicDto, JSONObject businessDto) throws Exception;

    /**
     * 下call成功待发货包裹列表查询接口
     * US/EU
     */
    String orderUnshippedPackageGet(TemuAppClientDTO publicDto, JSONObject businessDto) throws Exception;

    /**
     * 确认包裹发货接口
     * US/EU
     */
    String logisticsShippedPackageConfirm(TemuAppClientDTO publicDto, JSONObject businessDto) throws Exception;

    /**
     * 物流在线发货下单查询接口
     * US/EU
     */
    String logisticsShipmentResultGet(TemuAppClientDTO publicDto, JSONObject businessDto) throws Exception;

    /**
     * 物流在线发货重新下单接口
     * US/EU
     */
    String logisticsShipmentUpdate(TemuAppClientDTO publicDto, JSONObject businessDto) throws Exception;

    /**
     * 物流在线发货修改物流接口
     * US/EU
     */
    String logisticsShipmentShippingTypeUpdate(TemuAppClientDTO publicDto, JSONObject businessDto) throws Exception;

    /**
     * 物流在线发货打印面单接口
     * US/EU
     */
    String logisticsShipmentDocumentGet(TemuAppClientDTO publicDto, JSONObject businessDto) throws Exception;
}
