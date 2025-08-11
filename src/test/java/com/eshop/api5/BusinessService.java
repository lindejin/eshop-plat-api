package com.eshop.api5;

public class BusinessService {
    public void handleToolEvent(ToolUtils.ToolEvent event) {
        if ("SUCCESS".equals(event.getEventType())) {
            System.out.println("收到工具成功事件: " + event.getMessage());
            // 处理工具成功事件...
        }
    }

    public void performBusinessOperation() {
        ToolUtils tool = new ToolUtils();

        // 设置事件处理器
        tool.setEventPublisher(this::handleToolEvent);

        tool.executeToolMethod("业务参数");
    }
}
