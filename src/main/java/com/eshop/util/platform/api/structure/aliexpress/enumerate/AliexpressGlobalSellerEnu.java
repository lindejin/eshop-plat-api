package com.eshop.util.platform.api.structure.aliexpress.enumerate;

/**
 * @author ldj
 * @date 2024/4/17 15:27
 * @Description: ...
 * @Version 1.0
 */
public enum AliexpressGlobalSellerEnu {

    //统一类目下品牌信息查询
    //GET
    //global.seller.brands.list
    //描述：获取商家有发布权限的统一品牌
    SELLER_BRANDS_LIST("global.seller.brands.list"),
    //获取商家账号列表
    //GET
    //global.seller.relation.query
    //描述：获取商家账号关系列表
    SELLER_RELATION_QUERY("global.seller.relation.query");

    private final String apiName;

    AliexpressGlobalSellerEnu(String apiName) {
        this.apiName = apiName;
    }

    public String getApiName() {
        return this.apiName;
    }
}
