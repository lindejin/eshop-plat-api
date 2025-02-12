package com.eshop.api.modules.util.shop.app;

import com.alibaba.fastjson.JSONObject;
import com.eshop.api.modules.util.shop.PlatformAppUtil;
import com.eshop.db.config.service.PlatformService;
import com.eshop.db.config.service.ShopService;
import com.eshop.modal.entry.api.marketplace.auth.vo.PlatformTokenVO;
import com.eshop.modal.entry.temu.TemuCommonParams;
import com.eshop.modal.modal.eshop_config.TbShop;
import com.eshop.util.platform.api.structure.temu.dto.TemuAppClientDTO;
import com.eshop.util.platform.utils.shop.TemuShopCacheUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Objects;

@Slf4j
@Component
public class TemuAppClientUtils {

    @Autowired
    private TemuShopCacheUtils temuShopCacheUtils;

    @Autowired
    private PlatformService platformService;

    @Autowired
    private ShopService shopService;

    @Resource
    private PlatformAppUtil platformAppUtil;

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

    /**
     * 获取CN区的授权应用信息
     *
     * @param shopId
     * @return com.eshop.modal.entry.temu.TemuCommonParams
     * @author sheng
     * @date 2024-11-26 15:48
     */
    public TemuCommonParams getCNParams(Long shopId) {
        TbShop shopDO = null;
        try {
            shopDO = shopService.selectOneByProperty(TbShop::getId, shopId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        String paramStaticJson = platformAppUtil.getAppParamJson(shopDO.getAppId());

        if (Objects.isNull(shopId)) {
            throw new RuntimeException("店铺id不能为空");
        }
        TemuAppClientDTO temuAppClientDTO = getTemuAppClientDTO(shopId, "Temu", "CN", paramStaticJson);
        TemuCommonParams temuCommonParams = new TemuCommonParams();
        temuCommonParams.setAppKey(temuAppClientDTO.getAppKey());
        temuCommonParams.setAppSecret(temuAppClientDTO.getAppSecret());
        temuCommonParams.setDataType("JSON");
        temuCommonParams.setAccessToken(temuAppClientDTO.getAccessToken());
        return temuCommonParams;
    }

    /**
     * 获取授权信息
     *
     * @param shopId       店铺Id
     * @param shopLocation 区域编码
     * @return com.eshop.modal.entry.temu.TemuCommonParams
     * @author sheng
     * @date 2025-01-09 11:07
     */
    public TemuCommonParams getParams(Long shopId, String shopLocation) {
        TbShop shopDO = null;
        try {
            shopDO = shopService.selectOneByProperty(TbShop::getId, shopId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        String paramStaticJson = platformAppUtil.getAppParamJson(shopDO.getAppId());

        if (Objects.isNull(shopId)) {
            throw new RuntimeException("店铺id不能为空");
        }
        TemuAppClientDTO temuAppClientDTO = getTemuAppClientDTO(shopId, "Temu", shopLocation, paramStaticJson);
        TemuCommonParams temuCommonParams = new TemuCommonParams();
        temuCommonParams.setAppKey(temuAppClientDTO.getAppKey());
        temuCommonParams.setAppSecret(temuAppClientDTO.getAppSecret());
        temuCommonParams.setDataType("JSON");
        temuCommonParams.setAccessToken(temuAppClientDTO.getAccessToken());
        return temuCommonParams;
    }
}
