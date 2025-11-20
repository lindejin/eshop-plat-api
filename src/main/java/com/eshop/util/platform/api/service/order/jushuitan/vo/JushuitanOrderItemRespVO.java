package com.eshop.util.platform.api.service.order.jushuitan.vo;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class JushuitanOrderItemRespVO {

    //is_gift	boolean	false	是否赠品
    private Boolean is_gift;
    //sku_id	string	CY001	原始商品编码
    private String sku_id;
    //name	string	CY001	商品名称
    private String name;
    //refund_status	string		申请退款的状态,未申请：none；退款中：waiting；退款成功：success；退款关闭：closed
    private String refund_status;
    //refund_id	string		退款的唯一单号
    private String refund_id;
    //price	number		单价
    private BigDecimal price;
    //outer_oi_id	string	201911	子订单号，商家系统订单商品明细主键，为了拆单合单时溯源，最长不超过50
    private String outer_oi_id;
    //item_status	string		商品状态；None：无；WaitPay：待付款；WaitConfirm：等待审核；Question：异常；WaitDeliver：平台接口告知ERP订单项解锁可发货的状态； WaitFConfirm：等待财务审核；Delivering：发货中；WaitOuterSent：等待外仓发货；Sent：已发货；OuterSent：外仓发货；Merged：被合并；Cancelled：用户取消订单；Replaced：被替换（明细）；Split：被拆分； Delete：删除；Lock：锁定；SentCancelled：发货后取消
    private String item_status;
    //i_id	string	001	款式编码
    private String i_id;
    //properties_value	string	CY001	属性
    private String properties_value;
    //oi_id	integer	39845	子订单号，最长不超过20
    private Long oi_id;
    //amount	number	223.0	总额
    private BigDecimal amount;
    //shop_sku_id	string	201911	店铺商品编码，对应店铺商品资料页面平台店铺商品编码
    private String shop_sku_id;
    //raw_so_id	string	20210928	原始线上单号
    private String raw_so_id;
    //qty	integer	1	数量
    private Integer qty;
    //is_presale	boolean		是否预售
    private Boolean is_presale;
    //base_price	number	223.0	基本售价（原价）
    private BigDecimal base_price;
    //pic	string		商品图片
    private String pic;
    //sku_type	string	normal	商品类型；nomal：普通商品；combine：组合装商品；no_deliver：不发货
    private String sku_type;
    //shop_i_id	string		店铺款式编码
    private String shop_i_id;
    //buyer_paid_amount	number		营收小计：买家实付
    //（仅限爱库存,阿里巴巴,百度小店,得物,饿百零售,好食期,好衣库,京东,快团团,快手电商,蘑菇街,团好货,拼多多,杉杉商业,淘宝天猫,头条放心购,小红书,有赞）
    private BigDecimal buyer_paid_amount;

    //seller_income_amount	number		营收小计：卖家实收（仅限淘宝天猫，爱库存,阿里巴巴,百度小店,得物,饿百零售,好食期,好衣库,京东,快团团,快手电商,蘑菇街,团好货,拼多多,杉杉商业,头条放心购,小红书,有赞）
    private BigDecimal seller_income_amount;
    //referrer_id	string		主播ID
    private String referrer_id;
    //lwh_id	string		虚拟仓编号；系统中相关业务项需配置。 统一功能配置（lock.stock.lwh.query）
    private String lwh_id;
    //lwh_name	string		虚拟仓名称；系统中相关业务项需配置
    private String lwh_name;
    //remark	string		明细备注
    private String remark;
    //produced_date	string		生产日期
    private String produced_date;
    //batch_id	string		批次号
    private String batch_id;
    //item_ext_data	string		订单明细扩展字段
    private String item_ext_data;
}
