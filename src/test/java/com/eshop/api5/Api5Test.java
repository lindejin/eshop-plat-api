package com.eshop.api5;

public class Api5Test {

    public static void main(String[] args) {
        BusinessService businessService = new BusinessService();
        ToolUtils tool = new ToolUtils();

        // 设置事件处理器
        tool.setEventPublisher(businessService::handleToolEvent);

        tool.executeToolMethod("业务参数");
    }
}
