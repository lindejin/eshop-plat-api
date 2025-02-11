package com.eshop.util.platform.api.service.auth.dhgate;

import com.eshop.util.platform.api.service.auth.dhgate.dto.DhCodeUrlCreateDTO;
import com.eshop.util.platform.api.service.auth.dhgate.dto.DhTokenCreateDTO;
import com.eshop.util.platform.api.service.auth.dhgate.dto.DhTokenRefreshDTO;
import com.eshop.util.platform.api.structure.dhgate.dto.DhAppClientDTO;

/**
 * @author ldj
 * @date 2024/3/12 18:13
 * @Description: ...
 * @Version 1.0
 */
public interface DhGateAuthCallService {

    //生成调用api的codeUrl
    String codeUrlCreate(DhAppClientDTO dcDTO, DhCodeUrlCreateDTO reqDTO) throws Exception;

    //生成调用api的access_token
    String tokenCreate(DhAppClientDTO dcDTO, DhTokenCreateDTO reqDTO) throws Exception;

    //刷新access_token
    String tokenRefresh(DhAppClientDTO dcDTO, DhTokenRefreshDTO reqDTO) throws Exception;
}
