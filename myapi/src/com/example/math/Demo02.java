package com.example.math;

public class Demo02 {

    public static void main() {

        // 判断一个数是否为质数
        boolean result1 = Demo02.isPrime(455);
        System.out.println(result1);

    }

    public static boolean isPrime(int num) {

        for (int i = 2; i <= Math.sqrt(num); i++) {

            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

}
