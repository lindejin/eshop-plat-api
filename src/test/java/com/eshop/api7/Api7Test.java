package com.eshop.api7;

public class Api7Test {

    public static void main(String[] args) {
        BusinessService businessService = new BusinessService();
        // 创建工具实例
        ToolUtils tool = new ToolUtils();

        // 设置回调（使用方法引用将BusinessService的handleSuccess方法传递给工具类）
        tool.setSuccessCallback(businessService::handleToolSuccess);

        // 执行工具操作
        tool.executeToolMethod("业务参数");
    }
}
