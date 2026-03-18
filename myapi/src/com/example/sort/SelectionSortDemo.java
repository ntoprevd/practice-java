package com.example.sort;

public class SelectionSortDemo {

    static void main(String[] args) {

        // 选择排序

        int[] arr = { 8, 4, 7, 5, 2, 9, 3, 6, 1};

        // 外循环：要循环几次，这一个循环要拿着哪个索引与后面进行比较
        // 内循环：这一轮循环的具体行为
        for (int i = 0; i < arr.length - 1; i++) {

            for (int j = i + 1; j < arr.length; j++) {

                if(arr[i] > arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

    }
}
