package com.eshop.util.platform.api.service.product.shopee;

import com.alibaba.fastjson.JSONObject;
import com.eshop.util.platform.api.client.shopee.ShopeeClient;
import com.eshop.util.platform.api.client.shopee.ShopeeRequest;
import com.eshop.util.platform.api.client.shopee.ShopeeResponse;
import com.eshop.util.platform.api.structure.shopee.dto.ShopeeAppClientDTO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author ldj
 * @date 2023/3/24 14:01
 * @Description: ...
 * @Version 1.0
 */
@Service
public class ShopeeProductCallImpl implements ShopeeProductCall {

    @Resource
    private ShopeeClient shopeeClient;

    @Override
    public String postProduct(ShopeeAppClientDTO publicDto, JSONObject businessDto) throws Exception {
        String apiMethod = "/api/v2/product/add_item";
        //post->json
        Integer mediaType = 2;
        //店铺
        Integer secretType = 2;

        ShopeeRequest shopeeRequest = new ShopeeRequest();
        shopeeRequest.setApiName(apiMethod);
        shopeeRequest.setMediaType(mediaType);
        shopeeRequest.setSecretType(secretType);
        //业务参数
        shopeeRequest.setJsonParams(businessDto);

        ShopeeResponse shopeeResponse = shopeeClient.execute(shopeeRequest, publicDto);
        return shopeeResponse.getGopResponseBody();
    }

    @Override
    public String updateProduct(ShopeeAppClientDTO publicDto, JSONObject businessDto) throws Exception {
        String apiMethod = "/api/v2/product/update_item";
        //post->json
        Integer mediaType = 2;
        //店铺
        Integer secretType = 2;

        ShopeeRequest shopeeRequest = new ShopeeRequest();
        shopeeRequest.setApiName(apiMethod);
        shopeeRequest.setMediaType(mediaType);
        shopeeRequest.setSecretType(secretType);
        //业务参数
        shopeeRequest.setJsonParams(businessDto);

        ShopeeResponse shopeeResponse = shopeeClient.execute(shopeeRequest, publicDto);
        return shopeeResponse.getGopResponseBody();
    }

    @Override
    public String postProductSku(ShopeeAppClientDTO publicDto, JSONObject businessDto) throws Exception {
        String apiMethod = "/api/v2/product/init_tier_variation";
        //post->json
        Integer mediaType = 2;
        //店铺
        Integer secretType = 2;
        ShopeeRequest shopeeRequest = new ShopeeRequest();
        shopeeRequest.setApiName(apiMethod);
        shopeeRequest.setMediaType(mediaType);
        shopeeRequest.setSecretType(secretType);
        //商品实体
        shopeeRequest.setJsonParams(businessDto);

        ShopeeResponse shopeeResponse = shopeeClient.execute(shopeeRequest, publicDto);
        return shopeeResponse.getGopResponseBody();
    }

    @Override
    public String updateProductSku(ShopeeAppClientDTO publicDto, JSONObject businessDto) throws Exception {
        String apiMethod = "/api/v2/product/update_model";
        //post->json
        Integer mediaType = 2;
        //店铺
        Integer secretType = 2;
        ShopeeRequest shopeeRequest = new ShopeeRequest();
        shopeeRequest.setApiName(apiMethod);
        shopeeRequest.setMediaType(mediaType);
        shopeeRequest.setSecretType(secretType);

        shopeeRequest.setJsonParams(businessDto);

        ShopeeResponse shopeeResponse = shopeeClient.execute(shopeeRequest, publicDto);
        return shopeeResponse.getGopResponseBody();
    }

    @Override
    public String getProductList(ShopeeAppClientDTO publicDto, Map<String, Object> businessDto) throws Exception {
        String apiMethod = "/api/v2/product/get_item_list";
        //get->json
        Integer mediaType = 1;
        //店铺
        Integer secretType = 2;
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
    public String getProductDetail(ShopeeAppClientDTO publicDto, Map<String, Object> businessDto) throws Exception {
        String apiMethod = "/api/v2/product/get_item_base_info";
        //get->json
        Integer mediaType = 1;
        //店铺
        Integer secretType = 2;
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
    public String getProductSkuList(ShopeeAppClientDTO publicDto, Map<String, Object> businessDto) throws Exception {
        String apiMethod = "/api/v2/product/get_model_list";
        //get->json
        Integer mediaType = 1;
        //店铺
        Integer secretType = 2;
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
    public String getProductExtraInfo(ShopeeAppClientDTO publicDto, Map<String, Object> businessDto) throws Exception {
        String apiMethod = "/api/v2/product/get_item_extra_info";
        //get->json
        Integer mediaType = 1;
        //店铺
        Integer secretType = 2;
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
    public String deleteProduct(ShopeeAppClientDTO publicDto, JSONObject businessDto) throws Exception {
        String apiMethod = "/api/v2/product/delete_item";
        //post->json
        Integer mediaType = 2;
        //店铺
        Integer secretType = 2;

        ShopeeRequest shopeeRequest = new ShopeeRequest();
        shopeeRequest.setApiName(apiMethod);
        shopeeRequest.setMediaType(mediaType);
        shopeeRequest.setSecretType(secretType);
        //商品实体
        shopeeRequest.setJsonParams(businessDto);

        ShopeeResponse shopeeResponse = shopeeClient.execute(shopeeRequest, publicDto);
        return shopeeResponse.getGopResponseBody();
    }

    @Override
    public String updateProductSkuPrice(ShopeeAppClientDTO publicDto, JSONObject businessDto) throws Exception {
        String apiMethod = "/api/v2/product/update_price";
        //post->json
        Integer mediaType = 2;
        //店铺
        Integer secretType = 2;

        ShopeeRequest shopeeRequest = new ShopeeRequest();
        shopeeRequest.setApiName(apiMethod);
        shopeeRequest.setMediaType(mediaType);
        shopeeRequest.setSecretType(secretType);

        shopeeRequest.setJsonParams(businessDto);

        ShopeeResponse shopeeResponse = shopeeClient.execute(shopeeRequest, publicDto);
        return shopeeResponse.getGopResponseBody();
    }

    /**
     * 类目属性通过
     */
    @Override
    public String getCategoryAttributes(ShopeeAppClientDTO publicDto, Map<String, Object> businessDto) throws Exception {
        //访问接口
        String apiMethod = "/api/v2/product/get_attributes";
        //请求类型 get
        Integer mediaType = 1;
        //加密等级 店铺
        Integer secretType = 2;

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
    public String getChannelList(ShopeeAppClientDTO publicDto, Map<String, Object> businessDto) throws Exception {
        //访问接口
        String apiMethod = "/api/v2/logistics/get_channel_list";
        //请求类型 get
        Integer mediaType = 1;
        //加密等级 店铺
        Integer secretType = 2;

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
    public String getBrandList(ShopeeAppClientDTO publicDto, Map<String, Object> businessDto) throws Exception {
        //访问接口
        String apiMethod = "/api/v2/product/get_brand_list";
        //请求类型 get
        Integer mediaType = 1;
        //加密等级 店铺
        Integer secretType = 2;

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
    public String getItemLimit(ShopeeAppClientDTO publicDto, Map<String, Object> businessDto) throws Exception {
        //访问接口
        String apiMethod = "/api/v2/product/get_item_limit";
        //请求类型 get
        Integer mediaType = 1;
        //加密等级 店铺
        Integer secretType = 2;

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
    public String getSupportSizeChart(ShopeeAppClientDTO publicDto, Map<String, Object> businessDto) throws Exception {
        //访问接口
        String apiMethod = "/api/v2/product/support_size_chart";
        //请求类型 get
        Integer mediaType = 1;
        //加密等级 店铺
        Integer secretType = 2;

        ShopeeRequest shopeeRequest = new ShopeeRequest();
        shopeeRequest.setApiName(apiMethod);
        shopeeRequest.setMediaType(mediaType);
        shopeeRequest.setSecretType(secretType);
        //业务参数
        shopeeRequest.setMapParams(businessDto);

        ShopeeResponse shopeeResponse = shopeeClient.execute(shopeeRequest, publicDto);
        return shopeeResponse.getGopResponseBody();

    }
    //
    @Override
    public String updateSizeChart(ShopeeAppClientDTO publicDto, JSONObject businessDto) throws Exception {
        String apiMethod = "/api/v2/product/update_size_chart";
        //post->json
        Integer mediaType = 2;
        //店铺
        Integer secretType = 2;

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
        String apiMethod = "/api/v2/product/get_size_chart_list";
        //请求类型 get
        Integer mediaType = 1;
        //加密等级 店铺
        Integer secretType = 2;

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
        String apiMethod = "/api/v2/product/get_size_chart_detail";
        //请求类型 get
        Integer mediaType = 1;
        //加密等级 店铺
        Integer secretType = 2;

        ShopeeRequest shopeeRequest = new ShopeeRequest();
        shopeeRequest.setApiName(apiMethod);
        shopeeRequest.setMediaType(mediaType);
        shopeeRequest.setSecretType(secretType);
        //业务参数
        shopeeRequest.setMapParams(businessDto);

        ShopeeResponse shopeeResponse = shopeeClient.execute(shopeeRequest, publicDto);
        return shopeeResponse.getGopResponseBody();

    }
}
