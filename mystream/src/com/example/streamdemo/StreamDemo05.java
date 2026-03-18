package com.example.streamdemo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamDemo05 {

    static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();
        Collections.addAll(list, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        List<Integer> list1 = list.stream()
                .filter(s -> s % 2 == 0)
                .collect(Collectors.toList());
        System.out.println(list1);

        System.out.println("====================================");

        ArrayList<String> list2 = new ArrayList<>();
        Collections.addAll(list2, "zhangsan, 23", "lisi, 24", "wangwu, 25");

        Map<String, Integer> collect = list2.stream()
                .filter(s -> Integer.parseInt(s.split(", ")[1]) >= 24)
                .collect(Collectors.toMap(new Function<String, String>() {
                    @Override
                    public String apply(String s) {
                        return s.split(", ")[0];
                    }
                }, new Function<String, Integer>() {
                    @Override
                    public Integer apply(String s) {
                        return Integer.parseInt(s.split(", ")[1]);
                    }
                }));
        System.out.println(collect);

        Map<String, Integer> collect1 = list2.stream()
                .filter(s -> Integer.parseInt(s.split(", ")[1]) >= 24)
                .collect(Collectors
                        .toMap(s -> s.split(", ")[0],
                                s -> Integer.parseInt(s.split(", ")[1])));

        System.out.println(collect1);
    }
}
