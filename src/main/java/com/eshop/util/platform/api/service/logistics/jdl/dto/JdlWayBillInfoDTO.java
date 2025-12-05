package com.eshop.util.platform.api.service.logistics.jdl.dto;

@lombok.Getter
@lombok.Setter
public class JdlWayBillInfoDTO {
    //popFlag	Integer	否	0	是否京东商城订单（pop订单）。枚举值：1—京东商城订单；0—其他平台订单。不填或者填写0则认为非京东商城订单。长度1
    private Integer popFlag;
    //orderNo	String	条件	261234556	销售平台订单号（例如京东商城订单号），当popFlag=1时，orderNo为必填项，且不能为空字符串。长度2-50
    private String orderNo;
    //wayBillCode	String	条件	YT3722410104738	三方物流服务商运单号。cpCode是顺丰、德邦、跨越、三通一达等其他物流服务商（非京东物流）时必填。长度2-50
    private String wayBillCode;
    //jdWayBillCode	String	条件	JDVC12044009714	京东物流运单号，cpCode为JD（京东快递）、JDKY（京东快运）、JDDJ（京东大件）、ZY（众邮快递）时必填。长度15-30
    private String jdWayBillCode;
}
