package com.example.functiondemo;

import java.util.ArrayList;
import java.util.Collections;

public class FunctionDemo02 {

    static void main(String[] args) {

        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, "张无忌", "周芷若", "赵敏", "张强", "张三丰");

        // list.stream()
        //      .filter(s -> s.startsWith("张") && s.length() == 3)
        //      .forEach(System.out::println);

        list.stream()
                .filter(new FunctionDemo02()::strJudge)
                .forEach(s -> System.out.println(s));
    }

    public boolean strJudge(String string){

        return string.startsWith("张") && string.length() == 3;

    }
}
