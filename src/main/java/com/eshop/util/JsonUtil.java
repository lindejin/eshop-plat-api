//package com.eshop.util;
//
//
//import com.fasterxml.jackson.annotation.JsonInclude;
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.core.type.TypeReference;
//import com.fasterxml.jackson.databind.DeserializationFeature;
//import com.fasterxml.jackson.databind.JsonNode;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import java.io.IOException;
//
//public class JsonUtil {
//    private static final Logger log = LoggerFactory.getLogger(JsonUtil.class);
//    private static ObjectMapper objectMapper = new ObjectMapper();
//
//    static {
//        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
//    }
//
//    /* JADX WARN: Multi-variable type inference failed */
//    public static <T> String obj2String(T t) {
//        if (t == 0) {
//            return null;
//        }
//        try {
//            return t instanceof String ? (String) t : objectMapper.writeValueAsString(t);
//        } catch (IOException e) {
//            log.warn("Parse object to String error", e);
//            return null;
//        }
//    }
//
//    /* JADX WARN: Multi-variable type inference failed */
//    public static <T> String obj2StringPretty(T t) {
//        if (t == 0) {
//            return null;
//        }
//        try {
//            return t instanceof String ? (String) t : objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(t);
//        } catch (IOException e) {
//            log.warn("Parse object to String error", e);
//            return null;
//        }
//    }
//
//    /* JADX WARN: Multi-variable type inference failed */
//    public static <T> T string2Obj(String str, Class<T> cls) {
//        if (ObjectUtils.isEmpty(str) || cls == null) {
//            return null;
//        }
//        try {
//            return cls.equals(String.class) ? str : (T) objectMapper.readValue(str, cls);
//        } catch (IOException e) {
//            log.warn("Parse object to Object error", e);
//            return null;
//        }
//    }
//
//    /* JADX WARN: Multi-variable type inference failed */
//    public static <T> T string2Obj(String str, TypeReference<T> typeReference) {
//        if (ObjectUtils.isEmpty(str) || typeReference == null) {
//            return null;
//        }
//        try {
//            return typeReference.getType().equals(String.class) ? str : (T) objectMapper.readValue(str, typeReference);
//        } catch (IOException e) {
//            log.warn("Parse object to Object error", e);
//            return null;
//        }
//    }
//
//    public static <T> T string2Obj(String str, Class<T> cls, Class<?>... clsArr) {
//        try {
//            return (T) objectMapper.readValue(str, objectMapper.getTypeFactory().constructParametricType(cls, clsArr));
//        } catch (IOException e) {
//            log.warn("Parse object to Object error", e);
//            return null;
//        }
//    }
//
//    public static JsonNode readTree(String json) {
//        try {
//            JsonNode jsonNode = objectMapper.readTree(json);
//            return jsonNode;
//        } catch (JsonProcessingException e) {
//            log.warn("Parse object to Object error", e);
//            return null;
//        }
//    }
//}