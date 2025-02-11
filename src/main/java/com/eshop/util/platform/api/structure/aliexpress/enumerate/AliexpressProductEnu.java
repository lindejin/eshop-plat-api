package com.eshop.util.platform.api.structure.aliexpress.enumerate;

/**
 * @author ldj
 * @date 2024/2/29 11:24
 * @Description: ...
 * @Version 1.0
 */
public enum AliexpressProductEnu {
    //request.setApiName("aliexpress.solution.batch.product.price.update");
    //批量更新商品价格
    BATCH_PRODUCT_PRICE_UPDATE("aliexpress.solution.batch.product.price.update"),
    //request.setApiName("aliexpress.solution.product.edit");
    //用于编辑产品
    PRODUCT_EDIT("aliexpress.solution.product.edit"),
    //request.setApiName("aliexpress.solution.product.info.get");
    //获取单一产品信息
    PRODUCT_INFO_GET("aliexpress.solution.product.info.get"),
    //request.setApiName("aliexpress.solution.product.list.get");
    //获取产品列表
    PRODUCT_LIST_GET("aliexpress.solution.product.list.get"),
    //request.setApiName("aliexpress.solution.feed.invalidate");
    //特定 Feed 失效
    FEED_INVALIDATE("aliexpress.solution.feed.invalidate"),
    //request.setApiName("aliexpress.solution.product.post");
    //产品发布
    PRODUCT_POST("aliexpress.solution.product.post"),
    //request.setApiName("aliexpress.solution.schema.product.instance.post");
    //基于json schema实例上传产品
    SCHEMA_PRODUCT_INSTANCE_POST("aliexpress.solution.schema.product.instance.post"),
    //request.setApiName("aliexpress.offer.draftproduct.get");
    //查询草稿箱里的产品信息
    DRAFT_PRODUCT_GET("aliexpress.offer.draftproduct.get"),
    //request.setApiName("aliexpress.solution.batch.product.delete");
    //删除除草稿框外的在线产品
    BATCH_PRODUCT_DELETE("aliexpress.solution.batch.product.delete"),
    //request.setApiName("aliexpress.solution.batch.product.inventory.update");
    //批量产品库存更新
    BATCH_PRODUCT_INVENTORY_UPDATE("aliexpress.solution.batch.product.inventory.update"),
    //request.setApiName("aliexpress.solution.feed.list.get");
    //查询属于卖家的 Feed 列表
    FEED_LIST_GET("aliexpress.solution.feed.list.get"),
    //request.setApiName("aliexpress.solution.feed.query");
    //查询Feed执行结果
    FEED_QUERY("aliexpress.solution.feed.query"),
    //request.setApiName("aliexpress.solution.feed.submit");
    //供商家提交 Feed 数据
    FEED_SUBMIT("aliexpress.solution.feed.submit"),
    //request.setApiName("aliexpress.solution.hscode.query");
    //用于根据产品类别获取hscode
    HS_CODE_QUERY("aliexpress.solution.hscode.query"),
    //request.setApiName("aliexpress.solution.merchant.profile.get");
    //海外卖家获取正常信息
    MERCHANT_PROFILE_GET("aliexpress.solution.merchant.profile.get"),
    //request.setApiName("aliexpress.solution.schema.product.full.update");
    //产品全量更新
    SCHEMA_PRODUCT_FULL_UPDATE("aliexpress.solution.schema.product.full.update"),
    //request.setApiName("aliexpress.solution.product.schema.get");
    //获取产品架构
    PRODUCT_SCHEMA_GET("aliexpress.solution.product.schema.get"),
    //request.setApiName("aliexpress.postproduct.redefining.setsizechart");
    //修改商品所引用的尺码模板
    SET_SIZE_CHART("aliexpress.postproduct.redefining.setsizechart"),
    //request.setApiName("aliexpress.postproduct.redefining.editaeproduct");
    //修改编辑商品信息
    POST_PRODUCT_REDEFINING_EDIT_AE_PRODUCT("aliexpress.postproduct.redefining.editaeproduct"),
    //request.setApiName("aliexpress.product.diagnosis.pageQueryProblem");
    //分页查询待优化商品列表
    PRODUCT_DIAGNOSIS_PAGE_QUERY_PROBLEM("aliexpress.product.diagnosis.pageQueryProblem"),
    //request.setApiName("aliexpress.postproduct.redefining.createproductgroup");
    //创建产品分组
    POST_PRODUCT_REDEFINING_CREATE_PRODUCT_GROUP("aliexpress.postproduct.redefining.createproductgroup"),
    //request.setApiName("aliexpress.postproduct.redefining.postaeproduct");
    //发布产品信息
    POST_PRODUCT_REDEFINING_POST_AE_PRODUCT("aliexpress.postproduct.redefining.postaeproduct"),
    //request.setApiName("aliexpress.postproduct.redefining.postmultilanguageaeproduct");
    //发布多语言产品(试用)
    POST_PRODUCT_REDEFINING_POST_MULTI_LANGUAGE_AE_PRODUCT("aliexpress.postproduct.redefining.postmultilanguageaeproduct"),
    //request.setApiName("aliexpress.postproduct.redefining.onlineaeproduct");
    //商品上架
    POST_PRODUCT_REDEFINING_ONLINE_AE_PRODUCT("aliexpress.postproduct.redefining.onlineaeproduct"),
    //request.setApiName("aliexpress.postproduct.redefining.offlineaeproduct");
    //商品下架
    POST_PRODUCT_REDEFINING_OFFLINE_AE_PRODUCT("aliexpress.postproduct.redefining.offlineaeproduct"),
    //request.setApiName("aliexpress.postproduct.redefining.setgroups");
    //商品分组设置
    POST_PRODUCT_REDEFINING_SET_GROUPS("aliexpress.postproduct.redefining.setgroups"),
    //request.setApiName("aliexpress.postproduct.redefining.findproductinfolistquery");
    //商品列表查询接口
    POST_PRODUCT_REDEFINING_FIND_PRODUCT_INFO_LIST_QUERY("aliexpress.postproduct.redefining.findproductinfolistquery"),
    //request.setApiName("aliexpress.offer.product.delete");
    //商品删除接口
    PRODUCT_DELETE("aliexpress.offer.product.delete"),
    //request.setApiName("aliexpress.offer.product.post");
    //商品发布新接口
    PRODUCT_POST_NEW("aliexpress.offer.product.post"),
    //request.setApiName("aliexpress.offer.product.edit");
    //商品新的编辑接口
    PRODUCT_EDIT_NEW("aliexpress.offer.product.edit"),
    //request.setApiName("aliexpress.offer.product.query");
    //商品查询新接口
    PRODUCT_QUERY_NEW("aliexpress.offer.product.query"),
    //request.setApiName("aliexpress.postproduct.redefining.setshopwindowproduct");
    //商品橱窗设置
    SET_SHOP_WINDOW_PRODUCT("aliexpress.postproduct.redefining.setshopwindowproduct"),
    //request.setApiName("aliexpress.postproduct.redefining.findaeproductprohibitedwords");
    //商品违禁词查询
    FIND_AE_PRODUCT_PROHIBITED_WORDS("aliexpress.postproduct.redefining.findaeproductprohibitedwords"),
    //request.setApiName("aliexpress.offer.redefining.copysizetemplate");
    //将指定的尺码模版信息复制到具有相同的模型的目标叶子类目下面
    COPY_SIZE_TEMPLATE("aliexpress.offer.redefining.copysizetemplate"),
    //aliexpress.offer.redefining.getcanusedproductbysizetemplateid
    //获取当前尺码模版可以被引用的商品列表
    GET_CAN_USED_PRODUCT("aliexpress.offer.redefining.getcanusedproductbysizetemplateid"),
    //request.setApiName("aliexpress.postproduct.redefining.renewexpire");
    //延长商品有效期
    RENEW_EXPIRE("aliexpress.postproduct.redefining.renewexpire"),
    //request.setApiName("aliexpress.carmodel.update.product.carInfo");
    //批量更新商品绑定车型信息
    CAR_MODEL_UPDATE_PRODUCT_CAR_INFO("aliexpress.carmodel.update.product.carInfo"),
    //request.setApiName("aliexpress.carmodel.findByTecIds");
    //批量查询车型库数据
    CAR_MODEL_FIND_BY_TEC_IDS("aliexpress.carmodel.findByTecIds"),
    //request.setApiName("aliexpress.ugc.product.video.upload");
    //新增商品主图短视频
    UGC_PRODUCT_VIDEO_UPLOAD("aliexpress.ugc.product.video.upload"),
    //request.setApiName("aliexpress.postproduct.redefining.querypromisetemplatebyid");
    //服务模板查询
    QUERY_PROMISE_TEMPLATE_BY_ID("aliexpress.postproduct.redefining.querypromisetemplatebyid"),
    //request.setApiName("aliexpress.offer.redefining.querybundle");
    //查询主商品搭配列表
    QUERY_BUNDLE("aliexpress.offer.redefining.querybundle"),
    //request.setApiName("aliexpress.postproduct.redefining.findaeproductdetailmodulelistbyqurey");
    //查询信息模板列表
    FIND_AE_PRODUCT_DETAIL_MODULE_LIST_BY_QUREY("aliexpress.postproduct.redefining.findaeproductdetailmodulelistbyqurey"),
    //request.setApiName("aliexpress.postproduct.redefining.findaeproductmodulebyid");
    //查询单个信息模板详情
    FIND_AE_PRODUCT_MODULE_BY_ID("aliexpress.postproduct.redefining.findaeproductmodulebyid"),
    //request.setApiName("aliexpress.postproduct.redefining.findaeproductstatusbyid");
    //查询商品状态
    FIND_AE_PRODUCT_STATUS_BY_ID("aliexpress.postproduct.redefining.findaeproductstatusbyid"),
    //request.setApiName("aliexpress.carmodel.findListByProductId");
    //查询商品绑定的车型信息
    CAR_MODEL_FIND_LIST_BY_PRODUCT_ID("aliexpress.carmodel.findListByProductId"),
    //request.setApiName("aliexpress.product.diagnosis.result.list");
    //查询商家下已优化商品
    PRODUCT_DIAGNOSIS_RESULT_LIST("aliexpress.product.diagnosis.result.list"),
    //request.setApiName("aliexpress.product.diagnosis.queryProblem");
    //查询商家下待优化的商品问题类型列表
    PRODUCT_DIAGNOSIS_QUERY_PROBLEM("aliexpress.product.diagnosis.queryProblem"),
    //request.setApiName("aliexpress.postproduct.redefining.queryproductgroupidbyproductid");
    //查询指定商品ID所在产品分组
    QUERY_PRODUCT_GROUP_ID_BY_PRODUCT_ID("aliexpress.postproduct.redefining.queryproductgroupidbyproductid"),
    //request.setApiName("aliexpress.offer.draftproduct.get");
    //查询草稿箱里的产品信息
    DRAFT_PRODUCT_GET_NEW("aliexpress.offer.draftproduct.get"),
    //request.setApiName("aliexpress.offer.draftproducts.get");
    //查询草稿箱里的商品列表
    DRAFT_PRODUCTS_GET("aliexpress.offer.draftproducts.get"),
    //request.setApiName("aliexpress.carmodel.get.brand");
    //查询车型库支持的品牌
    CAR_MODEL_GET_BRAND("aliexpress.carmodel.get.brand"),
    //request.setApiName("aliexpress.carmodel.get.country");
    //查询车型库支持的国家
    CAR_MODEL_GET_COUNTRY("aliexpress.carmodel.get.country"),
    //request.setApiName("aliexpress.carmodel.get.linktarget");
    //查询零配件关联的TEC车型ID
    CAR_MODEL_GET_LINK_TARGET("aliexpress.carmodel.get.linktarget"),
    //request.setApiName("aliexpress.carmodel.get.article");
    //根据OE号查询零配件信息
    CAR_MODEL_GET_ARTICLE("aliexpress.carmodel.get.article"),
    //request.setApiName("aliexpress.carmodel.findByTecId");
    //根据tecId查询车型库数据
    CAR_MODEL_FIND_BY_TEC_ID("aliexpress.carmodel.findByTecId"),
    //request.setApiName("aliexpress.postproduct.redefining.getsizechartinfobycategoryid");
    //根据类目id获得适用的尺码表信息列表（不推荐使用）
    GET_SIZE_CHART_INFO_BY_CATEGORY_ID("aliexpress.postproduct.redefining.getsizechartinfobycategoryid"),
    //request.setApiName("aliexpress.postproduct.redefining.categoryforecast");
    //类目预测
    CATEGORY_FORECAST("aliexpress.postproduct.redefining.categoryforecast"),
    //request.setApiName("aliexpress.offer.product.skuprices.edit");
    //编辑单商品多sku价格
    PRODUCT_SKU_PRICES_EDIT("aliexpress.offer.product.skuprices.edit"),
    //request.setApiName("aliexpress.postproduct.redefining.editmutilpleskustocks");
    //编辑单商品多个SKU的库存
    EDIT_MULTIPLE_SKU_STOCKS("aliexpress.postproduct.redefining.editmutilpleskustocks"),
    //request.setApiName("aliexpress.postproduct.redefining.editsingleskuprice");
    //编辑商品单个SKU价格
    EDIT_SINGLE_SKU_PRICE("aliexpress.postproduct.redefining.editsingleskuprice"),
    //request.setApiName("aliexpress.postproduct.redefining.editsingleskustock");
    //编辑商品单个SKU库存
    EDIT_SINGLE_SKU_STOCK("aliexpress.postproduct.redefining.editsingleskustock"),
    //request.setApiName("aliexpress.postproduct.redefining.editsimpleproductfiled");
    //编辑商品的单个字段
    EDIT_SIMPLE_PRODUCT_FILED("aliexpress.postproduct.redefining.editsimpleproductfiled"),
    //request.setApiName("aliexpress.postproduct.redefining.editmultilanguageproduct");
    //编辑商品的多语言标题或详描
    EDIT_MULTI_LANGUAGE_PRODUCT("aliexpress.postproduct.redefining.editmultilanguageproduct"),
    //request.setApiName("aliexpress.postproduct.redefining.editproductcategoryattributes");
    //编辑商品类目属性
    EDIT_PRODUCT_CATEGORY_ATTRIBUTES("aliexpress.postproduct.redefining.editproductcategoryattributes"),
    //request.setApiName("aliexpress.postproduct.redefining.findaeproductbyid");
    //获取单个产品信息
    FIND_AE_PRODUCT_BY_ID("aliexpress.postproduct.redefining.findaeproductbyid"),
    //request.setApiName("aliexpress.offer.redefining.getsizetemplatesbycategoryid");
    //获取叶子类目下尺码模版列表
    GET_SIZE_TEMPLATES_BY_CATEGORY_ID("aliexpress.offer.redefining.getsizetemplatesbycategoryid"),
    //request.setApiName("aliexpress.postproduct.redefining.getproductgrouplist");
    //获取当前会员的产品分组（不推荐使用）
    GET_PRODUCT_GROUP_LIST("aliexpress.postproduct.redefining.getproductgrouplist"),
    //request.setApiName("aliexpress.product.productgroups.get");
    //获取当前会员的产品分组（新）
    PRODUCT_GROUPS_GET("aliexpress.product.productgroups.get"),
    //request.setApiName("aliexpress.offer.redefining.initialnewbundle");
    //通过商品ID初始化商品搭配
    INITIAL_NEW_BUNDLE("aliexpress.offer.redefining.initialnewbundle"),


    // ----------------------全托管--------------------》start----
    // 获取商家账号关系列表
    SELLER_RELATION_QUERY("global.seller.relation.query"),

    // 获取商家账号关系列表
    AE_CATEGORY_TREE_LIST("aliexpress.category.tree.list"),

    // 根据发布类目id、父属性路径（可选）获取子属性信息。只返回当前账号有权限的品牌集合
    AE_CATEGORY_REDEFINING_GETCHILDATTRIBUTESRESULTBYPOSTCATEIDANDPATH("aliexpress.category.redefining.getchildattributesresultbypostcateidandpath"),

    // 全托管店铺-商品发布
    AE_CHOICE_PRODUCT_POST("aliexpress.choice.product.post"),

    // 全托管店铺-查询单个商品详情
    AE_CHOICE_PRODUCT_QUERY("aliexpress.choice.product.query");
    // ----------------------全托管-------------------《  end----



    private final String apiName;

    AliexpressProductEnu(String apiName) {
        this.apiName = apiName;
    }

    public String getApiName() {
        return this.apiName;
    }
}
