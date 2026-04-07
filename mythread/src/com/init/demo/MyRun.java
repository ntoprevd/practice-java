package com.init.demo;

public class MyRun implements Runnable{
    @Override
    public void run() {

        for (int i = 0; i < 70; i++) {

            Thread t = Thread.currentThread();

            System.out.println(t.getName() + "HelloWorld!");
        }
    }
}
