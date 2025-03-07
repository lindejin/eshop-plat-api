package com.eshop.service.api.marketplace.biz.order.normal.domain.serivce;

import com.eshop.modal.modal.eshop_order.TbOrderProducts;

import java.util.List;

/**
 * @author ldj
 * @date 2023/12/8 10:21
 * @Description: ...
 * @Version 1.0
 */
public interface OrderSyncSkuDeclareService {

    /**
     * 处理订单sku 装配申报信息并入库
     */
    void orderSkuAndProductSkuToDeclare(List<TbOrderProducts> opList) throws Exception;
}
