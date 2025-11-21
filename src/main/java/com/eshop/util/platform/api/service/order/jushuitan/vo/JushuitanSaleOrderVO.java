package com.eshop.util.platform.api.service.order.jushuitan.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JushuitanSaleOrderVO {

    //co_id	integer	11053062	公司编号
    //shop_id	integer	11690153	店铺编码
    //io_id	integer	166	出库单号(商家维度下出库单全局唯一值)
    //o_id	integer	36008	内部单号
    //so_id	string	3425786782368239	线上单号
    //created	string	2021-09-1614:05:07	创建时间
    //modified	string	2021-09-2315:07:58	修改时间
    //status	string	Confirmed	状态 ;WaitConfirm:待出库,Confirmed:已出库,Delete:作废（订单发货中取消订单）,OuterConfirming:外部发货中;Cancelled=取消（订单发货后撤销已发货）
    //order_type	string	普通订单	订单类型，普通订单；补发订单；分销Plus；供销Plus；换货订单
    //invoice_title	string		发票抬头
    //shop_buyer_id	string		买家昵称/线下客户
    //open_id	string		平台买家唯一值，仅支持天猫，抖音，快手
    //receiver_country	string		国家
    //receiver_state	string		省
    //receiver_city	string		市
    //receiver_district	string		区
    //receiver_town	string		街道
    //receiver_address	string		地址
    //receiver_name	string		收件人姓名
    //receiver_phone	string		收件人手机
    //receiver_mobile	string		收件人电话
    //buyer_message	string		买家留言
    //remark	string		备注
    //is_cod	boolean	false	是否货到付款
    //pay_amount	number	706.0	应付金额
    //l_id	string	20210923	物流单号
    //io_date	string	2021-09-2315:07:58	出库时间
    //lc_id	string	SF	快递公司编码
    //stock_enabled	string	on	是否启用库存管理
    //drp_co_id_from	string		分销商编号
    //labels	string	延时发货	标记|多标签
    //paid_amount	number	706.0	订单支付详情中的支付金额
    //free_amount	number	0.0	优惠金额
    //buyer_paid_amount	number		买家实付（仅限爱库存,阿里巴巴,百度小店,得物,饿百零售,好食期,好衣库,京东,快团团,快手电商,蘑菇街,团好货,拼多多,杉杉商业,淘宝天猫,头条放心购,小红书,有赞）
    //seller_income_amount	number		卖家实收（仅限爱库存,阿里巴巴,百度小店,得物,饿百零售,好食期,好衣库,京东,快团团,快手电商,蘑菇街,团好货,拼多多,杉杉商业,淘宝天猫,头条放心购,小红书,有赞）
    //f_volume	string		实测体积
    //freight	number	4.0	买家支付运费
    //first_freight	string		跨境订单-头程运费
    //outerwms_freight	string		跨境订单-尾程运费
    //weight	number	0.0	预估重量
    //f_weight	number		实称重量
    //merge_so_id	string		合并订单号
    //wms_co_id	integer	11053062	分仓编号
    //business_staff	string	川梣	业务人员
    //currency	string		货币类型
    //pay_date	string	2019-12-1616:35:28	付款日期
    //logistics_company	string	顺丰速运	物流公司名称
    //wave_id	integer		拣货批次号
    //seller_flag	integer		旗帜(1红旗，2黄旗，3绿旗，4蓝旗，5紫旗)）
    //gov_supplier_name	string		实际销售公司
    //government_free_amount	number		国补金额
    //order_staff_id	integer	12854967	订单业务员编号
    //order_staff_name	string	川梣	订单业务员名称
    //node	string		线下备注
    //first_freight_tariff	number		跨境订单-头程关税
    //field_2	number		跨境订单-头程其他费用
    //items	array		商品集合
    //ClusterInfos	array		子母单的子单信息
    //batchs	array		生产批次集合 获取该节点系统中相关业务项需配置（对应erp基础设置开启生产批次管理 如果是分仓数据 分仓也需要开启）
    //sns	array		唯一码集合 获取该节点系统中相关业务项需配置（对应erp基础设置商品唯一码开关）默认从跟踪信息唯一码界面取值，如果开启了唯一码流水读取的是唯一码流水界面的数据

    //is_print_express	boolean		快递单已打印
    //is_print	boolean		订单已打印
    //shop_name	string		店铺名称
    //ts	integer		数据库行版本号：https://docs.microsoft.com/zh-cn/sql/t-sql/data-types/rowversion-transact-sql?view=sql-server-ver16
    //shipment	string		跨境订单买家指定物流（is_get_cblogistic传true返回）
    //deliver_name	string		跨境订单物流方式（is_get_cblogistic传true返回）
    //channel_name	string		跨境订单渠道名称（is_get_cblogistic传true返回）
    //tracking_number	string		跨境订单国际运单号（is_get_cblogistic传true返回）
    //package_no	string		参考号
    //warehouse_oid	string		外部单据号
    //cb_finances	object		跨境订单财务数据（废弃）
    //cb_financenew	object		新版跨境订单财务数据
    //owner_co_id	number		货主编码
}
