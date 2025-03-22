package com.eshop.example.utls;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MapExtUtils {

    /**
     * 将 List 转换为 Map，保留最新的一个值
     *
     * @param list        需要转换的集合
     * @param keyMapper   提取键的函数
     * @param valueMapper 提取值的函数
     * @param <K>         键类型
     * @param <V>         值类型
     * @param <T>         集合元素类型
     * @return 转换后的 Map（如果 list 为 null，返回空 Map）
     */
    public static <K, V, T> Map<K, V> toMapKeepNewest(List<T> list, Function<? super T, ? extends K> keyMapper, Function<? super T, ? extends V> valueMapper) {
        if (list == null || list.isEmpty()) {
            return Collections.emptyMap(); // 如果 list 为 null 或空，返回空 Map
        }
        return list.stream()
                .filter(Objects::nonNull) // 过滤掉 null 元素
                .collect(Collectors.toMap(
                        keyMapper,
                        valueMapper,
                        (oldVal, newVal) -> newVal // 保留最新的一个值
                ));
    }

    /**
     * 将 List 转换为 Map，保留最老的一个值
     *
     * @param list        需要转换的集合
     * @param keyMapper   提取键的函数
     * @param valueMapper 提取值的函数
     * @param <K>         键类型
     * @param <V>         值类型
     * @param <T>         集合元素类型
     * @return 转换后的 Map（如果 list 为 null，返回空 Map）
     */
    public static <K, V, T> Map<K, V> toMapKeepOldest(List<T> list, Function<? super T, ? extends K> keyMapper, Function<? super T, ? extends V> valueMapper) {
        if (list == null || list.isEmpty()) {
            return Collections.emptyMap(); // 如果 list 为 null 或空，返回空 Map
        }
        return list.stream()
                .filter(Objects::nonNull) // 过滤掉 null 元素
                .collect(Collectors.toMap(
                        keyMapper,
                        valueMapper,
                        (oldVal, newVal) -> oldVal // 保留最老的一个值
                ));
    }
}