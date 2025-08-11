package com.eshop.api6;


public class Api6Test {

    public static void main(String[] args) {
        BusinessService businessService = new BusinessService();
        ToolUtils tool = new ToolUtils();

        // 设置事件处理器
        tool.setCallback(businessService);

        tool.executeToolMethod("业务参数");
    }
}
