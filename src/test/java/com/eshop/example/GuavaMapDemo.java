package com.eshop.example;

import com.google.common.collect.Maps;
import org.apache.commons.collections4.map.HashedMap;

import java.util.HashMap;
import java.util.Map;

public class GuavaMapDemo {
    public static void main(String[] args) {
        // 创建一个 Map
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Apple");
        map.put(2, "Banana");
        map.put(3, "Cherry");

        // 将普通 Map 转换为 HashedMap
        HashedMap<Integer, String> hashedMap = new HashedMap<>(map);

        // 使用 Java 的 Map 遍历方法
        System.out.println("使用 Java 的 Map 遍历方法：");
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }

        // 使用 Guava 的 Maps.filterEntries 过滤遍历
        System.out.println("使用 Guava 的 Maps.filterEntries 过滤遍历：");
        Map<Integer, String> filteredMap = Maps.filterEntries(map, entry -> entry.getKey() % 2 == 0);
        filteredMap.forEach((key, value) -> System.out.println("Key: " + key + ", Value: " + value));
    }
}
