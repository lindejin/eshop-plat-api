package com.eshop.example;


import com.google.common.collect.*;

import java.util.Arrays;
import java.util.List;

public class ListTest01 {
    public static void main(String[] args) {
        List<ShopDO> shopDOList = Arrays.asList(
                new ShopDO(1, "Shop A"),
                new ShopDO(2, "Shop B"),
                new ShopDO(1, "Shop A") // 重复元素
        );
        // 使用 Guava 的 Multimap 去重
        Multimap<Integer, ShopDO> multimap = ArrayListMultimap.create();
        for (ShopDO shop : shopDOList) {
            multimap.put(shop.getId(), shop);
        }

        // 提取去重后的结果
        List<ShopDO> uniqueList = multimap.keySet().stream()
                .map(key -> multimap.get(key).iterator().next()) // 获取每个组的第一个元素
                .collect(ImmutableList.toImmutableList());

        System.out.println(uniqueList); // 输出： [ShopDO{id=1, name='Shop A'}, ShopDO{id=2, name='Shop B'}]
    }
}