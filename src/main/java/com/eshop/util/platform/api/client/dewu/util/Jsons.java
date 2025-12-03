package com.eshop.util.platform.api.client.dewu.util;

import com.fasterxml.jackson.core.type.TypeReference;

import java.io.InputStream;
import java.lang.reflect.Type;

public class Jsons {
    public static <T> String toJson(T object) {
        return JacksonResolver.toJson(object);
    }

    public static <T> String toNullJson(T object) {
        return JacksonResolver.toNullJson(object);
    }

    public static <T> byte[] toBytes(T object) {
        return JacksonResolver.toBytes(object);
    }

    public static <T> String toPrettyJson(T object) {
        return JacksonResolver.toPrettyJson(object);
    }

    public static <T> T parse(String json, Class<T> clazz) {
        return JacksonResolver.parse(json, clazz);
    }

    public static <T> T parse(byte[] bytes, Class<T> clazz) {
        return JacksonResolver.parse(bytes, clazz);
    }

    public static <T> T parse(InputStream inputStream, Class<T> clazz) {
        return JacksonResolver.parse(inputStream, clazz);
    }

    public static <T> T parse(String json, Type type) {
        return JacksonResolver.parse(json, type);
    }

    public static <T> T parse(byte[] bytes, Type type) {
        return JacksonResolver.parse(bytes, type);
    }

    public static <T> T parse(InputStream inputStream, Type type) {
        return JacksonResolver.parse(inputStream, type);
    }

    public static <T> T parse(String json, TypeReference<T> typeReference) {
        return JacksonResolver.parse(json, typeReference);
    }

    public static <T> T parse(byte[] bytes, TypeReference<T> typeReference) {
        return JacksonResolver.parse(bytes, typeReference);
    }

    public static <T> T parse(InputStream inputStream, TypeReference<T> typeReference) {
        return JacksonResolver.parse(inputStream, typeReference);
    }

    public static <E, C extends java.util.Collection<E>> C parseCollection(String json, Class<C> collectionClazz, Class<E> elementClazz) {
        return JacksonResolver.parseCollection(json, collectionClazz, elementClazz);
    }

    public static <E, C extends java.util.Collection<E>> C parseCollection(byte[] bytes, Class<C> collectionClazz, Class<E> elementClazz) {
        return JacksonResolver.parseCollection(bytes, collectionClazz, elementClazz);
    }

    public static <E, C extends java.util.Collection<E>> C parseCollection(InputStream inputStream, Class<C> collectionClazz, Class<E> elementClazz) {
        return JacksonResolver.parseCollection(inputStream, collectionClazz, elementClazz);
    }

    public static <K, V, M extends java.util.Map<K, V>> M parseMap(String json, Class<M> mapClazz, Class<K> keyClazz, Class<V> valueClazz) {
        return JacksonResolver.parseMap(json, mapClazz, keyClazz, valueClazz);
    }

    public static <K, V, M extends java.util.Map<K, V>> M parseMap(byte[] bytes, Class<M> mapClazz, Class<K> keyClazz, Class<V> valueClazz) {
        return JacksonResolver.parseMap(bytes, mapClazz, keyClazz, valueClazz);
    }

    public static <K, V, M extends java.util.Map<K, V>> M parseMap(InputStream inputStream, Class<M> mapClazz, Class<K> keyClazz, Class<V> valueClazz) {
        return JacksonResolver.parseMap(inputStream, mapClazz, keyClazz, valueClazz);
    }
}
