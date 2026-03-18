package com.example.streamdemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.function.IntFunction;

public class StreamDemo03 {

    static void main(String[] args) {

        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, "张无忌", "周芷若", "赵敏", "张强", "张三丰", "张翠山", "张良", "王二麻子", "谢广坤");

        list.stream().forEach(System.out::println);

        long count = list.stream().count();
        System.out.println(count);

        System.out.println("==================================");

        Object[] arr1 = list.stream().toArray();
        System.out.println(Arrays.toString(arr1));

        String[] array = list.stream().toArray(new IntFunction<String[]>() {
            @Override
            public String[] apply(int value) {
                return new String[value];
            }
        });
        System.out.println(Arrays.toString(array));

        String[] array1 = list.stream().toArray(value -> new String[value]);
        System.out.println(Arrays.toString(array1));

    }
}
