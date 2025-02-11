package com.eshop.util.platform.api.service.category.aliexpress;

import com.eshop.util.platform.api.service.category.aliexpress.dto.*;
import com.eshop.util.platform.api.structure.aliexpress.dto.AeAppClientDTO;
import com.eshop.util.platform.api.structure.aliexpress.enumerate.AliexpressCategoryEnu;
import com.global.iop.api.IopClient;
import com.global.iop.api.IopClientImpl;
import com.global.iop.api.IopRequest;
import com.global.iop.api.IopResponse;
import com.global.iop.domain.Protocol;
import com.global.iop.util.ApiException;
import com.global.iop.util.FileItem;
import org.springframework.stereotype.Service;

/**
 * @author ldj
 * @date 2024/3/6 11:31
 * @Description: ...
 * @Version 1.0
 */
@Service
public class AliexpressCategoryCallImpl implements AliexpressCategoryCall {

     /*
    IopClient client = new IopClient(url, appkey, appSecret);
    IopRequest request = new IopRequest();
    request.setApiName("aliexpress.category.redefining.getPropValueFeature");
    request.addApiParameter("propertyId", "1111");
    request.addApiParameter("valueId", "2222");
    request.addApiParameter("featureKey", "CountryCode");
    IopResponse response = client.execute(request, Protocol.GOP);
    System.out.println(response.getBody());
    Thread.sleep(10);
     */

    /**
     * 获取AE属性的PropValueFeature
     */
    @Override
    public String getPropValueFeature(AeAppClientDTO acDTO, AeCategoryGetPropValueFeatureDTO reqDto) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressCategoryEnu.GET_PROP_VALUE_FEATURE.getApiName());
        request.addApiParameter("propertyId", reqDto.getPropertyId());
        request.addApiParameter("valueId", reqDto.getValueId());
        request.addApiParameter("featureKey", reqDto.getFeatureKey());
        IopResponse response = client.execute(request, Protocol.GOP);
        return response.getGopResponseBody();
    }

    /*
    IopClient client = new IopClient(url, appkey, appSecret);
    IopRequest request = new IopRequest();
    request.setApiName("/v2.0/categories/suggestion");
    request.setHttpMethod("GET");
    request.addApiParameter("image_url", "https://upload.wikimedia.org/wikipedia/commons/b/b5/Winnersh_Meadows_Trees.jpg");
    request.addApiParameter("language", "es");
    request.addApiParameter("title", "test product");
    IopResponse response = client.execute(request, accessToken, Protocol.REST_VND_2);
    System.out.println(response.getBody());
    Thread.sleep(10);
     */

    /**
     * suggestion
     */
    @Override
    public String suggestion(AeAppClientDTO acDTO, AeCategorySuggestionDTO reqDto) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressCategoryEnu.SUGGESTION.getApiName());
        request.setHttpMethod("GET");
        request.addApiParameter("image_url", reqDto.getImage_url());
        request.addApiParameter("language", reqDto.getLanguage());
        request.addApiParameter("title", reqDto.getTitle());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.REST_VND_2);
        return response.getGopResponseBody();
    }

    /*
    IopClient client = new IopClient(url, appkey, appSecret);
    IopRequest request = new IopRequest();
    request.setApiName("aliexpress.data.qd.file.upload");
    request.addApiParameter("upload_meta", "{\"partition\":\"ds\\u003d20230101\",\"biz_code\":\"QD-CROWD\"}");
    request.addFileParameter("file_data",new FileItem("/Users/D ocuments/book.jpg"));
    IopResponse response = client.execute(request, Protocol.TOP);
    System.out.println(response.getBody());
    Thread.sleep(10);
     */

    /**
     * qdUpload
     */
    @Override
    public String qdUpload(AeAppClientDTO acDTO, AeCategoryQdUploadDTO reqDto) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressCategoryEnu.QD_FILE_UPLOAD.getApiName());
        request.addApiParameter("upload_meta", reqDto.getUpload_meta());
        try {
            request.addFileParameter("file_data", new FileItem(reqDto.getFile_name(), reqDto.getFile_data()));
        } catch (Exception e) {
            return "文件上传失败,IO异常!";
        }
        IopResponse response = client.execute(request, Protocol.TOP);
        return response.getGopResponseBody();
    }

    //查询属于特定类别的sku属性信息
    /*
IopClient client = new IopClient(url, appkey, appSecret);
IopRequest request = new IopRequest();
request.setApiName("aliexpress.solution.sku.attribute.query");
request.addApiParameter("query_sku_attribute_info_request", "{\"category_id\":\"11112222\",\"aliexpress_category_id\":\"200000801\"}");
IopResponse response = client.execute(request, accessToken, Protocol.TOP);
System.out.println(response.getBody());
Thread.sleep(10);
     */

    /**
     * 查询属于特定类别的sku属性信息
     */
    @Override
    public String skuAttributeQuery(AeAppClientDTO acDTO, AeCategorySkuAttributeQueryDTO reqDto) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressCategoryEnu.SKU_ATTRIBUTE_QUERY.getApiName());
        request.addApiParameter("query_sku_attribute_info_request", reqDto.getQuery_sku_attribute_info_request());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }

    //API，用于卖家查询类别树。只支持显示卖家有权发布产品的类别。
    /*
IopClient client = new IopClient(url, appkey, appSecret);
IopRequest request = new IopRequest();
request.setApiName("aliexpress.solution.seller.category.tree.query");
request.addApiParameter("category_id", "509");
request.addApiParameter("filter_no_permission", "true");
IopResponse response = client.execute(request, accessToken, Protocol.TOP);
System.out.println(response.getBody());
Thread.sleep(10);
     */

    /**
     * 用于卖家查询类别树 只支持显示卖家有权发布产品的类别
     */
    @Override
    public String sellerCategoryTreeQuery(AeAppClientDTO acDTO, AeCategorySellerCategoryTreeQueryDTO reqDto) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressCategoryEnu.SELLER_CATEGORY_TREE_QUERY.getApiName());
        request.addApiParameter("category_id", reqDto.getCategory_id());
        request.addApiParameter("filter_no_permission", reqDto.getFilter_no_permission());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }

    //判断叶子类目是否必须尺码表
    /*
IopClient client = new IopClient(url, appkey, appSecret);
IopRequest request = new IopRequest();
request.setApiName("aliexpress.category.redefining.sizemodelsrequiredforpostcat");
request.addApiParameter("param0", "200000386");
IopResponse response = client.execute(request, Protocol.TOP);
System.out.println(response.getBody());
Thread.sleep(10);
     */

    /**
     * 判断叶子类目是否必须尺码表
     */
    @Override
    public String sizeModelsRequiredForPostCat(AeAppClientDTO acDTO, AeCategorySizeModelsRequiredForPostCatDTO reqDto) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressCategoryEnu.SIZE_MODELS_REQUIRED_FOR_POST_CAT.getApiName());
        request.addApiParameter("param0", reqDto.getParam0());
        IopResponse response = client.execute(request, Protocol.TOP);
        return response.getGopResponseBody();
    }

    //查询海外商家授权品牌
    /*
IopClient client = new IopClient(url, appkey, appSecret);
IopRequest request = new IopRequest();
request.setApiName("aliexpress.merchant.oversea.brand.get");
IopResponse response = client.execute(request, accessToken, Protocol.TOP);
System.out.println(response.getBody());
Thread.sleep(10);
     */

    /**
     * 查询海外商家授权品牌
     */
    @Override
    public String merchantOverseaBrandGet(AeAppClientDTO acDTO, AeCategoryMerchantOverseaBrandGetDTO reqDto) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressCategoryEnu.MERCHANT_OVERSEA_BRAND_GET.getApiName());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }

    //查询类目下欧盟责任人列表
    /*
IopClient client = new IopClient(url, appkey, appSecret);
IopRequest request = new IopRequest();
request.setApiName("aliexpress.category.eu.responsible.persons.list");
request.setHttpMethod("GET");
request.addApiParameter("category_id", "39050508");
request.addApiParameter("channel", "AE_GLOBAL");
request.addApiParameter("channel_seller_id", "2671514005");
IopResponse response = client.execute(request, accessToken, Protocol.TOP);
System.out.println(response.getBody());
Thread.sleep(10);
     */

    /**
     * 查询类目下欧盟责任人列表
     */
    @Override
    public String euResponsiblePersonsList(AeAppClientDTO acDTO, AeCategoryEuResponsiblePersonsListDTO reqDto) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressCategoryEnu.EU_RESPONSIBLE_PERSONS_LIST.getApiName());
        request.setHttpMethod("GET");
        request.addApiParameter("category_id", reqDto.getCategory_id());
        request.addApiParameter("channel", reqDto.getChannel());
        request.addApiParameter("channel_seller_id", reqDto.getChannel_seller_id());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }

    //根据发布类目id、父属性路径（可选）获取子属性信息，只返回有权限品牌
    /*
IopClient client = new IopClient(url, appkey, appSecret);
IopRequest request = new IopRequest();
request.setApiName("aliexpress.category.redefining.getchildattributesresultbypostcateidandpath");
request.addApiParameter("channel", "AE_GLOBAL");
request.addApiParameter("locale", "en_US");
request.addApiParameter("product_type", "2");
request.addApiParameter("channel_seller_id", "2671514005");
request.addApiParameter("param1", "349");
request.addApiParameter("param2", "219=9441741844");
IopResponse response = client.execute(request, accessToken, Protocol.TOP);
System.out.println(response.getBody());
Thread.sleep(10);
     */

    /**
     * 根据发布类目id、父属性路径（可选）获取子属性信息，只返回有权限品牌
     */
    @Override
    public String getChildAttributesResultByPostCateIdAndPath(AeAppClientDTO acDTO, AeCategoryGetChildAttributesResultByPostCateIdAndPathDTO reqDto) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressCategoryEnu.GET_CHILD_ATTRIBUTES_RESULT_BY_POST_CATE_ID_AND_PATH.getApiName());
        request.addApiParameter("channel", reqDto.getChannel());
        request.addApiParameter("locale", reqDto.getLocale());
        request.addApiParameter("product_type", reqDto.getProduct_type());
        request.addApiParameter("channel_seller_id", reqDto.getChannel_seller_id());
        request.addApiParameter("param1", reqDto.getParam1());
        request.addApiParameter("param2", reqDto.getParam2());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }

    //类目资质信息查询
    /*
IopClient client = new IopClient(url, appkey, appSecret);
IopRequest request = new IopRequest();
request.setApiName("aliexpress.category.qualifications.list");
request.setHttpMethod("GET");
request.addApiParameter("category_id", "200001426");
request.addApiParameter("local", "zh_CN");
IopResponse response = client.execute(request, accessToken, Protocol.TOP);
System.out.println(response.getBody());
Thread.sleep(10);
     */

    /**
     * 类目资质信息查询
     */
    @Override
    public String qualificationsList(AeAppClientDTO acDTO, AeCategoryQualificationsListDTO reqDto) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressCategoryEnu.QUALIFICATIONS_LIST.getApiName());
        request.setHttpMethod("GET");
        request.addApiParameter("category_id", reqDto.getCategory_id());
        request.addApiParameter("local", reqDto.getLocal());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }

    //获取单个类目信息
    /*
IopClient client = new IopClient(url, appkey, appSecret);
IopRequest request = new IopRequest();
request.setApiName("aliexpress.category.redefining.getpostcategorybyid");
request.addApiParameter("param0", "5090301");
IopResponse response = client.execute(request, Protocol.TOP);
System.out.println(response.getBody());
Thread.sleep(10);
     */

    /**
     * 获取单个类目信息
     */
    @Override
    public String getPostCategoryById(AeAppClientDTO acDTO, AeCategoryGetPostCategoryByIdDTO reqDto) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressCategoryEnu.GET_POST_CATEGORY_BY_ID.getApiName());
        request.addApiParameter("param0", reqDto.getParam0());
        IopResponse response = client.execute(request, Protocol.TOP);
        return response.getGopResponseBody();
    }

    //获取指定类目下子类目信息
    /*
IopClient client = new IopClient(url, appkey, appSecret);
IopRequest request = new IopRequest();
request.setApiName("aliexpress.category.redefining.getchildrenpostcategorybyid");
request.addApiParameter("param0", "509");
IopResponse response = client.execute(request, Protocol.TOP);
System.out.println(response.getBody());
Thread.sleep(10);
     */

    /**
     * 获取指定类目下子类目信息
     */
    @Override
    public String getChildrenPostCategoryById(AeAppClientDTO acDTO, AeCategoryGetChildrenPostCategoryByIdDTO reqDto) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressCategoryEnu.GET_CHILDREN_POST_CATEGORY_BY_ID.getApiName());
        request.addApiParameter("param0", reqDto.getParam0());
        IopResponse response = client.execute(request, Protocol.TOP);
        return response.getGopResponseBody();
    }

    //获取指定类目下的子类目信息（可校验卖家权限）
    /*
IopClient client = new IopClient(url, appkey, appSecret);
IopRequest request = new IopRequest();
request.setApiName("aliexpress.category.tree.list");
request.setHttpMethod("GET");
request.addApiParameter("channel_seller_id", "2671514005");
request.addApiParameter("only_with_permission", "true");
request.addApiParameter("channel", "AE_GLOBAL");
request.addApiParameter("category_id", "0");
IopResponse response = client.execute(request, accessToken, Protocol.TOP);
System.out.println(response.getBody());
Thread.sleep(10);
     */

    /**
     * 获取指定类目下的子类目信息（可校验卖家权限）
     */
    @Override
    public String treeList(AeAppClientDTO acDTO, AeCategoryTreeListDTO reqDto) throws ApiException {
        IopClient client = new IopClientImpl(acDTO.getUrl(), acDTO.getAppKey(), acDTO.getAppSecret());
        IopRequest request = new IopRequest();
        request.setApiName(AliexpressCategoryEnu.TREE_LIST.getApiName());
        request.setHttpMethod("GET");
        request.addApiParameter("channel_seller_id", reqDto.getChannel_seller_id());
        request.addApiParameter("only_with_permission", reqDto.getOnly_with_permission());
        request.addApiParameter("channel", reqDto.getChannel());
        request.addApiParameter("category_id", reqDto.getCategory_id());
        IopResponse response = client.execute(request, acDTO.getAccessToken(), Protocol.TOP);
        return response.getGopResponseBody();
    }
}
