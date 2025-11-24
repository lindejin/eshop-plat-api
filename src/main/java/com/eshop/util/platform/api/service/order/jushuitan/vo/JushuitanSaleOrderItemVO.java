package com.eshop.util.platform.api.service.order.jushuitan.vo;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class JushuitanSaleOrderItemVO {

    //ioi_id	integer	198	子单号
    private Long ioi_id;
    //pic	string		图片
    private String pic;
    //sku_id	string	s111001	商品编码
    private String sku_id;
    //qty	integer	1	数量
    private Integer qty;
    //name	string	SKUA1	商品名称
    private String name;
    //properties_value	string	SKUA1	颜色规格
    private String properties_value;
    //sale_price	number	223.0	单价
    private BigDecimal sale_price;
    //oi_id	string		订单子订单号
    private String oi_id;
    //sale_amount	number	223.0	金额
    private BigDecimal sale_amount;
    //i_id	string		款式编码
    private String i_id;
    //unit	string		商品单位
    private String unit;
    //sale_base_price	number	223.0	原价
    private BigDecimal sale_base_price;
    //combine_sku_id	string		组合装商品编码
    private String combine_sku_id;
    //is_gift	boolean	false	是否赠品
    private Boolean is_gift;
    //outer_oi_id	string		子订单号，商家系统订单商品明细主键,为了拆单合单时溯源，最长不超过50,保持唯一
    private String outer_oi_id;
    //raw_so_id	string		原始线上订单号
    private String raw_so_id;
    //batch_id	string		批次号，获取该字段系统中相关业务项需配置
    private String batch_id;
    //product_date	string		批次日期，系统中相关业务项需配置
    private String product_date;
    //supplier_id	integer		供应商编号，系统中相关业务项需配置
    private Long supplier_id;
    //expiration_date	string		有效期至，系统中相关业务项需配置
    private String expiration_date;
    //buyer_paid_amount	number		买家实付
    private BigDecimal buyer_paid_amount;
    //seller_income_amount	number		卖家实收
    private BigDecimal seller_income_amount;
    //total_qty	number	1.6	总用量
    private Double total_qty;
}
