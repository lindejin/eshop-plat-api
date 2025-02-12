package com.eshop.util.platform.call.order.temu.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TemuOrderPoAfterSalesParentAfterSalesListGetResultResultDataVO {
    //parentOrderSn	STRING	是	订单父单号
    private String parentOrderSn;
    //parentAfterSalesSn	STRING	是	售后父单号
    private String parentAfterSalesSn;
    //afterSalesStatusGroup	INTEGER	是	售后单状态分组:1:待处理2:已申请3:包裹已寄出4:平台审核中5:已退款6:已拒绝7:已取消
    private Integer afterSalesStatusGroup;
    //parentAfterSalesStatus	INTEGER	是	当前售后状态1:买家申请退款,待处理2:买家退货包裹已寄出3:退货包裹已签收,待商家处理4:退款已发起,系统处理中5:已退款6:买家已取消售后7:已拒绝8:买家退货使用商家提供运单,待商家审核上传运单9:退款已发起,系统处理中10:买家已申请退货11:平台审核中
    private Integer parentAfterSalesStatus;
    //afterSalesType	INTEGER	是	售后类型1:仅退款2：退货退款
    private Integer afterSalesType;
    //createAt	INTEGER	是	父售后单创建时间,单位秒
    private Long createAt;
    //updateAt	INTEGER	是	售后单的最后更新时间,单位秒。
    private Long updateAt;
}
