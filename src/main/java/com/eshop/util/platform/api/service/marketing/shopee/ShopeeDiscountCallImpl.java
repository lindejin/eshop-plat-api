package com.eshop.util.platform.api.service.marketing.shopee;

import com.alibaba.fastjson.JSONObject;
import com.eshop.util.platform.api.client.shopee.ShopeeClient;
import com.eshop.util.platform.api.client.shopee.ShopeeRequest;
import com.eshop.util.platform.api.client.shopee.ShopeeResponse;
import com.eshop.util.platform.api.structure.shopee.dto.ShopeeAppClientDTO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author ldj
 * @date 2023/3/23 10:31
 * @Description: ...
 * @Version 1.0
 */
@Service
public class ShopeeDiscountCallImpl implements ShopeeDiscountCall {

    @Resource
    private ShopeeClient shopeeClient;

    @Override
    public String createDiscount(ShopeeAppClientDTO publicDto, JSONObject businessDto) throws Exception {
        String apiMethod = "/api/v2/discount/add_discount";
        //post->json
        Integer mediaType = 2;
        //店铺
        Integer secretType = 2;

        ShopeeRequest shopeeRequest = new ShopeeRequest();
        shopeeRequest.setApiName(apiMethod);
        shopeeRequest.setMediaType(mediaType);
        shopeeRequest.setSecretType(secretType);
        //业务数据
        shopeeRequest.setJsonParams(businessDto);

        ShopeeResponse shopeeResponse = shopeeClient.execute(shopeeRequest, publicDto);
        return shopeeResponse.getGopResponseBody();

    }

    @Override
    public String createDiscountItem(ShopeeAppClientDTO publicDto, JSONObject businessDto) throws Exception {
        String apiMethod = "/api/v2/discount/add_discount_item";
        //post->json
        Integer mediaType = 2;
        //店铺
        Integer secretType = 2;

        ShopeeRequest shopeeRequest = new ShopeeRequest();
        shopeeRequest.setApiName(apiMethod);
        shopeeRequest.setMediaType(mediaType);
        shopeeRequest.setSecretType(secretType);
        //业务数据
        shopeeRequest.setJsonParams(businessDto);

        ShopeeResponse shopeeResponse = shopeeClient.execute(shopeeRequest, publicDto);
        return shopeeResponse.getGopResponseBody();
    }

    @Override
    public String removeDiscount(ShopeeAppClientDTO publicDto, JSONObject businessDto) throws Exception {
        String apiMethod = "/api/v2/discount/delete_discount";
        //post->json
        Integer mediaType = 2;
        //店铺
        Integer secretType = 2;

        ShopeeRequest shopeeRequest = new ShopeeRequest();
        shopeeRequest.setApiName(apiMethod);
        shopeeRequest.setMediaType(mediaType);
        shopeeRequest.setSecretType(secretType);
        //业务数据
        shopeeRequest.setJsonParams(businessDto);

        ShopeeResponse shopeeResponse = shopeeClient.execute(shopeeRequest, publicDto);
        return shopeeResponse.getGopResponseBody();
    }

    @Override
    public String removeDiscountItem(ShopeeAppClientDTO publicDto, JSONObject businessDto) throws Exception {
        String apiMethod = "/api/v2/discount/delete_discount_item";
        //post->json
        Integer mediaType = 2;
        //店铺
        Integer secretType = 2;

        ShopeeRequest shopeeRequest = new ShopeeRequest();
        shopeeRequest.setApiName(apiMethod);
        shopeeRequest.setMediaType(mediaType);
        shopeeRequest.setSecretType(secretType);
        //业务数据
        shopeeRequest.setJsonParams(businessDto);

        ShopeeResponse shopeeResponse = shopeeClient.execute(shopeeRequest, publicDto);
        return shopeeResponse.getGopResponseBody();
    }
}
