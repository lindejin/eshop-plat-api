package com.eshop.api4;

import java.util.function.Consumer;

//2. 使用Java内置Consumer接口（多个参数）
public class MultiParamExecutor {
    private Consumer<String[]> task;
    private String[] params;

    public void setTask(Consumer<String[]> task, String... params) {
        this.task = task;
        this.params = params;
    }

    public void execute() {
        if (task != null) {
            task.accept(params);
        }
    }

    public static void main(String[] args) {
        MultiParamExecutor executor = new MultiParamExecutor();

        // 设置带多个参数的任务
        executor.setTask(
                (params) -> {
                    System.out.println("收到 " + params.length + " 个参数");
                    for (String p : params) {
                        System.out.println("处理参数: " + p);
                    }
                },
                "Java", "Python", "JavaScript", "C++"
        );

        // 在需要时执行
        if (Math.random() > 0.5) {
            System.out.println("立即执行任务...");
            executor.execute();
        } else {
            System.out.println("稍后执行任务...");
            // ...其他操作...
            executor.execute();
        }
    }
}