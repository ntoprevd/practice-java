package com.heima.demo;

import java.util.Random;

public class Role{

    private String name;
    private int blood;

    public Role(){}

    public Role(String name, int blood){
        this.name = name;
        this.blood = blood;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBlood() {
        return blood;
    }

    public void setBlood(int blood) {
        this.blood = blood;
    }

    public void attack(Role role){

        Random r = new Random();
        int hurt = r.nextInt(20) + 1;

        int remainBlood = role.getBlood() - hurt;
        remainBlood = Math.max(remainBlood, 0);

        role.setBlood(remainBlood);
        System.out.println(this.getName() + "攻击了" + role.getName() +
                "，造成了" + hurt + "点伤害，" +
                role.getName() + "还剩" + role.getBlood() + "点血。");
    }
}
