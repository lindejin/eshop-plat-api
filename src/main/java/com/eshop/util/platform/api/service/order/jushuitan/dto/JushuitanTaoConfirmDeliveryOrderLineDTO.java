package com.eshop.util.platform.api.service.order.jushuitan.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class JushuitanTaoConfirmDeliveryOrderLineDTO {

    //orderLineNo	String	1	单据行号
    private String orderLineNo;
    //orderSourceCode	String	P1234	平台交易订单编码
    private String orderSourceCode;
    //subSourceCode	String	J1234	平台交易子订单编码
    private String subSourceCode;
    //itemCode	String	I1234	商品编码
    private String itemCode;
    //itemId	String	WI1234	商品仓储系统编码
    private String itemId;
    //inventoryType	String	ZP	库存类型(ZP=正品;CC=残次;JS=机损;XS=箱损;ZT=在途库存;默认为查所有类型的库存)
     private String inventoryType;
    //ownerCode	String	OW1234	货主编码
    private String ownerCode;
    //itemName	String	淘公仔	商品名称
    private String itemName;
    //extCode	String	PL1234	交易平台商品编码
    private String extCode;
    //planQty	Number	12	应发商品数量
    private Integer planQty;
    //actualQty	Number	12	实发商品数量
    private Integer actualQty;
    //batchCode	String	P1234	批次编号
    private String batchCode;
    //productDate	String	2016-09-09	生产日期(YYYY-MM-DD)
    private String productDate;
    //expireDate	String	2017-09-09	过期日期(YYYY-MM-DD)
    private String expireDate;
    //produceCode	String	P2345	生产批号
    private String produceCode;
    //batchs	Batch[]		批次列表
    private List<JushuitanTaoConfirmDeliveryOrderBatchDTO> batchs;
    //qrCode	String	one;two	商品的二维码(类似电子产品的SN码;用来进行商品的溯源;多个二维码之间用分号;隔开)
    private String qrCode;
    //snCode	String	货品sn编码	货品sn编码
    private String snCode;
    //snList	SnList		sn列表
    private List<String> snList;
    //supplierName	String	供应商名称	供应商名称
    private String supplierName;
    //supplierCode	String	供应商编码	供应商编码
    private String supplierCode;
    //imeiList	ImeiList		imeiList
    private List<JushuitanTaoConfirmDeliveryOrderImeiDTO> imeiList;
}
