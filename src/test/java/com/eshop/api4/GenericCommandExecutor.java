package com.eshop.api4;

import java.util.HashMap;
import java.util.Map;

//3. 泛型参数化命令模式（更通用）
public class GenericCommandExecutor {
    public interface Command<T> {
        void execute(T context);
    }

    private static class EmailCommand implements Command<Map<String, String>> {
        @Override
        public void execute(Map<String, String> context) {
            System.out.println("发送邮件至: " + context.get("email"));
            System.out.println("主题: " + context.get("subject"));
            System.out.println("内容: " + context.get("body"));
        }
    }

    private Command<Map<String, String>> command;
    private Map<String, String> context;

    public void setCommand(Command<Map<String, String>> command, Map<String, String> context) {
        this.command = command;
        this.context = context;
    }

    public void executeCommand() {
        if (command != null) {
            command.execute(context);
        }
    }

    public static void main(String[] args) {
        GenericCommandExecutor executor = new GenericCommandExecutor();

        // 准备参数上下文
        Map<String, String> emailContext = new HashMap<>();
        emailContext.put("email", "user@example.com");
        emailContext.put("subject", "订单确认");
        emailContext.put("body", "您的订单已发货");

        // 设置命令和参数
        executor.setCommand(new EmailCommand(), emailContext);

        // 当满足条件时执行
        System.out.println("等待付款确认...");
        // 模拟等待条件满足
        try { Thread.sleep(2000); } catch (Exception ignored) {}

        System.out.println("付款完成，发送通知...");
        executor.executeCommand();
    }
}