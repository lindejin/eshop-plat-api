package com.eshop.example;

import com.eshop.example.utls.ListExtUtils;

import java.util.Arrays;
import java.util.List;

public class ListTest03 {

    public static void main(String[] args) {
        List<ShopDO> shopDOList = Arrays.asList(
                new ShopDO(1, "Shop A"),
                new ShopDO(2, "Shop B"),
                new ShopDO(1, "Shop A") // 重复元素
        );
        // 根据 id 属性去重
        List<ShopDO> uniqueListById = ListExtUtils.distinctByKey(shopDOList, ShopDO::getId);
        System.out.println(uniqueListById); // 输出： [ShopDO{id=1, name='Shop A'}, ShopDO{id=2, name='Shop B'}]

        // 直接去重（根据 equals 和 hashCode 方法）
        List<ShopDO> uniqueList = ListExtUtils.distinct(shopDOList);
        System.out.println(uniqueList); // 输出： [ShopDO{id=1, name='Shop A'}, ShopDO{id=2, name='Shop B'}]
    }


}
