package com.eshop.util.platform.api.service.logistics.cainiao.vo;


import java.util.List;

@lombok.Getter
@lombok.Setter
public class CainiaoCloudSellerCustomAreaDetailVO {

    //customAreaUrl	string	128	true	http://cloudprint.cainiao.com/template/customArea/440439	自定义区 url
    //customAreaName	string	128	true	圆通自定义区1	自定义区名称
    //keys	List<KeyResult>	- -	true	- -	key 列表

    private String customAreaUrl;
    private String customAreaName;
    private List<CainiaoCloudSellerCustomAreaDetailKeyResult> keys;
}
