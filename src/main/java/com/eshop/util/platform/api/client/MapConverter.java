package com.eshop.util.platform.api.client;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.Arrays;
import java.util.Map;

public class MapConverter {
    public static MultiValueMap<String, String> convert(Map<String, Object> map) {
        MultiValueMap<String, String> result = new LinkedMultiValueMap<>();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            if (entry.getValue() != null) {
                result.put(entry.getKey(), Arrays.asList(entry.getValue().toString()));
            }
        }
        return result;
    }
}