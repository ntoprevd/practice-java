package com.example.search;

import java.util.ArrayList;

public class BasicSearchDemo01 {

    static void main(String[] args) {

        // 基本查找/顺序查找

        int[] arr = {12, 34, 89, 544, 23, 98, 98, 89, 87, 89, 0};
        int number = 89;

        System.out.println(isContain(arr, number));
        System.out.println(getIndex(arr, number));

        ArrayList<Integer> list = getAllIndex(arr, number);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }

    }

    // 是否存在于数组中
    public static boolean isContain(int[] arr, int num){

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == num){
                return true;
            }
        }
        return false;
    }
    
    // 存在则返回索引, 不考虑重复
    public static int getIndex(int[] arr, int num){
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == num){
                return i;
            }
        }
        return -1;
    }

    // 返回索引，考虑重复
    public static ArrayList<Integer> getAllIndex(int[] arr, int num){

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == num){
                list.add(i);
            }
        }

        return list;
    }
}
