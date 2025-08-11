package com.eshop.api5;

import java.util.function.Consumer;

public class ToolUtils {
    // 成功事件发布器
    private Consumer<ToolEvent> eventPublisher;

    public void setEventPublisher(Consumer<ToolEvent> publisher) {
        this.eventPublisher = publisher;
    }

    public void executeToolMethod(String params) {
        try {
            System.out.println("执行工具方法: " + params);

            // 如果设置了事件发布器，发布成功事件
            if (eventPublisher != null) {
                ToolEvent event = new ToolEvent("SUCCESS", "操作成功", params);
                eventPublisher.accept(event);
            }
        } catch (Exception e) {
            // 错误处理
        }
    }

    // 工具事件类
    public static class ToolEvent {
        private final String eventType;
        private final String message;
        private final String params;

        public ToolEvent(String eventType, String message, String params) {
            this.eventType = eventType;
            this.message = message;
            this.params = params;
        }

        public String getEventType() { return eventType; }
        public String getMessage() { return message; }
        public String getParams() { return params; }
    }
}