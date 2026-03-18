package com.heima.demo2;

import java.util.Scanner;

public class ScannerDemo {

    static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入小数");

        double result = sc.nextDouble();
        System.out.println(result);
    }

}
