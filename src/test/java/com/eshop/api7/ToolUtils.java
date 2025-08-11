package com.eshop.api7;

import java.util.function.Consumer;

public class ToolUtils {
    // 成功回调函数定义（使用Java8的Consumer）
    private Consumer<ResultDTO> successCallback;

    // 设置成功回调
    public void setSuccessCallback(Consumer<ResultDTO> callback) {
        this.successCallback = callback;
    }

    // 执行工具方法
    public void executeToolMethod(String params) {
        try {
            // 模拟工具方法执行
            System.out.println("执行工具方法: " + params);

            // 构造结果对象
            ResultDTO result = new ResultDTO("SUCCESS", "操作成功完成");

            // 如果设置了回调，执行回调
            if (successCallback != null) {
                successCallback.accept(result);
            }
        } catch (Exception e) {
            // 错误处理
        }
    }

    // 结果DTO（作为工具模块的内部类）
    public static class ResultDTO {
        private final String status;
        private final String message;

        public ResultDTO(String status, String message) {
            this.status = status;
            this.message = message;
        }

        public String getStatus() { return status; }
        public String getMessage() { return message; }
    }
}
