package com.eshop.util.platform.api.service.order.temu;

import com.alibaba.fastjson.JSONObject;
import com.eshop.util.platform.api.structure.temu.dto.TemuAppClientDTO;

public interface TemuOrderPoCall {

    /**
     * 获取订单列表
     * 批量查询订单，同步来自Temu的消费者订单
     * US/EU
     */
    String getOrderList(TemuAppClientDTO publicDto, JSONObject businessDto) throws Exception;

    /**
     * 获取订单详情
     * 查询单个订单详情
     * US/EU
     */
    String getOrderDetail(TemuAppClientDTO publicDto, JSONObject businessDto) throws Exception;

    /**
     * 可合并发货订单列表查询
     * US/EU
     */
    String getCombinedShipmentList(TemuAppClientDTO publicDto, JSONObject businessDto) throws Exception;

    /**
     * 订单收货地址查询接口
     * 查询单个订单收货人及收货地址信息
     * US/EU
     */
    String getOrderShippingInfo(TemuAppClientDTO publicDto, JSONObject businessDto) throws Exception;

    /**
     * 订单发货运单查询接口
     * 查询单个订单对应包裹号及发货运单及承运商信息
     * US/EU
     */
    String getLogisticsShipment(TemuAppClientDTO publicDto, JSONObject businessDto) throws Exception;

    /**
     * 订单履约信息同步接口
     * US/EU
     */
    String orderFulfillmentInfoSync(TemuAppClientDTO publicDto, JSONObject businessDto) throws Exception;

    /**
     * 订单发货通知接口
     * US/EU
     */
    String logisticsShipmentConfirm(TemuAppClientDTO publicDto, JSONObject businessDto) throws Exception;

    /**
     * 批量发子包裹接口
     * US/EU
     */
    String logisticsShipmentSubConfirm(TemuAppClientDTO publicDto, JSONObject businessDto) throws Exception;

    /**
     * 物流模版查询接口
     * US/EU
     */
    String logisticsTemplateGet(TemuAppClientDTO publicDto, JSONObject businessDto) throws Exception;

    /**
     * 物流商查询接口
     * US/EU
     */
    String logisticsCompaniesGet(TemuAppClientDTO publicDto, JSONObject businessDto) throws Exception;

    /**
     * 查询父售后单信息
     * US/EU
     */
    String afterSalesParentAfterSalesListGet(TemuAppClientDTO publicDto, JSONObject businessDto) throws Exception;

    /**
     * 查询子售后单信息
     * US/EU
     */
    String afterSalesAfterSalesListGet(TemuAppClientDTO publicDto, JSONObject businessDto) throws Exception;

    /**
     * 查询售后逆向物流信息
     * US/EU
     */
    String afterSalesParentReturnOrderGet(TemuAppClientDTO publicDto, JSONObject businessDto) throws Exception;

}
