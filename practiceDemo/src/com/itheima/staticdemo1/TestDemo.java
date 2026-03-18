package com.itheima.staticdemo1;

public class TestDemo {
    public static void main(String[] args) {

        int[] arr_1 = {1, 2, 3, 4, 5, 6, 7, 8};
        String s = ArrayUtil.printArr(arr_1);
        System.out.println(s);

        double[] arr_2 = {1.2, 3, 4.5, 6, 7.8};
        double ave = ArrayUtil.getAverage(arr_2);
        System.out.println(ave);

    }
}
