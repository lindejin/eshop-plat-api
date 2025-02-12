package com.eshop.util.shop.app;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.eshop.util.shop.vo.PlatformTokenVO;
import com.eshop.util.platform.api.structure.tiktok.dto.TikTokAppClientDTO;
import com.eshop.util.shop.cache.ShopCacheUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author ldj
 * @date 2024/3/15 14:12
 * @Description: ...
 * @Version 1.0
 */
@Slf4j
@Component
public class TikTokAppClientUtils {

    @Resource
    private ShopCacheUtils shopCacheUtils;

    /**
     * 获取tiktok app client dto
     * @param shopId
     * @param paramStaticJson
     * @return
     */
    public TikTokAppClientDTO getTikTokAppClientDTO(Long shopId, String paramStaticJson) {
        JSONObject paramJson = JSON.parseObject(paramStaticJson);
        String appKey = paramJson.getString("app_key");
        if (StringUtils.isBlank(appKey)) {
            appKey = paramJson.getString("appKey");
        }
        String appSecret = paramJson.getString("app_secret");
        if (StringUtils.isBlank(appSecret)) {
            appSecret = paramJson.getString("appSecret");
        }
        TikTokAppClientDTO tikDTO = new TikTokAppClientDTO();
        tikDTO.setAppKey(appKey);
        tikDTO.setAppSecret(appSecret);

        PlatformTokenVO platformTokenVO = shopCacheUtils.getPlatformTokenVO(shopId);
        tikDTO.setAccessToken(platformTokenVO.getAccessToken());
        tikDTO.setRefreshToken(platformTokenVO.getRefreshToken());
        return tikDTO;
    }
}
