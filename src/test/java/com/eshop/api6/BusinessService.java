package com.eshop.api6;

// 同样依赖common-api
public class BusinessService implements ToolCallback {

    @Override
    public void onToolSuccess(String resultMessage) {
        System.out.println("Service处理回调: " + resultMessage);
        // 执行业务逻辑...
    }
}
