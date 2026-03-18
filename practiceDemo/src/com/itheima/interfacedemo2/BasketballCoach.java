package com.itheima.interfacedemo2;

public class BasketballCoach extends Coach{

    @Override
    public void teach() {
        System.out.println("篮球教练在教打篮球");
    }

    public BasketballCoach() {
    }

    public BasketballCoach(String name, String age) {
        super(name, age);
    }
}
