package com.init.demo03;

public class Test {
    static void main(String[] args) {

        Mythread t1 = new Mythread();
        OtherThread ot = new OtherThread();

        t1.setName("线程1");
        ot.setName("守护线程");

        ot.setDaemon(true);

        t1.start();
        ot.start();
    }
}
