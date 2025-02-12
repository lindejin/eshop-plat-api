package com.eshop.api.modules.util.shop.app;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.eshop.modal.entry.api.marketplace.auth.vo.PlatformTokenVO;
import com.eshop.util.platform.api.structure.dhgate.dto.DhAppClientDTO;
import com.eshop.util.platform.utils.shop.ShopCacheUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author ldj
 * @date 2024/3/15 14:09
 * @Description: ...
 * @Version 1.0
 */
@Slf4j
@Component
public class DhAppClientUtils {

    @Resource
    private ShopCacheUtils shopCacheUtils;

    /**
     * 获取dhgate app client dto
     * @param shopId
     * @param paramStaticJson
     * @return
     */
    public DhAppClientDTO getDhAppClientDTO(Long shopId, String paramStaticJson) {
        JSONObject paramJson = JSON.parseObject(paramStaticJson);
        DhAppClientDTO dcDTO = new DhAppClientDTO();
        dcDTO.setAppKey(paramJson.getString("appKey"));
        dcDTO.setAppSecret(paramJson.getString("appSecret"));

        PlatformTokenVO platformTokenVO = shopCacheUtils.getPlatformTokenVO(shopId);
        dcDTO.setAccessToken(platformTokenVO.getAccessToken());
        dcDTO.setRefreshToken(platformTokenVO.getRefreshToken());
        return dcDTO;
    }
}
