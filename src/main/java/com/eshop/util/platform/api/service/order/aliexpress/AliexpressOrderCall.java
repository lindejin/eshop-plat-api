package com.eshop.util.platform.api.service.order.aliexpress;

import com.eshop.util.platform.api.service.order.aliexpress.dto.*;
import com.eshop.util.platform.api.structure.aliexpress.dto.AeAppClientDTO;
import com.global.iop.util.ApiException;

/**
 * @author ldj
 * @date 2024/3/6 17:26
 * @Description: ...
 * @Version 1.0
 */
public interface AliexpressOrderCall {

    //获取订单收据信息
    String getSolutionOrderReceiptInfo(AeAppClientDTO aeAppClientDTO, AeOrderGetReceiptInfoDTO reqDto) throws ApiException;

    //从速卖通获取订单清单
    String getSolutionOrderList(AeAppClientDTO aeAppClientDTO, AeOrderGetSolutionOrderListDTO reqDto) throws ApiException;

    //为卖家配送订单
    String fulfillSolutionOrder(AeAppClientDTO aeAppClientDTO, AeOrderFulfillSolutionOrderDTO reqDto) throws ApiException;

    //买家订单物流详情解密
    String decryptOrder(AeAppClientDTO aeAppClientDTO, AeOrderDecryptOrderDTO reqDto) throws ApiException;

    //卖家同意取消订单
    String acceptCancelOrder(AeAppClientDTO aeAppClientDTO, AeOrderAcceptCancelOrderDTO reqDto) throws ApiException;

    //卖家拒绝取消订单
    String refuseCancelOrder(AeAppClientDTO aeAppClientDTO, AeOrderRefuseCancelOrderDTO reqDto) throws ApiException;

    //平台固定参数获取
    String getTaxationPlatform(AeAppClientDTO aeAppClientDTO, AeOrderGetTaxationPlatformDTO reqDto) throws ApiException;

    //延长买家收货时间
    String extendsBuyerAcceptGoodsTime(AeAppClientDTO aeAppClientDTO, AeOrderExtendsBuyerAcceptGoodsTimeDTO reqDto) throws ApiException;

    //新版交易订单详情查询
    String findOrderById(AeAppClientDTO aeAppClientDTO, AeOrderFindOrderByIdDTO reqDto) throws ApiException;

    //查询卖家备注内容
    String queryRemarks(AeAppClientDTO aeAppClientDTO, AeOrderQueryRemarksDTO reqDto) throws ApiException;

    //查询订单卖家备注
    String queryRemark(AeAppClientDTO aeAppClientDTO, AeOrderQueryRemarkDTO reqDto) throws ApiException;

    //查询订单放款信息
    String findLoanListQuery(AeAppClientDTO aeAppClientDTO, AeOrderFindLoanListQueryDTO reqDto) throws ApiException;

    //订单交易信息查询
    String findOrderTradeInfo(AeAppClientDTO aeAppClientDTO, AeOrderFindOrderTradeInfoDTO reqDto) throws ApiException;

    //订单列表查询
    String orderListGet(AeAppClientDTO aeAppClientDTO, AeOrderOrderListGetDTO reqDto) throws ApiException;

    //订单列表简化查询
    String findOrderListSimpleQuery(AeAppClientDTO aeAppClientDTO, AeOrderFindOrderListSimpleQueryDTO reqDto) throws ApiException;

    //订单基础信息查询
    String findOrderBaseInfo(AeAppClientDTO aeAppClientDTO, AeOrderFindOrderBaseInfoDTO reqDto) throws ApiException;

    //订单收货信息查询
    String findOrderReceiptInfo(AeAppClientDTO aeAppClientDTO, AeOrderFindOrderReceiptInfoDTO reqDto) throws ApiException;

    //记录订单备注信息
    String saveRemark(AeAppClientDTO aeAppClientDTO, AeOrderSaveRemarkDTO reqDto) throws ApiException;

}
