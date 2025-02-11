package com.eshop.util.platform.api.service.order.dhgate;

import com.alibaba.fastjson.JSONObject;
import com.eshop.util.platform.api.structure.dhgate.dto.DhAppClientDTO;

/**
 * @author ldj
 * @date 2023/6/7 16:44
 * @Description: ...
 * @Version 1.0
 */
public interface DhGateOrderCall {

    /**
     * 获取订单列表
     *
     * @param publicDto
     * @param businessDto
     * @return
     */
    String getOrderList(DhAppClientDTO publicDto, JSONObject businessDto) throws Exception;

    /**
     * 获取订单详情
     *
     * @param publicDto
     * @param businessDto
     * @return
     */
    String getOrderDetail(DhAppClientDTO publicDto, JSONObject businessDto) throws Exception;

    /**
     * 获取订单商品
     *
     * @param publicDto
     * @param businessDto
     * @return
     */
    String getOrderProductList(DhAppClientDTO publicDto, JSONObject businessDto) throws Exception;

    /**
     * 获取订单物流轨迹列表
     *
     * @param publicDto
     * @param businessDto
     * @return
     */
    String getOrderShipmentTracking(DhAppClientDTO publicDto, JSONObject businessDto) throws Exception;

    /**
     * 获取seller纠纷开启订单列表接口
     *
     * @param publicDto
     * @param businessDto
     * @return
     */
    String orderDisputeOpenListPage(DhAppClientDTO publicDto, JSONObject businessDto) throws Exception;

    /**
     * 获取seller纠纷关闭订单列表接口
     *
     * @param publicDto
     * @param businessDto
     * @return
     */
    String orderDisputeCloseListPage(DhAppClientDTO publicDto, JSONObject businessDto) throws Exception;

    /**
     * 获取订单的退款信息接口
     *
     * @param publicDto
     * @param businessDto
     * @return
     */
    String orderRefundList(DhAppClientDTO publicDto, JSONObject businessDto) throws Exception;


    /**
     * 判断订单是否可请款接口
     *
     * @param publicDto
     * @param businessDto
     * @return
     */
    String canSendInvoice(DhAppClientDTO publicDto, JSONObject businessDto) throws Exception;

    /**
     * 订单请款接口
     *
     * @param publicDto
     * @param businessDto
     * @return
     */
    String sendInvoice(DhAppClientDTO publicDto, JSONObject businessDto) throws Exception;
}
