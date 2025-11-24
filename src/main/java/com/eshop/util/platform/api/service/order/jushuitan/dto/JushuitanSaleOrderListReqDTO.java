package com.eshop.util.platform.api.service.order.jushuitan.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class JushuitanSaleOrderListReqDTO {
    //shop_id	integer	否		店铺编码
    private Integer shop_id;
    //is_offline_shop	boolean	否		是否线上店铺：shop_id为0且is_offline_shop为true查询线下店铺单据
    private Boolean is_offline_shop;
    //status	string	否		单据状态 WaitConfirm=待出库;Confirmed=已出库;Delete=作废(发货前取消订单);Cancelled=取消（发货后撤销发货）;OuterConfirming外部发货中；Archive已结算
    private String status;
    //modified_begin	string	否	2022-12-09 00:00:06	起始时间，和结束时间必须同时存在，时间间隔不能超过七天，与线上单号不能同时为空；tips:用时间条件查询由于查询中数据存在变动的可能会由于排序问题引发分页查询漏单的问题，建议使用ts时间戳增量查询的方式
    private String modified_begin;
    //modified_end	string	否	2022-12-09 10:00:06	结束时间，和起始时间必须同时存在，时间间隔不能超过七天，与线上单号不能同时为空
    private String modified_end;
    //so_ids	array	否		指定 线上单号，和时间段不能同时为空，最大50 	string	否
    private List<String> so_ids;
    //page_index	integer	否		第几页，从第一页开始，默认1
    private Integer page_index;
    //page_size	integer	否		每页多少条，默认30，最大50
    private Integer page_size;
    //wms_co_id	integer	否		出库仓编号
    private Integer wms_co_id;
    //o_ids	array	否		内部单号 最大50条；与时间条件不能同时为空 string	否
    private List<String> o_ids;
    //l_ids	array	否		物流单号；不超过20条 string	否
    private List<String> l_ids;
    //wave_ids	array	否		拣货批次号；不超过50条 与时间条件不能同时为空 number	否
    private List<Long> wave_ids;
    //start_ts	integer	否		时间戳，sql server中的行版本号，该字段查询防止分页过程中漏单
    private Long start_ts;
    //is_get_total	boolean	否		是否查询总条数默认true，如果使用start_ts查询，该值默认为false不返回总条数总页数否则影响查询效率
    private Boolean is_get_total;
    //io_ids	array	否		出库单号列表（商家维度下出库单全局唯一值），最大50 string	否
    private List<String> io_ids;
    //owner_co_id	integer	否	11322398	货主编码
    private Long owner_co_id;
    //is_get_cbfinance	boolean	否		是否获取跨境财务信息
    private Boolean is_get_cbfinance;
    //is_get_cblogistic	boolean	否		是否获取跨境物流信息
    private Boolean is_get_cblogistic;
    //date_type	number	否		时间类型 0:修改时间modified，2:出库时间io_date;默认0
    private Integer date_type;
    //drp_co_id	number	否		分销商编码（如使用该添加，时间查询条件限制跨度为1天）
    private Integer drp_co_id;
    //inout_flds	array	否		出库单主表自定义查询字段 string	否	volume,package,owner_co_id,cus_id,as_id,outer_so_id,oaid,is_split,is_merge	体积,包材,货主编码,货通客户id,售后单号,奇门外部交易单号,oaid,是否被拆分，是否被合并
    private List<String> inout_flds;
    //inout_item_flds	array	否		出库单明细自定义查询字段 string	否	volume,bu_id,combine_sku_qty	体积,虚拟仓编码,组合装商品数量
    private List<String> inout_item_flds;
    //archive	boolean	否		是否查询归档数据；true查询归档；false或不传默认查未归档
    private Boolean archive;
}
