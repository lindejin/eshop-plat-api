package com.eshop.api4;

import java.util.function.BiConsumer;

//4. 多类型参数的执行器（BiConsumer）
public class DualParamExecutor {
    private BiConsumer<String, Integer> task;
    private String param1;
    private Integer param2;

    public void setTask(BiConsumer<String, Integer> task, String param1, Integer param2) {
        this.task = task;
        this.param1 = param1;
        this.param2 = param2;
    }

    public void execute() {
        if (task != null) {
            task.accept(param1, param2);
        }
    }

    public static void main(String[] args) {
        DualParamExecutor executor = new DualParamExecutor();

        // 设置不同类型参数的任务
        executor.setTask(
                (name, age) -> System.out.println(name + "已经" + age + "岁了"),
                "张三", 28
        );

        // 模拟触发条件
        System.out.println("等待用户确认信息...");
        boolean userConfirmed = true; // 模拟用户确认操作

        if (userConfirmed) {
            executor.execute();
        }
    }
}
