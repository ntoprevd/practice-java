package com.example.sort;

public class RecursionDemo01 {

    static void main(String[] args) {

        // 递归求和
        /*
        * 1 ~ 100 = 100 + 1 ~ 99
        * 1 ~ 99 = 99 + 1 ~ 98
        * 1 ~ 98 = 98 + 1 ~ 97
        * ...
        * 1 ~ 2 = 2 + 1 ~ 1
        * 1 ~ 1 = 1（出口）
        *
        * getSum(100)  = 100 + getSum(99)
        * getSum(99) = 99 + getSum(98)
        * getSum(98) = 98 + getSum(97)
        * ...
        * getSum(2) = 2 + getSum(1)
        * getSum(1) = 1(出口)
        * */

        // 递归求阶乘
        /*
        * getFact(100) = 100 * getFact(99)
        * getFact(99) = 99 * getFact(98)
        * ...
        * getFact(3) = 3 * getFact(2)
        * getFact(2) = 2 * getFact(1)
        * getFact(1) = 1
        * getFact(0) = 1
        * */


        System.out.println(getSum(100));
        System.out.println(getFactorial(5));

    }

    // 递归求和
    public static int getSum(int number){

        if(number == 1){
            return 1;
        }

        return number + getSum(number - 1);

    }

    // 递归求阶乘
    public static int getFactorial(int number){

        if(number == 1 || number == 0){
            return 1;
        }

        return number * getFactorial(number - 1);

    }

}
