package com.eshop.util.platform.api.service.logistics.xiaohongshu.dto;

@lombok.Getter
@lombok.Setter
public class XiaohongshuEbillTemplatesReqDTO {

    //    参数名称	参数类型	是否必填	参数描述
    //    cpCode	string	非必填	快递公司编码
    private String cpCode;
    //    brandCode	string	非必填	品牌编码，当前只有顺丰快运和顺丰速运查询需要传值
    private String brandCode;
    //    type	string	非必填	类型，默认不填返回标准模板列表， ark-返回小红书商家配置的模板列表
    private String type;
    //    templateCustomerType	number	非必填	自定义类型 0-标准 1-订单号 2-商品名称/规格/数量 3-商品名称/规格/数量 + 买家留言 + 商家备注 4-订单号 + 商品名称/规格/数量 + 买家留言 + 商家 10-商家云打印系统自定义 20-自定义打印项组合
    private Integer templateCustomerType;
    //    billVersion	number	非必填	电子面单版本号，1-默认值旧版电子面单 2-新版电子面单
    private Integer billVersion;

}
