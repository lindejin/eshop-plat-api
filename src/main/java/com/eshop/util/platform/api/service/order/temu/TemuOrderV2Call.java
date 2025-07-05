package com.eshop.util.platform.api.service.order.temu;

import com.eshop.util.platform.api.service.order.temu.dto.*;
import com.eshop.util.platform.api.service.order.temu.dto.TemuOrderListV2ReqDTO;
import com.eshop.util.platform.api.service.order.temu.dto.TemuOrderPoOrderShippingInfoV2ReqDTO;
import com.eshop.util.platform.api.service.order.temu.vo.*;
import com.eshop.util.platform.api.service.order.temu.vo.TemuOrderListV2RespVO;
import com.eshop.util.platform.api.service.order.temu.vo.TemuOrderPoOrderShippingInfoV2RespVO;
import com.eshop.util.platform.api.structure.temu.dto.TemuAppClientDTO;

public interface TemuOrderV2Call {


    /**
     * 获取订单列表
     * 批量查询订单，同步来自Temu的消费者订单
     * US/EU
     */
    TemuOrderListV2RespVO getOrderListV2(TemuAppClientDTO publicDto, TemuOrderListV2ReqDTO reqDTO) throws Exception;

    /**
     * 获取订单详情
     * 查询单个订单详情
     * US/EU
     */
    TemuOrderDetailV2RespVO getOrderDetailV2(TemuAppClientDTO publicDto, TemuOrderDetailV2ReqDTO reqDTO) throws Exception;

    /**
     * 订单收货地址
     * 查询订单收货地址
     * US/EU
     */
    TemuOrderPoOrderShippingInfoV2RespVO getOrderShippingInfoV2(TemuAppClientDTO tcDTO, TemuOrderPoOrderShippingInfoV2ReqDTO reqDTO) throws Exception;

    /**
     * 订单发货运单查询接口
     * 查询单个订单对应包裹号及发货运单及承运商信息
     * US/EU
     */
    TemuOrderPoLogisticsShipmentV2RespVO getLogisticsShipmentV2(TemuAppClientDTO tcDTO, TemuOrderPoLogisticsShipmentV2ReqDTO reqDTO) throws Exception;


    /**
     * 订单发货通知接口
     * US/EU
     */
    TemuOrderPoV2LogisticsShipmentConfirmRespVO logisticsShipmentConfirmV2(TemuAppClientDTO tcDTO, TemuOrderPoV2LogisticsShipmentConfirmReqDTO reqDTO) throws Exception;
}
