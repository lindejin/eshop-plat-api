package com.eshop.util.platform.call.order.temu.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TemuOrderPoAfterSalesParentAfterSalesListGetReqDTO {

    //createAtStart	INTEGER	否	售后单创建时间起始查询时间，秒级时间戳,闭区间
    //备注：
    //1、createAtStart需联合createAtEnd一并入参。
    //2、创建时间和更新时间至少需有一组时间为必填入参。
    private Long createAtStart;
    //createAtEnd	INTEGER	否	售后单创建时间结束查询时间，秒级时间戳,闭区间
    //备注：
    //1、createAtStart需联合createAtEnd一并入参。
    //2、创建时间和更新时间至少需有一组时间为必填入参。
    private Long createAtEnd;
    //updateAtStart	INTEGER	否	售后单状态变更时间开始查询时间，秒级时间戳,闭区间
    //备注：
    //1、updateAtStart需联合updateAtEnd一并入参。
    //2、创建时间和更新时间至少需有一组时间为必填入参。
    private Long updateAtStart;
    //updateAtEnd	INTEGER	否	售后单状态变更时间结束查询时间，秒级时间戳,闭区间
    //备注：
    //1、updateAtStart需联合updateAtEnd一并入参。
    //2、创建时间和更新时间至少需有一组时间为必填入参。
    private Long updateAtEnd;

    //parentAfterSalesSnList	LIST	否	限定查询的售后父单号列表，为空时不限定售后父单号范围
    private List<String> parentAfterSalesSnList;
    //parentOrderSnList	LIST	否	限定查询的订单父单号列表，为空时不限定订单父单号范围
    private List<String> parentOrderSnList;
    //afterSalesStatusGroup	INTEGER	否	售后单状态分组，枚举如下:1:待处理2:已申请3:包裹已寄出4:平台审核中5:已退款6:已拒绝7:已取消
    private Integer afterSalesStatusGroup;
    //pageNo	INTEGER	否	页码,默认第1页开始
    private Integer pageNo;
    //pageSize	INTEGER	否	页面大小,默认每页10条,max<=200
    private Integer pageSize;
}
