package com.eshop.service.api.marketplace.biz.order.normal.domain.repository;


import com.eshop.entity.base.PlatformSyncInfoResponseVO;
import com.eshop.entity.order.TbOrder;

/**
 * @author ldj
 * @date 2024/3/18 14:16
 * @Description: ...
 * @Version 1.0
 */
public interface OrderClient {

    /**
     * 获取信息 -- 分页
     */
    PageUtil getSyncOrderListCount(PlatformSyncDTO dto, OrderSyncDTO orderSyncDTO, Integer pageNo, Integer pageSize)throws Exception ;

    /**
     * 获取信息list -- 订单存量（新增）
     */
    PlatformSyncListResponseVO<PlatformSyncInfoResponseVO<TbOrder>> getAddSyncOrderList(PlatformSyncDTO dto, OrderSyncDTO orderSyncDTO, Integer pageNo, Integer pageSize, PlatformPageCursorDto cursorDto)throws Exception ;

    /**
     * 获取订单详情 - 新增
     */
    OrderAddContextVO getAddOrderDetailSync(PlatformSyncDTO psDto, PlatformSyncInfoResponseVO<TbOrder> po)throws Exception ;

    /**
     * 获取订单信息list -- 订单存量（更新）
     */
    PlatformSyncListResponseVO<PlatformSyncInfoResponseVO<TbOrder>> getUpdateSyncOrderList(PlatformSyncDTO psDto, OrderSyncDTO osDto, Integer pageNo, Integer pageSize, PlatformPageCursorDto cursorDto)throws Exception ;

    /**
     * 获取订单详情 - 更新
     */
    OrderUpContextVO getUpdateOrderDetailSync(PlatformSyncDTO psDto, PlatformSyncInfoResponseVO<TbOrder> po)throws Exception ;

    /**
     * 获取订单信息list -- 订单取消申请
     */
    PlatformSyncListResponseVO<PlatformSyncInfoResponseVO<TbOrder>> getInCancelSyncOrderList(PlatformSyncDTO psDto, OrderSyncDTO osDto, Integer pageNo, Integer pageSize, PlatformPageCursorDto cursorDto)throws Exception ;

    /**
     * 获取订单详情 - 订单取消申请
     */
    TbOrderInfo getInCancelOrderDetailSync(PlatformSyncDTO psDto, String orderNo)throws Exception ;
}
