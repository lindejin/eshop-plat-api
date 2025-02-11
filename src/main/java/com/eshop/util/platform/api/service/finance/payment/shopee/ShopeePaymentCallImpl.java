package com.eshop.util.platform.api.service.finance.payment.shopee;

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
 * @date 2024/7/17 9:38
 * @Description: ...
 * @Version 1.0
 */
@Service
public class ShopeePaymentCallImpl implements ShopeePaymentCall {

    @Resource
    private ShopeeClient shopeeClient;

    @Override
    public String getEscrowDetail(ShopeeAppClientDTO publicDto, Map<String, Object> businessDto) throws Exception {
        String apiMethod = "/api/v2/payment/get_escrow_detail";
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
    public String getEscrowDetailBatch(ShopeeAppClientDTO publicDto, JSONObject businessDto) throws Exception {
        String apiMethod = "/api/v2/payment/get_escrow_detail_batch";
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
}
