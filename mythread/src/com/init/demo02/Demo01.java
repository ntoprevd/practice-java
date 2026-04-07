package com.init.demo02;

public class Demo01 {

    static void main(String[] args) {

        MyRunnable mr = new MyRunnable();

        Thread t1 = new Thread(mr, "线程1");
        Thread t2 = new Thread(mr, "线程2");

        // 线程优先级
        t1.setPriority(10);
        t2.setPriority(1);

        t1.start();
        t2.start();
    }
}
