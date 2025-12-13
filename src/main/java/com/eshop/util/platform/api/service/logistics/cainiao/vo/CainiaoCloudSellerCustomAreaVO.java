package com.eshop.util.platform.api.service.logistics.cainiao.vo;

@lombok.Getter
@lombok.Setter
public class CainiaoCloudSellerCustomAreaVO {

    //standardTemplateUrl	string	128	true	http://1.xx	标准模板 url
    //customAreaName	string	128	true	圆通自定义区1	自定义区名称
    //customAreaMappingId	long	64	true	123	自定义区 mappingId

    private String standardTemplateUrl;
    private String customAreaName;
    private Long customAreaMappingId;
}
