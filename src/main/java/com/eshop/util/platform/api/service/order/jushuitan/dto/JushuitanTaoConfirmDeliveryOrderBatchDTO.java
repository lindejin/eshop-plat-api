package com.eshop.util.platform.api.service.order.jushuitan.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JushuitanTaoConfirmDeliveryOrderBatchDTO {

    //batchCode	String	PC1234	批次编号
    private String batchCode;
    //productDate	String	2016-09-09	生产日期(YYYY-MM-DD)
    private String productDate;
    //expireDate	String	2017-09-09	过期日期(YYYY-MM-DD)
    private String expireDate;
    //produceCode	String	PH1234	生产批号
    private String produceCode;
    //inventoryType	String	ZP	库存类型(ZP=正品;CC=残次;JS=机损;XS=箱损;ZT=在途库存;默认为查所有类型的库存)
    private String inventoryType;
    //actualQty	Number	12	实发数量(要求batchs节点下所有的实发数量之和等于orderline中的实发数量)
    private Integer actualQty;
    //snCode	String	货品sn编码	货品sn编码
    private String snCode;
}
