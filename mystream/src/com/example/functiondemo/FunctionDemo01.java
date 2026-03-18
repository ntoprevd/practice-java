package com.example.functiondemo;

import java.util.ArrayList;
import java.util.Collections;

public class FunctionDemo01 {

    static void main(String[] args) {

        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, "1", "2", "3", "4", "5");
        
        // 常规

        /*ArrayList<Integer> numList = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            int num = Integer.parseInt(list.get(i));
            numList.add(num);
        }

        System.out.println(numList);*/

        // 匿名内部类

        /*list.stream()
                .map(new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return Integer.parseInt(s);
            }
        })
                .forEach(s -> System.out.println(s));*/

        // lambda

        /*list.stream()
                .map(s -> Integer.parseInt(s))
                .forEach(s -> System.out.println(s));*/

        // 方法引用

        list.stream()
                .map(Integer::parseInt)
                .forEach(System.out::println);
    }
}
