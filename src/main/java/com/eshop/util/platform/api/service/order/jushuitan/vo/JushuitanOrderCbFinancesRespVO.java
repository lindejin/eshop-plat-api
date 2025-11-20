package com.eshop.util.platform.api.service.order.jushuitan.vo;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class JushuitanOrderCbFinancesRespVO {

    //o_id	number		内部订单号
    private Long o_id;
    //rebate_fee	integer		回扣金额
    private BigDecimal rebate_fee;
    //product_tax	integer		收入税费
    private BigDecimal product_tax;
    //shipping_tax	integer		快递税
    private BigDecimal shipping_tax;
    //other_income	integer		其他收入
    private BigDecimal other_income;
    //voucher_from_seller	integer		促销优惠金额
    private BigDecimal voucher_from_seller;
    //platform_commission	integer		平台佣金
    private BigDecimal platform_commission;
    //transition_fee	integer		转账费
    private BigDecimal transition_fee;
    //transaction_fee	integer		交易手续费
    private BigDecimal transaction_fee;
    //opaque_bagging_fee	integer		支出税费
    private BigDecimal opaque_bagging_fee;
    //other_expense	integer		其他费用
    private BigDecimal other_expense;

}
