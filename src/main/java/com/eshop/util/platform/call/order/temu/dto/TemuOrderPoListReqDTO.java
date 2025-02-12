package com.eshop.util.platform.call.order.temu.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TemuOrderPoListReqDTO {
    //参数名称	参数类型	是否必须	说明
    //pageNumber	INTEGER	否	分页号，默认1，最大100
    private Integer pageNumber;
    //pageSize	INTEGER	否	分页大小，默认10，最大100
    private Integer pageSize;
    //parentOrderStatus	INTEGER	否	父单状态，默认查全部枚举值如下
    //0-全部
    //1-”PENDING“，挂起中
    //2-"UN_SHIPPING"，待发货
    //3-"CANCELED",已取消
    //4-"SHIPPED"，已发货
    //5-“RECEIPTED”,已签收
    //备注：
    //本本订单还存在如下状态
    //41-部分取消
    //51-部分签收
    private Integer parentOrderStatus;
    //createAfter	INTEGER	否	父单创建时间开始查询时间，格式是秒时间戳
    private Long createAfter;
    //createBefore	INTEGER	否	父单创建时间结束查询时间，格式是秒时间戳。查询时间需要同时入参开始和结束时间才生效
    private Long createBefore;
    //parentOrderSnList	LIST	否	父单号列表，单次请求最多20个
    private List<String> parentOrderSnList;
    //expectShipLatestTimeStart	INTEGER	否	期望最晚发货时间开始查询时间，格式是秒时间戳
    private Long expectShipLatestTimeStart;
    //expectShipLatestTimeEnd	INTEGER	否	期望最晚发货时间结束查询时间，格式是秒时间戳。查询时间需要同时入参开始和结束时间才生效
    private Long expectShipLatestTimeEnd;
    //updateAtStart	INTEGER	否	订单更新时间开始查询时间，格式是秒时间戳
    private Long updateAtStart;
    //updateAtEnd	INTEGER	否	订单更新时间结束查询时间，格式是秒时间戳。查询时间需要同时入参开始和结束时间才生效
    private Long updateAtEnd;
    //regionId	INTEGER	否	区域ID，美国-211
    private Long regionId;
    //fulfillmentTypeList	STRING[]	否	子订单履约类型，具体枚举值如下：
    //1. 数组只传入fulfillBySeller，只返回卖家履约子订单列表
    //2. 数组只传入fulfillByCooperativeWarehouse，只返回合作仓履约子订单列表
    //3. 数组传入fulfillBySeller和fulfillByCooperativeWarehouse，返回卖家履约子订单列表+合作仓履约子订单列表
    //4. fulfillmentTypeList不传或者传了为空，默认返回卖家履约子订单列表
    private List<String> fulfillmentTypeList;
}
