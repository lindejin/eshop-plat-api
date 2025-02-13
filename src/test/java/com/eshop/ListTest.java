package com.eshop;

import java.util.List;

public class ListTest {
    public static void main(String[] args) {
        try {
            List<Object> list = null;
            for (Object s : list) {
                System.out.println("a");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            List<Object> list = null;
            for (int i = 0; i < list.size(); i++) {
                System.out.println("a");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
