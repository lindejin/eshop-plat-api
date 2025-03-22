package com.eshop.example;

import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.map.HashedMap;

import java.util.HashMap;
import java.util.Map;

public class ApacheCommonsMapDemo {
    public static void main(String[] args) {
        // 创建一个 Map
        Map<Integer, String> map = new HashMap<>();

        map.put(1, "Apple");
        map.put(2, "Banana");
        map.put(3, "Cherry");

        HashedMap<Integer, String> hashedMap = new HashedMap<>(map);

        // 使用 MapIterator 遍历 Map
        MapIterator<Integer, String> iterator = hashedMap.mapIterator();
        while (iterator.hasNext()) {
            Integer key = iterator.next();
            String value = iterator.getValue();
            System.out.println("Key: " + key + ", Value: " + value);
        }
    }
}
