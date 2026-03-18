package com.example.streamdemo;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamDemo04 {

    static void main(String[] args) {

        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, "张无忌-男-15","周芷若-女-20", "赵敏-女-25", "张强-男-100", "张三丰-男-35", "张翠山-女-40", "张良-你男-45", "王二麻子-男-50", "谢广坤-男-55");

        // list
        List<String> list1 = list.stream().filter(s -> "男".equals(s.split("-")[1])).toList();
        System.out.println(list1);

        // set
        Set<String> collect = list.stream().filter(s -> "男".equals(s.split("-")[1])).collect(Collectors.toSet());
        System.out.println(collect);

        // map
        Map<String, Integer> collect1 = list.stream().filter(s -> "男".equals(s.split("-")[1]))
                .collect(Collectors.toMap(new Function<String, String>() {
                    @Override
                    public String apply(String s) {
                        return s.split("-")[0];
                    }
                }, new Function<String, Integer>() {
                    @Override
                    public Integer apply(String s) {
                        return Integer.parseInt(s.split("-")[2]);
                    }
                }));
        System.out.println(collect1);
    }
}
