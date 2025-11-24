package com.eshop.util.platform.api.service.order.jushuitan.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JushuitanTaoSaleOrderCbFinanceNewVO {
    //名称	类型	是否必须	示例值	描述
    //currency_code	string			报告币种
    private String currency_code;
    //order_currency_code	string			订单币种
    private String order_currency_code;
    //o_id	int			内部订单号
    private Long o_id;
    //rate	string			汇率
    private String rate;
    //currency_to_usd	string			原币转美元汇率
    private String currency_to_usd; 
    //currency_to_rmb	string			原币转人民币汇率
    private String currency_to_rmb;
    //rate_date	string			汇率对应的日期
    private String rate_date;
    //profit	string			利润金额
    private String profit;
    //profit_rate	string			利润率（百分比）
    private String profit_rate;
    //net_amount	string			平台净额
    private String net_amount;
    //income_group	string			收入分组的费用项
    private String income_group;
    //income_total	string			收入总额（收入总额=实收金额-退款金额合计+其他收入-分类单收入冲减）
    private String income_total;
    //expense_group	string			平台支出分组的费用项
    private String expense_group;
    //expense_total	string			平台支出总额
    private String expense_total;
    //erp_expense_group	string			ERP支出分组的费用项
    private String erp_expense_group;
    //erp_expense_total	string			ERP支出总额
    private String erp_expense_total;
    //refund_group	string			退款组的费用项
    private String refund_group;
    //refund_total	string			退款总额
    private String refund_total;

}
