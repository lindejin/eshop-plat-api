package com.eshop.util.platform.api.service.logistics.cainiao.vo;

import java.util.List;

@lombok.Getter
@lombok.Setter
public class CainiaoCloudSellerStdCustomAreaVO {

    //cpCode	string	32	true	YTO	cp code
    //customAreas	List<CustomArea>	- -	true	- -	自定义区列表
    private String cpCode;
    private List<CainiaoCloudSellerCustomAreaVO> customAreas;
}
