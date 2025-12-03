package com.eshop.util.platform.api.service.logistics.xiaohongshu.vo;

@lombok.Getter
@lombok.Setter
public class XiaohongshuEbillTemplateVO {
    //  id	number	模板id，取号的时候传入此值
    private Long id;
    //	cpCode	string	快递公司编码
    private String cpCode;
    //	brandCode	string	品牌，仅部分快递支持
    private String brandCode;
    //	templateType	string	模板尺寸，76*130-一联，100*150-二联，100*180-三联
    private String templateType;
    //	templateCustomerType	number	自定义类型 0-标准 1-订单号 2-商品名称/规格/数量 3-商品名称/规格/数量 + 买家留言 + 商家备注 4-订单号 + 商品名称/规格/数量 + 买家留言 + 商家备注 10-商家云打印系统自定义
   private Integer templateCustomerType;
    //	templateName	string	模板名称
    private String templateName;
    //	templateDesc	string	模板描述
    private String templateDesc;
    //	templatePreviewUrl	string	预览URL
    private String templatePreviewUrl;
    //	standardTemplateUrl	string	标准模板URL
    private String standardTemplateUrl;
    //	customerTemplateUrl	string	自定义模板URL，templateCustomerType=0时该字段为空，支持的大小是76*30和100*40两种尺寸;isv可根据标记语言规则自己实现自定义区域，新版是小红书自研的标记语言，语法格式是json；旧版使用的菜鸟的标记语言，语法格式是xml
    private String customerTemplateUrl;
    //	customerPrintItems	object	自定义打印项参数列表，注意格式是List<String>，示例：["order","buyerMemo"]
    private java.util.List<String> customerPrintItems;
}
