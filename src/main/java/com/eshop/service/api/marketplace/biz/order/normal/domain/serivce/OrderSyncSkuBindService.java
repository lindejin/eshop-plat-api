package com.eshop.service.api.marketplace.biz.order.normal.domain.serivce;

import com.eshop.modal.modal.eshop_order.TbOrderProducts;

import java.util.List;
import java.util.Map;

/**
 * @author ldj
 * @date 2023/12/8 9:55
 * @Description: ...
 * @Version 1.0
 */
public interface OrderSyncSkuBindService {

    /**
     * 订单信息 订单sku 匹配 productSku
     */
    void orderSkuAndProductSkuBind(List<TbOrderProducts> opList, Long shopId) throws Exception;

    /**
     * 自动绑定平台sku
     *
     * @param opList 订单商品
     * @param shopId 店铺Id
     * @return java.util.Map<java.lang.String, java.util.List < com.eshop.modal.modal.eshop_order.TbOrderProducts>>
     * @author sheng
     * @date 2023-12-11 16:35
     */
    Map<String, List<TbOrderProducts>> autoBindingFinishProduct(List<TbOrderProducts> opList, Long shopId) throws Exception;

    /**
     * 自动绑定平台sku2
     */
    Map<String, Long> autoBindingFinishProduct2(List<TbOrderProducts> opList, Long depotId) throws Exception;
}