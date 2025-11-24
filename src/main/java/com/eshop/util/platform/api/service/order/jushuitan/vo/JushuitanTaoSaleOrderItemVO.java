package com.eshop.util.platform.api.service.order.jushuitan.vo;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JushuitanTaoSaleOrderItemVO {

    //名称	类型	是否必须	示例值	描述
    //i_id	string			款式编码
    private String i_id;
    //sale_base_price	string			原价
    private String sale_base_price;
    //is_gift	bool			是否赠品
    private Boolean is_gift;
    //oi_id	int			订单的子订单号
    private Long oi_id;
    //outer_oi_id	string			子订单号，商家系统订单商品明细主键,为了拆单合单时溯源，最长不超过50,保持唯一
    private String outer_oi_id;
    //raw_so_id	string			商品所属原订单号
    private String raw_so_id;
    //combine_sku_id	string			组合装商品编码
    private String combine_sku_id;
    //ioi_id	int			子单号
    private Long ioi_id;
    //pic	string			图片地址
    private String pic;
    //sku_id	string			商品编码
    private String sku_id;
    //qty	int			数量
    private Integer qty;
    //name	string			名称
    private String name;
    //properties_value	string			属性
    private String properties_value;
    //sale_price	string			单价
    private String sale_price;
    //sale_amount	string			总金额
    private String sale_amount;
    //bu_id	int			虚拟仓编码
    private Long bu_id;
    //buyer_paid_amount	string			营收小计：买家实付
    private String buyer_paid_amount;
    //seller_income_amount	string			营收小计：卖家实收
    private String seller_income_amount;
}
