package com.itheima.interfacedemo1;

public class Test {

    public static void main(String[] args) {
        Dog d = new Dog("小黄", "2");
        System.out.println(d.getName() + d.getAge() + "岁了");
        d.eat();
        d.swim();

        Rabbit r = new Rabbit("小白", "2");
        System.out.println(r.getName() + r.getAge() + "岁了");
        r.eat();

        Frog f = new Frog("小绿", "3");
        System.out.println(f.getName() + f.getAge() + "岁了");
        f.eat();
        f.swim();
    }
}
