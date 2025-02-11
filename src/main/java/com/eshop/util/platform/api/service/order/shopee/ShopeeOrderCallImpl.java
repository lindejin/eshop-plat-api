package com.eshop.util.platform.api.service.order.shopee;

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
 * @date 2023/6/26 16:46
 * @Description: ...
 * @Version 1.0
 */
@Service
public class ShopeeOrderCallImpl implements ShopeeOrderCall {

    @Resource
    private ShopeeClient shopeeClient;

    @Override
    public String getOrderList(ShopeeAppClientDTO publicDto, Map<String, Object> businessDto) throws Exception {
        String apiMethod = "/api/v2/order/get_order_list";
        //get->
        Integer mediaType = 1;
        //店铺级别加密
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
    public String getOrderDetail(ShopeeAppClientDTO publicDto, Map<String, Object> businessDto) throws Exception {
        String apiMethod = "/api/v2/order/get_order_detail";
        //get->
        Integer mediaType = 1;
        //店铺级别加密
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
    public String cancelOrder(ShopeeAppClientDTO publicDto, JSONObject businessDto) throws Exception {
        String apiMethod = "/api/v2/order/cancel_order";
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
    public String handleBuyerCancellation(ShopeeAppClientDTO publicDto, JSONObject businessDto) throws Exception {
        String apiMethod = "/api/v2/order/handle_buyer_cancellation";
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
}
