package com.eshop.util.shop.app;

import com.alibaba.fastjson.JSONObject;
import com.eshop.util.platform.api.structure.temu.dto.TemuAppClientDTO;
import com.eshop.util.shop.vo.PlatformTokenVO;
import com.eshop.util.shop.cache.TemuShopCacheUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class TemuAppClientUtils {

    @Autowired
    private TemuShopCacheUtils temuShopCacheUtils;

    /**
     * 获取 temu app client dto
     */
    public TemuAppClientDTO getTemuAppClientDTO(Long shopId, String platformCode, String shopLocation, String paramStaticJson) {
        JSONObject shopLocationJson = getParamStaticJson(shopLocation, paramStaticJson);
        TemuAppClientDTO scDTO = new TemuAppClientDTO();
        scDTO.setAppKey(shopLocationJson.getString("appKey"));
        scDTO.setAppSecret(shopLocationJson.getString("appSecret"));
        PlatformTokenVO platformTokenVO = temuShopCacheUtils.getPlatformTokenVO(shopId, shopLocation);
        scDTO.setAccessToken(platformTokenVO.getAccessToken());
        scDTO.setLocation(shopLocation);
        return scDTO;
    }

    private JSONObject getParamStaticJson(String shopLocation, String paramStaticJson) {
        try {
            if (StringUtils.isBlank(paramStaticJson)) {
                throw new RuntimeException("平台paramStaticJson异常!!!");
            }
            JSONObject jsonObject = JSONObject.parseObject(paramStaticJson);
            JSONObject shopLocationJson = jsonObject.getJSONObject(shopLocation);

            if (shopLocationJson == null) {
                throw new RuntimeException("shopLocationJson异常!shopLocation:" + shopLocation);
            }
            return shopLocationJson;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
