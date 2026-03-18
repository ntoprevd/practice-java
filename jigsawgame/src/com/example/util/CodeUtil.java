package com.example.util;

import java.util.ArrayList;
import java.util.Random;

public class CodeUtil {

    // 生成验证码
    public static String getCode(){

        // 一个集合存放字母
        ArrayList<Character> list = new ArrayList<>();

        // 添加a-z，A-Z
        for (int i = 0; i < 26; i++) {
            list.add((char)('a' + i));
            list.add((char)('A' + i));
        }

        // 随机数
        Random r = new Random();

        // 创建StringBuilder容器
        StringBuilder sb = new StringBuilder();

        // 随机获取四位字母并添加进StringBuilder
        for (int i = 0; i < 4; i++) {
            int index = r.nextInt(list.size());
            char ch = list.get(index);
            sb.append(ch);
        }

        // 随机一位数字
        int num = r.nextInt(10);
        sb.append(num);

        // 将sb转换为数组，更好添加
        int index = r.nextInt(5);
        char[] arr =  sb.toString().toCharArray();
        int temp = arr[index];
        arr[index] = arr[arr.length - 1];
        arr[arr.length - 1] = (char)temp;

        // 把数组转换成字符串并返回
        return new String(arr);
    }

}
