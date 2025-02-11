package com.eshop.util.platform.api.service.logistics.shopee;

import com.alibaba.fastjson.JSONObject;
import com.eshop.util.platform.api.client.shopee.ShopeeClient;
import com.eshop.util.platform.api.client.shopee.ShopeeRequest;
import com.eshop.util.platform.api.client.shopee.ShopeeResponse;
import com.eshop.util.platform.api.structure.shopee.dto.ShopeeAppClientDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author ldj
 * @date 2023/10/18 9:59
 * @Description: ...
 * @Version 1.0
 */
@Service
public class ShopeeLogisticsCallImpl implements ShopeeLogisticsCall {

    @Resource
    private ShopeeClient shopeeClient;

    @Override
    public String getShippingParameter(ShopeeAppClientDTO publicDto, Map<String, Object> businessDto) throws Exception {

        String apiMethod = "/api/v2/logistics/get_shipping_parameter";
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

    @Override
    public String getShippingDocumentParameter(ShopeeAppClientDTO publicDto, JSONObject businessDto) throws Exception {
        String apiMethod = "/api/v2/logistics/get_shipping_document_parameter";
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
    public String shipOrder(ShopeeAppClientDTO publicDto, JSONObject businessDto) throws Exception {

        String apiMethod = "/api/v2/logistics/ship_order";
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
    public String getTrackingNumber(ShopeeAppClientDTO publicDto, Map<String, Object> businessDto) throws Exception {

        String apiMethod = "/api/v2/logistics/get_tracking_number";
        //1.get
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

    @Override
    public String createShippingDocument(ShopeeAppClientDTO publicDto, JSONObject businessDto) throws Exception {

        String apiMethod = "/api/v2/logistics/create_shipping_document";
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
    public String getShippingDocumentResult(ShopeeAppClientDTO publicDto, JSONObject businessDto) throws Exception {
        String apiMethod = "/api/v2/logistics/get_shipping_document_result";
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
    public ResponseEntity<byte[]> downloadShippingDocument(ShopeeAppClientDTO publicDto, JSONObject businessDto) {
        String apiMethod = "/api/v2/logistics/download_shipping_document";
        //post->json
        Integer mediaType = 2;
        //店铺
        Integer secretType = 2;

        ShopeeRequest shopeeRequest = new ShopeeRequest();
        shopeeRequest.setApiName(apiMethod);
        shopeeRequest.setMediaType(mediaType);
        shopeeRequest.setSecretType(secretType);

        shopeeRequest.setJsonParams(businessDto);

        return shopeeClient.downloadFile(shopeeRequest, publicDto);

    }

    @Override
    public String getShippingDocumentDataInfo(ShopeeAppClientDTO publicDto, JSONObject businessDto) throws Exception {
        String apiMethod = "/api/v2/logistics/get_shipping_document_data_info";
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
