package com.eshop.logistics;


import com.eshop.entity.logistics.TbLogisticsFreight;

import java.math.BigDecimal;
import java.util.List;

/**
 * 包裹费用算法
 */
public interface ParcelCostUtils {

    /**
     * 计算商户_成本价
     * @param costPrice
     * @param purchaseDiscount
     * @param otherExpenses
     * @return
     */
    BigDecimal merchantCostPriceCalculate(BigDecimal costPrice, Double purchaseDiscount,BigDecimal otherExpenses);


    /**
     * 预估物流运费
     * @param lfs
     * @param weight 单位（kg）统一单位好计算
     * @return
     */
    BigDecimal estimateFreightCalculate(List<TbLogisticsFreight> lfs, Double weight);
}
