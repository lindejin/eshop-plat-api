package com.eshop.service.api.marketplace.biz.order.normal.domain.serivce.impl;

import com.eshop.api.modules.service.api.marketplace.order.domain.order.domain.serivce.OrderSyncSkuBindService;
import com.eshop.api.modules.util.SkuBindingUtil;
import com.eshop.api.modules.util.TikTokUtil;
import com.eshop.api.modules.util.log.OrderLogServiceUtils;
import com.eshop.api.modules.util.service.ServiceMapUtils;
import com.eshop.db.product.service.main.TbExteriorSkuBindingService;
import com.eshop.db.product.service.main.TbProductService;
import com.eshop.modal.modal.eshop_order.TbOrderProducts;
import com.eshop.modal.modal.eshop_product.mian.TbExteriorSkuBinding;
import com.eshop.modal.modal.eshop_product.mian.TbProduct;
import com.eshop.modal.modal.eshop_product.mian.TbProductSku;
import com.eshop.modal.response.RetCode;
import com.eshop.util.platform.OrderUtils;
import com.eshop.util.platform.utils.order.DhgateOrderUtils;
import com.eshop.util.platform.utils.product.ProductSkuUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author ldj
 * @date 2023/12/8 9:55
 * @Description: ...
 * @Version 1.0
 */
@Service
@Slf4j
public class OrderSyncSkuBindServiceImpl implements OrderSyncSkuBindService {

    @Resource
    private ServiceMapUtils serviceMapUtils;

    @Resource
    private DhgateOrderUtils dhgateOrderUtils;

    @Resource
    private OrderLogServiceUtils orderLogServiceUtils;

    @Resource
    private TbExteriorSkuBindingService exteriorSkuBindingService;
    @Autowired
    private TbProductService productService;
    @Autowired
    private SkuBindingUtil skuBindingUtil;
    @Autowired
    private ProductSkuUtils productSkuUtils;


    /**
     * 订单信息 订单sku 匹配 productSku
     */
    @Override
    public void orderSkuAndProductSkuBind(List<TbOrderProducts> opList, Long shopId) throws Exception {
        //替换shopSku特殊字符
        dhgateOrderUtils.replaceSku(opList);
        //获取sku绑定信息
        List<TbExteriorSkuBinding> esbDOS = getExteriorSkuBindingList(opList);
        if (CollectionUtils.isEmpty(esbDOS)) {
            return;
        }
        //获取sku绑定映射 key:shopSku->value:productSku
        Map<String, String> skuBindingMap = productSkuUtils.getsSkuBindingMap(esbDOS);
        //获取绑定的sku信息
        Map<Object, TbProductSku> productSkuMap = getProductSkuMap(esbDOS);
        //获取绑定的spu信息
        Map<Object, TbProduct> productMap = getProductMap(productSkuMap);

        //循环订单sku 绑定信息赋值
        for (TbOrderProducts opDO : opList) {
            String shopSku = opDO.getShopSku();
            if (OrderUtils.isMakeUpForPrice(shopSku)) {
                continue;
            }
            String productSku = productSkuUtils.getSkuBinding(skuBindingMap, shopId, shopSku);
            if (StringUtils.isNotBlank(productSku)) {
                orderLogServiceUtils.bindingSaveLog(shopSku, productSku, opDO.getOrderNo());
            }
            TbProductSku psDO = productSkuMap.get(productSku);
            if (Objects.nonNull(psDO)) {
                opDO.setProductSku(productSku);
                opDO.setBasisWeight(psDO.getWeight());

                TbProduct productDO = productMap != null ? productMap.get(psDO.getSpuCode()) : null;
                if (productDO != null) {
                    opDO.setProductCnName(productDO.getBase().getProductName());
                    opDO.setProductEnName(productDO.getBase().getProductNameEn());
                }
            }
        }
    }

    /**
     * 自动绑定成品
     *
     * @param opList  订单商品
     * @param depotId 仓库Id
     * @author sheng
     * @date 2023-12-08 14:27
     */
    public Map<String, List<TbOrderProducts>> autoBindingFinishProduct(List<TbOrderProducts> opList, Long depotId) throws Exception {
        //未绑定的sku
        Map<String, List<TbOrderProducts>> unboundSpuMap = opList.stream()
                .filter(e -> StringUtils.isBlank(e.getProductSku()) && StringUtils.isNotBlank(e.getShopSku()))
                .collect(Collectors.groupingBy(e -> TikTokUtil.captureSpuCode(e.getShopSku())));
        if (CollectionUtils.sizeIsEmpty(unboundSpuMap)) {
            return Collections.emptyMap();
        }
        //成品信息
        List<TbProduct> tbProducts = productService.selectProductByRawSpusAndDepotId(unboundSpuMap.keySet(), depotId);
        if (CollectionUtils.isEmpty(tbProducts)) {
            return unboundSpuMap;
        }
        //过滤移出掉存在的spu
        tbProducts.stream().forEach(e -> {
            unboundSpuMap.remove(e.getRawSpu());
        });
        return unboundSpuMap;
    }

    public Map<String, Long> autoBindingFinishProduct2(List<TbOrderProducts> opList, Long depotId) throws Exception {
        //未绑定的sku
        Map<String, List<TbOrderProducts>> unboundSpuMap = opList.stream()
                .filter(e -> StringUtils.isBlank(e.getProductSku()) && StringUtils.isNotBlank(e.getShopSku()))
                .collect(Collectors.groupingBy(e -> TikTokUtil.captureSpuCode(e.getShopSku())));
        if (CollectionUtils.sizeIsEmpty(unboundSpuMap)) {
            return Collections.emptyMap();
        }
        //成品信息
        List<TbProduct> tbProducts = productService.selectProductByRawSpusAndDepotId(unboundSpuMap.keySet(), depotId);
        if (CollectionUtils.isNotEmpty(tbProducts)) {
            //过滤移出掉存在的spu
            tbProducts.stream().forEach(e -> {
                unboundSpuMap.remove(e.getRawSpu());
            });
        }
        Map<String, Long> result = unboundSpuMap.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        e -> e.getValue().stream()
                                .map(TbOrderProducts::getProductId)
                                .filter(Objects::nonNull)
                                .findFirst()
                                .orElse(null)
                ));
        return result;
    }


    /**
     * 获取第三方sku绑定信息表
     */
    private List<TbExteriorSkuBinding> getExteriorSkuBindingList(List<TbOrderProducts> opList) throws Exception {
        List<String> shopSkus = opList.stream().filter(k -> StringUtils.isNotBlank(k.getShopSku())).map(TbOrderProducts::getShopSku).distinct().collect(Collectors.toList());
        if (CollectionUtils.isEmpty(shopSkus)) {
            return null;
        }
        List<TbExteriorSkuBinding> resultList = exteriorSkuBindingService.selectInByProperty(TbExteriorSkuBinding::getShopSku, shopSkus);
        if (CollectionUtils.isEmpty(resultList)) {
            return null;
        }
        return resultList;
    }

    /**
     * 获取绑定的sku信息
     */
    private Map<Object, TbProductSku> getProductSkuMap(List<TbExteriorSkuBinding> esbs) throws Exception {
        List<String> skuCodes = esbs.stream().filter(p -> StringUtils.isNotBlank(p.getProductSku())).map(p -> p.getProductSku()).distinct().collect(Collectors.toList());
        Map<Object, TbProductSku> productSkuMap = serviceMapUtils.findProductSkuMap(skuCodes);
        return productSkuMap;
    }

    /**
     * 获取绑定的spu信息
     */
    private Map<Object, TbProduct> getProductMap(Map<Object, TbProductSku> productSkuMap) throws Exception {
        List<String> spuCodes = getSpuCodes(productSkuMap);
        Map<Object, TbProduct> productMap = serviceMapUtils.findProductMap(spuCodes);
        return productMap;
    }

    /**
     * 获取主产品spuCode集合
     */
    private List<String> getSpuCodes(Map<Object, TbProductSku> productSkuMap) throws Exception {
        if (MapUtils.isEmpty(productSkuMap)) {
            return null;
        }
        List<TbProductSku> list = new ArrayList<>(productSkuMap.values());
        List<String> spuCodes = list.stream().filter(k -> StringUtils.isNotBlank(k.getSpuCode())).map(k -> k.getSpuCode()).collect(Collectors.toList());
        if (CollectionUtils.isEmpty(spuCodes)) {
            return null;
        }
        return spuCodes;
    }

    /**
     * 绑定sku  TODO
     *
     * @param orderNo 订单号
     * @param skuCode 平台sku
     * @param shopSku 店铺sku
     * @param shopId  店铺Id
     * @return com.eshop.modal.modal.eshop_product.mian.TbExteriorSkuBinding
     * @author sheng
     * @date 2023-12-09 14:43
     */
    public TbExteriorSkuBinding generateSkuBindingInfo(String orderNo, String skuCode, String shopSku, Long shopId) {
        TbExteriorSkuBinding skuBinding = new TbExteriorSkuBinding();
        skuBinding.setProductSku(skuCode);
        skuBinding.setInsert(1);
        skuBinding.setMark(2);
        skuBinding.setOrderNo(orderNo);
        skuBinding.setShopSku(shopSku);
        skuBinding.setShopId(shopId);

        RetCode<String> rt = null;
        try {
            rt = skuBindingUtil.shopSkuBinding(skuBinding);
        } catch (Exception e) {
            log.error("自动绑定店铺sku( " + shopSku + " )失败, 失败原因:" + e);
            return null;
        }
        if (rt.getAck() != 0) {
            orderLogServiceUtils.saveOrderLogInfo(orderNo, "自动绑定店铺SKU", "店铺sku( " + shopSku + " )绑定失败," + rt.getMsg(), "sys");
            return null;
        }
        return skuBinding;
    }
}
