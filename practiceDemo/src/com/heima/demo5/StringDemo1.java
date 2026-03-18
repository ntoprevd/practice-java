package com.heima.demo5;

import java.util.Scanner;

public class StringDemo1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个字符串：");
        String str;

        while (true) {
            str = sc.next();

            if (isNumber(str) && str.length() <= 9) {
                break;
            } else {
                System.out.println("字符串无效！请重新输入：");
            }
        }

        String luoMaNumber = changeToLuoMa(str);
        System.out.println(luoMaNumber);

    }

    public static boolean isNumber(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) > '9' || str.charAt(i) < '0') {
                return false;
            }
        }
        return true;
    }

    public static String changeToLuoMa(String str){

        String[] arr = {"", "Ⅰ", "Ⅱ", "Ⅲ", "Ⅳ", "Ⅴ", "Ⅵ", "Ⅶ", "Ⅷ", "Ⅸ"};
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            int c = str.charAt(i) - '0';
            sb.append(arr[c]);
        }
        return sb.toString();
    }
}