package com.eshop.service.api.marketplace.biz.order.normal.domain.serivce;

import com.alibaba.fastjson.JSONObject;
import com.eshop.modal.entry.platform.config.PlatformSyncDTO;
import com.eshop.modal.entry.platform.order.dto.OrderSyncDTO;
import com.eshop.modal.webutil.order.TbOrderInfo;

import java.sql.SQLException;

/**
 * @author ldj
 * @date 2023/6/26 14:04
 * @Description: ...
 * @Version 1.0
 */
public interface OrderSyncManagerService {

    /**
     * 同步订单列表(新增)
     *
     */
    void orderSyncAdd(PlatformSyncDTO psDto, OrderSyncDTO osDto, boolean isCursor) throws SQLException, Exception;

    /**
     * 同步订单列表(更新)
     *
     */
    void orderSyncUpdate(PlatformSyncDTO psDto, OrderSyncDTO osDto, boolean isCursor) throws SQLException, Exception;

    /**
     * 回调订单列表(更新 需要请求详情然后判断更新)
     */
    void orderSyncCallback(PlatformSyncDTO psDto, String orderNo, JSONObject payload) throws SQLException, Exception;

    /**
     * 回调订单列表(更新2 直接更新)
     */
    void updateOrderDetailSync(PlatformSyncDTO psDTO, TbOrderInfo orderInfo);

    /**
     * 同步订单列表(订单取消申请)
     *
     */
    void orderSyncInCancel(PlatformSyncDTO psDto, OrderSyncDTO osDto, boolean isCursor) throws SQLException, Exception;

}
