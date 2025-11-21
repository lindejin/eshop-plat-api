package com.eshop.util.platform.api.service.order.jushuitan.vo;


import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class JushuitanTaoOrderVO {

    //名称	类型	是否必须	示例值	描述
    //order_date	string			下单时间
    private String order_date;
    //shop_status	string			平台订单状态：https://jushuitan.yuque.com/docs/share/200c8f37-49c5-4b22-a530-f37046691d4b?#8lWt 《平台订单shop_status字段枚举》密码：qqs7
    private String shop_status;
    //question_type	string			异常类型
    private String question_type;
    //shop_id	int			店铺编号
    private Long shop_id;
    //question_desc	string			异常描述
    private String question_desc;
    //so_id	string			线上单号
    private String so_id;
    //status	string			ERP订单状态：待付款：WaitPay；发货中：Delivering；被合并：Merged；异常：Question；被拆分：Split；等供销商|外仓发货：WaitOuterSent；已付款待审核：WaitConfirm；已客审待财审：WaitFConfirm；已发货：Sent；取消：Cancelled
    private String status;
    //receiver_state	string			省
    private String receiver_state;
    //receiver_city	string			市
    private String receiver_city;
    //receiver_district	string			区
    private String receiver_district;
    //send_date	string			发货时间
    private String send_date;
    //plan_delivery_date	string			预计发货时间
    private String plan_delivery_date;
    //creator_name	string			操作业务员
    private String creator_name;
    //buyer_tax_no	string			发票税号
    private String buyer_tax_no;
    //invoice_type	string			发票类型
    private String invoice_type;
    //pay_amount	string			应付金额
    private String pay_amount;
    //freight	string			运费
    private String freight;
    //buyer_message	string			买家留言
    private String buyer_message;
    //remark	string			卖家留言
    private String remark;
    //invoice_title	string			发票抬头
    private String invoice_title;
    //is_cod	bool			是否货到付款
    private Boolean is_cod;
    //type	string			订单类型
    private String type;
    //paid_amount	string			实际支付金额
    private String paid_amount;
    //pay_date	string			支付日期
    private String pay_date;
    //modified	string			订单修改时间
    private String modified;
    //order_from	string			订单来源，ERP：手工下单； COPY：复制； TAOBAO；淘宝天猫； MERGE：合并； SPLIT：拆分；拆分还原； MOBILE：手机； IMPORT:导入； drp-s：供销推送； drp-d：分销推送； KWAISHOP：快手；微商城； PINDUODUO；拼多多； TOUTIAOFXG；头条放心购
    private String order_from;
    //l_id	string			快递单号
    private String l_id;
    //shop_name	string			店铺名称
    private String shop_name;
    //wms_co_id	int			发货仓编号
    private Long wms_co_id;
    //logistics_company	string			快递公司名称
    private String logistics_company;
    //free_amount	string			优惠金额
    private String free_amount;
    //co_id	int			公司编号
    private Long co_id;
    //pays	list			pays
    private List<JushuitanTaoOrderPayVO> pays;
    //drp_co_id_to	string			供销商编号
    private String drp_co_id_to;
    //end_time	string			收货时间
    private String end_time;
    //referrer_id	string			主播id
    private String referrer_id;
    //invoice_data	string			专票信息
    private String invoice_data;
    //drp_info	string			供分销信息
    private String drp_info;
    //shop_buyer_id	string			买家昵称
    private String shop_buyer_id;
    //seller_flag	string			旗帜
    private String seller_flag;
    //invoice_amount	string			发票金额
    private String invoice_amount;
    //oaid	string			淘系订单oaid
    private String oaid;
    //open_id	string			买家唯一id(拼多多,头条放心购,快手电商,淘宝天猫,阿里巴巴,药师帮,启博微分销)
    private String open_id;
    //node	string			线下备注
    private String node;
    //referrer_name	string			主播名称
    private String referrer_name;
    //shop_site	string			店铺站点信息
    private String shop_site;
    //drp_co_id_from	string			分销商编号
    private String drp_co_id_from;
    //un_lid	string			国际物流单号
    private String un_lid;
    //receiver_zip	string			邮编
    private String receiver_zip;
    //receiver_email	string			收货邮箱
    private String receiver_email;
    //created	string			订单创建时间
    private String created;
    //receiver_country	string			国家代码
    private String receiver_country;
    //skus	string			商品（商品总数.sku_id*qty）
    private String skus;
    //shipment	string			买家指定物流
    private String shipment;
    //weight	string			预估重量
    private String weight;
    //sign_time	string			预计送达时间
    private String sign_time;
    //f_weight	string			实称重量
    private String f_weight;
    //is_split	bool			是否拆分后订单
    private Boolean is_split;
    //is_merge	bool			是否合并后订单
    private Boolean is_merge;
    //o_id	string			内部订单号
    private String o_id;
    //items	list			商品明细
    private List<JushuitanTaoOrderItemVO> items;
    //labels	string			多标签
    private String labels;
    //currency	string			币种
    private String currency;
    //lc_id	string			快递公司编码
    private String lc_id;
    //ts	int		long类型	时间戳
    private Long ts;
    //merge_so_id	string			合并前店铺号加线上单号
    private String merge_so_id;
    //link_o_id	string			拆分前内部订单号
    private String link_o_id;
    //seller_income_amount	decimal			卖家实收
    private BigDecimal seller_income_amount;
    //buyer_paid_amount	decimal			买家实付
    private BigDecimal buyer_paid_amount;
    //chosen_channel	string			实发快递渠道
    private String chosen_channel;
    //platform_free_amount	string			平台优惠
    private String platform_free_amount;
    //pay_free_amount	string			支付优惠
    private String pay_free_amount;
    //referrer_free_amount	string			达人优惠
    private String referrer_free_amount;
    //shop_free_amount	string			店铺优惠
    private String shop_free_amount;
    //as_id	int			补发换货单对应的售后单号
    private Long as_id;
    //outer_so_id	string			外部交易单号
    private String outer_so_id;
}
