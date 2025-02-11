package com.eshop.util.platform.api.service.auth.dhgate;

import com.alibaba.fastjson.JSONObject;
import com.eshop.util.platform.api.service.auth.dhgate.dto.DhCodeUrlCreateDTO;
import com.eshop.util.platform.api.service.auth.dhgate.dto.DhTokenCreateDTO;
import com.eshop.util.platform.api.service.auth.dhgate.dto.DhTokenRefreshDTO;
import com.eshop.util.platform.api.structure.dhgate.dto.DhAppClientDTO;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ldj
 * @date 2024/3/12 18:13
 * @Description: ...
 * @Version 1.0
 */
@Service("DhGateAuthCallServiceImpl")
public class DhGateAuthCallServiceImpl implements DhGateAuthCallService {

    @Resource
    private RestTemplate restTemplate;

    @Override
    public String codeUrlCreate(DhAppClientDTO acDTO, DhCodeUrlCreateDTO reqDto) throws Exception {
        String url = acDTO.getCodeUrl();
        String clientId = acDTO.getAppKey();
        String redirect = reqDto.getRedirectUrl();

        String redirectUrl = redirect + "/" + reqDto.getShopId() + "/" + reqDto.getOpId() + "/";

        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("client_id", clientId);
        paramMap.put("response_type", "code");
        paramMap.put("redirect_uri", redirectUrl);
        paramMap.put("scope", "basic");
        paramMap.put("state", "ok");
        paramMap.put("display", "page");

        url = buildUrlWithParams(url, paramMap);
        return url;
    }


    @Override
    public String tokenCreate(DhAppClientDTO acDTO, DhTokenCreateDTO reqDto) throws Exception {
        String url = acDTO.getTokenUrl();
        String clientId = acDTO.getAppKey();
        String clientSecret = acDTO.getAppSecret();
        String redirect = reqDto.getRedirectUrl();
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("grant_type", "authorization_code");
        paramMap.put("code", reqDto.getCode());
        paramMap.put("client_id", clientId);
        paramMap.put("client_secret", clientSecret);
        paramMap.put("redirect_uri", redirect);

        url = buildUrlWithParams(url, paramMap);
        return executeTokenRequest(url);
    }


    @Override
    public String tokenRefresh(DhAppClientDTO acDTO, DhTokenRefreshDTO reqDto) throws Exception {
        String url = acDTO.getTokenUrl();
        String clientId = acDTO.getAppKey();
        String clientSecret = acDTO.getAppSecret();

        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("grant_type", "refresh_token");
        paramMap.put("refresh_token", reqDto.getRefreshToken());
        paramMap.put("client_id", clientId);
        paramMap.put("client_secret", clientSecret);
        paramMap.put("scope", "basic");

        url = buildUrlWithParams(url, paramMap);
        return executeTokenRequest(url);
    }

    /**
     * 该方法接收一个基本URL和参数的映射，将这些参数作为查询参数添加到URL中，然后返回最终构建的URL。
     *
     * @param url      需要添加查询参数的基本URL。
     * @param paramMap 需要添加到URL的查询参数映射。
     * @return 添加了查询参数的最终URL。
     */
    private String buildUrlWithParams(String url, Map<String, String> paramMap) throws UnsupportedEncodingException {
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url);

        System.out.println(JSONObject.toJSONString(paramMap));
        // 遍历JSONObject并添加查询参数
        for (Map.Entry<String, String> entry : paramMap.entrySet()) {
            if (entry.getKey() != null) {
                String encodedValue = URLEncoder.encode(entry.getValue(), "UTF-8");
                builder.queryParam(entry.getKey(), encodedValue);
            }
        }
        url = builder.build().toUriString();
        return url;
    }

    /**
     * 于执行令牌请求，包括发送请求并处理响应。
     */
    private String executeTokenRequest(String url) {
        String userAgent = "Mozilla/5.0 (Windows NT 6.2; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.87 Safari/537.36";
        HttpHeaders headers = new HttpHeaders();
        headers.set("user-agent", userAgent);
        try {
            // 使用url发送请求
            ResponseEntity<String> response = restTemplate
                    .exchange(url, HttpMethod.GET, new HttpEntity<>(null, headers),
                            String.class);
            return response.getBody();
        } catch (HttpClientErrorException ex) {
            String statusText = ex.getStatusText();  // 获取错误状态文本，如 "Bad Request"
            int statusCode = ex.getStatusCode().value();  // 获取错误状态码，如 400
            String responseBody = ex.getResponseBodyAsString();  // 获取包含错误信息的响应体

            JSONObject jsonObject = new JSONObject();
            jsonObject.put("Https错误状态文本", statusText);
            jsonObject.put("Https错误状态码", statusCode);
            jsonObject.put("Https错误信息的响应体", responseBody);
            return jsonObject.toJSONString();
            // 处理错误信息的代码
        } catch (Exception e) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("错误信息", e.getMessage());
            return jsonObject.toJSONString();
        }
    }
}
