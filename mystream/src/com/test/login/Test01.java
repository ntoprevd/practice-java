package com.test.login;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Test01 {

    static void main(String[] args) throws IOException {

        // 获取本地数据
        BufferedReader bw = new BufferedReader(new FileReader("src\\com\\test\\login\\userinfo.txt"));
        String line;
        line = bw.readLine();
        bw.close();

        // 获得正确用户名与密码
        String[] arr = line.split("&");
        String rightName = arr[0].split("=")[1];
        String rightPassword = arr[1].split("=")[1];

        // 用户输入
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名");
        String name = sc.nextLine();
        System.out.println("请输入密码");
        String password = sc.nextLine();

        // 判断
        if(rightName.equals(name) && rightPassword.equals(password)){
            System.out.println("登录成功");
        }else{
            System.out.println("登录失败");
        }
    }
}