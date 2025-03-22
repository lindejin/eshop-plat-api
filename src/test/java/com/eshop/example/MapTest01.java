package com.eshop.example;

import com.google.common.collect.Maps;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class MapTest01 {
    public static void main(String[] args) {
        List<ShopDO> shopDOList = Arrays.asList(
                new ShopDO(1, "Shop A"),
                new ShopDO(2, "Shop B")
        );

        // 使用 Guava 的 Maps.uniqueIndex
        Map<Integer, ShopDO> map = Maps.uniqueIndex(shopDOList, ShopDO::getId);

        System.out.println(map); // 输出：{1=Shop A, 2=Shop B}
    }
}
