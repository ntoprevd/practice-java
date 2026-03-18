package com.itheima.interfacedemo1;

public class Rabbit extends Animal{

    @Override
    public void eat() {
        System.out.println("兔子吃胡萝卜");
    }

    public Rabbit() {
    }

    public Rabbit(String name, String age) {
        super(name, age);
    }
}
