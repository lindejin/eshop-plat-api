package com.eshop.order;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.eshop.entity.config.TbShop;
import com.eshop.service.config.ITbShopService;
import com.eshop.util.platform.api.structure.tiktok.dto.TikTokAppClientDTO;
import com.eshop.util.shop.PlatformAppClientUtils;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

@Slf4j
@SpringBootTest
public class TikTokTest {

    @Resource
    private ITbShopService iTbShopService;

    @Resource
    private PlatformAppClientUtils platformAppClientUtils;

    @Test
    void getLogisticsShipment() throws Exception {
        TbShop shopDO = iTbShopService.getById(1597);
        TikTokAppClientDTO tikTokAppClientDTO = platformAppClientUtils.getTikTokAppClientDTO(shopDO);
        //获取平台店铺信息
        TiktokAuthBaseInfoDTO authDto = new TiktokAuthBaseInfoDTO();
        authDto.setPlatformAppInfo(JSON.parseObject(shopDO.getParamStaticJson()));
        authDto.setAccessToken(tikTokAppClientDTO.getAccessToken());

        Map<String, TKShopInfoVO> shopInfoMap = getShopInfoMap(authDto);
        System.out.println(JSONObject.toJSONString(shopInfoMap));

        System.out.println(tikTokAppClientDTO.getAccessToken());
    }

    /**
     * 获取店铺信息
     */
    public Map<String, TKShopInfoVO> getShopInfoMap(TiktokAuthBaseInfoDTO authDTO) {
        String requestPath = "/authorization/202309/shops";
        String logPrefix = "(TK获取店铺信息)";
        TiktokAuthBaseInfoDTO dto = TikTokUtil.removeShopCipher(authDTO);
        JSONObject jsonObject = getRequest(requestPath, dto, new HashMap<>(), logPrefix);
        List<TKShopInfoVO> shops = TikTokUtil.getReturnDataConvertObj(jsonObject, "shops", TKShopInfoVO.class, logPrefix);
        if (CollectionUtils.isEmpty(shops)) {
            throw new RuntimeException(logPrefix + "未获取到店铺信息,返回信息:" + jsonObject.toJSONString());
        }
        return shops.stream().collect(Collectors.toMap(TKShopInfoVO::getRegion, e -> e, (oldVal, newVal) -> newVal));
    }

    @Resource
    private OkHttpClient okHttpClient;


    public JSONObject getRequest(String requestPath, TiktokAuthBaseInfoDTO authDTO, Map<String, Object> paramMap,
                                 String logPrefix) {
        int maxNum = 5;
        JSONObject resultJson = null;
        for (int i = 0; i < maxNum; i++) {
            try {
                resultJson = sendGetRequest1(requestPath, authDTO, paramMap, logPrefix);
                break;
            } catch (Exception e) {
                try {
                    Thread.sleep(new Random().nextInt(1000) + 300);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
                if (i == maxNum - 1) {
                    log.error(logPrefix + "错误信息: " + e);
                    String message = e.getMessage();
                    if (message.contains("timed out")) {
                        throw new TkException("网络连接超时,请稍后重试...");
                    } else if (message.contains("The 'x-tts-access-token' header is invalid")) {
                        throw new TkException("未获取到对应授权信息");
                    } else {
                        throw new TkException(e.getMessage());
                    }
                }
            }
        }
        return resultJson;
    }
    private static final String ENV_GL_OLD = "https://open-api.tiktokglobalshop.com";

    private static final String ENV_GL = "https://us.vogocmerp.com/openapi_tiktok_gl";
    /**
     * get请求
     */
    public JSONObject sendGetRequest1(String urlTemp, TiktokAuthBaseInfoDTO authDTO, Map<String, Object> paramMap,
                                      String logPrefix) {

        String appKey = authDTO.getPlatformAppInfo().getString("app_key");
        String appSecret = authDTO.getPlatformAppInfo().getString("app_secret");
        String shopCipher = authDTO.getShopCipher();
        String accessToken = authDTO.getAccessToken();

        if (StringUtils.isBlank(urlTemp)) {
            throw new TkException("Url路径不能为空!!!");
        }
        String urlFirst = PatternUtil.replaceCurlyBracketContent(urlTemp, paramMap);
        String requestUrl = TikTokUtil.generateNewRequestUrl(urlFirst, appKey, appSecret,shopCipher,paramMap, "");

        if (requestUrl.indexOf(ENV_GL_OLD)!=-1){
            requestUrl = requestUrl.replace(ENV_GL_OLD,ENV_GL);
        }
        return sendGetRequestOkHttp(requestUrl, accessToken, logPrefix);

    }

    public JSONObject sendGetRequestOkHttp(String requestUrl, String accessToken, String logPrefix) {

        Request request = new Request.Builder()
                .url(requestUrl)
                .get()
                .addHeader("x-tts-access-token", accessToken)
                .build();

        try (Response response = okHttpClient.newCall(request).execute()) {
            ResponseBody responseBody = response.body();
            String responseBodyStr = responseBody != null ? responseBody.string() : "";

            // 处理非成功响应
            if (!response.isSuccessful()) {
                String errorMessage = extractErrorMessage(responseBodyStr);
                throw new TkException(logPrefix + " 请求失败，状态码(" + response.code() + ") 错误信息: " + errorMessage);
            }

            // 处理空响应体
            if (responseBodyStr.isEmpty()) {
                throw new TkException(logPrefix + " 未获取到请求返回信息");
            }

            return JSON.parseObject(responseBodyStr);

        } catch (IOException e) {
            throw new TkException(logPrefix + " 请求发生IO异常: " + e.getMessage(), e);
        }
    }

    private String extractErrorMessage(String responseBody) {
        try {
            JSONObject errorJson = JSON.parseObject(responseBody);
            String message = errorJson.getString("message");
            if (StringUtils.isBlank(message)) {
                return responseBody; // 解析失败时返回原始内容
            }
            return message;
        } catch (Exception e) {
            return responseBody; // 解析失败时返回原始内容
        }
    }
}
