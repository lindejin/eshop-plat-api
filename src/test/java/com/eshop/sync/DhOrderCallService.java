package com.eshop.sync;

import com.eshop.sync.dto.*;
import com.eshop.sync.vo.*;
import com.eshop.util.platform.api.structure.dhgate.dto.DhAppClientDTO;

/**
 * @author ldj
 * @date 2024/3/16 11:00
 * @Description: ...
 * @Version 1.0
 */
public interface DhOrderCallService {

    /**
     * 获取订单列表
     */
    DhOrderListRespVO getOrderList(DhAppClientDTO dcDTO, DhOrderListReqDTO orderListReqDTO) throws Exception;

    /**
     * 获取订单详情
     */
    DhOrderDetailRespVO getOrderDetail(DhAppClientDTO dcDTO, DhOrderDetailReqDTO orderDetailReqDTO) throws Exception;

    /**
     * 获取订单商品
     */
    DhOrderProductListRespVO getOrderProductList(DhAppClientDTO dcDTO, DhOrderProductListReqDTO orderProductListReqDTO) throws Exception;

    /**
     * 获取订单物流轨迹列表
     */
    DhOrderShipmentTrackingRespVO getOrderShipmentTracking(DhAppClientDTO dcDTO, DhOrderShipmentTrackingReqDTO orderShipmentTrackingReqDTO) throws Exception;

    /**
     * 获取纠纷开启订单列表接口
     */
    DhOrderDisputeOpenListRespVO orderDisputeOpenListPage(DhAppClientDTO dcDTO, DhOrderDisputeOpenListReqDTO orderDisputeOpenListReqDTO) throws Exception;

    /**
     * 获取纠纷关闭订单列表接口
     */
    DhOrderDisputeCloseListRespVO orderDisputeCloseListPage(DhAppClientDTO dcDTO, DhOrderDisputeCloseListReqDTO orderDisputeCloseListReqDTO) throws Exception;

    /**
     * 获取订单的退款信息接口
     */
    DhOrderRefundListRespVO getOrderRefundList(DhAppClientDTO dcDTO, DhOrderRefundListReqDTO orderRefundInfoReqDTO) throws Exception;

    /**
     * 判断订单是否可请款接口
     */
    DhOrderCanSendInvoiceRespVO canSendInvoice(DhAppClientDTO dcDTO, DhOrderCanSendInvoiceReqDTO orderCheckApplyMoneyReqDTO) throws Exception;

    /**
     * 订单请款接口
     */
    DhOrderSendInvoiceRespVO sendInvoice(DhAppClientDTO dcDTO, DhOrderSendInvoiceReqDTO orderSendInvoiceReqDTO) throws Exception;
}
