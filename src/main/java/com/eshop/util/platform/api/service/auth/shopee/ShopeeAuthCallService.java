package com.eshop.util.platform.api.service.auth.shopee;

import com.eshop.util.platform.api.service.auth.shopee.dto.ShopeeCodeUrlCreateDTO;
import com.eshop.util.platform.api.service.auth.shopee.dto.ShopeeTokenCreateDTO;
import com.eshop.util.platform.api.service.auth.shopee.dto.ShopeeTokenRefreshDTO;
import com.eshop.util.platform.api.structure.shopee.dto.ShopeeAppClientDTO;

/**
 * @author ldj
 * @date 2024/2/26 16:50
 * @Description: ...
 * @Version 1.0
 */
public interface ShopeeAuthCallService {


    //生成调用api的codeUrl
    String codeUrlCreate(ShopeeAppClientDTO scDTO, ShopeeCodeUrlCreateDTO reqDTO) throws Exception;

    //生成调用api的access_token
    String tokenCreate(ShopeeAppClientDTO scDTO, ShopeeTokenCreateDTO reqDTO) throws Exception;

    //刷新access_token
    String tokenRefresh(ShopeeAppClientDTO scDTO, ShopeeTokenRefreshDTO reqDTO) throws Exception;
}
