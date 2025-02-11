package com.eshop.util.platform.api.service.category.aliexpress;

import com.eshop.util.platform.api.service.category.aliexpress.dto.*;
import com.eshop.util.platform.api.structure.aliexpress.dto.AeAppClientDTO;
import com.global.iop.util.ApiException;

public interface AliexpressCategoryCall {

    //获取AE属性的PropValueFeature
    String getPropValueFeature(AeAppClientDTO acDTO, AeCategoryGetPropValueFeatureDTO reqDto) throws ApiException;

    //suggestion
    String suggestion(AeAppClientDTO acDTO, AeCategorySuggestionDTO reqDto) throws ApiException;

    //qdUpload
    String qdUpload(AeAppClientDTO acDTO, AeCategoryQdUploadDTO reqDto) throws ApiException;

    //查询属于特定类别的sku属性信息
    String skuAttributeQuery(AeAppClientDTO acDTO, AeCategorySkuAttributeQueryDTO reqDto) throws ApiException;

    //API，用于卖家查询类别树。只支持显示卖家有权发布产品的类别。
    String sellerCategoryTreeQuery(AeAppClientDTO acDTO, AeCategorySellerCategoryTreeQueryDTO reqDto) throws ApiException;

    //判断叶子类目是否必须尺码表
    String sizeModelsRequiredForPostCat(AeAppClientDTO acDTO, AeCategorySizeModelsRequiredForPostCatDTO reqDto) throws ApiException;

    //查询海外商家授权品牌
    String merchantOverseaBrandGet(AeAppClientDTO acDTO, AeCategoryMerchantOverseaBrandGetDTO reqDto) throws ApiException;

    //查询类目下欧盟责任人列表
    String euResponsiblePersonsList(AeAppClientDTO acDTO, AeCategoryEuResponsiblePersonsListDTO reqDto) throws ApiException;

    //根据发布类目id、父属性路径（可选）获取子属性信息，只返回有权限品牌
    String getChildAttributesResultByPostCateIdAndPath(AeAppClientDTO acDTO, AeCategoryGetChildAttributesResultByPostCateIdAndPathDTO reqDto) throws ApiException;

    //类目资质信息查询
    String qualificationsList(AeAppClientDTO acDTO, AeCategoryQualificationsListDTO reqDto) throws ApiException;

    //获取单个类目信息
    String getPostCategoryById(AeAppClientDTO acDTO, AeCategoryGetPostCategoryByIdDTO reqDto) throws ApiException;

    //获取指定类目下子类目信息
    String getChildrenPostCategoryById(AeAppClientDTO acDTO, AeCategoryGetChildrenPostCategoryByIdDTO reqDto) throws ApiException;

    //获取指定类目下的子类目信息（可校验卖家权限）
    String treeList(AeAppClientDTO acDTO, AeCategoryTreeListDTO reqDto) throws ApiException;
}
