package com.init.demo;

import java.util.concurrent.FutureTask;

public class Test03 {

    static void main(String[] args) throws Exception {

        // 创建MyCallable的对象(表示多线程要执行的任务)
        MyCallable mc = new MyCallable();

        // 创建FutureTask的对象(作用管理多线程运行的结果)
        FutureTask<Integer> ft = new FutureTask<>(mc);

        // 创建线程的对象
        Thread t = new Thread(ft);

        // 启动线程
        t.start();

        // 获取多线程运行的结果
        Integer result = ft.get();
        System.out.println(result);
    }
}
