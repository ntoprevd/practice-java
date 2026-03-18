package com.itheima.interfacedemo1;

public class Frog extends Animal implements swim {

    @Override
    public void eat() {
        System.out.println("青蛙吃虫子");
    }

    @Override
    public void swim() {
        System.out.println("蛙泳");
    }

    public Frog() {
    }

    public Frog(String name, String age) {
        super(name, age);
    }
}
