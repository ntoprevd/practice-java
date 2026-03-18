package com.heima.demo4;

public class StringDemo2 {
    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4};
        String result = splicing(arr);
        System.out.println(result);
    }

    public static String splicing(int[] arr){

        String result = "[";

        for (int i = 0; i <
                arr.length; i++) {

            if(i == arr.length - 1){
                result = result + arr[i];
            }
            else{
                result = result + arr[i] + ", ";
            }
        }
        result = result + "]";
        return result;
    }
}
