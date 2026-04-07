package com.init.demo;

public class Test01{

    static void main(String[] args) {

        MyThread th1 = new MyThread();
        MyThread th2 = new MyThread();

        th1.setName("Thread1");
        th2.setName("Thread2");

        th1.start();
        th2.start();
    }
}
