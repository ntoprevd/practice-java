package com.heima.demo;

public class FightTest {

    static void main(String[] args) {

        Role role_1 = new Role("乔青", 100);
        Role role_2 = new Role("斑鸠", 100);

        while(true){

            role_1.attack(role_2);
            if(role_2.getBlood() == 0){
                System.out.println(role_1.getName() + "K.O了" + role_2.getName());
                break;
            }

            role_2.attack(role_1);
            if(role_1.getBlood() == 0){
                System.out.println(role_2.getName() + "K.O了" + role_1.getName());
                break;
            }

        }
    }
}