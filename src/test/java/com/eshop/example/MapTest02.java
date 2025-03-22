package com.eshop.example;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.map.HashedMap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapTest02 {
    public static void main(String[] args) {
        List<ShopDO> shopDOList = Arrays.asList(
                new ShopDO(1, "Shop A"),
                new ShopDO(2, "Shop B")
        );

        // 使用 Apache Commons 的 MapUtils 和 CollectionUtils 转换为 Map
        Map<Integer, ShopDO> map = new HashMap<>();
        CollectionUtils.forAllDo(shopDOList, shop -> map.put(shop.getId(), shop));

        // 输出 Map
        System.out.println(map); // 输出：{1=Shop A, 2=Shop B}

        // 方式 1：使用 Java 自带的 Map 遍历方法
        System.out.println("遍历方式 1：使用 Java 自带的 Map 遍历方法");
        for (Map.Entry<Integer, ShopDO> entry : map.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }

        // 方式 2：使用 Apache Commons 的 MapIterator
        System.out.println("遍历方式 2：使用 Apache Commons 的 MapIterator");
        MapIterator<Integer, ShopDO> iterator = new HashedMap<>(map).mapIterator();
        while (iterator.hasNext()) {
            Integer key = iterator.next();
            ShopDO value = iterator.getValue();
            System.out.println("Key: " + key + ", Value: " + value);
        }
    }
}
