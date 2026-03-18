package com.itheima.polymorphismdemo1;

public class Cat extends Animal{
    @Override
    public void show() {
        System.out.println("Cat --- show");
    }

    public void catchMouse(){
        System.out.println("Cat catch mouse.");
    }
}
