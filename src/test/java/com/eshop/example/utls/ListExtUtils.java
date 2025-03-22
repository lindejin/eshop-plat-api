package com.eshop.example.utls;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ListExtUtils {

    /**
     * 根据对象的某个属性去重（支持判空和空值处理）
     *
     * @param list         需要去重的集合
     * @param keyExtractor 提取属性的函数
     * @param <T>          集合元素类型
     * @param <R>          属性类型
     * @return 去重后的集合（如果 list 为 null，返回空集合）
     */
    public static <T, R> List<T> distinctByKey(List<T> list, Function<? super T, ? extends R> keyExtractor) {
        if (list == null || list.isEmpty()) {
            return Collections.emptyList(); // 如果 list 为 null 或空，返回空集合
        }
        return list.stream()
                .filter(Objects::nonNull) // 过滤掉 null 元素
                .filter(distinctByKeyPredicate(keyExtractor))
                .collect(Collectors.toList());
    }

    /**
     * 自定义去重 Predicate（支持判空和空值处理）
     *
     * @param keyExtractor 提取属性的函数
     * @param <T>          集合元素类型
     * @param <R>          属性类型
     * @return 去重 Predicate
     */
    private static <T, R> Predicate<T> distinctByKeyPredicate(Function<? super T, ? extends R> keyExtractor) {
        Map<R, Boolean> seen = new ConcurrentHashMap<>(); // 使用线程安全的 Map
        return t -> {
            R key = keyExtractor.apply(t);
            return key != null && seen.putIfAbsent(key, Boolean.TRUE) == null; // 如果 key 为 null，跳过
        };
    }

    /**
     * 直接去重（根据对象的 equals 和 hashCode 方法，支持判空）
     *
     * @param list 需要去重的集合
     * @param <T>  集合元素类型
     * @return 去重后的集合（如果 list 为 null，返回空集合）
     */
    public static <T> List<T> distinct(List<T> list) {
        if (list == null || list.isEmpty()) {
            return Collections.emptyList(); // 如果 list 为 null 或空，返回空集合
        }
        return list.stream()
                .filter(Objects::nonNull) // 过滤掉 null 元素
                .distinct()
                .collect(Collectors.toList());
    }

    /**
     * 从 List 中提取某个属性并去重
     *
     * @param list        需要处理的集合
     * @param keyExtractor 提取属性的函数
     * @param <T>         集合元素类型
     * @param <R>         属性类型
     * @return 去重后的属性列表（如果 list 为 null，返回空列表）
     */
    public static <T, R> List<R> distinctByValues(List<T> list, Function<? super T, ? extends R> keyExtractor) {
        if (list == null || list.isEmpty()) {
            return Collections.emptyList(); // 如果 list 为 null 或空，返回空列表
        }
        return list.stream()
                .filter(Objects::nonNull) // 过滤掉 null 元素
                .map(keyExtractor) // 提取属性
                .filter(Objects::nonNull) // 过滤掉属性值为 null 的情况
                .distinct() // 去重
                .collect(Collectors.toList());
    }
}