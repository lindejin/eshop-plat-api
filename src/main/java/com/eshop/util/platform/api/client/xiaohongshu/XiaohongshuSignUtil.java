package com.eshop.util.platform.api.client.xiaohongshu;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;

import java.util.Map;

@Slf4j
public class XiaohongshuSignUtil {

    /**
     * 生成签名 (根据小红书官方签名算法实现)
     * 签名规则:
     * 1. 参与签名的参数: method, appId, timestamp, version
     * 2. 拼接格式: method?appId=xxx&timestamp=xxx&version=xxx
     * 3. 将appSecret拼接在最后
     * 4. 计算整个字符串的MD5值(小写)
     * <p>
     * 示例:
     * product.createItem?appId=21d6***748be8de0&timestamp=1612518379&version=2.0429a***a3aee9ef9e4a858210
     * => MD5 => aa4c59****50632d80dc4
     */
    public static String generateSign(Map<String, String> params, String appSecret) {
        // 1. 获取参与签名的参数
        String method = params.get("method");
        String appId = params.get("appId");
        String timestamp = params.get("timestamp");
        String version = params.get("version");

        // 2. 按照规则拼接字符串: method?appId=xxx&timestamp=xxx&version=xxx
        StringBuilder signContent = new StringBuilder();
        signContent.append(method)
                .append("?appId=").append(appId)
                .append("&timestamp=").append(timestamp)
                .append("&version=").append(version);

        // 3. 拼接appSecret
        signContent.append(appSecret);

        // 4. 计算MD5并转为小写
        String sign = DigestUtils.md5Hex(signContent.toString()).toLowerCase();

        log.debug("小红书签名原文: {}", signContent);
        log.debug("小红书生成签名: {}", sign);

        return sign;
    }

}
