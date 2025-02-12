package com.eshop.util.shop;

import com.alibaba.fastjson.JSONObject;
import com.eshop.util.RedisUtils;
import com.eshop.util.constants.ConstantsRedisKey;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

/**
 * @author ldj
 * @date 2023/2/15 15:44
 * @Description: ...
 * @Version 1.0
 */
@Component
public class TemuShopCacheUtils {

    /**
     * 更新店铺授权token,redis数据
     */
    public void updateAuthRedisData(Long shopId, String accessToken, Long unixTimestamp, String shopLocation) {
        String refreshToken = accessToken;
        if (StringUtils.isBlank(accessToken)) {
            throw new RuntimeException(accessToken);
        }
        JSONObject result = new JSONObject();
        result.put("accessToken", accessToken);
        result.put("refreshToken", refreshToken);

        long expire_in = unixTimestamp / 1000L;

        long refresh_in = unixTimestamp / 1000L;

        //全部属性key
        String ecJoinKey = ConstantsRedisKey.REDIS_TOKEN_EC_JOIN + shopLocation + ":" + shopId;
        //access key
        String ecJoinAccessKey = ConstantsRedisKey.REDIS_TOKEN_EC_ACCESS_JOIN + shopLocation + ":" + shopId;
        //refresh key
        String ecJoinRefreshKey = ConstantsRedisKey.REDIS_TOKEN_EC_REFRESH_JOIN + shopLocation + ":" + shopId;

        //redis保留精确到秒
        RedisUtils.set(ecJoinKey, result.toJSONString(), refresh_in * 5);
        //更新 redis accessToken 指定时间 expire_in
        RedisUtils.set(ecJoinAccessKey, accessToken, expire_in);
        //更新 redis refreshToken 指定时间 refresh_in
        RedisUtils.set(ecJoinRefreshKey, refreshToken, refresh_in * 5);
    }


    /**
     * 根据店铺id获取授权token
     *
     * @param shopId
     * @return
     */
    public PlatformTokenVO getPlatformTokenVO(Long shopId, String shopLocation) {
        //全部属性key
        String ecJoinKey = ConstantsRedisKey.REDIS_TOKEN_EC_JOIN + shopLocation + ":" + shopId;
        //access key
        String ecJoinAccessKey = ConstantsRedisKey.REDIS_TOKEN_EC_ACCESS_JOIN + shopLocation + ":" + shopId;
        //refresh key
        String ecJoinRefreshKey = ConstantsRedisKey.REDIS_TOKEN_EC_REFRESH_JOIN + shopLocation + ":" + shopId;

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
