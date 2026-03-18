package com.itheima.interfacedemo2;

public class BasketballSporter extends Sporter{

    @Override
    public void study() {
        System.out.println("篮球运动员在学习打篮球");
    }

    public BasketballSporter() {
    }

    public BasketballSporter(String name, String age) {
        super(name, age);
    }
}
