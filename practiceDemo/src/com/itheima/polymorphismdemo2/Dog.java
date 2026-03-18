package com.itheima.polymorphismdemo2;

public class Dog extends Animal{
    public Dog() {
    }

    public Dog(String color, int age) {
        super(color, age);
    }

    @Override
    public void eat(String something) {
        System.out.println(getAge() + "岁的" + getColor() + "颜色的狗在吃" + something);
    }

    public void lookHome(){
        System.out.println("狗在看家");
    }

}
