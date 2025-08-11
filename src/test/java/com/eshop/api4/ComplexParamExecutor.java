package com.eshop.api4;

//5. 参数工厂模式（复杂参数构建）
public class ComplexParamExecutor {
    public interface ParamBuilder {
        Object[] buildParams();
    }

    public interface Task {
        void execute(Object[] params);
    }

    private Task task;
    private ParamBuilder paramBuilder;

    public void setTask(Task task, ParamBuilder paramBuilder) {
        this.task = task;
        this.paramBuilder = paramBuilder;
    }

    public void execute() {
        if (task != null && paramBuilder != null) {
            Object[] params = paramBuilder.buildParams();
            task.execute(params);
        }
    }

    public static void main(String[] args) {
        ComplexParamExecutor executor = new ComplexParamExecutor();

        // 设置任务和参数生成器
        executor.setTask(
                params -> {
                    System.out.println("处理订单:");
                    System.out.println("订单号: " + params[0]);
                    System.out.println("商品: " + params[1]);
                    System.out.println("数量: " + params[2]);
                    System.out.println("总价: " + params[3]);
                },
                () -> {
                    // 在需要执行时才会构建参数
                    System.out.println("构建参数...");
                    return new Object[]{"ORD-20230811", "Java编程书籍", 3, 299.97};
                }
        );

        // 稍后执行（此时参数才会被构建）
        System.out.println("订单处理中...");
        executor.execute();
    }
}
//参数传递模式对比
//方法	参数支持	延迟构建	使用场景
//函数式接口	单个参数	❌	简单任务
//BiConsumer	两个参数	❌	双参数场景
//命令模式	上下文对象	✅	复杂业务逻辑
//参数工厂	动态构建	✅	参数值需要计算时