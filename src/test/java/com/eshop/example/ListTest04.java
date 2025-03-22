package com.eshop.example;

import com.eshop.example.utls.ListExtUtils;

import java.util.Arrays;
import java.util.List;

public class ListTest04 {

    public static void main(String[] args) {
        List<ShopDO> shopDOList = Arrays.asList(
                new ShopDO(1, "Shop A"),
                new ShopDO(2, "Shop B"),
                new ShopDO(1, "Shop A") // 重复元素
        );
        // 提取 appId 并去重
        List<Integer> appIds = ListExtUtils.distinctByValues(shopDOList, ShopDO::getId);
        System.out.println(appIds); // 输出：[1, 2, 3]    }

    }
}
