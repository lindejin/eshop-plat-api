package com.eshop.util.platform.call.order.temu.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TemuOrderPoAfterSalesAfterSalesListGetResultBaseDataVO {
    //parentAfterSalesSn	STRING	是	售后父单号
    private String parentAfterSalesSn;
    //applyAfterSalesGoodsNumber	LONG	是	申请售后件数
    private Long applyAfterSalesGoodsNumber;
    //afterSalesSn	STRING	是	售后子单号
    private String afterSalesSn;
    //skuId	LONG	是	货品skuid
    private Long skuId;
    //applyTimeMills	LONG	是	发起售后时间,单位毫秒
    private Long applyTimeMills;
    //afterSalesStatus	LONG	是	当前子单售后状态1:买家申请退款,待处理2:买家退货包裹已寄出3:退货包裹已签收,待商家处理4:退款已发起,系统处理中5:已退款6:买家已取消售后7:已拒绝8:买家退货使用商家提供运单,待商家审核上传运单9:退款已发起,系统处理中10:买家已申请退货11:平台审核中
    private Long afterSalesStatus;
    //afterSalesType	INTEGER	是	售后类型1:仅退款2：退货退款
    private Integer afterSalesType;
}

