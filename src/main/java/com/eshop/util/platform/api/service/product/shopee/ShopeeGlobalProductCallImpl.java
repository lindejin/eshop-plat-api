package com.eshop.util.platform.api.service.product.shopee;

import com.alibaba.fastjson.JSONObject;
import com.eshop.util.platform.api.client.shopee.ShopeeClient;
import com.eshop.util.platform.api.client.shopee.ShopeeRequest;
import com.eshop.util.platform.api.client.shopee.ShopeeResponse;
import com.eshop.util.platform.api.structure.shopee.dto.ShopeeAppClientDTO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ldj
 * @date 2024/1/22 14:05
 * @Description: ...
 * @Version 1.0
 */
@Service
public class ShopeeGlobalProductCallImpl implements ShopeeGlobalProductCall {

    @Resource
    private ShopeeClient shopeeClient;


    @Override
    public String getGlobalItemList(ShopeeAppClientDTO publicDto, Map<String, Object> businessDto) throws Exception {
        String apiMethod = "/api/v2/global_product/get_global_item_list";
        //get->json
        Integer mediaType = 1;
        // 商户级别加密(商户调用商户)
        Integer secretType = 3;

        ShopeeRequest shopeeRequest = new ShopeeRequest();
        shopeeRequest.setApiName(apiMethod);
        shopeeRequest.setMediaType(mediaType);
        shopeeRequest.setSecretType(secretType);
        //商品实体
        shopeeRequest.setMapParams(businessDto);

        ShopeeResponse shopeeResponse = shopeeClient.execute(shopeeRequest, publicDto);
        return shopeeResponse.getGopResponseBody();
    }

    @Override
    public String getGlobalItemBaseInfo(ShopeeAppClientDTO publicDto, Map<String, Object> businessDto) throws Exception {
        String apiMethod = "/api/v2/global_product/get_global_item_info";
        //get->json
        Integer mediaType = 1;
        // 商户级别加密(商户调用商户)
        Integer secretType = 3;

        ShopeeRequest shopeeRequest = new ShopeeRequest();
        shopeeRequest.setApiName(apiMethod);
        shopeeRequest.setMediaType(mediaType);
        shopeeRequest.setSecretType(secretType);
        //商品实体
        shopeeRequest.setMapParams(businessDto);

        ShopeeResponse shopeeResponse = shopeeClient.execute(shopeeRequest, publicDto);
        return shopeeResponse.getGopResponseBody();
    }

    @Override
    public String getGlobalModelList(ShopeeAppClientDTO publicDto, Map<String, Object> businessDto) throws Exception {
        String apiMethod = "/api/v2/global_product/get_global_model_list";

        //get->json
        Integer mediaType = 1;
        // 商户级别加密(商户调用商户)
        Integer secretType = 3;

        ShopeeRequest shopeeRequest = new ShopeeRequest();
        shopeeRequest.setApiName(apiMethod);
        shopeeRequest.setMediaType(mediaType);
        shopeeRequest.setSecretType(secretType);
        //商品实体
        shopeeRequest.setMapParams(businessDto);

        ShopeeResponse shopeeResponse = shopeeClient.execute(shopeeRequest, publicDto);
        return shopeeResponse.getGopResponseBody();
    }

    @Override
    public String getGlobalItemId(ShopeeAppClientDTO publicDto, Map<String, Object> businessDto) throws Exception {
        String apiMethod = "/api/v2/global_product/get_global_item_id";
        //get->json
        Integer mediaType = 1;
        // 商户级别加密(商户调用商户)
        Integer secretType = 3;

        ShopeeRequest shopeeRequest = new ShopeeRequest();
        shopeeRequest.setApiName(apiMethod);
        shopeeRequest.setMediaType(mediaType);
        shopeeRequest.setSecretType(secretType);
        //商品实体
        shopeeRequest.setMapParams(businessDto);

        ShopeeResponse shopeeResponse = shopeeClient.execute(shopeeRequest, publicDto);
        return shopeeResponse.getGopResponseBody();
    }

    @Override
    public String addGlobalItem(ShopeeAppClientDTO publicDto, JSONObject param) throws Exception {
        String apiMethod = "/api/v2/global_product/add_global_item";
        Integer mediaType = 2;
        //店铺
        Integer secretType = 3;
        ShopeeRequest shopeeRequest = new ShopeeRequest();
        shopeeRequest.setApiName(apiMethod);
        shopeeRequest.setMediaType(mediaType);
        shopeeRequest.setSecretType(secretType);
        //业务参数
        shopeeRequest.setJsonParams(param);
        ShopeeResponse shopeeResponse = shopeeClient.execute(shopeeRequest, publicDto);
        return shopeeResponse.getGopResponseBody();
    }

    @Override
    public String initTierVariation(ShopeeAppClientDTO acDTO, JSONObject paramsJson) throws Exception {
        String apiMethod = "/api/v2/global_product/init_tier_variation";
        Integer mediaType = 2;
        //店铺
        Integer secretType = 3;
        ShopeeRequest shopeeRequest = new ShopeeRequest();
        shopeeRequest.setApiName(apiMethod);
        shopeeRequest.setMediaType(mediaType);
        shopeeRequest.setSecretType(secretType);
        //业务参数
        shopeeRequest.setJsonParams(paramsJson);
        ShopeeResponse shopeeResponse = shopeeClient.execute(shopeeRequest, acDTO);
        return shopeeResponse.getGopResponseBody();
    }

    @Override
    public String getCategoryRecommend(ShopeeAppClientDTO publicDto, Map<String, Object> paramsMap) throws Exception {
        String apiMethod = "/api/v2/global_product/category_recommend";
        Integer mediaType = 1;
        //店铺
        Integer secretType = 3;
        ShopeeRequest shopeeRequest = new ShopeeRequest();
        shopeeRequest.setApiName(apiMethod);
        shopeeRequest.setMediaType(mediaType);
        shopeeRequest.setSecretType(secretType);
        //业务参数
        shopeeRequest.setMapParams(paramsMap);
        ShopeeResponse shopeeResponse = shopeeClient.execute(shopeeRequest, publicDto);
        return shopeeResponse.getGopResponseBody();
    }


    @Override
    public String getRecommendAttribute(ShopeeAppClientDTO publicDto, Map<String, Object> paramsMap) throws Exception {
        String apiMethod = "/api/v2/global_product/get_recommend_attribute";
        Integer mediaType = 1;
        //店铺
        Integer secretType = 3;
        ShopeeRequest shopeeRequest = new ShopeeRequest();
        shopeeRequest.setApiName(apiMethod);
        shopeeRequest.setMediaType(mediaType);
        shopeeRequest.setSecretType(secretType);
        //业务参数
        shopeeRequest.setMapParams(paramsMap);
        ShopeeResponse shopeeResponse = shopeeClient.execute(shopeeRequest, publicDto);
        return shopeeResponse.getGopResponseBody();
    }

    @Override
    public String getAttributes(ShopeeAppClientDTO acDTO, Map<String, Object> paramsMap) throws Exception {
        String apiMethod = "/api/v2/global_product/get_attributes";
        Integer mediaType = 1;
        //店铺
        Integer secretType = 3;

        ShopeeRequest shopeeRequest = new ShopeeRequest();
        shopeeRequest.setApiName(apiMethod);
        shopeeRequest.setMediaType(mediaType);
        shopeeRequest.setSecretType(secretType);
        //业务参数
        shopeeRequest.setMapParams(paramsMap);
        ShopeeResponse shopeeResponse = shopeeClient.execute(shopeeRequest, acDTO);
        return shopeeResponse.getGopResponseBody();
    }

    @Override
    public String getBrandList(ShopeeAppClientDTO acDTO, Map<String, Object> paramsMap) throws Exception {
        String apiMethod = "/api/v2/global_product/get_brand_list";
        Integer mediaType = 1;
        //店铺
        Integer secretType = 3;
        ShopeeRequest shopeeRequest = new ShopeeRequest();
        shopeeRequest.setApiName(apiMethod);
        shopeeRequest.setMediaType(mediaType);
        shopeeRequest.setSecretType(secretType);
        //业务参数
        shopeeRequest.setMapParams(paramsMap);
        ShopeeResponse shopeeResponse = shopeeClient.execute(shopeeRequest, acDTO);
        return shopeeResponse.getGopResponseBody();
    }

    @Override
    public String getDtsLimit(ShopeeAppClientDTO acDTO, Map<String, Object> paramsMap) throws Exception {
        String apiMethod =  "/api/v2/global_product/get_dts_limit";
        Integer mediaType = 1;
        //店铺
        Integer secretType = 3;
        ShopeeRequest shopeeRequest = new ShopeeRequest();
        shopeeRequest.setApiName(apiMethod);
        shopeeRequest.setMediaType(mediaType);
        shopeeRequest.setSecretType(secretType);
        //业务参数
        shopeeRequest.setMapParams(paramsMap);
        ShopeeResponse shopeeResponse = shopeeClient.execute(shopeeRequest, acDTO);
        return shopeeResponse.getGopResponseBody();
    }

    @Override
    public String supportSizeChart(ShopeeAppClientDTO acDTO, Map<String, Object> paramsMap) throws Exception {
        String apiMethod =  "/api/v2/global_product/support_size_chart";
        Integer mediaType = 1;
        //店铺
        Integer secretType = 3;
        ShopeeRequest shopeeRequest = new ShopeeRequest();
        shopeeRequest.setApiName(apiMethod);
        shopeeRequest.setMediaType(mediaType);
        shopeeRequest.setSecretType(secretType);
        //业务参数
        shopeeRequest.setMapParams(paramsMap);
        ShopeeResponse shopeeResponse = shopeeClient.execute(shopeeRequest, acDTO);
        return shopeeResponse.getGopResponseBody();
    }

    @Override
    public String updateSizeChart(ShopeeAppClientDTO publicDto, JSONObject businessDto) throws Exception {
        String apiMethod = "/api/v2/global_product/update_size_chart";
        //post->json
        Integer mediaType = 2;
        //商户
        Integer secretType = 3;

        ShopeeRequest shopeeRequest = new ShopeeRequest();
        shopeeRequest.setApiName(apiMethod);
        shopeeRequest.setMediaType(mediaType);
        shopeeRequest.setSecretType(secretType);

        shopeeRequest.setJsonParams(businessDto);

        ShopeeResponse shopeeResponse = shopeeClient.execute(shopeeRequest, publicDto);
        return shopeeResponse.getGopResponseBody();
    }

    @Override
    public String getSizeChartList(ShopeeAppClientDTO publicDto, Map<String, Object> businessDto) throws Exception {
        //访问接口
        String apiMethod = "/api/v2/global_product/get_size_chart_list";
        //请求类型 get
        Integer mediaType = 1;
        //加密等级 商户
        Integer secretType = 3;

        ShopeeRequest shopeeRequest = new ShopeeRequest();
        shopeeRequest.setApiName(apiMethod);
        shopeeRequest.setMediaType(mediaType);
        shopeeRequest.setSecretType(secretType);
        //业务参数
        shopeeRequest.setMapParams(businessDto);

        ShopeeResponse shopeeResponse = shopeeClient.execute(shopeeRequest, publicDto);
        return shopeeResponse.getGopResponseBody();

    }

    @Override
    public String getSizeChartDetail(ShopeeAppClientDTO publicDto, Map<String, Object> businessDto) throws Exception {
        //访问接口
        String apiMethod = "/api/v2/global_product/get_size_chart_detail";
        //请求类型 get
        Integer mediaType = 1;
        //加密等级 商户
        Integer secretType = 3;

        ShopeeRequest shopeeRequest = new ShopeeRequest();
        shopeeRequest.setApiName(apiMethod);
        shopeeRequest.setMediaType(mediaType);
        shopeeRequest.setSecretType(secretType);
        //业务参数
        shopeeRequest.setMapParams(businessDto);

        ShopeeResponse shopeeResponse = shopeeClient.execute(shopeeRequest, publicDto);
        return shopeeResponse.getGopResponseBody();

    }

    @Override
    public String getGlobalItemLimit(ShopeeAppClientDTO acDTO, Map<String, Object> paramsMap) throws Exception {
        String apiMethod =  "/api/v2/global_product/get_global_item_limit";
        Integer mediaType = 1;
        //店铺
        Integer secretType = 3;
        ShopeeRequest shopeeRequest = new ShopeeRequest();
        shopeeRequest.setApiName(apiMethod);
        shopeeRequest.setMediaType(mediaType);
        shopeeRequest.setSecretType(secretType);
        //业务参数
        shopeeRequest.setMapParams(paramsMap);
        ShopeeResponse shopeeResponse = shopeeClient.execute(shopeeRequest, acDTO);
        return shopeeResponse.getGopResponseBody();
    }

    @Override
    public String getPublishableShop(ShopeeAppClientDTO acDTO, Map<String, Object> paramsMap) throws Exception {
        String apiMethod = "/api/v2/global_product/get_publishable_shop";
        Integer mediaType = 1;
        //店铺
        Integer secretType = 3;
        ShopeeRequest shopeeRequest = new ShopeeRequest();
        shopeeRequest.setApiName(apiMethod);
        shopeeRequest.setMediaType(mediaType);
        shopeeRequest.setSecretType(secretType);
        //业务参数
        shopeeRequest.setMapParams(paramsMap);
        ShopeeResponse shopeeResponse = shopeeClient.execute(shopeeRequest, acDTO);
        return shopeeResponse.getGopResponseBody();
    }

    @Override
    public String createPublishTask(ShopeeAppClientDTO acDTO, JSONObject paramsJson) throws Exception {
        String apiMethod ="/api/v2/global_product/create_publish_task";
        Integer mediaType = 2;
        //店铺
        Integer secretType = 3;
        ShopeeRequest shopeeRequest = new ShopeeRequest();
        shopeeRequest.setApiName(apiMethod);
        shopeeRequest.setMediaType(mediaType);
        shopeeRequest.setSecretType(secretType);
        //业务参数
        shopeeRequest.setJsonParams(paramsJson);
        ShopeeResponse shopeeResponse = shopeeClient.execute(shopeeRequest, acDTO);
        return shopeeResponse.getGopResponseBody();
    }

    @Override
    public String getPublishTaskResult(ShopeeAppClientDTO acDTO, Map<String, Object> businessDto) throws Exception {
        String apiMethod = "/api/v2/global_product/get_publish_task_result";
        //get->json
        Integer mediaType = 1;
        //店铺
        Integer secretType = 3;

        ShopeeRequest shopeeRequest = new ShopeeRequest();
        shopeeRequest.setApiName(apiMethod);
        shopeeRequest.setMediaType(mediaType);
        shopeeRequest.setSecretType(secretType);
        //商品实体
        shopeeRequest.setMapParams(businessDto);
        ShopeeResponse shopeeResponse = shopeeClient.execute(shopeeRequest, acDTO);
        return shopeeResponse.getGopResponseBody();
    }

    @Override
    public String getPublishedList(ShopeeAppClientDTO acDTO, Map<String, Object> businessDto) throws Exception {
        String apiMethod = "/api/v2/global_product/get_published_list";
        //get->json
        Integer mediaType = 1;
        //店铺
        Integer secretType = 3;

        ShopeeRequest shopeeRequest = new ShopeeRequest();
        shopeeRequest.setApiName(apiMethod);
        shopeeRequest.setMediaType(mediaType);
        shopeeRequest.setSecretType(secretType);
        //商品实体
        shopeeRequest.setMapParams(businessDto);
        ShopeeResponse shopeeResponse = shopeeClient.execute(shopeeRequest, acDTO);
        return shopeeResponse.getGopResponseBody();
    }


    @Override
    public String deleteGlobalProduct(ShopeeAppClientDTO acDTO, Long globalItemId) throws Exception {
        String apiMethod = "/api/v2/global_product/create_publish_task";
        Integer mediaType = 2;
        //店铺
        Integer secretType = 3;
        ShopeeRequest shopeeRequest = new ShopeeRequest();
        shopeeRequest.setApiName(apiMethod);
        shopeeRequest.setMediaType(mediaType);
        shopeeRequest.setSecretType(secretType);
        JSONObject paramsJson = new JSONObject();
        paramsJson.put("global_item_id", globalItemId);
        //业务参数
        shopeeRequest.setJsonParams(paramsJson);
        ShopeeResponse shopeeResponse = shopeeClient.execute(shopeeRequest, acDTO);
        return shopeeResponse.getGopResponseBody();
    }

    @Override
    public String getMerchantWarehouseLocationList(ShopeeAppClientDTO acDTO) throws Exception {
        String apiMethod = "/api/v2/merchant/get_merchant_warehouse_location_list";
        //get->json
        Integer mediaType = 1;
        //店铺
        Integer secretType = 3;

        ShopeeRequest shopeeRequest = new ShopeeRequest();
        shopeeRequest.setApiName(apiMethod);
        shopeeRequest.setMediaType(mediaType);
        shopeeRequest.setSecretType(secretType);
        //商品实体
        shopeeRequest.setMapParams(new HashMap<>());
        ShopeeResponse shopeeResponse = shopeeClient.execute(shopeeRequest, acDTO);
        return shopeeResponse.getGopResponseBody();
    }

    @Override
    public String getGlobalCategoryList(ShopeeAppClientDTO acDTO, Map<String, Object> businessDto) throws Exception {
        String apiMethod = "/api/v2/global_product/get_category";
        //get->json
        Integer mediaType = 1;
        //商户
        Integer secretType = 3;

        ShopeeRequest shopeeRequest = new ShopeeRequest();
        shopeeRequest.setApiName(apiMethod);
        shopeeRequest.setMediaType(mediaType);
        shopeeRequest.setSecretType(secretType);
        //商品实体
        shopeeRequest.setMapParams(businessDto);
        ShopeeResponse shopeeResponse = shopeeClient.execute(shopeeRequest, acDTO);
        return shopeeResponse.getGopResponseBody();
    }
}
