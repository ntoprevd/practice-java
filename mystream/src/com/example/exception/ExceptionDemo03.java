package com.example.exception;

import java.util.Scanner;

public class ExceptionDemo03 {

    static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        GirlFriend gf = new GirlFriend();

        while (true) {
            try {
                System.out.println("请输入女朋友名字：");
                String name = sc.nextLine();
                gf.setName(name);

                System.out.println("请输入女朋友年龄：");
                String ageStr = sc.nextLine();
                int age = Integer.parseInt(ageStr);
                gf.setAge(age);
                break;

            } catch (NumberFormatException e) {
                e.printStackTrace();
            } catch (AgeOutOfBoundsException e) {
                e.printStackTrace();
            } catch (NameFormatException e) {
                e.printStackTrace();
            }
        }

        System.out.println(gf);

    }
}
