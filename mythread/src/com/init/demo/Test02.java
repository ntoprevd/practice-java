package com.init.demo;

public class Test02 {

    static void main(String[] args) {

        // 创建myrun类的对象
        MyRun mr = new MyRun();

        // 创建Thread类的对象
        Thread t1 = new Thread(mr);
        Thread t2 = new Thread(mr);

        // 命名
        t1.setName("线程1");
        t2.setName("线程2");

        // 启动
        t1.start();
        t2.start();
    }
}
