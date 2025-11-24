package com.eshop.util.platform.api.service.order.jushuitan.vo;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class JushuitanSaleOrderVO {

    //co_id	integer	11053062	公司编号
    private Long co_id;
    //shop_id	integer	11690153	店铺编码
    private Long shop_id;
    //io_id	integer	166	出库单号(商家维度下出库单全局唯一值)
    private Long io_id;
    //o_id	integer	36008	内部单号
    private Long o_id;
    //so_id	string	3425786782368239	线上单号
    private String so_id;
    //created	string	2021-09-1614:05:07	创建时间
    private String created;
    //modified	string	2021-09-2315:07:58	修改时间
    private String modified;
    //status	string	Confirmed	状态 ;WaitConfirm:待出库,Confirmed:已出库,Delete:作废（订单发货中取消订单）,OuterConfirming:外部发货中;Cancelled=取消（订单发货后撤销已发货）
    private String status;
    //order_type	string	普通订单	订单类型，普通订单；补发订单；分销Plus；供销Plus；换货订单
    private String order_type;
    //invoice_title	string		发票抬头
    private String invoice_title;
    //shop_buyer_id	string		买家昵称/线下客户
    private String shop_buyer_id;
    //open_id	string		平台买家唯一值，仅支持天猫，抖音，快手
    private String open_id;
    //receiver_country	string		国家
    private String receiver_country;
    //receiver_state	string		省
    private String receiver_state;
    //receiver_city	string		市
    private String receiver_city;
    //receiver_district	string		区
    private String receiver_district;
    //receiver_town	string		街道
    private String receiver_town;
    //receiver_address	string		地址
    private String receiver_address;
    //receiver_name	string		收件人姓名
    private String receiver_name;
    //receiver_phone	string		收件人手机
    private String receiver_phone;
    //receiver_mobile	string		收件人电话
    private String receiver_mobile;
    //buyer_message	string		买家留言
    private String buyer_message;
    //remark	string		备注
    private String remark;
    //is_cod	boolean	false	是否货到付款
    private Boolean is_cod;
    //pay_amount	number	706.0	应付金额
    private BigDecimal pay_amount;
    //l_id	string	20210923	物流单号
    private String l_id;
    //io_date	string	2021-09-2315:07:58	出库时间
    private String io_date;
    //lc_id	string	SF	快递公司编码
    private String lc_id;
    //stock_enabled	string	on	是否启用库存管理
    private String stock_enabled;
    //drp_co_id_from	string		分销商编号
    private String drp_co_id_from;
    //labels	string	延时发货	标记|多标签
    private String labels;
    //paid_amount	number	706.0	订单支付详情中的支付金额
    private BigDecimal paid_amount;
    //free_amount	number	0.0	优惠金额
    private BigDecimal free_amount;
    //buyer_paid_amount	number		买家实付（仅限爱库存,阿里巴巴,百度小店,得物,饿百零售,好食期,好衣库,京东,快团团,快手电商,蘑菇街,团好货,拼多多,杉杉商业,淘宝天猫,头条放心购,小红书,有赞）
    private BigDecimal buyer_paid_amount;
    //seller_income_amount	number		卖家实收（仅限爱库存,阿里巴巴,百度小店,得物,饿百零售,好食期,好衣库,京东,快团团,快手电商,蘑菇街,团好货,拼多多,杉杉商业,淘宝天猫,头条放心购,小红书,有赞）
    private BigDecimal seller_income_amount;
    //f_volume	string		实测体积
    private String f_volume;
    //freight	number	4.0	买家支付运费
    private BigDecimal freight;
    //first_freight	string		跨境订单-头程运费
    private BigDecimal first_freight;
    //outerwms_freight	string		跨境订单-尾程运费
    private BigDecimal outerwms_freight;
    //weight	number	0.0	预估重量
    private Double weight;
    //f_weight	number		实称重量
    private Double f_weight;
    //merge_so_id	string		合并订单号
    private String merge_so_id;
    //wms_co_id	integer	11053062	分仓编号
    private Long wms_co_id;
    //business_staff	string	川梣	业务人员
    private String business_staff;
    //currency	string		货币类型
    private String currency;
    //pay_date	string	2019-12-1616:35:28	付款日期
    private String pay_date;
    //logistics_company	string	顺丰速运	物流公司名称
    private String logistics_company;
    //wave_id	integer		拣货批次号
    private Long wave_id;
    //seller_flag	integer		旗帜(1红旗，2黄旗，3绿旗，4蓝旗，5紫旗)）
    private Long seller_flag;
    //gov_supplier_name	string		实际销售公司
    private String gov_supplier_name;
    //government_free_amount	number		国补金额
    private BigDecimal government_free_amount;
    //order_staff_id	integer	12854967	订单业务员编号
    private Long order_staff_id;
    //order_staff_name	string	川梣	订单业务员名称
    private String order_staff_name;
    //node	string		线下备注
    private String node;
    //first_freight_tariff	number		跨境订单-头程关税
    private BigDecimal first_freight_tariff;
    //field_2	number		跨境订单-头程其他费用
    private BigDecimal field_2;
    //items	array		商品集合
    private List<JushuitanSaleOrderItemVO> items;
    //ClusterInfos	array		子母单的子单信息
    private List<JushuitanSaleOrderClusterInfoVO> ClusterInfos;
    //batchs	array		生产批次集合 获取该节点系统中相关业务项需配置（对应erp基础设置开启生产批次管理 如果是分仓数据 分仓也需要开启）
    private List<JushuitanSaleOrderBatchVO> batchs;
    //sns	array		唯一码集合 获取该节点系统中相关业务项需配置（对应erp基础设置商品唯一码开关）默认从跟踪信息唯一码界面取值，如果开启了唯一码流水读取的是唯一码流水界面的数据
    private List<JushuitanSaleOrderSnVO> sns;
    //is_print_express	boolean		快递单已打印
    private Boolean is_print_express;
    //is_print	boolean		订单已打印
    private Boolean is_print;
    //shop_name	string		店铺名称
    private String shop_name;
    //ts	integer		数据库行版本号：https://docs.microsoft.com/zh-cn/sql/t-sql/data-types/rowversion-transact-sql?view=sql-server-ver16
    private Long ts;
    //shipment	string		跨境订单买家指定物流（is_get_cblogistic传true返回）
    private String shipment;
    //deliver_name	string		跨境订单物流方式（is_get_cblogistic传true返回）
    private String deliver_name;
    //channel_name	string		跨境订单渠道名称（is_get_cblogistic传true返回）
    private String channel_name;
    //tracking_number	string		跨境订单国际运单号（is_get_cblogistic传true返回）
    private String tracking_number;
    //package_no	string		参考号
    private String package_no;
    //warehouse_oid	string		外部单据号
    private String warehouse_oid;
    //cb_finances	object		跨境订单财务数据（废弃）
    private JushuitanSaleOrderCbFinancesVO cb_finances;
    //cb_financenew	object		新版跨境订单财务数据
    private JushuitanSaleOrderCbFinanceNewVO cb_financenew;
    //owner_co_id	number		货主编码
    private Long owner_co_id;
}
