package com.heima.demo4;

public class StringBuilderDemo1 {
    public static void main(String[] args) {

        // 1. 创建对象
        StringBuilder sb = new StringBuilder();
        System.out.println(sb);

        // 2. 添加
        sb.append("AWE");
        sb.append("BBE");
        sb.append("CCR");

        System.out.println(sb);

        // 3. 反转
        sb.reverse();
        System.out.println(sb);

        // 4. 获取长度
        int len = sb.length();
        System.out.println(len);

        // 5. 转换成String
        String str = sb.toString();
        System.out.println(str);
    }
}
