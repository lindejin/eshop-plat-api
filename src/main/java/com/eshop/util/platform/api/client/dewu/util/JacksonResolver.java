package com.eshop.util.platform.api.client.dewu.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.MapType;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;

public class JacksonResolver {
    private static final ObjectMapper OBJECT_MAPPER;

    private static final ObjectMapper OBJECT_NULL_MAPPER;

    static {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        objectMapper.configure(SerializationFeature.FAIL_ON_SELF_REFERENCES, false);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.configure(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS, true);
        objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
        objectMapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
        OBJECT_MAPPER = objectMapper;
        ObjectMapper objectNullMapper = new ObjectMapper();
        objectNullMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        objectNullMapper.configure(SerializationFeature.FAIL_ON_SELF_REFERENCES, false);
        objectNullMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.configure(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS, true);
        objectNullMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
        objectNullMapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
        OBJECT_NULL_MAPPER = objectNullMapper;
    }

    public static final ObjectMapper objectMapper() {
        return OBJECT_MAPPER;
    }

    public static <T> String toJson(T object) {
        try {
            return OBJECT_MAPPER.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException(e.getMessage(), e);
        }
    }

    public static <T> String toNullJson(T object) {
        try {
            return OBJECT_NULL_MAPPER.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException(e.getMessage(), e);
        }
    }

    public static <T> byte[] toBytes(T object) {
        try {
            return OBJECT_MAPPER.writeValueAsBytes(object);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException(e.getMessage(), e);
        }
    }

    public static <T> String toPrettyJson(T object) {
        try {
            return OBJECT_MAPPER.writerWithDefaultPrettyPrinter()
                    .writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException(e.getMessage(), e);
        }
    }

    public static <T> T parse(String json, Class<T> clazz) {
        try {
            return (T) OBJECT_MAPPER.readValue(json, clazz);
        } catch (Exception e) {
            throw new IllegalArgumentException(String.format("json:[%s] %s", new Object[]{json, e.getMessage()}), e);
        }
    }

    public static <T> T parse(byte[] bytes, Class<T> clazz) {
        try {
            return (T) OBJECT_MAPPER.readValue(bytes, clazz);
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage(), e);
        }
    }

    public static <T> T parse(InputStream inputStream, Class<T> clazz) {
        try {
            return (T) OBJECT_MAPPER.readValue(inputStream, clazz);
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage(), e);
        }
    }

    public static <T> T parse(String json, final Type type) {
        return parse(json, new TypeReference<T>() {
            public Type getType() {
                return type;
            }
        });
    }

    public static <T> T parse(byte[] bytes, final Type type) {
        return parse(bytes, new TypeReference<T>() {
            public Type getType() {
                return type;
            }
        });
    }

    public static <T> T parse(InputStream inputStream, final Type type) {
        return parse(inputStream, new TypeReference<T>() {
            public Type getType() {
                return type;
            }
        });
    }

    public static <T> T parse(String json, TypeReference<T> typeReference) {
        try {
            return (T) OBJECT_MAPPER.readValue(json, typeReference);
        } catch (Exception e) {
            throw new IllegalArgumentException(String.format("json:[%s] %s", new Object[]{json, e.getMessage()}), e);
        }
    }

    public static <T> T parse(byte[] bytes, TypeReference<T> typeReference) {
        try {
            return (T) OBJECT_MAPPER.readValue(bytes, typeReference);
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage(), e);
        }
    }

    public static <T> T parse(InputStream inputStream, TypeReference<T> typeReference) {
        try {
            return (T) OBJECT_MAPPER.readValue(inputStream, typeReference);
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage(), e);
        }
    }

    public static <E, C extends java.util.Collection<E>> C parseCollection(String json, Class<C> collectionClazz, Class<E> elementClazz) {
        CollectionType collectionType = OBJECT_MAPPER.getTypeFactory().constructCollectionType(collectionClazz, elementClazz);
        try {
            return (C) OBJECT_MAPPER.readValue(json, (JavaType) collectionType);
        } catch (IOException e) {
            throw new IllegalArgumentException(String.format("json:[%s] %s", new Object[]{json, e.getMessage()}), e);
        }
    }

    public static <E, C extends java.util.Collection<E>> C parseCollection(byte[] bytes, Class<C> collectionClazz, Class<E> elementClazz) {
        CollectionType collectionType = OBJECT_MAPPER.getTypeFactory().constructCollectionType(collectionClazz, elementClazz);
        try {
            return (C) OBJECT_MAPPER.readValue(bytes, (JavaType) collectionType);
        } catch (IOException e) {
            throw new IllegalArgumentException(e.getMessage(), e);
        }
    }

    public static <E, C extends java.util.Collection<E>> C parseCollection(InputStream inputStream, Class<C> collectionClazz, Class<E> elementClazz) {
        CollectionType collectionType = OBJECT_MAPPER.getTypeFactory().constructCollectionType(collectionClazz, elementClazz);
        try {
            return (C) OBJECT_MAPPER.readValue(inputStream, (JavaType) collectionType);
        } catch (IOException e) {
            throw new IllegalArgumentException(e.getMessage(), e);
        }
    }

    public static <K, V, M extends java.util.Map<K, V>> M parseMap(String json, Class<M> mapClazz, Class<K> keyClazz, Class<V> valueClazz) {
        MapType mapType = OBJECT_MAPPER.getTypeFactory().constructMapType(mapClazz, keyClazz, valueClazz);
        try {
            return (M) OBJECT_MAPPER.readValue(json, (JavaType) mapType);
        } catch (IOException e) {
            throw new IllegalArgumentException(String.format("json:[%s] %s", new Object[]{json, e.getMessage()}), e);
        }
    }

    public static <K, V, M extends java.util.Map<K, V>> M parseMap(byte[] bytes, Class<M> mapClazz, Class<K> keyClazz, Class<V> valueClazz) {
        MapType mapType = OBJECT_MAPPER.getTypeFactory().constructMapType(mapClazz, keyClazz, valueClazz);
        try {
            return (M) OBJECT_MAPPER.readValue(bytes, (JavaType) mapType);
        } catch (IOException e) {
            throw new IllegalArgumentException(e.getMessage(), e);
        }
    }

    public static <K, V, M extends java.util.Map<K, V>> M parseMap(InputStream inputStream, Class<M> mapClazz, Class<K> keyClazz, Class<V> valueClazz) {
        MapType mapType = OBJECT_MAPPER.getTypeFactory().constructMapType(mapClazz, keyClazz, valueClazz);
        try {
            return (M) OBJECT_MAPPER.readValue(inputStream, (JavaType) mapType);
        } catch (IOException e) {
            throw new IllegalArgumentException(e.getMessage(), e);
        }
    }
}
