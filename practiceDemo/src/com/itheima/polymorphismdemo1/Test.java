package com.itheima.polymorphismdemo1;

public class Test {
    public static void main(String[] args) {

        Animal a = new Dog();
        a.show();

        // 强制类型转换
        Dog d = (Dog) a;
        d.lookHome();

        a = new Cat();
        a.show();
        Cat c = (Cat) a;
        c.catchMouse();

        a = new Dog();
        if(a instanceof Dog d1){
            d1.lookHome();
        }
        if(a instanceof Cat c1){
            c1.catchMouse();
        }

    }
}
