package com.example.exception;

public class GirlFriend {

    private String name;
    private int age;

    public GirlFriend() {
    }

    public GirlFriend(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name){

        if(name.length() < 2 || name.length() > 18){
            throw new NameFormatException(name + "长度应在2~18内");
        }
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {

        if(age < 19 || age > 50){
            throw new AgeOutOfBoundsException(age + "应在19~50内");
        }
        this.age = age;
    }

    @Override
    public String toString(){
        return "GirlFriend{ name = "+ name + ", age = "+ age +" }";
    }
}
