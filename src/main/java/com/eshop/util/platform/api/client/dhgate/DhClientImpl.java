package com.eshop.util.platform.api.client.dhgate;

import com.eshop.util.platform.api.client.MapConverter;
import com.eshop.util.platform.api.structure.dhgate.dto.DhAppClientDTO;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author ldj
 * @date 2024/3/12 10:47
 * @Description: ...
 * @Version 1.0
 */
@Service
public class DhClientImpl implements DhClient {

    @Resource
    private RestTemplate restTemplate;

    @Override
    public DhResponse execute(DhRequest dhRequest, DhAppClientDTO publicDTO) throws Exception {
        Map<String, Object> params = dhRequest.getBusinessDTO();
        params.put("method", dhRequest.getApiName());
        params.put("v", dhRequest.getApiVersion());
        params.put("access_token", publicDTO.getAccessToken());
        params.put("timestamp", System.currentTimeMillis());

        String url = publicDTO.getUrl();
        HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType("application/x-www-form-urlencoded; charset=UTF-8");
        headers.setContentType(type);
        headers.add("Accept", MediaType.APPLICATION_JSON.toString());
        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(MapConverter.convert(params), headers);

        ResponseEntity<String> exchange = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class, params);
        DhResponse dhResponse = new DhResponse();
        dhResponse.setGopResponseBody(exchange.getBody());
        return dhResponse;
    }
}
