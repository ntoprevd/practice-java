package com.example.streamdemo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.function.Function;
import java.util.stream.Stream;

public class StreamDemo02 {

    static void main() {

        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, "张无忌", "张无忌", "张无忌", "周芷若", "赵敏", "张强", "张三丰", "张翠山", "张良", "王二麻子", "谢广坤");

        ArrayList<String> list1 = new ArrayList<>();
        Collections.addAll(list1, "路障", "卢登");

        ArrayList<String> list2 = new ArrayList<>();
        Collections.addAll(list2, "张无忌-15", "周芷若-20", "赵敏-25", "张强-100", "张三丰-35", "张翠山-40", "张良-45", "王二麻子-50", "谢广坤-55");

        // filter
        // list.stream().filter(s -> s.startsWith("张")).forEach(s -> System.out.println(s));

        // skip limit
        list.stream()
                .skip(3)
                .limit(3)
                .forEach(System.out::println);

        // distinct
        list.stream().distinct().forEach(System.out::print);

        // concat
        Stream.concat(list.stream(), list1.stream()).forEach(System.out::println);

        System.out.println("=====================================");

        // map
        list2.stream()
                .map(new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {

                String[] arr = s.split("-");
                String str = arr[1];

                return Integer.parseInt(str);
            }
        }).forEach(System.out::println);

        System.out.println("=====================================");

        list2.stream()
                .map(s -> Integer.parseInt(s.split("-")[1]))
                .forEach(System.out::println);

    }
}
