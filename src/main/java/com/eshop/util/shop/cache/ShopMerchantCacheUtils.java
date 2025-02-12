package com.eshop.util.shop.cache;

import com.alibaba.fastjson.JSONObject;
import com.eshop.util.RedisUtils;
import com.eshop.util.constants.ConstantsRedisKey;
import com.eshop.util.shop.vo.PlatformMerchantTokenRedisVO;
import com.eshop.util.shop.vo.PlatformMerchantTokenVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Date;

/**
 * @author ldj
 * @date 2023/2/15 15:44
 * @Description: ...
 * @Version 1.0
 */
@Component
public class ShopMerchantCacheUtils {

    /**
     * 删除店铺的本身的缓存
     *
     * @param shopMerchantId
     */
    public void deleteShopMerchantRedisData(Long shopMerchantId) {
        RedisUtils.del("join:ecPlatform:" + shopMerchantId);
    }

    /**
     * 更新店铺授权token,redis数据
     */
    public void updateAuthRedisData(PlatformMerchantTokenRedisVO tokenRespVO) {
        Long shopMerchantId = tokenRespVO.getShopMerchantId();
        String accessToken = tokenRespVO.getAccessToken();
        String refreshToken = tokenRespVO.getRefreshToken();
        Date expiresTime = new Date(tokenRespVO.getExpireTime());
        if (StringUtils.isBlank(accessToken)) {
            throw new RuntimeException(JSONObject.toJSONString(tokenRespVO));
        }
        JSONObject result = new JSONObject();
        result.put("accessToken", accessToken);
        result.put("refreshToken", refreshToken);

        long expire_in = getDeviationTime(expiresTime);

        Long refresh_in = tokenRespVO.getRefreshIn() / 1000L;

        //全部属性key
        String ecJoinKey = ConstantsRedisKey.REDIS_TOKEN_MERCHANT_EC_JOIN + shopMerchantId;
        //access key
        String ecJoinAccessKey = ConstantsRedisKey.REDIS_TOKEN_MERCHANT_EC_ACCESS_JOIN + shopMerchantId;
        //refresh key
        String ecJoinRefreshKey = ConstantsRedisKey.REDIS_TOKEN_MERCHANT_EC_REFRESH_JOIN + shopMerchantId;

        //redis保留精确到秒
        RedisUtils.set(ecJoinKey, result.toJSONString(), refresh_in*5);
        //更新 redis accessToken 指定时间 expire_in
        RedisUtils.set(ecJoinAccessKey, accessToken, expire_in);
        //更新 redis refreshToken 指定时间 refresh_in
        RedisUtils.set(ecJoinRefreshKey, refreshToken, refresh_in*5);
    }

    /**
     * 计算距离现在还有多久过期 单位秒
     */
    private long getDeviationTime(Date expiresTime) {
        long endTime = expiresTime.getTime();
        long nowTime = Instant.now().toEpochMilli();
        return (endTime - nowTime) / 1000;
    }


    /**
     * 判断店铺 授权token是否过期
     *
     * @param shopMerchantId
     * @return
     */
    public boolean hasKeyByShopAccessToken(Long shopMerchantId) {
        //全部属性key
        String ecJoinKey = ConstantsRedisKey.REDIS_TOKEN_MERCHANT_EC_JOIN + shopMerchantId;
        //access key
        String ecJoinAccessKey = ConstantsRedisKey.REDIS_TOKEN_MERCHANT_EC_ACCESS_JOIN + shopMerchantId;
        //refresh key
        String ecJoinRefreshKey = ConstantsRedisKey.REDIS_TOKEN_MERCHANT_EC_REFRESH_JOIN + shopMerchantId;

        boolean hasKey = false;
        //accessToken是否存在
        hasKey = RedisUtils.hasKey(ecJoinAccessKey);
        if (!hasKey) {
            //店铺授权返回tokenJson是否存在
            hasKey = RedisUtils.hasKey(ecJoinKey);
        }
        return hasKey;
    }


    /**
     * 根据店铺商户id获取授权token
     *
     * @param shopMerchantId
     * @return
     */
    public PlatformMerchantTokenVO getPlatformTokenVO(Long shopMerchantId) {
        //全部属性key
        String ecJoinKey = ConstantsRedisKey.REDIS_TOKEN_MERCHANT_EC_JOIN + shopMerchantId;
        //access key
        String ecJoinAccessKey = ConstantsRedisKey.REDIS_TOKEN_MERCHANT_EC_ACCESS_JOIN + shopMerchantId;
        //refresh key
        String ecJoinRefreshKey = ConstantsRedisKey.REDIS_TOKEN_MERCHANT_EC_REFRESH_JOIN + shopMerchantId;

        String tokenStr = RedisUtils.get(ecJoinKey);

        String accessToken = "";
        String refreshToken = "";

        if (StringUtils.isNotBlank(tokenStr)) {
            JSONObject tokenJson = JSONObject.parseObject(tokenStr);
            accessToken = tokenJson.getString("accessToken");
            refreshToken = tokenJson.getString("refreshToken");
        } else {
            accessToken = RedisUtils.get(ecJoinAccessKey);
            refreshToken = RedisUtils.get(ecJoinRefreshKey);
        }

        if (StringUtils.isBlank(refreshToken)) {
            refreshToken = RedisUtils.get(ecJoinRefreshKey);
        }
        PlatformMerchantTokenVO ptVO = new PlatformMerchantTokenVO();
        ptVO.setShopMerchantId(shopMerchantId);
        ptVO.setAccessToken(accessToken);
        ptVO.setRefreshToken(refreshToken);
        return ptVO;
    }
}
