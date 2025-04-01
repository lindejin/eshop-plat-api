package com.eshop.shop;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.eshop.entity.config.TbPlatformApp;
import com.eshop.entity.config.TbShop;
import com.eshop.service.config.ITbPlatformAppService;
import com.eshop.service.config.ITbShopService;
import com.eshop.util.platform.api.service.auth.shopee.ShopeeAuthCallService;
import com.eshop.util.platform.api.service.auth.shopee.dto.ShopeeTokenRefreshDTO;
import com.eshop.util.platform.api.service.user.shop.shopee.ShopeeShopCall;
import com.eshop.util.platform.api.structure.shopee.dto.ShopeeAppClientDTO;
import com.eshop.util.shop.PlatformAppClientUtils;
import com.eshop.util.shop.cache.ShopCacheUtils;
import com.eshop.util.shop.vo.PlatformTokenVO;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Objects;

@SpringBootTest
public class TestShop {

    @Resource
    private PlatformAppClientUtils platformAppClientUtils;

    @Resource
    private ShopeeShopCall shopeeShopCall;

    @Resource
    private ITbShopService iTbShopService;

    @Resource
    private ITbPlatformAppService iTbPlatformAppService;

    @Resource
    private ShopCacheUtils shopCacheUtils;

    @Resource
    private ShopeeAuthCallService shopeeAuthCallService;

    @Test
    void getAllCategoriesAsyncAndSaveToJsonAppend() throws Exception {
        TbShop shopDO = iTbShopService.getById(2582L);
        ShopeeAppClientDTO clientDTO = platformAppClientUtils.getShopeeAppClientDTO(shopDO);
        String shopInfo = shopeeShopCall.getShopInfo(clientDTO, new HashMap<>());
        System.out.println(shopInfo);


    }

    @Test
    void tokenRefresh() throws Exception {
        TbShop shopDO = iTbShopService.getById(2582L);
        PlatformTokenRefreshDTO pcDTO = buildPlatformTokenRefreshDTO(shopDO.getId());
        PlatformTokenRespVO platformTokenRespVO = tokenRefresh(pcDTO);
        System.out.println(JSON.toJSONString(platformTokenRespVO));
    }

    public PlatformTokenRespVO tokenRefresh(PlatformTokenRefreshDTO pcDTO) throws Exception {
        Integer shopType = pcDTO.getShopType();


        JSONObject paramJson = JSON.parseObject(pcDTO.getParamStaticJson());
        ShopeeAppClientDTO scDTO = new ShopeeAppClientDTO();
        scDTO.setPartnerId(paramJson.getString("partner_id"));
        scDTO.setPartnerKey(paramJson.getString("key"));

        ShopeeTokenRefreshDTO reqDTO = new ShopeeTokenRefreshDTO();
        reqDTO.setRefreshToken(pcDTO.getRefreshToken());
        //判断是否是虾皮商户
        if (shopType != null && shopType == 4) {
            reqDTO.setMerchantId(pcDTO.getPlatMerchantId());
        } else {
            reqDTO.setShopId(pcDTO.getPlatShopId());
        }
        reqDTO.setShopType(pcDTO.getShopType());

        String respBody = shopeeAuthCallService.tokenRefresh(scDTO, reqDTO);


        // 使用Fastjson解析JSON字符串
        JSONObject tokenJson = JSONObject.parseObject(respBody);

        // 添加额外的参数
        assemblyTokenJson(tokenJson);

        // 创建一个新的PlatformShopTokenRespVO对象，并设置其属性
        PlatformTokenRespVO respVO = new PlatformTokenRespVO();
        respVO.setAccessToken(tokenJson.getString("access_token"));
        respVO.setRefreshToken(tokenJson.getString("refresh_token"));
        respVO.setExpireIn(tokenJson.getLong("expire_in"));
        respVO.setExpireTime(tokenJson.getLong("expire_time"));
        respVO.setRefreshIn(tokenJson.getLong("refresh_in"));
        respVO.setRefreshTime(tokenJson.getLong("refresh_time"));
        // 注意：shopId, platformShopId, opId 和 jsonObj 的值需要您自己设置，因为它们在JSON数据中不存在

        respVO.setShopId(pcDTO.getShopId());
        respVO.setShopType(pcDTO.getShopType());
        respVO.setPlatMainAccountId(pcDTO.getPlatMainAccountId());
        respVO.setPlatMerchantId(pcDTO.getPlatMerchantId());
        respVO.setPlatShopId(pcDTO.getPlatShopId());

        respVO.setOpId(pcDTO.getOpId());
        respVO.setRespBody(respBody);
        return respVO;
    }
    /**
     * 构建刷新token参数
     */
    private PlatformTokenRefreshDTO buildPlatformTokenRefreshDTO(Long shopId) throws Exception {
        Long opId = 1L;
        String refreshToken = getRefreshToken(shopId);
        TbShop tbShop = iTbShopService.getById(shopId);
        //String platformCode = tbShop.getPlatformCode();
        ////获取平台秘钥等信息
        TbPlatformApp tbPlatformApp = iTbPlatformAppService.getById(tbShop.getAppId());
        if (Objects.isNull(tbPlatformApp)) {
            throw new RuntimeException("未获取到对应授权信息,店铺Id:" + tbShop.getId());
        }
        String paramStaticJson = tbPlatformApp.getAppParamJson();

        PlatformTokenRefreshDTO refreshDTO = new PlatformTokenRefreshDTO();
        refreshDTO.setRefreshToken(refreshToken);
        refreshDTO.setPlatformCode(tbPlatformApp.getPlatformCode());
        refreshDTO.setShopId(shopId);
        refreshDTO.setShopType(new Integer(tbShop.getShopType()));

        if (tbShop.getShopType() == 1) {
            //授权总店铺
            //虾皮属于跨境
            refreshDTO.setPlatMainAccountId(tbShop.getPlatformShopId());
        } else if (tbShop.getShopType() == 4) {
            //授权总店铺下的子商户
            refreshDTO.setPlatMerchantId(tbShop.getPlatformShopId());
        } else if (tbShop.getShopType() == 3) {
            //授权总店铺下的子店铺
            refreshDTO.setPlatShopId(tbShop.getPlatformShopId());
        } else {
            //其他的统一赋值到平台店铺id
            refreshDTO.setPlatShopId(tbShop.getPlatformShopId());
        }

        refreshDTO.setOpId(opId);
        refreshDTO.setParamStaticJson(paramStaticJson);
        return refreshDTO;
    }

    /**
     * 获取refreshToken
     */
    private String getRefreshToken(Long shopId) {
        PlatformTokenVO platformTokenVO = shopCacheUtils.getPlatformTokenVO(shopId);
        String refreshToken = platformTokenVO.getRefreshToken();
        if (StringUtils.isBlank(refreshToken)) {
            return null;
        }
        return refreshToken;
    }

    /**
     * 一些参数补充
     */
    private void assemblyTokenJson(JSONObject tokenJson) {
        boolean isToken = false;
        //API 调用成功时返回。可以多次使用并在 4 小时后过期的动态令牌。
        if (StringUtils.isNotBlank(tokenJson.getString("access_token"))) {
            isToken = true;


            //API 调用成功时返回。access_token的有效期（以秒为单位）。
            Long expire_in = tokenJson.getLong("expire_in");
            //统一标准 token 截止日期
            //注意：expire_in 的值需要乘以 1000，因为它是以秒为单位的
            Long expire_time = System.currentTimeMillis() + expire_in * 1000;
            tokenJson.put("expire_time", expire_time);

            //refresh_token 对每个shop_id和merchant_id分别有效，有效期为30天。
            // 30天的毫秒数
            long refresh_in = (30 * 24 * 60 * 60) * 1000L;
            long refresh_time = System.currentTimeMillis() + refresh_in;
            tokenJson.put("refresh_in", refresh_in);
            tokenJson.put("refresh_time", refresh_time);
            // 注意：expire_in 的值需要乘以 1000，因为它是以秒为单位的
            tokenJson.put("expire_in", expire_in * 1000);
        }
    }
}
