package com.eshop.util.platform.api.service.logistics.temu;

import com.alibaba.fastjson.JSONObject;
import com.eshop.util.platform.api.service.logistics.temu.dto.*;
import com.eshop.util.platform.api.service.logistics.temu.vo.*;
import com.eshop.util.platform.api.structure.temu.dto.TemuAppClientDTO;

public interface TemuOrderPoLogisticsCall {

    /**
     * 查询卖家发货仓库基础信息接口
     * US/EU
     */
    TemuLogisticsWarehouseListRespVO logisticsWarehouseListGet(TemuAppClientDTO publicDto, TemuLogisticsWarehouseListReqDTO reqDTO) throws Exception;

    /**
     * temu.logistics.shiplogisticstype.get
     * 描述：您可以通过此 API 获取所有在线发货物流类型的信息。
     * 之后，他们可以在 Temu 上调用“bg.logistics.shipment.create”来创建购买发货。
     * 一旦您选择购买发货物流类型，Temu 将自动为您选择最推荐的渠道 ID 和购买发货方式。
     */
    TemuLogisticsShipLogisticsTypeRespVO logisticsShipLogisticsTypeGet(TemuAppClientDTO temuAcDTO, TemuLogisticsShipLogisticsTypeReqDTO reqDTO) throws Exception;

    /**
     * 查询可用物流服务接口
     * US/EU
     */
    TemuLogisticsShippingServicesRespVO logisticsShippingServicesGet(TemuAppClientDTO publicDto, TemuLogisticsShippingServicesReqDTO reqDTO) throws Exception;

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
    TemuLogisticsShipmentResultRespVO logisticsShipmentResultGet(TemuAppClientDTO temuAcDTO, TemuLogisticsShipmentResultReqDTO reqDTO) throws Exception;

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
    TemuLogisticsShipmentDocumentRespVO logisticsShipmentDocumentGet(TemuAppClientDTO publicDto, TemuLogisticsShipmentDocumentReqDTO businessDto) throws Exception;
}
