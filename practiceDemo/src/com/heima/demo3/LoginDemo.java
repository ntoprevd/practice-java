package com.heima.demo3;

import java.util.Scanner;

public class LoginDemo {
    public static void main(String[] args) {

        String rightUsername = "zhangsan";
        String rightPassword = "123456";

        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 3; i++) {

            System.out.println("请输入用户名：");
            String username = sc.next();
            System.out.println("请输入密码：");
            String password = sc.next();

            if (username.equals(rightUsername) && password.equals(rightPassword)) {
                System.out.println("登录成功！");
                break;
            }
            else{
                if(i == 2){
                    System.out.println("账户已锁定！请联系管理员解锁：xxx-xxxx");
                }
                else{
                    System.out.println("登录失败！请检查用户名或密码");
                }
            }
        }
    }
}
