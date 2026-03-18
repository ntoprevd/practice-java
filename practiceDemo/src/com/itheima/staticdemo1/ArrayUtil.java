package com.itheima.staticdemo1;

public class ArrayUtil {

    // 私有化构造方法
    private ArrayUtil(){}

    // 方法

    // 返回整数数组内容
    public static String printArr(int[] arr){

        StringBuilder sb = new StringBuilder();
        sb.append("[");

        for (int i = 0; i < arr.length; i++) {
            if(i == arr.length - 1){
                sb.append(arr[i]);
            }
            else{
                sb.append(arr[i]).append(", ");
            }
        }

        sb.append("]");
        return sb.toString();
    }

    // 返回平均分
    public static double getAverage(double[] arr){

        double sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
        }
        return sum/ arr.length;
    }
}
