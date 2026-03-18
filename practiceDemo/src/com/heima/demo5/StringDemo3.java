package com.heima.demo5;

import java.util.Scanner;

public class StringDemo3 {
    public static void main(String[] args) {
        // 1. 定义两个字符串
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入第一个字符串：");
        String strA = sc.next();
        System.out.println("请输入第二个字符串：");
        String strB = sc.next();

        // 2. 对第一个字符串进行旋转操作
        // strA = rotate(strA);

        // 3. 旋转之后的字符要比较，并输出true or false
        boolean result = isSame(strA, strB);
        System.out.println(result);
    }

    // 方法一：使用substring
    public static String rotate(String strA) {
        char first = strA.charAt(0);
        String end = strA.substring(1);

        return end + first;
    }

    // 方法二：使用数组
    public static String arrRotate(String strA){
        char[] arr = strA.toCharArray();
        char first = arr[0];
        for (int i = 1; i < arr.length; i++) {
            arr[i - 1] = arr[i];
        }
        arr[arr.length - 1] = first;
        return new String(arr);
    }

    public static boolean isSame(String strA, String strB) {
        for (int i = 0; i < strA.length(); i++) {
            strA = rotate(strA);
            if (strA.equals(strB)) {
                return true;
            }
        }
        return false;
    }
}