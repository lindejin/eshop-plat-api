package com.eshop.api.modules.util.shop.app;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.eshop.modal.entry.api.marketplace.auth.vo.PlatformMerchantTokenVO;
import com.eshop.modal.entry.api.marketplace.auth.vo.PlatformTokenVO;
import com.eshop.util.platform.api.structure.shopee.dto.ShopeeAppClientDTO;
import com.eshop.util.platform.utils.merchant.ShopMerchantCacheUtils;
import com.eshop.util.platform.utils.shop.ShopCacheUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author ldj
 * @date 2024/3/15 14:10
 * @Description: ...
 * @Version 1.0
 */
@Slf4j
@Component
public class ShopeeAppClientUtils {

    @Resource
    private ShopCacheUtils shopCacheUtils;

    @Resource
    private ShopMerchantCacheUtils shopMerchantCacheUtils;

    /**
     * 获取shopee app client dto
     * @param shopId
     * @param paramStaticJson
     * @return
     */
    public ShopeeAppClientDTO getShopeeAppClientDTO(Long shopId,String platformShopId , String paramStaticJson) {
        JSONObject paramJson = JSON.parseObject(paramStaticJson);
        ShopeeAppClientDTO scDTO = new ShopeeAppClientDTO();
        scDTO.setPartnerId(paramJson.getString("partner_id"));
        scDTO.setPartnerKey(paramJson.getString("key"));
        scDTO.setPlatformShopId(platformShopId);
        PlatformTokenVO platformTokenVO = shopCacheUtils.getPlatformTokenVO(shopId);
        scDTO.setAccessToken(platformTokenVO.getAccessToken());
        scDTO.setRefreshToken(platformTokenVO.getRefreshToken());
        return scDTO;
    }


    /**
     * 获取shopee app client dto
     * @param shopMerchantId
     * @param paramStaticJson
     * @return
     */
    public ShopeeAppClientDTO getShopeeAppClientDTO2(Long shopMerchantId,String platformShopId , String paramStaticJson) {
        JSONObject paramJson = JSON.parseObject(paramStaticJson);
        ShopeeAppClientDTO scDTO = new ShopeeAppClientDTO();
        scDTO.setPartnerId(paramJson.getString("partner_id"));
        scDTO.setPartnerKey(paramJson.getString("key"));
        scDTO.setPlatformShopId(platformShopId);
        PlatformMerchantTokenVO platformTokenVO = shopMerchantCacheUtils.getPlatformTokenVO(shopMerchantId);
        scDTO.setAccessToken(platformTokenVO.getAccessToken());
        scDTO.setRefreshToken(platformTokenVO.getRefreshToken());
        return scDTO;
    }
}
