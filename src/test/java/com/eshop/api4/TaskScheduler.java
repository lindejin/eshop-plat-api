package com.eshop.api4;

public class TaskScheduler {
    private Runnable delayedTask;

    public void scheduleTask(Runnable task) {
        this.delayedTask = task;
    }

    public void executeNow(String uuid) {
        System.out.println(uuid);
        if (delayedTask != null) {
            delayedTask.run(); // 在当前线程执行
        }
    }

    public static void main(String[] args) {
        TaskScheduler scheduler = new TaskScheduler();

        // 创建任务但不立即执行
        scheduler.scheduleTask(() -> {
            System.out.println("执行预定任务");
        });

        // ...其他代码...

        // 稍后执行任务（在当前线程）
        String uuid = "uuid";
        scheduler.executeNow(uuid);
    }
}
