package com.itheima.polymorphismdemo2;

public class Test {
    public static void main(String[] args) {

        /*Person p1 = new Person("张三", 30);
        Dog d = new Dog("黑", 1);
        p1.keepPet(d, "骨头");
        d.lookHome();

        Person p2 = new Person("李四", 40);
        Cat c = new Cat("蓝", 2);
        p2.keepPet(c, "小鱼干");
        c.catchMouse();*/

        Person p = new Person("赵一", 25);
        Dog a1 = new Dog("白", 2);
        p.keepPet(a1, "剩饭");


        Cat a2 = new Cat("灰", 1);
        p.keepPet(a2, "熊掌");

    }
}
