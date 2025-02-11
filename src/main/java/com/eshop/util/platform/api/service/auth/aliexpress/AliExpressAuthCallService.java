package com.eshop.util.platform.api.service.auth.aliexpress;

import com.eshop.util.platform.api.service.auth.aliexpress.dto.AeCodeUrlCreateDTO;
import com.eshop.util.platform.api.service.auth.aliexpress.dto.AeTokenCreateDTO;
import com.eshop.util.platform.api.service.auth.aliexpress.dto.AeTokenRefreshDTO;
import com.eshop.util.platform.api.structure.aliexpress.dto.AeAppClientDTO;

/**
 * @author ldj
 * @date 2024/2/26 16:49
 * @Description: ...
 * @Version 1.0
 */
public interface AliExpressAuthCallService {

    //生成调用api的codeUrl
    String codeUrlCreate(AeAppClientDTO acDTO, AeCodeUrlCreateDTO reqDto) throws Exception;

    //生成调用api的access_token
    String tokenCreate(AeAppClientDTO acDTO, AeTokenCreateDTO reqDto) throws Exception;

    //刷新access_token
    String tokenRefresh(AeAppClientDTO acDTO, AeTokenRefreshDTO reqDTO) throws Exception;
}
