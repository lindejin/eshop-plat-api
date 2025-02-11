package com.eshop.util.platform.api.service.auth.shopee;

import com.eshop.util.platform.api.client.shopee.ShopeeClient;
import com.eshop.util.platform.api.client.shopee.ShopeeRequest;
import com.eshop.util.platform.api.client.shopee.ShopeeResponse;
import com.eshop.util.platform.api.client.shopee.ShopeeUtils;
import com.eshop.util.platform.api.service.auth.shopee.dto.ShopeeCodeUrlCreateDTO;
import com.eshop.util.platform.api.service.auth.shopee.dto.ShopeeTokenCreateDTO;
import com.eshop.util.platform.api.service.auth.shopee.dto.ShopeeTokenRefreshDTO;
import com.eshop.util.platform.api.structure.shopee.dto.ShopeeAppClientDTO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ldj
 * @date 2023/2/15 11:26
 * @Description: ...
 * @Version 1.0
 */
@Service("ShopeeAuthCallServiceImpl")
public class ShopeeAuthCallServiceImpl implements ShopeeAuthCallService {

    @Resource
    private ShopeeClient shopeeClient;

    @Override
    public String codeUrlCreate(ShopeeAppClientDTO publicDto, ShopeeCodeUrlCreateDTO reqDto) throws Exception {
        //访问地址
        String authorizeUrl = publicDto.getUrl();
        //重定向地址
        String redirect = reqDto.getRedirectUrl();

        Long shopId = reqDto.getShopId();
        Long opId = reqDto.getOpId();
        String partnerId = publicDto.getPartnerId();
        String partnerKey = publicDto.getPartnerKey();

        long timest = System.currentTimeMillis();
        timest = timest / 1000L;
        String path = "/api/v2/shop/auth_partner";
        String redirect_url = redirect + "/" + shopId + "/" + opId + "/";

        String tmp_base_string = partnerId + path + timest;
        String sign = ShopeeUtils.getsShopeeSign(tmp_base_string, partnerKey);

        String urlNet = authorizeUrl + path + "?partner_id=" + partnerId + "&timestamp=" + timest + "&sign=" + sign + "&redirect=" + redirect_url;
        return urlNet;
    }

    @Override
    public String tokenCreate(ShopeeAppClientDTO publicDto, ShopeeTokenCreateDTO reqDto) throws Exception {

        String partnerId = publicDto.getPartnerId();

        String code = reqDto.getCode();
        String mainAccountId = reqDto.getMainAccountId();
        String shopId = reqDto.getShopId();
        Integer shopType = reqDto.getShopType();


        String apiMethod = "/api/v2/auth/token/get";
        //装配访问参数
        Integer mediaType = 4;
        Integer secretType = 1;

        ShopeeRequest shopeeRequest = new ShopeeRequest();
        shopeeRequest.setApiName(apiMethod);
        shopeeRequest.setMediaType(mediaType);
        shopeeRequest.setSecretType(secretType);

        Map<String, Object> params = new HashMap<>();
        params.put("code", code);
        params.put("partner_id", Long.parseLong(partnerId));
        //判断是否是跨境店
        if (shopType != null && shopType == 1) {
            params.put("main_account_id", Long.parseLong(mainAccountId));
        } else {
            params.put("shop_id", Long.parseLong(shopId));
        }

        shopeeRequest.setMapParams(params);

        ShopeeResponse shopeeResponse = shopeeClient.tokenCreateAndRefresh(shopeeRequest, publicDto);
        return shopeeResponse.getGopResponseBody();
    }


    @Override
    public String tokenRefresh(ShopeeAppClientDTO publicDto, ShopeeTokenRefreshDTO reqDto) throws Exception {
        Integer shopType = reqDto.getShopType();
        String partnerId = publicDto.getPartnerId();
        String apiMethod = "/api/v2/auth/access_token/get";
        //装配访问参数
        Integer mediaType = 4;
        Integer secretType = 1;

        //装配访问参数
        ShopeeRequest shopeeRequest = new ShopeeRequest();
        shopeeRequest.setApiName(apiMethod);
        shopeeRequest.setMediaType(mediaType);
        shopeeRequest.setSecretType(secretType);

        Map<String, Object> params = new HashMap<>();
        params.put("refresh_token", reqDto.getRefreshToken());
        params.put("partner_id", Long.parseLong(partnerId));
        //判断是否是虾皮商户
        if (shopType != null && shopType == 4) {
            params.put("merchant_id", Long.parseLong(reqDto.getMerchantId()));
        } else {
            params.put("shop_id", Long.parseLong(reqDto.getShopId()));
        }
        shopeeRequest.setMapParams(params);

        ShopeeResponse shopeeResponse = shopeeClient.tokenCreateAndRefresh(shopeeRequest, publicDto);
        return shopeeResponse.getGopResponseBody();
    }
}
