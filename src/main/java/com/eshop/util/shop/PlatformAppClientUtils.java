//package com.eshop.util.shop;
//
//import com.eshop.entity.config.TbShop;
//import com.eshop.entity.config.TbShopMainAccount;
//import com.eshop.entity.config.TbShopMerchant;
//import com.eshop.service.config.ITbShopMainAccountService;
//import com.eshop.service.config.ITbShopMerchantService;
//import com.eshop.util.platform.api.structure.aliexpress.dto.AeAppClientDTO;
//import com.eshop.util.platform.api.structure.dhgate.dto.DhAppClientDTO;
//import com.eshop.util.platform.api.structure.shopee.dto.ShopeeAppClientDTO;
//import com.eshop.util.platform.api.structure.temu.dto.TemuAppClientDTO;
//import com.eshop.util.platform.api.structure.tiktok.dto.TikTokAppClientDTO;
//import com.eshop.util.shop.app.*;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.Resource;
//
///**
// * @author ldj
// * @date 2024/3/15 13:56
// * @Description: ...
// * @Version 1.0
// */
//@Slf4j
//@Component
//public class PlatformAppClientUtils {
//
//    @Resource
//    private DhAppClientUtils dhAppClientUtils;
//
//    @Resource
//    private ShopeeAppClientUtils shopeeAppClientUtils;
//
//    @Resource
//    private AeAppClientUtils aeAppClientUtils;
//
//    @Resource
//    private TikTokAppClientUtils tikTokAppClientUtils;
//
//    @Resource
//    private PlatformAppUtil platformAppUtil;
//
//    @Resource
//    private ITbShopMainAccountService shopMainAccountService;
//
//    @Resource
//    private ITbShopMerchantService shopMerchantService;
//
//    @Resource
//    private TemuAppClientUtils temuAppClientUtils;
//
//    /**
//     * 获取dhgate app client dto
//     *
//     * @param shopDO
//     * @return
//     */
//    public DhAppClientDTO getDhAppClientDTO(TbShop shopDO) {
//        Long shopId = shopDO.getId();
//        String paramStaticJson = platformAppUtil.getAppParamJson(shopDO.getAppId());
//        return dhAppClientUtils.getDhAppClientDTO(shopId, paramStaticJson);
//    }
//
//    /**
//     * 获取dhgate app client dto
//     *
//     * @param shopId
//     * @param paramStaticJson
//     * @return
//     */
//    public DhAppClientDTO getDhAppClientDTO(Long shopId, String paramStaticJson) {
//        return dhAppClientUtils.getDhAppClientDTO(shopId, paramStaticJson);
//    }
//
//    /**
//     * 获取shopee app client dto
//     *
//     * @param shopDO
//     * @return
//     */
//    public ShopeeAppClientDTO getShopeeAppClientDTO(TbShop shopDO) {
//        Long shopId = shopDO.getId();
//        String platformShopId = shopDO.getPlatformShopId();
//        String paramStaticJson = platformAppUtil.getAppParamJson(shopDO.getAppId());
//        return shopeeAppClientUtils.getShopeeAppClientDTO(shopId, platformShopId, paramStaticJson);
//    }
//
//    /**
//     * 获取shopee app client dto
//     */
//    public ShopeeAppClientDTO getShopeeAppClientDTO(TbShopMerchant shopMerchantDO) {
//        Long shopMerchantId = shopMerchantDO.getId();
//        String platformShopId = shopMerchantDO.getPlatformShopMerchantId();
//        String paramStaticJson = getAppParamJson(shopMerchantDO.getId());
//        return shopeeAppClientUtils.getShopeeAppClientDTO2(shopMerchantId, platformShopId, paramStaticJson);
//    }
//
//    public String getAppParamJson(Long shopMerchantId) {
//        try {
//            TbShopMerchant tbShopMerchant = shopMerchantService.getById(shopMerchantId);
//            TbShopMainAccount tbShopMainAccount = shopMainAccountService.getById( tbShopMerchant.getMainAccountId());
//            return platformAppUtil.getAppParamJson(tbShopMainAccount.getAppId());
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//
//    }
//
//    /**
//     * 获取shopee app client dto
//     *
//     * @return
//     */
//    public ShopeeAppClientDTO getShopeeAppClientDTO(Long shopId, String platformShopId, String paramStaticJson) {
//        return shopeeAppClientUtils.getShopeeAppClientDTO(shopId, platformShopId, paramStaticJson);
//    }
//
//    /**
//     * 获取aliexpress app client dto
//     *
//     * @param shopDO
//     * @return
//     */
//    public AeAppClientDTO getAeAppClientDTO(TbShop shopDO) {
//        Long shopId = shopDO.getId();
//        String paramStaticJson = platformAppUtil.getAppParamJson(shopDO.getAppId());
//
//        return aeAppClientUtils.getAeAppClientDTO(shopId, paramStaticJson);
//    }
//
//    /**
//     * 获取aliexpress app client dto
//     *
//     * @param shopId
//     * @param paramStaticJson
//     * @return
//     */
//    public AeAppClientDTO getAeAppClientDTO(Long shopId, String paramStaticJson) {
//        return aeAppClientUtils.getAeAppClientDTO(shopId, paramStaticJson);
//    }
//
//    /**
//     * 获取tiktok app client dto
//     *
//     * @param shopDO
//     * @return
//     */
//    public TikTokAppClientDTO getTikTokAppClientDTO(TbShop shopDO) {
//        Long shopId = shopDO.getId();
//        String paramStaticJson = platformAppUtil.getAppParamJson(shopDO.getAppId());
//
//        return tikTokAppClientUtils.getTikTokAppClientDTO(shopId, paramStaticJson);
//    }
//
//    /**
//     * 获取tiktok app client dto
//     *
//     * @param shopId
//     * @param paramStaticJson
//     * @return
//     */
//    public TikTokAppClientDTO getTikTokAppClientDTO(Long shopId, String paramStaticJson) {
//        return tikTokAppClientUtils.getTikTokAppClientDTO(shopId, paramStaticJson);
//    }
//
//    /**
//     * 获取 temu app client dto
//     */
//    public TemuAppClientDTO getTemuAppClientDTO(TbShop shopDO, String shopLocation) {
//        Long shopId = shopDO.getId();
//        String platformCode = shopDO.getPlatformCode();
//        String paramStaticJson = platformAppUtil.getAppParamJson(shopDO.getAppId());
//        return temuAppClientUtils.getTemuAppClientDTO(shopId, platformCode,shopLocation,paramStaticJson);
//    }
//
//    /**
//     * 获取 temu app client dto
//     */
//    public TemuAppClientDTO getTemuAppClientDTO(Long shopId, String platformCode, String shopLocation,String paramStaticJson) {
//        return temuAppClientUtils.getTemuAppClientDTO(shopId, platformCode,shopLocation,paramStaticJson);
//    }
//
//
//}
