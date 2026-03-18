package com.itheima.polymorphismdemo2;

public class Person {
    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    /*public void keepPet(Dog dog, String something){
        System.out.println("年龄为" + this.getAge() + "岁的" + this.getName() + "养了一只" + dog.getColor() + "颜色的" + dog.getAge() + "岁的狗");
        dog.eat(something);
    }

    public void keepPet(Cat cat, String something){
        System.out.println("年龄为" + this.getAge() + "岁的" + this.getName() + "养了一只" + cat.getColor() + "颜色的" + cat.getAge() + "岁的猫");
        cat.eat(something);
    }*/

    public void keepPet(Animal a, String something){
        if(a instanceof Dog d){
            System.out.println("年龄为" + this.getAge() + "岁的" + this.getName() + "养了一只" + a.getColor() + "颜色的" + a.getAge() + "岁的狗");
            d.eat(something);
            d.lookHome();
        } else if (a instanceof Cat c) {
            System.out.println("年龄为" + this.getAge() + "岁的" + this.getName() + "养了一只" + a.getColor() + "颜色的" + a.getAge() + "岁的猫");
            c.eat(something);
            c.catchMouse();
        }else{
            System.out.println("没有这个选项");
        }
    }
}
