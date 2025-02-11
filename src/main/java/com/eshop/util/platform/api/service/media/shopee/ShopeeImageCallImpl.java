package com.eshop.util.platform.api.service.media.shopee;

import com.eshop.util.platform.api.client.shopee.ShopeeClient;
import com.eshop.util.platform.api.client.shopee.ShopeeRequest;
import com.eshop.util.platform.api.client.shopee.ShopeeResponse;
import com.eshop.util.platform.api.structure.shopee.dto.ShopeeAppClientDTO;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

import javax.annotation.Resource;

/**
 * @author ldj
 * @date 2023/3/24 14:56
 * @Description: ...
 * @Version 1.0
 */
@Service
public class ShopeeImageCallImpl implements ShopeeImageCall {

    @Resource
    private ShopeeClient shopeeClient;

    @Override
    public String uploadImage(ShopeeAppClientDTO publicDto, MultiValueMap<String, Object> businessDto) throws Exception {
        String apiMethod = "/api/v2/media_space/upload_image";
        //post->file
        Integer mediaType = 3;
        //公共级别加密
        Integer secretType = 1;

        ShopeeRequest shopeeRequest = new ShopeeRequest();
        shopeeRequest.setApiName(apiMethod);
        shopeeRequest.setMediaType(mediaType);
        shopeeRequest.setSecretType(secretType);
        //业务参数
        shopeeRequest.setMuMapParams(businessDto);

        ShopeeResponse shopeeResponse = shopeeClient.execute(shopeeRequest, publicDto);
        return shopeeResponse.getGopResponseBody();
    }
}
