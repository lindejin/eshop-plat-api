package com.eshop.util.platform.api.client.dewu;

import com.eshop.util.platform.api.client.dewu.util.JsonUtil;
import com.eshop.util.platform.api.client.dewu.util.Jsons;
import com.eshop.util.platform.api.client.dewu.util.MD5Util;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.*;
import java.util.stream.Collectors;

public class DewuSignUtil {

    private static final Logger log = LoggerFactory.getLogger(DewuSignUtil.class);

    public static String createNewSign(Map<String, Object> params, String secret) {
        if (params.containsKey("secret"))
            params.remove("secret");
        params.entrySet().removeIf(entry -> (entry.getValue() == null));
        String paramsString = JsonUtil.obj2String(params);
        TreeMap<String, String> treeMap = jsonToMap(paramsString);
        String sign = getSign(treeMap, secret);
        return sign;
    }

    public static TreeMap<String, String> jsonToMap(String formData) {
        TreeMap<String, String> reqParams = new TreeMap<>();
        JsonNode jsonNode = JsonUtil.readTree(formData);
        Iterator<Map.Entry<String, JsonNode>> entryIterator = jsonNode.fields();
        List<Map.Entry<String, JsonNode>> entries = copyIterator(entryIterator);
        entries.forEach(jNode -> {
            StringBuffer value = new StringBuffer();
            if (((JsonNode) jNode.getValue()).isArray()) {
                Iterator<JsonNode> elements = ((JsonNode) jNode.getValue()).elements();
                List<JsonNode> jsonNodeList = copyIterator(elements);
                for (JsonNode node : jsonNodeList) {
                    if (node.isTextual()) {
                        value.append(node.asText()).append(",");
                        continue;
                    }
                    value.append(node.toString()).append(",");
                }
                if (value.length() > 0)
                    value.deleteCharAt(value.length() - 1);
            } else if (((JsonNode) jNode.getValue()).isTextual()) {
                value = value.append(((JsonNode) jNode.getValue()).asText());
            } else if (jNode != null) {
                value = value.append(((JsonNode) jNode.getValue()).toString());
            }
            reqParams.putIfAbsent(jNode.getKey(), value.toString());
        });
        return reqParams;
    }

    public static TreeMap<String, String> jsonToMapNew(String formData) {
        TreeMap<String, String> reqParams = new TreeMap<>();
        Map<String, Object> stringObjectMap = (Map) Jsons.parse(formData, new TypeReference<Map<String, Object>>() { // from class: com.dewu.sdk.base.util.Signer.1
        });
        stringObjectMap.forEach((key, value) -> {
            String collect = "";
            if (value instanceof List) {
                collect = (String) ((List) value).stream().map(e -> {
                    if ((e instanceof Map) || (e instanceof List)) {
                        return Jsons.toJson(e);
                    }
                    return Objects.toString(e);
                }).collect(Collectors.joining(","));
            } else if (value != null) {
                if (value instanceof Map) {
                    collect = Jsons.toJson(value);
                } else {
                    collect = value.toString();
                }
            }
            reqParams.putIfAbsent(key, value == null ? "" : collect);
        });
        return reqParams;
    }


    public static <T> List<T> copyIterator(Iterator<T> iter) {
        List<T> copy = new ArrayList<>();
        while (iter.hasNext())
            copy.add(iter.next());
        return copy;
    }

    public static String getSign(TreeMap<String, String> reqParams, String secret) {
        String sortedKvStr = reqParams.entrySet().stream().map(entry -> {
            try {
                return URLEncoder.encode(String.valueOf(entry.getKey()), "UTF-8") + "=" + URLEncoder.encode(String.valueOf(entry.getValue()), "UTF-8") + "&";
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException(e);
            }
        }).reduce("", String::concat);
        sortedKvStr = sortedKvStr.substring(0, sortedKvStr.length() - 1) + secret;
        String sign = MD5Util.getMD5Str(sortedKvStr).toUpperCase();
        log.info("{}, {}", sortedKvStr, sign);
        return sign;
    }
}
