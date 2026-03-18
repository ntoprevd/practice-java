package com.example.test;

import java.util.Random;

public class Test01 {
    public static void main(String[] args) {

        // 定义一个一维数组
        int[] tempArr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9 ,10, 11, 12, 13, 14, 15};

        Random r = new Random();

        // 打乱数组顺序
        for (int i = 0; i < tempArr.length; i++) {

            // 生成一个随机数
            int index = r.nextInt(tempArr.length);

            // 遍历，换数
            int temp = tempArr[i];
            tempArr[i] = tempArr[index];
            tempArr[index] = temp;
        }

        // 定义一个二维数组
        int[][] date = new int[4][4];

        // 把一维数组的数放入二维数组

        // 法一：遍历一维数组
        for (int i = 0; i < tempArr.length; i++) {
            date[i / 4][i % 4] = tempArr[i];
        }

        // 法二：遍历二维数组
        int index = 0;
        for (int i = 0; i < date.length; i++) {
            for (int j = 0; j < date[i].length; j++) {
                date[i][j] = tempArr[index];
                index++;
            }
        }

    }
}
