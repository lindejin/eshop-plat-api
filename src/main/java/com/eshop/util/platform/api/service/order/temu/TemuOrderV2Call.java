package com.eshop.util.platform.api.service.order.temu;

import com.eshop.util.platform.api.service.order.temu.dto.TemuOrderDetailV2ReqDTO;
import com.eshop.util.platform.api.service.order.temu.dto.TemuOrderListV2ReqDTO;
import com.eshop.util.platform.api.service.order.temu.vo.TemuOrderDetailV2RespVO;
import com.eshop.util.platform.api.service.order.temu.vo.TemuOrderListV2RespVO;
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

}
