package com.eshop.api4;

//1. 使用自定义函数式接口（单个参数）
public class ParamExecutor {
    @FunctionalInterface
    public interface Task<T> {
        void execute(T param);
    }

    private Task<String> task; // 支持泛型
    private String param;

    public void setTask(Task<String> task, String param) {
        this.task = task;
        this.param = param;
    }

    public void execute() {
        if (task != null) {
            task.execute(param);
        }
    }

    public static void main(String[] args) {
        ParamExecutor executor = new ParamExecutor();

        // 设置带参数的任务
        executor.setTask(
                (str) -> System.out.println("执行任务: " + str.toUpperCase()),
                "hello world"
        );

        // 延迟执行
        System.out.println("等待3秒...");
        try { Thread.sleep(3000); } catch (Exception ignored) {}

        executor.execute();
    }
}
