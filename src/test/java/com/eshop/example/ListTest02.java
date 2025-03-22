package com.eshop.example;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Predicate;

import java.util.*;

public class ListTest02 {

    public static void main(String[] args) {
        List<ShopDO> shopDOList = Arrays.asList(
                new ShopDO(1, "Shop A"),
                new ShopDO(2, "Shop B"),
                new ShopDO(1, "Shop A") // 重复元素
        );

        // 根据 id 属性去重
        List<ShopDO> uniqueList = new ArrayList<>();
        Set<Integer> seenIds = new HashSet<>();
        CollectionUtils.select(shopDOList, new Predicate<ShopDO>() {
            @Override
            public boolean evaluate(ShopDO shop) {
                return seenIds.add(shop.getId()); // 如果 id 未出现过，则保留
            }
        }, uniqueList);

        System.out.println(uniqueList); // 输出： [ShopDO{id=1, name='Shop A'}, ShopDO{id=2, name='Shop B'}]
    }


}
