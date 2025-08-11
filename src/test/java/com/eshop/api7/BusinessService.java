package com.eshop.api7;

public class BusinessService {
    public void handleToolSuccess(ToolUtils.ResultDTO result) {
        // 处理工具执行成功的业务逻辑
        System.out.println("Service处理结果: " + result.getMessage());
        // 这里执行实际的业务操作...
        System.out.println("这里执行实际的业务操作...");
    }

    public void performBusinessOperation() {
        // 创建工具实例
        ToolUtils tool = new ToolUtils();

        // 设置回调（使用方法引用）
        tool.setSuccessCallback(this::handleToolSuccess);

        // 执行工具操作
        tool.executeToolMethod("业务参数");
    }
}