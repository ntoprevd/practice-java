package com.heima.demo5;

import java.util.Scanner;

public class StringDemo2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个字符串：");
        String str;

        while (true) {
            str = sc.next();

            if (checkStr(str)) {
                break;
            } else {
                System.out.println("输入无效！请重新输入：");
            }
        }

        String LuoMa = getLuoMa(str);
        System.out.println(LuoMa);

    }

    public static boolean checkStr(String str) {

        if (str.length() > 9) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) < '0' || str.charAt(i) > '9') {
                return false;
            }
        }
        return true;
    }

    public static String getLuoMa(String str){

        StringBuilder sc = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char number = str.charAt(i);
            sc.append(changeToLuoMa(number));
        }
    return sc.toString();
    }

    public static String changeToLuoMa(char number){

        String str;
        switch (number){
            case '1' -> str = "Ⅰ";
            case '2' -> str = "Ⅱ";
            case '3' -> str = "Ⅲ";
            case '4' -> str = "Ⅳ";
            case '5' -> str = "Ⅴ";
            case '6' -> str = "Ⅵ";
            case '7' -> str = "Ⅶ";
            case '8' -> str = "Ⅷ";
            case '9' -> str = "Ⅸ";
            default -> str = "";
        }
        return str;
    }

}
