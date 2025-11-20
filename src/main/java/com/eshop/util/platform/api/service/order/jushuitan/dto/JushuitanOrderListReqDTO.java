package com.eshop.util.platform.api.service.order.jushuitan.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class JushuitanOrderListReqDTO {

    //shop_id	integer	否	10208218	店铺编号
    private Integer shop_id;

    //is_offline_shop	boolean	否	false	shop_id为0且is_offline_shop为true查询线下店铺单据
    private Boolean is_offline_shop;

    //so_ids	array	否		线上单号
    private List<String> so_ids;

    //与时间条件，内部单号不能同时为空，最大限制20条
    //modified_begin	string	否	2021-12-02 10:26:25	起始时间，和结束时间必须同时存在，时间间隔不能超过七天，与线上单号，内部单号不能同时为空;tips:用时间条件查询由于查询中数据存在变动的可能会由于排序问题引发分页查询漏单的问题，建议使用ts时间戳增量查询的方式
    private String modified_begin;

    //modified_end	string	否	2021-12-09 10:26:25	结束时间，和起始时间必须同时存在，时间间隔不能超过七天，与线上单号，内部单号不能同时为空
    private String modified_end;

    //date_type	number	否		(0:修改时间modified，2:订单日期order_date，3:发货时间send_date；非必填，默认0)
    private Integer date_type;

    //status	string	否		订单状态：待付款：WaitPay；发货中：Delivering；被合并：Merged；异常：Question；被拆分：Split；等供销商|外仓发货：WaitOuterSent；已付款待审核：WaitConfirm；已客审待财审：WaitFConfirm；已发货：Sent；取消：Cancelled
    private String status;

    //page_index	integer	否		第几页，从1开始
    private Integer page_index;

    //page_size	integer	否		最每页多少条，最大100条
    private Integer page_size;

    //start_ts	integer	否		ts时间戳，sql server中的行版本号，该字段查询防止分页过程中漏单。查询条件值是大于等于的关系
    private Long start_ts;

    //is_get_total	boolean	否		是否查询总条数默认true，如果使用start_ts查询，该值需要传false不返回总条数总页数否则影响查询效率
    private Boolean is_get_total;

    //o_ids	array	否		内部订单号
    //（商家维度下订单信息的唯一值），与时间条件，线上单号不能同时为空
    private List<Long> o_ids;

    //is_get_cbfinance	boolean	否		是否查询跨境财务信息
    private Boolean is_get_cbfinance;

    //order_flds	array	否		订单自定义查询字段
    private List<String> order_flds;

    //order_item_flds	array	否		订单明细自定义查询字段
    private List<String> order_item_flds;

    //order_types	array	否		订单类型
    private List<String> order_types;

    //archive	boolean	否	false	是否查询历史订单：false 否；true是。默认fale
    private Boolean archive;
}
