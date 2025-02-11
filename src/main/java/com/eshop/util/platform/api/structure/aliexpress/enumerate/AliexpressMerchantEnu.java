package com.eshop.util.platform.api.structure.aliexpress.enumerate;

/**
 * @author ldj
 * @date 2024/4/23 14:00
 * @Description: ...
 * @Version 1.0
 */
public enum AliexpressMerchantEnu {

    //  ○ GET/POST
    //  全部商机的下载
    //  ae.merchant.assortment.seller.plan.chance.download.all
    PLAN_CHANCE_DOWNLOAD_ALL("ae.merchant.assortment.seller.plan.chance.download.all"),
    //  ○ GET/POST
    //  分页查指定商机的所有机会信息
    //  ae.merchant.assortment.seller.plan.chance.list
    PLAN_CHANCE_LIST("ae.merchant.assortment.seller.plan.chance.list"),
    //  ○ GET/POST
    //  商家地址列表查询
    //  aliexpress.merchant.Address.list
    ADDRESS_LIST("aliexpress.merchant.Address.list"),
    //  ○ GET/POST
    //  商机信息列表
    //  ae.merchant.assortment.seller.arrangement.plan.list
    ARRANGEMENT_PLAN_LIST("ae.merchant.assortment.seller.arrangement.plan.list"),
    //  ○ GET/POST
    //  批量供货
    //  ae.merchant.assortment.seller.apply.all
    APPLY_ALL("ae.merchant.assortment.seller.apply.all"),
    //  ○
    //  GET/POST指定商机的下载
    //  ae.merchant.assortment.seller.plan.chance.download
    PLAN_CHANCE_DOWNLOAD("ae.merchant.assortment.seller.plan.chance.download"),
    //  ○ GET/POST
    //  指定商机的报名状态查询
    //  ae.merchant.assortment.seller.plan.products.query
    PLAN_PRODUCTS_QUERY("ae.merchant.assortment.seller.plan.products.query"),
    //  ○ GET/POST
    //  查询AE商家隐私文件
    //  aliexpress.merchant.private.file.get
    PRIVATE_FILE_GET("aliexpress.merchant.private.file.get"),
    //  ○ GET/POST
    //  查询卖家资料
    //  aliexpress.merchant.profile.get
    PROFILE_GET("aliexpress.merchant.profile.get"),
    //  ○ GET/POST
    //  查询商家店铺诊断问题列表
    //  aliexpress.merchant.diagnosis.query
    DIAGNOSIS_QUERY("aliexpress.merchant.diagnosis.query"),
    //  ○ GET/POST
    //  统计数据读取
    //  ae.merchant.assortment.seller.plan.dashboard.query
    PLAN_DASHBOARD_QUERY("ae.merchant.assortment.seller.plan.dashboard.query");

    private final String apiName;

    AliexpressMerchantEnu(String apiName) {
        this.apiName = apiName;
    }

    public String getApiName() {
        return this.apiName;
    }
}
