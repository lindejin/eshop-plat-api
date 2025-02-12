package com.eshop.api.modules.util.shop.app;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.eshop.modal.entry.api.marketplace.auth.vo.PlatformTokenVO;
import com.eshop.util.platform.api.structure.aliexpress.dto.AeAppClientDTO;
import com.eshop.util.platform.utils.shop.ShopCacheUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author ldj
 * @date 2024/3/15 14:11
 * @Description: ...
 * @Version 1.0
 */
@Slf4j
@Component
public class AeAppClientUtils {

    @Resource
    private ShopCacheUtils shopCacheUtils;

    /**
     * 获取aliexpress app client dto
     * @param shopId
     * @param paramStaticJson
     * @return
     */
    public AeAppClientDTO getAeAppClientDTO(Long shopId, String paramStaticJson) {
        JSONObject paramJson = JSON.parseObject(paramStaticJson);
        AeAppClientDTO acDTO = new AeAppClientDTO();
        acDTO.setAppKey(paramJson.getString("appKey"));
        acDTO.setAppSecret(paramJson.getString("appSecret"));

        PlatformTokenVO platformTokenVO = shopCacheUtils.getPlatformTokenVO(shopId);
        acDTO.setAccessToken(platformTokenVO.getAccessToken());
        acDTO.setRefreshToken(platformTokenVO.getRefreshToken());
        return acDTO;
    }
}
