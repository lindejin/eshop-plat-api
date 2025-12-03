package com.eshop.util.platform.api.service.logistics.xiaohongshu.dto;

@lombok.Getter
@lombok.Setter
public class XiaohongshuEbillOrderReqDTO {
    //  参数名称	参数类型	是否必填	参数描述
    //	cpCode	string	必填	快递公司编码
    private String cpCode;
    //	waybillCode	string	必填	面单号
    private String waybillCode;
    //	billVersion	number	非必填	电子面单版本号，1-默认值旧版电子面单 2-新版电子面单
    private Integer billVersion;
}
