package com.itheima.polymorphismdemo2;

public class Cat extends Animal{
    public Cat() {
    }

    public Cat(String color, int age) {
        super(color, age);
    }

    @Override
    public void eat(String something) {
        System.out.println(getAge() + "岁的" + getColor() + "颜色的猫在吃" + something);
    }

    public void catchMouse(){
        System.out.println("猫在抓老鼠");
    }

}
