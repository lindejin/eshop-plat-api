package com.eshop.example;

import com.eshop.example.utls.MapExtUtils;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.map.HashedMap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class MapTest03 {
    public static void main(String[] args) {
        List<ShopDO> shopDOList = Arrays.asList(
                new ShopDO(1, "Shop A"),
                new ShopDO(1, "Shop A"),
                new ShopDO(1, "Shop A"),
                new ShopDO(1, "Shop AB"),
                new ShopDO(2, "Shop B")
        );

        // 保留最新的一个值
        Map<Integer, ShopDO> paMapNewest = MapExtUtils.toMapKeepNewest(shopDOList, ShopDO::getId, Function.identity());
        System.out.println("保留最新的一个值：" + paMapNewest); // 输出：{1=param3, 2=param2, 3=param4}

        // 保留最老的一个值
        Map<Integer, ShopDO> paMapOldest = MapExtUtils.toMapKeepOldest(shopDOList, ShopDO::getId, Function.identity());
        System.out.println("保留最老的一个值：" + paMapOldest); // 输出：{1=param1, 2=param2, 3=param4}
    }
}
