package com.eshop.api6;
// 依赖common-api
public class ToolUtils {
    private ToolCallback callback;

    public void setCallback(ToolCallback callback) {
        this.callback = callback;
    }

    public void executeToolMethod(String params) {
        try {
            System.out.println("执行工具方法: " + params);

            if (callback != null) {
                callback.onToolSuccess("工具操作成功: " + params);
            }
        } catch (Exception e) {
            // 错误处理
        }
    }
}
