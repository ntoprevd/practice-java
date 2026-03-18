package com.itheima.extendsdemo2;

public class Husky extends Dog{
    public void raidHome(){
        System.out.println("哈士奇在拆家");
    }

    @Override
    public void eat(){
        System.out.println("哈士奇在吃狗粮");
    }
}
