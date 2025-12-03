package com.eshop.util.platform.api.service.logistics.xiaohongshu.vo;

@lombok.Getter
@lombok.Setter
public class XiaohongshuEbillOrderVO {

    //  waybillCode	string	面单号
    private String waybillCode;
    //	printData	string	面单打印数据
    private String printData;
    //	parentWaybillCode	string	子母单会返回母单
    private String parentWaybillCode;
    //	extraInfo	string	扩展信息
    private String extraInfo;
    //	cpCode	string	快递公司编码
    private String cpCode;
    //	customerPrintData	string	自定义打印数据
    private String customerPrintData;
}
