package com.itheima.interfacedemo1;

public class Dog extends Animal implements swim{
    @Override
    public void eat() {
        System.out.println("狗吃骨头");
    }

    @Override
    public void swim() {
        System.out.println("狗刨");
    }

    public Dog() {
    }

    public Dog(String name, String age) {
        super(name, age);
    }
}
