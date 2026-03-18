package com.example.search;

public class BinarySearchDemo01 {

    public static void main(String[] args) {

        // 二分查找\折半查找: 数据需要有顺序

        int[] arr = {1, 14, 16, 27, 36, 36, 36, 37, 37, 49, 50, 69, 89, 99};
        int number01 = 1;
        int number02 = 36;
        int number03 = 59;

        System.out.println(getIndex(arr, number01));
        System.out.println(getIndex(arr, number02));
        System.out.println(getIndex(arr, number03));

    }

    public static int getIndex(int[] arr, int num) {

        // 定义min、max、mid
        int min = 0;
        int max = arr.length - 1;

        while(true){

            if(min > max){
                return -1;
            }

            int mid = (min + max) / 2;

            // 三种情况：mid比数小，mid比数大，mid和数一样
            if(arr[mid] > num){
                max = mid - 1;
            } else if (arr[mid] < num) {
                min = mid + 1;
            } else{
                return mid;
            }

        }

    }
}
