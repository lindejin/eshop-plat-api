package com.eshop.util.platform.api.service.order.jushuitan.vo;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class JushuitanOrderRespVO {

    //is_cod	boolean	false	是否货到付款
    private Boolean is_cod;
    //l_id	string		快递单号
    private String l_id;
    //send_date	string		发货日期
    private String send_date;
    //pay_date	string	2019-12-16 16:35:28	支付时间
    private String pay_date;
    //freight	string	4.0	买家支付运费，保留两位小数，单位（元）
    private String freight;
    //first_freight	string		跨境订单-头程运费
    private String first_freight;
    //outerwms_freight	string		跨境订单-尾程运费
    private String outerwms_freight;
    //receiver_address	string		收货地址
    private String receiver_address;
    //receiver_district	string		区
    private String receiver_district;
    //wms_co_id	string	0	发货仓编号(当值为0表示主仓)
    private String wms_co_id;
    //logistics_company	string		快递公司
    private String logistics_company;
    //as_id	number		补发换货单对应的售后单号
    private Long as_id;
    //free_amount	number		抵扣金额
    private BigDecimal free_amount;
    //shop_name	string	川梣铺子	店铺名称
    private String shop_name;
    //question_type	string	等待订单合并	问题类型，仅当问题订单时有效
    private String question_type;
    //outer_pay_id	string	20210928	外部支付单号
    private String outer_pay_id;
    //so_id	string	20210928	线上订单号，线上同步过来的订单号，最长不超过20;唯一
    private String so_id;
    //type	string	普通订单	订单类型，普通订单；补发订单；分销Plus；供销Plus；换货订单
    private String type;
    //order_from	string	open	订单来源，ERP：手工下单； COPY：复制； MERGE：合并； SPLIT：拆分；拆分还原； MOBILE：京东； IMPORT:导入； drp-s：供销推送； drp-d：分销推送； KWAISHOP：快手；微商城； PINDUODUO；拼多多； TOUTIAOFXG；头条放心购
    private String order_from;
    //status	string	Question	聚水潭订单状态 待付款：WaitPay；发货中：Delivering；被合并：Merged；异常：Question；被拆分：Split；等供销商|外仓发货：WaitOuterSent；已付款待审核：WaitConfirm；已客审待财审：WaitFConfirm；已发货：Sent；取消：Cancelled
    private String status;
    //pay_amount	number		应付金额，保留两位小数，单位（元）
    private BigDecimal pay_amount;
    //shop_buyer_id	string		买家昵称
    private String shop_buyer_id;
    //open_id	string		平台买家唯一值，仅限平台已经支持的才会返回
    private String open_id;
    //shop_status	string	平台订单状态： 等待买家付款=WAIT_BUYER_PAY， 等待卖家发货=WAIT_SELLER_SEND_GOODS,等待买家确认收货=WAIT_BUYER_CONFIRM_GOODS, 交易成功=TRADE_FINISHED, 付款后交易关闭=TRADE_CLOSED,付款前交易关闭=TRADE_CLOSED_BY_TAOBAO；	https://jushuitan.yuque.com/docs/share/200c8f37-49c5-4b22-a530-f37046691d4b?#8lWt 《平台订单shop_status字段枚举》密码：qqs7
    private String shop_status;
    //receiver_mobile	string		手机
    private String receiver_mobile;
    //receiver_phone	string		电话
    private String receiver_phone;
    //order_date	string	2019-12-15 18:14:26	订单日期
    private String order_date;
    //question_desc	string		问题描述
    private String question_desc;
    //receiver_city	string		收件信息-市
    private String receiver_city;
    //receiver_state	string		收件信息-省
    private String receiver_state;
    //receiver_name	string		收件信息-收件人
    private String receiver_name;
    //o_id	integer	38852	ERP内部订单号，聚水潭生成的订单号，唯一
    private Long o_id;
    //shop_id	integer	11690153	店铺编号
    private Long shop_id;
    //co_id	integer	11053062	公司编号
    private Long co_id;
    //remark	string		订单备注；卖家备注
    private String remark;
    //package_no	string		参考号
    private String package_no;
    //warehouse_oid	string		外部单据号
    private String warehouse_oid;
    //drp_co_id_from	string		分销商编号
    private String drp_co_id_from;
    //modified	string	2021-09-28 16:08:13	最后修改时间
    private String modified;
    //labels	string	延时发货	多标签
    private String labels;
    //paid_amount	number		实际支付金额
    private BigDecimal paid_amount;
    //platform_free_amount	string		平台优惠；null值处理成了空字符串返回，实际有值的是number类型返回
    private String platform_free_amount;
    //pay_free_amount	string		支付优惠；null值处理成了空字符串返回，实际有值的是number类型返回
    private String pay_free_amount;
    //referrer_free_amount	string		达人优惠；null值处理成了空字符串返回，实际有值的是number类型返回
    private String referrer_free_amount;
    //shop_free_amount	string		店铺优惠；null值处理成了空字符串返回，实际有值的是number类型返回
    private String shop_free_amount;
    //currency	string		币种
    private String currency;
    //buyer_message	string		买家留言
    private String buyer_message;
    //lc_id	string		物流公司编码
    private String lc_id;
    //cb_total_tax	string		跨境平台税金
    private String cb_total_tax;
    //invoice_title	string		发票抬头
    private String invoice_title;
    //invoice_type	string		发票类型
    private String invoice_type;
    //buyer_tax_no	string		发票税号
    private String buyer_tax_no;
    //creator_name	string		订单业务员
    private String creator_name;
    //plan_delivery_date	string		计划发货时间
    private String plan_delivery_date;
    //node	string		线下备注
    private String node;
    //receiver_town	string		收件信息-街道
    private String receiver_town;
    //drp_co_id_to	string		供销商编号
    private String drp_co_id_to;
    //shop_site	string	商家自有商城	店铺站点信息
    private String shop_site;
    //un_lid	string		国际物流单号
    private String un_lid;
    //end_time	string		确认收货时间（仅限淘系平台，头条放心购、拼多多、苏宁易购、快手电商、有赞微商城，如果线上状态为取消，该时间为完结时间）
    private String end_time;
    //receiver_country	string		国家代码;（映射关系参考https://openweb.jushuitan.com/doc?docId=225）
    private String receiver_country;
    //receiver_zip	string		邮编
    private String receiver_zip;
    //seller_flag	integer		旗帜(1红旗，2黄旗，3绿旗，4蓝旗，5紫旗)）
    private Integer seller_flag;
    //receiver_email	string		收货邮箱
    private String receiver_email;
    //referrer_id	string		主播id
    private String referrer_id;
    //referrer_name	string		主播名称
    private String referrer_name;
    //created	string	2021-09-28 16:08:13	订单创建时间
    private String created;
    //pays	array		支付信息
    private List<JushuitanOrderPayRespVO> pays;
    //items	array		商品信息
    private List<JushuitanOrderItemRespVO> items;
    //skus	string		商品（商品总数.sku_id*qty）
    private String skus;
    //f_weight	number		实称重量
    private Double f_weight;
    //weight	number		重量
    private Double weight;
    //ts	integer		数据库行版本号：https://docs.microsoft.com/zh-cn/sql/t-sql/data-types/rowversion-transact-sql?view=sql-server-ver16
    private Long ts;
    //buyer_id	string		买家ID（系统根据shop_buy_id生成的）
    private String buyer_id;
    //buyer_paid_amount	number		营收小计：买家实付（仅限爱库存,阿里巴巴,百度小店,得物,饿百零售,好食期,好衣库,京东,快团团,快手电商,蘑菇街,团好货,拼多多,杉杉商业,淘宝天猫,头条放心购,小红书,有赞）
    private BigDecimal buyer_paid_amount;
    //seller_income_amount	number		营收小计：卖家实收（仅限淘宝天猫，爱库存,阿里巴巴,百度小店,得物,饿百零售,好食期,好衣库,京东,快团团,快手电商,蘑菇街,团好货,拼多多,杉杉商业,头条放心购,小红书,有赞）
    private BigDecimal seller_income_amount;
    //chosen_channel	string		实发快递渠道
    private String chosen_channel;
    //link_o_id	string		被合并被拆分的订单内部单号
    private String link_o_id;
    //merge_so_id	string		合并线上订单号
    private String merge_so_id;
    //shipment	string		买家指定物流
    private String shipment;
    //sign_time	string		预计送达时间
    private String sign_time;
    //cb_finances	object		跨境订单财务数据
    private JushuitanOrderCbFinancesRespVO cb_finances;
    //is_merge	boolean		是否合并后订单
    private Boolean is_merge;
    //is_split	boolean		是否拆分后订单
    private Boolean is_split;
    //first_freight_tariff	number		跨境订单-头程关税
    private BigDecimal first_freight_tariff;
    //f_freight_other_expense	number		跨境订单-头程其他费用
    private BigDecimal f_freight_other_expense;

}
