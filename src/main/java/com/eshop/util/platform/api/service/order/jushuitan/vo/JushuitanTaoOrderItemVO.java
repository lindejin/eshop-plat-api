package com.eshop.util.platform.api.service.order.jushuitan.vo;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class JushuitanTaoOrderItemVO {

    //名称	类型	是否必须	示例值	描述
    //batch_id	string			批次号
    private String batch_id;
    //produced_date	string			生产日期
    private String produced_date;
    //referrer_id	string			主播id
    private String referrer_id;
    //item_ext_data	string			商品明细拓展字段
    private String item_ext_data;
    //src_combine_sku_id	string			原组合商品编码
    private String src_combine_sku_id;
    //pic	string			图片
    private String pic;
    //sku_type	string			商品类型
    private String sku_type;
    //item_pay_amount	string			商品应付金额
    private String item_pay_amount;
    //remark	string			备注
    private String remark;
    //price	string			单价
    private String price;
    //outer_oi_id	string			线上子单号
    private String outer_oi_id;
    //is_gift	string			是否赠品
    private String is_gift;
    //refund_status	string			退款状态
    private String refund_status;
    //refund_id	string			退款单号
    private String refund_id;
    //item_status	string			商品状态
    private String item_status;
    //i_id	string			系统商品款号
    private String i_id;
    //shop_i_id	string			线上商品款号
    private String shop_i_id;
    //raw_so_id	string			原始线上单号
    private String raw_so_id;
    //is_presale	bool			是否预售
    private Boolean is_presale;
    //oi_id	string			系统子单号
    private String oi_id;
    //properties_value	string			属性
    private String properties_value;
    //amount	string			总金额
    private String amount;
    //base_price	string			原价
    private String base_price;
    //qty	decimal			数量
    private BigDecimal qty;
    //name	string			名称
    private String name;
    //sku_id	string			系统商品编码
    private String sku_id;
    //shop_sku_id	string			线上商品编码
    private String shop_sku_id;
    //buyer_paid_amount	string			买家实付
    private String buyer_paid_amount;
    //seller_income_amount	string			卖家实收
    private String seller_income_amount;
    //drp_price	string			采购价
    private String drp_price;
    //lwh_id	string			虚拟仓编码
    private String lwh_id;
    //lwh_name	string			虚拟仓名称
    private String lwh_name;
    //direct_parent_order_id	string			京东拆单后的原单号
    private String direct_parent_order_id;
    //outer_so_id	string			平台外部订单号
    private String outer_so_id;
}
