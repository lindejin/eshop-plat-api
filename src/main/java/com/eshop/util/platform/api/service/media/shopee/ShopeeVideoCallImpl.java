package com.eshop.util.platform.api.service.media.shopee;

import com.alibaba.fastjson.JSONObject;
import com.eshop.util.platform.api.client.shopee.ShopeeClient;
import com.eshop.util.platform.api.client.shopee.ShopeeRequest;
import com.eshop.util.platform.api.client.shopee.ShopeeResponse;
import com.eshop.util.platform.api.structure.shopee.dto.ShopeeAppClientDTO;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author ldj
 * @date 2023/3/24 14:56
 * @Description: ...
 * @Version 1.0
 */
@Service
public class ShopeeVideoCallImpl implements ShopeeVideoCall {

    @Resource
    private ShopeeClient shopeeClient;

    @Override
    public String initVideoUpload(ShopeeAppClientDTO publicDto, JSONObject businessDto) throws Exception {
        String apiMethod = "/api/v2/media_space/init_video_upload";

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
    public String uploadVideoPart(ShopeeAppClientDTO publicDto, MultiValueMap<String, Object> businessDto) throws Exception {
        String apiMethod = "/api/v2/media_space/upload_video_part";
        //post->file
        Integer mediaType = 3;
        //店铺
        Integer secretType = 2;

        ShopeeRequest shopeeRequest = new ShopeeRequest();
        shopeeRequest.setApiName(apiMethod);
        shopeeRequest.setMediaType(mediaType);
        shopeeRequest.setSecretType(secretType);

        shopeeRequest.setMuMapParams(businessDto);

        ShopeeResponse shopeeResponse = shopeeClient.execute(shopeeRequest, publicDto);
        return shopeeResponse.getGopResponseBody();
    }

    @Override
    public String completeVideoUpload(ShopeeAppClientDTO publicDto, JSONObject businessDto) throws Exception {
        String apiMethod = "/api/v2/media_space/complete_video_upload";
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
    public String getVideoUploadResult(ShopeeAppClientDTO publicDto, Map<String, Object> businessDto) throws Exception {
        String apiMethod = "/api/v2/media_space/get_video_upload_result";
        //get
        Integer mediaType = 1;
        //店铺
        Integer secretType = 2;

        ShopeeRequest shopeeRequest = new ShopeeRequest();
        shopeeRequest.setApiName(apiMethod);
        shopeeRequest.setMediaType(mediaType);
        shopeeRequest.setSecretType(secretType);

        shopeeRequest.setMapParams(businessDto);

        ShopeeResponse shopeeResponse = shopeeClient.execute(shopeeRequest, publicDto);
        return shopeeResponse.getGopResponseBody();
    }
}
