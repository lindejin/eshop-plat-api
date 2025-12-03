package com.eshop.util.platform.api.client.dewu.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.ObjectUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class JsonUtil {
    private static final Logger log = LoggerFactory.getLogger(JsonUtil.class);

    private static ObjectMapper objectMapper = new ObjectMapper();

    static {
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }

    public static <T> String obj2String(T obj) {
        if (obj == null)
            return null;
        try {
            return (obj instanceof String) ? (String) obj : objectMapper.writeValueAsString(obj);
        } catch (IOException e) {
            log.warn("Parse object to String error", e);
            return null;
        }
    }

    public static <T> String obj2StringPretty(T obj) {
        if (obj == null)
            return null;
        try {
            return (obj instanceof String) ? (String) obj : objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
        } catch (IOException e) {
            log.warn("Parse object to String error", e);
            return null;
        }
    }

    public static <T> T string2Obj(String str, Class<T> clazz) {
        if (ObjectUtils.isEmpty(str) || clazz == null)
            return null;
        try {
            return clazz.equals(String.class) ? (T) str : (T) objectMapper.readValue(str, clazz);
        } catch (IOException e) {
            log.warn("Parse object to Object error", e);
            return null;
        }
    }

    public static <T> T string2Obj(String str, TypeReference<T> typeReference) {
        if (ObjectUtils.isEmpty(str) || typeReference == null)
            return null;
        try {
            return typeReference.getType().equals(String.class) ? (T) str : (T) objectMapper.readValue(str, typeReference);
        } catch (IOException e) {
            log.warn("Parse object to Object error", e);
            return null;
        }
    }

    public static <T> T string2Obj(String str, Class<T> collectionClass, Class<?>... elementClasses) {
        JavaType javaType = objectMapper.getTypeFactory().constructParametricType(collectionClass, elementClasses);
        try {
            return (T) objectMapper.readValue(str, javaType);
        } catch (IOException e) {
            log.warn("Parse object to Object error", e);
            return null;
        }
    }

    public static JsonNode readTree(String json) {
        try {
            JsonNode jsonNode = objectMapper.readTree(json);
            return jsonNode;
        } catch (JsonProcessingException e) {
            log.warn("Parse object to Object error", (Throwable) e);
            return null;
        }
    }
}
