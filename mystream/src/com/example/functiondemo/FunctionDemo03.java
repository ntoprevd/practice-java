package com.example.functiondemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.function.Function;
import java.util.function.IntFunction;

public class FunctionDemo03 {

    static void main(String[] args) {

        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, "aaa", "bbb", "ccc", "ddd");

        ArrayList<Integer> list1 = new ArrayList<>();
        Collections.addAll(list1, 1, 2, 3, 4, 5, 6);

        Integer[] array = list1.stream()
                .toArray(new IntFunction<Integer[]>() {
                    @Override
                    public Integer[] apply(int value) {
                        return new Integer[value];
                    }
                });
        System.out.println(Arrays.toString(array));

        System.out.println("====================");

        list.stream()
                .map(new Function<String, String>() {
            @Override
            public String apply(String s) {
                return s.toUpperCase();
            }
        })
                .forEach(s -> System.out.println(s));

        list.stream()
                .map(String::toUpperCase)
                .forEach(s -> System.out.println(s));


    }
}
