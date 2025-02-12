package com.eshop.util.shop.cache;

import com.alibaba.fastjson.JSONObject;
import com.eshop.util.RedisUtils;
import com.eshop.util.constants.ConstantsRedisKey;
import com.eshop.util.shop.vo.PlatformTokenRedisVO;
import com.eshop.util.shop.vo.PlatformTokenVO;
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
public class ShopCacheUtils {

    /**
     * 删除店铺的本身的缓存
     *
     * @param shopId
     */
    public void deleteShopRedisData(Long shopId) {
        RedisUtils.del("join:ecPlatform:" + shopId);
    }

    /**
     * 更新店铺授权token,redis数据
     */
    public void updateAuthRedisData(PlatformTokenRedisVO tokenRespVO) {
        Long shopId = tokenRespVO.getShopId();
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
        String ecJoinKey = ConstantsRedisKey.REDIS_TOKEN_EC_JOIN + shopId;
        //access key
        String ecJoinAccessKey = ConstantsRedisKey.REDIS_TOKEN_EC_ACCESS_JOIN + shopId;
        //refresh key
        String ecJoinRefreshKey = ConstantsRedisKey.REDIS_TOKEN_EC_REFRESH_JOIN + shopId;

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
     * @param shopId
     * @return
     */
    public boolean hasKeyByShopAccessToken(Long shopId) {
        //全部属性key
        String ecJoinKey = ConstantsRedisKey.REDIS_TOKEN_EC_JOIN + shopId;
        //access key
        String ecJoinAccessKey = ConstantsRedisKey.REDIS_TOKEN_EC_ACCESS_JOIN + shopId;
        //refresh key
        String ecJoinRefreshKey = ConstantsRedisKey.REDIS_TOKEN_EC_REFRESH_JOIN + shopId;

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
     * 根据店铺id获取授权token
     *
     * @param shopId
     * @return
     */
    public JSONObject getAuthData(Long shopId) {
        //全部属性key
        String ecJoinKey = ConstantsRedisKey.REDIS_TOKEN_EC_JOIN + shopId;
        //access key
        String ecJoinAccessKey = ConstantsRedisKey.REDIS_TOKEN_EC_ACCESS_JOIN + shopId;
        //refresh key
        String ecJoinRefreshKey = ConstantsRedisKey.REDIS_TOKEN_EC_REFRESH_JOIN + shopId;

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
        JSONObject rtJson = new JSONObject();
        rtJson.put("accessToken", accessToken);
        rtJson.put("refreshToken", refreshToken);
        return rtJson;
    }


    /**
     * 根据店铺id获取授权token
     *
     * @param shopId
     * @return
     */
    public PlatformTokenVO getPlatformTokenVO(Long shopId) {
        //全部属性key
        String ecJoinKey = ConstantsRedisKey.REDIS_TOKEN_EC_JOIN + shopId;
        //access key
        String ecJoinAccessKey = ConstantsRedisKey.REDIS_TOKEN_EC_ACCESS_JOIN + shopId;
        //refresh key
        String ecJoinRefreshKey = ConstantsRedisKey.REDIS_TOKEN_EC_REFRESH_JOIN + shopId;

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
        PlatformTokenVO ptVO = new PlatformTokenVO();
        ptVO.setShopId(shopId);
        ptVO.setAccessToken(accessToken);
        ptVO.setRefreshToken(refreshToken);
        return ptVO;
    }
}
