package com.eshop.service.api.marketplace.biz.order.normal.domain.serivce.impl;

import com.eshop.api.modules.service.api.marketplace.order.domain.order.domain.serivce.OrderSyncSkuDeclareService;
import com.eshop.api.modules.util.service.ServiceMapUtils;
import com.eshop.db.order.service.OrderDeclareService;
import com.eshop.modal.modal.eshop_order.TbOrderDeclare;
import com.eshop.modal.modal.eshop_order.TbOrderProducts;
import com.eshop.modal.modal.eshop_product.mian.TbProductDeclare;
import com.eshop.modal.modal.eshop_product.mian.TbProductSku;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author ldj
 * @date 2023/12/8 10:21
 * @Description: ...
 * @Version 1.0
 */
@Service
public class OrderSyncSkuDeclareServiceImpl implements OrderSyncSkuDeclareService {

    @Resource
    private ServiceMapUtils serviceMapUtils;

    @Resource
    private OrderDeclareService orderDeclareService;

    private final static String regex = "@@@";

    /**
     * 处理订单sku 装配申报信息并入库
     */
    @Override
    public void orderSkuAndProductSkuToDeclare(List<TbOrderProducts> opList) throws Exception {
        if (CollectionUtils.isEmpty(opList)) {
            return;
        }
        // 获取所有产品SKU
        List<String> skuCodes = opList.stream().map(TbOrderProducts::getProductSku).filter(StringUtils::isNotBlank).distinct().collect(Collectors.toList());
        if (CollectionUtils.isEmpty(skuCodes)) {
            return;
        }
        // 统计每个订单号和产品SKU的数量
        Map<String, Long> skuQuantityMap = getSkuQuantityMap(opList);
        // 获取申报信息
        Map<String, TbProductDeclare> productSkuDeclareMap = getProductSkuDeclareMap(skuCodes);
        List<TbOrderDeclare> odDOS = new ArrayList<>();
        skuQuantityMap.forEach((k, v) -> {
            String[] at = k.split(regex);
            String orderNo = at[0];
            String productSku = at[1];
            TbOrderDeclare odDO = new TbOrderDeclare();
            odDO.setOrderNo(orderNo);
            odDO.setProductSku(productSku);
            TbProductDeclare pdDO = productSkuDeclareMap.get(productSku);
            if (pdDO != null) {
                odDO.setDeclareCnName(pdDO.getDeclareName());
                odDO.setDeclareEnName(pdDO.getDeclareNameEn());
                odDO.setCustomsCode(pdDO.getCustomsName());
                odDO.setDeclareCount(v);
                Double declareWeight = null;

                try {
                    // 计算重量和价格
                    declareWeight = pdDO.getDeclareWeight() * v;
                } catch (Exception e) {
                    declareWeight = Double.valueOf(0);
                }

                BigDecimal declarePrice = null;
                try {
                    declarePrice = pdDO.getDeclarePrice().multiply(BigDecimal.valueOf(v));
                } catch (Exception e) {
                    declarePrice = BigDecimal.valueOf(0);
                }

                odDO.setDeclareWeight(declareWeight);
                odDO.setDeclarePrice(declarePrice);
            }
            odDOS.add(odDO);
        });
        if (CollectionUtils.isNotEmpty(odDOS)) {
            orderDeclareService.saveMul(odDOS);
        }
    }

    /**
     * 统计每个订单号和产品SKU的数量
     */
    private Map<String, Long> getSkuQuantityMap(List<TbOrderProducts> opList) {
        // 统计每个订单号和产品SKU的数量
        Map<String, Long> skuQuantityMap = new HashMap<>();
        for (TbOrderProducts opDO : opList) {
            //当产品SKU不为空时，才统计数量
            if (StringUtils.isNotBlank(opDO.getProductSku())) {
                // 订单号+产品SKU作为key
                String orderProductKey = getOrderProductKey(opDO);
                long quantity = opDO.getNumber();
                // 统计每个订单号和产品SKU的数量
                skuQuantityMap.put(orderProductKey, skuQuantityMap.getOrDefault(orderProductKey, 0L) + quantity);
            }
        }
        return skuQuantityMap;
    }

    /**
     * 订单号+产品SKU作为key
     */
    private String getOrderProductKey(TbOrderProducts opDO) {
        return opDO.getOrderNo() + regex + opDO.getProductSku();
    }

    /**
     * 根据skuCodes获取商品申报信息映射
     */
    private Map<String, TbProductDeclare> getProductSkuDeclareMap(List<String> skuCodes) throws Exception {
        // 获取skuCode和产品sku映射
        Map<Object, TbProductSku> productSkuMap = serviceMapUtils.findProductSkuMap(skuCodes);
        // 获取spuCode集合
        List<String> spuCodes = productSkuMap.values().stream().map(TbProductSku::getSpuCode).filter(StringUtils::isNotBlank).distinct().collect(Collectors.toList());
        // 获取spuCode和申报信息映射
        Map<Object, TbProductDeclare> productDeclareMap = serviceMapUtils.findProductDeclareMap(spuCodes);
        // 申报信息处置 key:skuCode value:申报信息
        Map<String, TbProductDeclare> skuProductDeclareMap = new HashMap<>();
        for (TbProductSku productSku : productSkuMap.values()) {
            String skuCode = productSku.getSkuCode();
            String spuCode = productSku.getSpuCode();
            TbProductDeclare productDeclare = productDeclareMap.get(spuCode);
            if (productDeclare != null) {
                skuProductDeclareMap.put(skuCode, productDeclare);
            }
        }
        return skuProductDeclareMap;
    }
}
