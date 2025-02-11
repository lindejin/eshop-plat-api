package com.eshop.util.platform.api.structure.aliexpress.enumerate;

/**
 * @author ldj
 * @date 2024/2/27 17:32
 * @Description: ...
 * @Version 1.0
 */

public enum AliexpressCategoryEnu {
    //request.setApiName("aliexpress.category.redefining.getPropValueFeature");
    //AE getPropValueFeature
    GET_PROP_VALUE_FEATURE("aliexpress.category.redefining.getPropValueFeature"),
    //request.setApiName("/v2.0/categories/suggestion");
    //Get Category Suggestion
    SUGGESTION("/v2.0/categories/suggestion"),
    //request.setApiName("aliexpress.data.qd.file.upload");
    //QD数据文件上传
    QD_FILE_UPLOAD("aliexpress.data.qd.file.upload"),
    //request.setApiName("aliexpress.solution.sku.attribute.query")
    //查询属于特定类别的 sku 属性信息
    SKU_ATTRIBUTE_QUERY("aliexpress.solution.sku.attribute.query"),
    //request.setApiName("aliexpress.solution.seller.category.tree.query");
    //卖家查询分类树的接口
    SELLER_CATEGORY_TREE_QUERY("aliexpress.solution.seller.category.tree.query"),
    //request.setApiName("aliexpress.category.redefining.sizemodelsrequiredforpostcat");
    //判断叶子类目是否必须尺码表
    SIZE_MODELS_REQUIRED_FOR_POST_CAT("aliexpress.category.redefining.sizemodelsrequiredforpostcat"),
    //request.setApiName("aliexpress.merchant.oversea.brand.get");
    //查询海外商家授权品牌
    MERCHANT_OVERSEA_BRAND_GET("aliexpress.merchant.oversea.brand.get"),
    //request.setApiName("aliexpress.category.eu.responsible.persons.list");
    //获取欧盟负责人列表
    EU_RESPONSIBLE_PERSONS_LIST("aliexpress.category.eu.responsible.persons.list"),
    //request.setApiName("aliexpress.category.redefining.getchildattributesresultbypostcateidandpath");
    //根据发布类目id、父属性路径（可选）获取子属性信息，只返回有权限品牌
    GET_CHILD_ATTRIBUTES_RESULT_BY_POST_CATE_ID_AND_PATH("aliexpress.category.redefining.getchildattributesresultbypostcateidandpath"),
    //request.setApiName("aliexpress.category.qualifications.list");
    //类目资质信息查询
    QUALIFICATIONS_LIST("aliexpress.category.qualifications.list"),
    //request.setApiName("aliexpress.category.redefining.getpostcategorybyid");
    //获取单个类目信息
    GET_POST_CATEGORY_BY_ID("aliexpress.category.redefining.getpostcategorybyid"),
    //request.setApiName("aliexpress.category.redefining.getchildrenpostcategorybyid");
    //获取指定类目下子类目信息
    GET_CHILDREN_POST_CATEGORY_BY_ID("aliexpress.category.redefining.getchildrenpostcategorybyid"),
    //request.setApiName("aliexpress.category.tree.list");
    //获取指定类目下的子类目信息（可校验卖家权限）
    TREE_LIST("aliexpress.category.tree.list");

    private final String apiName;

    AliexpressCategoryEnu(String apiName) {
        this.apiName = apiName;
    }

    public String getApiName() {
        return this.apiName;
    }
}
