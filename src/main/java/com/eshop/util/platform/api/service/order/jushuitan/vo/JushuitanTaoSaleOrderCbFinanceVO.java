package com.eshop.util.platform.api.service.order.jushuitan.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JushuitanTaoSaleOrderCbFinanceVO {

    //名称	类型	是否必须	示例值	描述
    //o_id	string			内部订单号
    private Long o_id;
    //rebate_fee	string			回扣金额
    private String rebate_fee;
    //product_tax	string			收入税费
    private String product_tax;
    //shipping_tax	string			快递税
        private String shipping_tax;
    //other_income	string			其他收入
    private String other_income;
    //voucher_from_seller	string			促销优惠金额
    private String voucher_from_seller;
    //platform_commission	string			平台佣金
    private String platform_commission;
    //transition_fee	string			转账费
    private String transition_fee;
    //transaction_fee	string			交易手续费
    private String transaction_fee;
    //opaque_bagging_fee	string			支出税费
    private String opaque_bagging_fee;
    //other_expense	string			其他费用
    private String other_expense;
}
