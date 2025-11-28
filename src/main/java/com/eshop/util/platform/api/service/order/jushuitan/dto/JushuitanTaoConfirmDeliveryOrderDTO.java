package com.eshop.util.platform.api.service.order.jushuitan.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class JushuitanTaoConfirmDeliveryOrderDTO {

    //deliveryOrderCode	String	T1234	出库单号
    private String deliveryOrderCode;
    //deliveryOrderId	String	C1234	仓储系统出库单号
    private String deliveryOrderId;
    //warehouseCode	String	W1234	仓库编码
    private String warehouseCode;
    //orderType	String	JYCK	出库单类型(JYCK=一般交易出库;HHCK=换货出库;BFCK=补发出库;QTCK=其他出库单)
    private String orderType;
    //status	String	NEW	出库单状态(NEW-未开始处理;ACCEPT-仓库接单;PARTDELIVERED-部分发货完成;DELIVERED-发货完成;EXCEPTION-异 常;CANCELED-取消;CLOSED-关闭;REJECT-拒单;CANCELEDFAIL-取消失败;只传英文编码)
    private String status;
    //outBizCode	String	WB1234	外部业务编码(消息ID;用于去重;ISV对于同一请求;分配一个唯一性的编码。用来保证因为网络等原因导致重复传输;请求 不会被重复处理;条件必填;条件为一单需要多次确认时)
    private String outBizCode;
    //confirmType	Number	0	支持出库单多次发货(多次发货后确认时;0表示发货单最终状态确认;1表示发货单中间状态确认)
    private Integer confirmType;
    //orderConfirmTime	String	2016-09-08 12:00:00	订单完成时间(YYYY-MM-DD HH:MM:SS)
    private String orderConfirmTime;
    //operatorCode	String	O23	当前状态操作员编码
    private String operatorCode;
    //operatorName	String	老王	当前状态操作员姓名
    private String operatorName;
    //operateTime	String	2016-09-09 12:00:00	当前状态操作时间(YYYY-MM-DD HH:MM:SS)
    private String operateTime;
    //storageFee	String	12.0	仓储费用
    private String storageFee;
    //invoices	Invoice[]		发票信息
    private List<JushuitanTaoConfirmDeliveryOrderInvoiceDTO> invoices;
}
