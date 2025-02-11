package com.eshop.util.platform.api.structure.aliexpress.enumerate;

/**
 * @author ldj
 * @date 2024/2/28 10:40
 * @Description: ...
 * @Version 1.0
 */
public enum AliexpressImageEnu {
    //request.setApiName("aliexpress.image.redefining.uploadtempimage");
    //上传图片到临时目录
    UPLOAD_TEMP_IMAGE("aliexpress.image.redefining.uploadtempimage"),
    //request.setApiName("aliexpress.image.redefining.uploadtempimageforsdk");
    //上传图片到临时目录
    UPLOAD_TEMP_IMAGE_FOR_SDK("aliexpress.image.redefining.uploadtempimageforsdk"),
    //request.setApiName("aliexpress.photobank.redefining.uploadimage");
    //上传图片到图片银行
    UPLOAD_IMAGE("aliexpress.photobank.redefining.uploadimage"),
    //request.setApiName("aliexpress.photobank.redefining.uploadimageforsdk");
    //上传图片到图片银行
    UPLOAD_IMAGE_FOR_SDK("aliexpress.photobank.redefining.uploadimageforsdk"),
    //request.setApiName("aliexpress.photobank.redefining.delunusephoto");
    //删除未被引用图片
    DELETE_UNUSE_PHOTO("aliexpress.photobank.redefining.delunusephoto"),
    //request.setApiName("aliexpress.photobank.redefining.listimagepagination");
    //图片银行列表分页查询
    LIST_IMAGE_PAGINATION("aliexpress.photobank.redefining.listimagepagination"),
    //request.setApiName("aliexpress.photobank.redefining.listgroup");
    //图片银行分组列表查询
    LIST_GROUP("aliexpress.photobank.redefining.listgroup"),
    //request.setApiName("aliexpress.photobank.redefining.queryphotobankimagebypaths");
    //根据path查询图片信息
    QUERY_PHOTO_BANK_IMAGE_BY_PATHS("aliexpress.photobank.redefining.queryphotobankimagebypaths"),
    //request.setApiName("aliexpress.photobank.redefining.getphotobankinfo");
    //图片银行信息查询
    GET_PHOTO_BANK_INFO("aliexpress.photobank.redefining.getphotobankinfo"),
    //request.setApiName("aliexpress.photobank.redefining.wbimage.get");
    //获取白底图
    GET_WB_IMAGE("aliexpress.photobank.redefining.wbimage.get");

    private final String apiName;

    AliexpressImageEnu(String apiName) {
        this.apiName = apiName;
    }

    public String getApiName() {
        return this.apiName;
    }

}
