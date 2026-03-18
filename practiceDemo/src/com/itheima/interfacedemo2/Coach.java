package com.itheima.interfacedemo2;

public abstract class Coach extends Person{

    public abstract void teach();

    public Coach() {
    }

    public Coach(String name, String age) {
        super(name, age);
    }
}
