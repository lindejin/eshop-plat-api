package com.eshop.util.platform.api.service.auth.temu;


import com.eshop.util.platform.api.service.auth.temu.dto.TemuTokenCreateDTO;
import com.eshop.util.platform.api.service.auth.temu.vo.TemuTokenCreateVO;
import com.eshop.util.platform.api.structure.temu.dto.TemuAppClientDTO;

public interface TemuAuthCallService {

    //生成调用api的codeUrl
    //   String codeUrlCreate(ShopeeAppClientDTO scDTO, ShopeeCodeUrlCreateDTO reqDTO) throws Exception;

    //生成调用api的access_token
    TemuTokenCreateVO tokenCreate(TemuAppClientDTO scDTO, TemuTokenCreateDTO reqDTO) throws Exception;

    //刷新access_token
    // String tokenRefresh(ShopeeAppClientDTO scDTO, ShopeeTokenRefreshDTO reqDTO) throws Exception;

}
