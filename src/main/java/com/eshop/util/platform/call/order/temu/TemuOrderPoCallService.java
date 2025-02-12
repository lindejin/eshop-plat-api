package com.eshop.util.platform.call.order.temu;


import com.eshop.util.platform.api.structure.temu.dto.TemuAppClientDTO;
import com.eshop.util.platform.call.order.temu.dto.*;
import com.eshop.util.platform.call.order.temu.vo.*;

public interface TemuOrderPoCallService {

    /**
     * 获取订单列表
     */
    TemuOrderPoListRespVO getOrderList(TemuAppClientDTO tcDTO, TemuOrderPoListReqDTO orderListReqDTO) throws Exception;

    /**
     * 获取订单详情
     */
    TemuOrderPoDetailRespVO getOrderDetail(TemuAppClientDTO tcDTO, TemuOrderPoDetailReqDTO orderDetailReqDTO) throws Exception;

    /**
     * 可合并发货订单列表查询
     */
    TemuOrderPoCombinedShipmentListRespVO getCombinedShipmentList(TemuAppClientDTO tcDTO, TemuOrderPoCombinedShipmentListReqDTO combinedShipmentListReqDTO) throws Exception;

    /**
     * 订单收货地址查询
     */
    TemuOrderPoOrderShippingInfoRespVO getOrderShippingInfo(TemuAppClientDTO tcDTO, TemuOrderPoOrderShippingInfoReqDTO orderShippingInfoReqDTO) throws Exception;

    /**
     * 订单发货信息查询接口
     */
    TemuOrderPoLogisticsShipmentRespVO getLogisticsShipment(TemuAppClientDTO tcDTO, TemuOrderPoLogisticsShipmentReqDTO logisticsShipmentReqDTO) throws Exception;

    /**
     * 订单履约信息同步接口
     */
    TemuOrderPoOrderFulfillmentInfoSyncRespVO orderFulfillmentInfoSync(TemuAppClientDTO tcDTO, TemuOrderPoOrderFulfillmentInfoSyncReqDTO orderFulfillmentInfoSyncReqDTO) throws Exception;

    /**
     * 订单发货通知接口
     */
    TemuOrderPoLogisticsShipmentConfirmRespVO logisticsShipmentConfirm(TemuAppClientDTO tcDTO, TemuOrderPoLogisticsShipmentConfirmReqDTO logisticsShipmentConfirmReqDTO) throws Exception;

    /**
     * 批量发子包裹接口
     * 此接口只适应自发货场景下单件包裹拆多件进行运单号补充场景，此场景有较多校验逻辑，
     * 如：主包裹发货时间24小时内且状态必须为已发运不能已签收 等，具体可见限制逻辑和对应报错
     */
    TemuOrderPoLogisticsShipmentSubConfirmRespVO logisticsShipmentSubConfirm(TemuAppClientDTO tcDTO, TemuOrderPoLogisticsShipmentSubConfirmReqDTO logisticsShipmentSubConfirmReqDTO) throws Exception;

    /**
     * 物流模版查询接口
     */
    TemuOrderPoLogisticsTemplateGetRespVO logisticsTemplateGet(TemuAppClientDTO tcDTO, TemuOrderPoLogisticsTemplateGetReqDTO logisticsTemplateGetReqDTO) throws Exception;

    /**
     * 物流商查询接口
     */
    TemuOrderPoLogisticsCompaniesGetRespVO logisticsCompaniesGet(TemuAppClientDTO tcDTO, TemuOrderPoLogisticsCompaniesGetReqDTO logisticsCompaniesGetReqDTO) throws Exception;

    /**
     * 查询父售后单信息
     */
    TemuOrderPoAfterSalesParentAfterSalesListGetRespVO afterSalesParentAfterSalesListGet(TemuAppClientDTO tcDTO, TemuOrderPoAfterSalesParentAfterSalesListGetReqDTO afterSalesParentAfterSalesListGetReqDTO) throws Exception;

    /**
     * 查询子售后单信息
     */
    TemuOrderPoAfterSalesAfterSalesListGetRespVO afterSalesAfterSalesListGet(TemuAppClientDTO tcDTO, TemuOrderPoAfterSalesAfterSalesListGetReqDTO afterSalesAfterSalesListGetReqDTO) throws Exception;

    /**
     * 查询售后逆向物流信息
     */
    TemuOrderPoAfterSalesParentReturnOrderGetRespVO afterSalesParentReturnOrderGet(TemuAppClientDTO tcDTO, TemuOrderPoAfterSalesParentReturnOrderGetReqDTO afterSalesParentReturnOrderGetReqDTO) throws Exception;
}
