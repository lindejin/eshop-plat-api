package com.eshop.util.platform.api.service.user.merchant.shopee;

import com.eshop.util.platform.api.client.shopee.ShopeeClient;
import com.eshop.util.platform.api.client.shopee.ShopeeRequest;
import com.eshop.util.platform.api.client.shopee.ShopeeResponse;
import com.eshop.util.platform.api.structure.shopee.dto.ShopeeAppClientDTO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author ldj
 * @date 2024/1/24 14:45
 * @Description: ...
 * @Version 1.0
 */
@Service
public class ShopeeMerchantCallImpl implements ShopeeMerchantCall {

    @Resource
    private ShopeeClient shopeeClient;

    @Override
    public String getShopListByMerchant(ShopeeAppClientDTO publicDto, Map<String, Object> businessDto) throws Exception {
        String apiMethod = "/api/v2/merchant/get_shop_list_by_merchant";
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
}
