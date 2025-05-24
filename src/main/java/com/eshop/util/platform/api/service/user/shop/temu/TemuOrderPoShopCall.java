package com.eshop.util.platform.api.service.user.shop.temu;

import com.eshop.util.platform.api.service.user.shop.temu.dto.TemuOpenAccessTokenInfoGetReqDTO;
import com.eshop.util.platform.api.service.user.shop.temu.vo.TemuOpenAccessTokenInfoGetRespVO;
import com.eshop.util.platform.api.structure.temu.dto.TemuAppClientDTO;

public interface TemuOrderPoShopCall {

    /**
     * 查询当前token对应授权信息
     * CN/US/EU
     */
    TemuOpenAccessTokenInfoGetRespVO openAccessTokenInfoGet(TemuAppClientDTO publicDto, TemuOpenAccessTokenInfoGetReqDTO reqDTO) throws Exception;
}
