package com.eshop.logistics;

import com.eshop.entity.logistics.TbLogisticsFreight;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 包裹费用算法
 */
@Component
public class ParcelCostUtilsImpl implements ParcelCostUtils {

    //计算系数0.05
    private static final BigDecimal coefficient = new BigDecimal("0.05");

    /**
     * 计算商户_成本价
     * 算法 2023-01-07
     * 商户成本价 = 原成本价 + (原成本价 * (0.05 * 商户采购成本折扣)) + (原成本价 + (原成本价 * (0.05 * 商户采购成本折扣))) * 0.05
     * 算法公式更新 2023-01-10
     * 商户成本价 = 原成本价 + (原成本价 * (0.05 * 商户采购成本折扣))
     * @param costPrice 成本价
     * @param purchaseDiscount 采购折扣比例
     * @return
     */
    public BigDecimal merchantCostPriceCalculate(BigDecimal costPrice, Double purchaseDiscount,BigDecimal otherExpenses) {
        if(costPrice == null){
            throw new RuntimeException("计算商户成本价:原成本价不能为空");
        }
        if(purchaseDiscount == null){
            throw new RuntimeException("计算商户成本价:采购折扣比例不能为空");
        }
        if(otherExpenses == null){
            otherExpenses = BigDecimal.ZERO;
        }
//        //采购折扣比例""
//        BigDecimal purchaseDiscountBd = new BigDecimal(purchaseDiscount);
//        // (0.05 * 商户采购成本折扣)
//        BigDecimal m1 = coefficient.multiply(purchaseDiscountBd);
//        //(原成本价 * (0.05 * 商户采购成本折扣))
//        BigDecimal m2 = costPrice.multiply(m1);
//        // (原成本价 + (原成本价 * (0.05 * 商户采购成本折扣))) * 0.05
//        BigDecimal m3 = costPrice.add(m2).multiply(coefficient);
//        //原成本价 + (原成本价 * (0.05 * 商户采购成本折扣)) + (原成本价 + (原成本价 * (0.05 * 商户采购成本折扣))) * 0.05

        //采购折扣比例
        BigDecimal purchaseDiscountBd = new BigDecimal(purchaseDiscount);
        // (0.05 * 商户采购成本折扣)
        BigDecimal m1 = coefficient.multiply(purchaseDiscountBd);
        //原成本价 * m1 == (原成本价 * (0.05 * 商户采购成本折扣))
        BigDecimal m2 = costPrice.multiply(m1);
        //原成本价 + m2 == 原成本价 + (原成本价 * (0.05 * 商户采购成本折扣))
        BigDecimal m3 = costPrice.add(m2);
        //其他费用+m3 = 原成本价 + (原成本价 * (0.05 * 商户采购成本折扣))  + 其他费用
        BigDecimal result = m3.add(otherExpenses);
        //四舍五入
        result = result.setScale(6, BigDecimal.ROUND_HALF_UP);
        return result;
    }


    /**
     * 预估物流运费
     *  **判断包裹当前重量是否大于首重, **
     *
     *  1.**如果大于则 预估运费 = 当前包裹重量 \* 运费(kg) +操作费+其他费用 **
     *  2.**如果不大于 预估运费 = 首重 \* 运费(kg) +操作费+其他费用 **
     * @param lfs
     * @param weight 单位（kg）统一单位好计算
     * @return
     */
    public BigDecimal estimateFreightCalculate(List<TbLogisticsFreight> lfs, Double weight) {
        if(CollectionUtils.isEmpty(lfs)){
            throw new RuntimeException("预估物流运费:物流资费不能为空");
        }
        if(weight == null){
            throw new RuntimeException("预估物流运费:重量不能为空");
        }
        //获取区间重量物流资费
        TbLogisticsFreight lf = getLogisticsFreightByIntervalWeight(lfs, weight);

        if(lf == null){
            throw new RuntimeException("重量:"+weight+" 预估物流运费:没有符合条件的物流资费");
        }
        if(lf == null){
            //不计算直接返回
            return null;
        }
        if (lf.getOperatingCost() == null) {
            throw new RuntimeException("重量:"+weight+" 操作费 operatingCost :null");
        }
        if (lf.getOtherFees() == null) {
            throw new RuntimeException("重量:"+weight+" 其他费用 otherFees : null");
        }
        //判断包裹当前重量是否大于首重
        Double ykg = lf.getYkg();
        if(weight.compareTo(ykg) >0){
            //大于首重 预估运费 = (当前包裹重量 \* 运费(kg) +操作费+其他费用)*折扣比例 **
            BigDecimal m1 = lf.getFreight().multiply(new BigDecimal(weight)).add(lf.getOperatingCost()).add(lf.getOtherFees());
            BigDecimal m2 = m1.multiply(new BigDecimal(lf.getLogisticsDiscount()));
            //四舍五入6位
            m2 = m2.setScale(6, BigDecimal.ROUND_HALF_UP);
            return m2;
        }else {
            //小于等于首重 预估运费 = (首重 \* 运费(kg) +操作费+其他费用)*折扣比例 **
            BigDecimal m1 = lf.getFreight().multiply(new BigDecimal(ykg)).add(lf.getOperatingCost()).add(lf.getOtherFees());
            BigDecimal m2 = m1.multiply(new BigDecimal(lf.getLogisticsDiscount()));
            //四舍五入6位
            m2 = m2.setScale(6, BigDecimal.ROUND_HALF_UP);
            return m2;
        }
    }

    /**
     * 从物流资费集合中获取物流资费
     * @param lfs
     * @param weight
     * @return
     */
    private TbLogisticsFreight getLogisticsFreightByIntervalWeight(List<TbLogisticsFreight> lfs, Double weight) {
        //按照最低重量顺序排序
        lfs = lfs.stream().sorted(Comparator.comparing(TbLogisticsFreight::getMinimumWeight)).collect(Collectors.toList());
        //返回符合条件的 物流资费
        for (TbLogisticsFreight lf : lfs) {
            TbLogisticsFreight result = getLogisticsFreight(lf, weight);
            if (result != null) {
                return result;
            }
        }
        return null;
    }

    /**
     * 返回符合条件的 物流资费
     * @param lf
     * @param weight
     * @return
     */
    private TbLogisticsFreight getLogisticsFreight(TbLogisticsFreight lf,Double weight){
        Double minimumWeight = lf.getMinimumWeight();
        Double maximumWeight = lf.getMaximumWeight();
        //是否大于等于最低重量
        if( !(weight.compareTo(minimumWeight) >= 0)){
            return null;
        }
        //是否小于最大重量
        if(!(weight.compareTo(maximumWeight) < 0)){
            return null;
        }
        return lf;
    }
}
