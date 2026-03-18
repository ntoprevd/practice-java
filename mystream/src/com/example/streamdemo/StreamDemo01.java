package com.example.streamdemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.stream.Stream;

public class StreamDemo01 {

    static void main(String[] args) {

        // 单列集合
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, "a", "b", "c", "d", "e");

        Stream<String> stream = list.stream();
        stream.forEach(s -> System.out.print(s + " "));
        System.out.println(" ");

        // 双列集合
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("aaa", 111);
        hm.put("bbb", 222);
        hm.put("ccc", 333);
        hm.put("ddd", 444);

        hm.keySet().forEach(string -> System.out.print(string + " "));
        System.out.println(" ");
        hm.entrySet().forEach(s -> System.out.print(s + " "));
        System.out.println(" ");
        System.out.println(" ");

        // 数组
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        String[] arrStr = {"aaa", "bbb", "ccc", "ddd"};

        Arrays.stream(arr).forEach(s -> System.out.print(s + " "));
        System.out.println(" ");
        Arrays.stream(arrStr).forEach(s -> System.out.print(s + " "));
        System.out.println(" ");
        System.out.println(" ");

        // 随意数字
        Stream.of(1, 2, 3, 4, 5).forEach(s -> System.out.print(s + " "));
        System.out.println(" ");
        Stream.of("a", "b", "c", "d").forEach(s -> System.out.print(s + " "));

    }
}
