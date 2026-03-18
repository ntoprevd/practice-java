package com.itheima.polymorphismdemo1;

public class Dog extends Animal{
    @Override
    public void show() {
        System.out.println("Dog --- show");
    }

    public void lookHome(){
        System.out.println("Dog look home.");
    }

}
