package com.eshop.util.platform.api.client.shopee;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import com.eshop.util.ExceptionUtils;
import com.eshop.util.platform.api.structure.shopee.dto.ShopeeAppClientDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import javax.annotation.Resource;
import java.io.IOException;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Map;

/**
 * @author ldj
 * @date 2024/3/12 13:41
 * @Description: ...
 * @Version 1.0
 */
@Slf4j
@Service
public class ShopeeClientImpl implements ShopeeClient {

    @Resource
    private RestTemplate restTemplate;

    public ShopeeResponse execute(ShopeeRequest shopeeRequest, ShopeeAppClientDTO publicDTO) {
        JSONObject result = null;
        try {
            String apiUrl = publicDTO.getUrl();

            Integer mediaType = shopeeRequest.getMediaType();
            Integer secretType = shopeeRequest.getSecretType();
            String apiMethod = shopeeRequest.getApiName();


            String accessToken = publicDTO.getAccessToken();

            String partnerId = publicDTO.getPartnerId();
            String partnerKey = publicDTO.getPartnerKey();
            String shopId = publicDTO.getPlatformShopId();
            String merchantId = "";
            long timest = System.currentTimeMillis();
            timest = timest / 1000L;

            String body = "";
            String sign = "";
            String urlNet = "";
            if (mediaType == null) {
                throw new RuntimeException("请求类型判断失败！");
            }
            if (secretType == null) {
                throw new RuntimeException("加密类型判断失败！");
            }
            //公共加密
            if (secretType == 1) {
                String tmp_base_string = partnerId + apiMethod + timest;
                sign = ShopeeUtils.getsShopeeSign(tmp_base_string, partnerKey);
                urlNet = apiUrl + apiMethod + "?partner_id=" + partnerId + "&timestamp=" + timest + "&sign=" + sign;
            }
            //店铺级别加密
            if (secretType == 2) {
                String tmp_base_string = partnerId + apiMethod + timest + accessToken + shopId;
                sign = ShopeeUtils.getsShopeeSign(tmp_base_string, partnerKey);
                urlNet = apiUrl + apiMethod + "?partner_id=" + partnerId + "&access_token=" + accessToken + "&shop_id=" + shopId + "&timestamp=" + timest + "&sign=" + sign;
            }

            //商户级别加密(商户调用商户)
            if (secretType == 3) {
                merchantId = shopId;
                String tmp_base_string = partnerId + apiMethod + timest + accessToken + merchantId;
                sign = ShopeeUtils.getsShopeeSign(tmp_base_string, partnerKey);
                urlNet = apiUrl + apiMethod + "?partner_id=" + partnerId + "&access_token=" + accessToken + "&merchant_id=" + merchantId + "&timestamp=" + timest + "&sign=" + sign;
            }

            JSONObject jsonParams = shopeeRequest.getJsonParams();
            MultiValueMap<String, Object> muMapParams = shopeeRequest.getMuMapParams();
            Map<String, Object> mapParams = shopeeRequest.getMapParams();
            // 请求类型 1.get
            if (mediaType == 1) {
                //        partner_id
                mapParams.put("partner_id", partnerId);
                //        timestamp
                mapParams.put("timestamp", timest);
                //        access_token
                mapParams.put("access_token", accessToken);
                if (secretType == 3) {
                    //        shop_id
                    mapParams.put("merchant_id", merchantId);
                } else {
                    //        shop_id
                    mapParams.put("shop_id", shopId);
                }
                //        sign
                mapParams.put("sign", sign);

                body = getResponseGetBody(apiUrl + apiMethod, mapParams);
            }
            // 请求类型 2.post-json
            if (mediaType == 2) {
                body = postForJsonGetBody(urlNet, jsonParams.toString());
            }
            // 请求类型 3.post-file
            if (mediaType == 3) {
                body = postForFileGetBody(urlNet, muMapParams);
            }
            // 请求类型 4.post-map_json
            if (mediaType == 4) {
                body = postForMapJsonGetBody(urlNet, mapParams);
            }
            JSONObject resultJson = JSON.parseObject(body, Feature.DisableCircularReferenceDetect);

            result = resultJson;
        } catch (HttpClientErrorException ex) {
            String statusText = ex.getStatusText();  // 获取错误状态文本，如 "Bad Request"
            int statusCode = ex.getStatusCode().value();  // 获取错误状态码，如 400
            String responseBody = ex.getResponseBodyAsString();  // 获取包含错误信息的响应体

            JSONObject jsonObject = new JSONObject();
            jsonObject.put("Https错误状态文本", statusText);
            jsonObject.put("Https错误状态码", statusCode);
            jsonObject.put("Https错误信息的响应体", responseBody);
            result = jsonObject;
            // 处理错误信息的代码
        } catch (Exception e) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("错误信息", e.getMessage());
            result = jsonObject;
        }
        ShopeeResponse shopeeResponse = new ShopeeResponse();
        shopeeResponse.setGopResponseBody(result.toJSONString());
        return shopeeResponse;
    }

    /**
     * 获取数据统一接口
     * GET方式
     *
     * @param paramMap
     */
    public String getResponseGetBody(String url, Map<String, Object> paramMap) throws Exception {
        url = handleUrl(url, paramMap);
        ResponseEntity<String> forEntity = restTemplate.getForEntity(url, String.class);
        return forEntity.getBody();
    }

    //参数转换
    public String handleUrl(String url, Map<String, Object> paramMap) throws Exception {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url);
        // 遍历参数并添加查询参数
        for (Map.Entry<String, Object> entry : paramMap.entrySet()) {
            Object value = entry.getValue();
            if (value == null) {
                continue;
            }
            String encodedValue;
            if (value instanceof JSONObject) {
                // 如果值是JSONObject，转换为字符串并进行URL编码
                encodedValue = value.toString();
            } else {
                // 对其他值也进行URL编码
                encodedValue = value.toString();
            }
            builder.queryParam(entry.getKey(), encodedValue);
        }
        // 返回处理后的URL
        return builder.toUriString();
    }


    /**
     * post请求  发送json
     *
     * @param url
     * @param json
     * @return
     * @throws RestClientException
     */
    public String postForJsonGetBody(String url, String json) throws RestClientException {
        HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
        headers.setContentType(type);
        headers.add("Accept", MediaType.APPLICATION_JSON.toString());
        HttpEntity<String> formEntity = new HttpEntity<String>(json, headers);
        String s = restTemplate.postForEntity(url, formEntity, String.class).getBody();
        return s;
    }

    /**
     * post请求  上传文件
     * POST方式
     *
     * @param
     */
    public String postForFileGetBody(String url, MultiValueMap<String, Object> body) throws RestClientException {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        HttpEntity<MultiValueMap<String, Object>> requestEntity
                = new HttpEntity<>(body, headers);

        String serverUrl = url;

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate
                .postForEntity(serverUrl, requestEntity, String.class);

        return response.getBody();
    }

    /**
     * post请求  发送map-json
     *
     * @param url
     * @param map
     * @return
     * @throws RestClientException
     */
    public String postForMapJsonGetBody(String url, Map<String, Object> map) throws RestClientException {
        HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
        headers.setContentType(type);
        headers.add("Accept", MediaType.APPLICATION_JSON.toString());
        HttpEntity<Map<String, Object>> formEntity = new HttpEntity<>(map, headers);
        String respBody = restTemplate.postForEntity(url, formEntity, String.class).getBody();
        return respBody;
    }


    public ResponseEntity<byte[]> downloadFile(ShopeeRequest shopeeRequest, ShopeeAppClientDTO publicDTO) {
        JSONObject result = null;
        try {
            String apiUrl = publicDTO.getUrl();

            Integer mediaType = shopeeRequest.getMediaType();
            Integer secretType = shopeeRequest.getSecretType();
            String apiMethod = shopeeRequest.getApiName();


            String accessToken = publicDTO.getAccessToken();

            String partnerId = publicDTO.getPartnerId();
            String partnerKey = publicDTO.getPartnerKey();
            String shopId = publicDTO.getPlatformShopId();

            long timest = System.currentTimeMillis();
            timest = timest / 1000L;

            String body = "";
            String sign = "";
            String urlNet = "";
            if (mediaType == null) {
                throw new RuntimeException("请求类型判断失败！");
            }
            if (secretType == null) {
                throw new RuntimeException("加密类型判断失败！");
            }
            //公共加密
            if (secretType == 1) {
                String tmp_base_string = partnerId + apiMethod + timest;
                sign = ShopeeUtils.getsShopeeSign(tmp_base_string, partnerKey);
                urlNet = apiUrl + apiMethod + "?partner_id=" + partnerId + "&timestamp=" + timest + "&sign=" + sign;
            }
            //店铺级别加密
            if (secretType == 2) {
                String tmp_base_string = partnerId + apiMethod + timest + accessToken + shopId;
                sign = ShopeeUtils.getsShopeeSign(tmp_base_string, partnerKey);
                urlNet = apiUrl + apiMethod + "?partner_id=" + partnerId + "&access_token=" + accessToken + "&shop_id=" + shopId + "&timestamp=" + timest + "&sign=" + sign;
            }

            JSONObject jsonParams = shopeeRequest.getJsonParams();
            // 请求类型 4.post-map_json
            if (mediaType == 2) {
//                body = apiHttpUtil.postForMapJsonGetBody(urlNet, mapParams);
                return downloadFile(urlNet, jsonParams);
            }


        } catch (HttpClientErrorException ex) {
            String statusText = ex.getStatusText();  // 获取错误状态文本，如 "Bad Request"
            int statusCode = ex.getStatusCode().value();  // 获取错误状态码，如 400
            String responseBody = ex.getResponseBodyAsString();  // 获取包含错误信息的响应体

            JSONObject jsonObject = new JSONObject();
            jsonObject.put("Https错误状态文本", statusText);
            jsonObject.put("Https错误状态码", statusCode);
            jsonObject.put("Https错误信息的响应体", responseBody);
            log.error("虾皮 Https错误：" + jsonObject.toJSONString());
            log.error("虾皮 Https错误：" + ExceptionUtils.exToString(ex));
            // 处理错误信息的代码
            throw new RuntimeException(result.toJSONString());
        } catch (Exception e) {
            log.error("虾皮 请求异常：" + ExceptionUtils.exToString(e));
            throw new RuntimeException(result.toJSONString());
        }
        return null;
    }

    /**
     * 发送post请求，接收文件流
     *
     * @param url
     * @return InputStream
     * @throws RestClientException
     * @throws IOException
     */
    private ResponseEntity<byte[]> downloadFile(String url, JSONObject jsonParams) throws RestClientException, IOException {
        HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.APPLICATION_JSON;
        headers.setContentType(type);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_OCTET_STREAM));

//        HttpEntity<Map<String, Object>> requestEntity = new HttpEntity<>(jsonParams, headers);
        RequestEntity<Map<String, Object>> request = new RequestEntity<>(jsonParams, headers, HttpMethod.POST, URI.create(url));

//        ResponseEntity<InputStream> response = restTemplate.exchange(request, InputStream.class);
        ResponseEntity<byte[]> response = restTemplate.exchange(request, byte[].class);
        MediaType contentType = response.getHeaders().getContentType();

//        HttpHeaders headers = response.getHeaders();
        MediaType contentTypeR = response.getHeaders().getContentType();

        if (contentTypeR != null && contentTypeR.isCompatibleWith(MediaType.APPLICATION_JSON)) {
            byte[] responseBody = response.getBody();
            if (responseBody != null) {
                String jsonContent = new String(responseBody, StandardCharsets.UTF_8);
                System.out.println(jsonContent);
            }
        }
        if (response.getStatusCode().is2xxSuccessful()) {
            return response;
        } else {
            throw new RestClientException("Failed to download file. Status code: " + response.getStatusCodeValue());
        }
    }

    @Override
    public ShopeeResponse tokenCreateAndRefresh(ShopeeRequest shopeeRequest, ShopeeAppClientDTO publicDTO) {
        JSONObject result = null;
        try {
            String apiUrl = publicDTO.getUrl();

            Integer mediaType = shopeeRequest.getMediaType();
            Integer secretType = shopeeRequest.getSecretType();
            String apiMethod = shopeeRequest.getApiName();

            String partnerId = publicDTO.getPartnerId();
            String partnerKey = publicDTO.getPartnerKey();
            String shopId = publicDTO.getPlatformShopId();

            long timest = System.currentTimeMillis();
            timest = timest / 1000L;

            String body = "";
            String sign = "";
            String urlNet = "";
            if (mediaType == null) {
                throw new RuntimeException("请求类型判断失败！");
            }
            if (secretType == null) {
                throw new RuntimeException("加密类型判断失败！");
            }
            //公共加密
            String tmp_base_string = partnerId + apiMethod + timest;
            sign = ShopeeUtils.getsShopeeSign(tmp_base_string, partnerKey);
            urlNet = apiUrl + apiMethod + "?partner_id=" + partnerId + "&timestamp=" + timest + "&sign=" + sign;
            // 请求类型 4.post-map_json
            Map<String, Object> params = shopeeRequest.getMapParams();
            body = postForMapJsonGetBody(urlNet, params);
            JSONObject resultJson = JSON.parseObject(body, Feature.DisableCircularReferenceDetect);

            result = resultJson;
        } catch (HttpClientErrorException ex) {
            String statusText = ex.getStatusText();  // 获取错误状态文本，如 "Bad Request"
            int statusCode = ex.getStatusCode().value();  // 获取错误状态码，如 400
            String responseBody = ex.getResponseBodyAsString();  // 获取包含错误信息的响应体

            JSONObject jsonObject = new JSONObject();
            jsonObject.put("Https错误状态文本", statusText);
            jsonObject.put("Https错误状态码", statusCode);
            jsonObject.put("Https错误信息的响应体", responseBody);
            result = jsonObject;
            // 处理错误信息的代码
        } catch (Exception e) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("错误信息", e.getMessage());
            result = jsonObject;
        }
        ShopeeResponse shopeeResponse = new ShopeeResponse();
        shopeeResponse.setGopResponseBody(result.toJSONString());
        return shopeeResponse;
    }
}
