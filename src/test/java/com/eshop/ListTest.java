package com.eshop;

import lombok.val;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ListTest {
    public static void main(String[] args) {
//        try {
//            List<Object> list = null;
//            for (Object s : list) {
//                System.out.println("a");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        try {
//            List<Object> list = null;
//            for (int i = 0; i < list.size(); i++) {
//                System.out.println("a");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }


        List<Long> ids = Arrays.asList(5L, 2L, 8L);

        Long l = ids.stream()
                .max(Comparator.naturalOrder())
                .orElse(null);// 默认返回0或其他合理默认值
        System.out.println(l);

        Long ll = ids.stream()
                .max(Long::compareTo)
                .orElse(null);// 默认返回0或其他合理默认值
        System.out.println(ll);

    }
}
