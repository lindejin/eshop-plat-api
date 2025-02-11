package com.eshop.util.platform.api.structure.aliexpress.enumerate;

/**
 * @author ldj
 * @date 2024/3/30 17:14
 * @Description: ...
 * @Version 1.0
 */
public enum AliexpressPopChoiceProductEnu {

    //半托管商品新发一阶段pop信息草稿保存接口
    //GET/POST
    //aliexpress.offer.pop.choice.draft.post
    //描述：post半托管产品并且返回post成功后的产品的一阶段草稿id
    POP_CHOICE_DRAFT_POST("aliexpress.offer.pop.choice.draft.post"),

    //半托管商品新发第二段提交
    //GET/POST
    //aliexpress.pop.choice.product.post
    //描述：半托管商品新发第二段提交，需要带上第一段返回的草稿ID
    POP_CHOICE_PRODUCT_POST("aliexpress.pop.choice.product.post"),

    //半托管商品编辑
    //GET/POST
    //aliexpress.pop.choice.product.edit
    //描述：半托管商品编辑
    POP_CHOICE_PRODUCT_EDIT("aliexpress.pop.choice.product.edit"),

    //半托管商品草稿编辑接口
    //POST
    //aliexpress.draft.product.edit
    //描述：编辑草稿态的半托管商品
    POP_CHOICE_DRAFT_EDIT("aliexpress.draft.product.edit"),

    //半托管商品详情查询
    //GET/POST
    //aliexpress.pop.choice.product.query
    //描述：半托管商品详情查询
    POP_CHOICE_PRODUCT_QUERY("aliexpress.pop.choice.product.query"),

    //半托管库存编辑接口
    //GET/POST
    //aliexpress.pop.choice.product.stocks.update
    //描述：半托管库存编辑接口
    POP_CHOICE_PRODUCT_STOCKS_UPDATE("aliexpress.pop.choice.product.stocks.update"),

    //半托管预存信息查询
    //GET/POST
    //aliexpress.pop.choice.pre.product.query
    //描述：半托管商品详情查询
    POP_CHOICE_PRE_PRODUCT_QUERY("aliexpress.pop.choice.pre.product.query"),

    //商品半托管预存信息提交
    //GET/POST
    //aliexpress.pop.choice.pre.product.submit
    //描述：商品半托管预存信息提交
    POP_CHOICE_PRE_PRODUCT_SUBMIT("aliexpress.pop.choice.pre.product.submit"),

    //商品可升级为半托管SKU信息查询
    //GET/POST
    //aliexpress.pop.choice.draft.query
    //描述：商品可升级为半托管SKU信息查询
    POP_CHOICE_DRAFT_QUERY("aliexpress.pop.choice.draft.query"),


    //商家半托管基本信息查询
    //GET
    //aliexpress.pop.choice.info.query
    //描述：查询半托管相关信息，包括入选国家、商家下仓库列表
    POP_CHOICE_INFO_QUERY("aliexpress.pop.choice.info.query"),

    //已预存商品列表查询
    //GET
    //aliexpress.pop.choice.collected.products.list
    //描述：查询已预存半托管信息商品列表
    POP_CHOICE_COLLECTED_PRODUCTS_LIST("aliexpress.pop.choice.collected.products.list"),

    //查询半托管已加入/待加入/待预存商品列表
    //GET
    //aliexpress.pop.choice.products.list
    //描述：查询半托管已加入/待加入商品列表
    POP_CHOICE_PRODUCTS_LIST("aliexpress.pop.choice.products.list");


    private final String apiName;

    AliexpressPopChoiceProductEnu(String apiName) {
        this.apiName = apiName;
    }

    public String getApiName() {
        return this.apiName;
    }
}
