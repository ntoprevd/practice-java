package com.heima.demo4;

import java.util.Scanner;

public class StringDemo3 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入字符串：");
        String str = sc.next();

        String result = reverse(str);
        System.out.println(result);

    }
    public static String reverse(String str){

        String result = "";
        for (int i = str.length() - 1; i >= 0; i--) {
        result = result + str.charAt(i);
        }
        return result;
    }
}
