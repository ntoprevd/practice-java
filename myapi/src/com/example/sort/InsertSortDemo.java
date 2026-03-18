package com.example.sort;

public class InsertSortDemo {

    static void main(String[] args) {

        // 插入排序

        int[] arr = {3, 5, 44, 38, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};

        // 找到无序的数字是从哪一个索引开始的
        int startIndex = 1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > arr[i + 1]) {
                startIndex = i + 1;
                break;
            }
        }

        // 遍历无序的数组部分，并插入
        for (int i = startIndex; i < arr.length; i++) {

            int j = i;

            // 依次向前比较
            while (j > 0 && (arr[j] < arr[j - 1])) {

                int temp = arr[j - 1];
                arr[j - 1] = arr[j];
                arr[j] = temp;
                j--;

            }
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");

        }
    }
}
