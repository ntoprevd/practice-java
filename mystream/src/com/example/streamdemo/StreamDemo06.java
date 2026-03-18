package com.example.streamdemo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo06 {

    static void main(String[] args) {

        ArrayList<String> manList = new ArrayList<>();
        Collections.addAll(manList, "蔡困困，24", "叶闲闲，23", "刘步步，22", "午钱，24", "古加，30", "萧梁，27");

        ArrayList<String> womanList = new ArrayList<>();
        Collections.addAll(womanList, "赵小小，35", "杨颖，36", "高愿愿，43", "张甜甜，24", "陆拾，35", "杨消弭，33");

        Stream<String> manList1 = manList.stream()
                .filter(s -> s.split("，")[0].length() == 3)
                .limit(2);

        Stream<String> womanList1 = womanList.stream()
                .filter(s -> s.startsWith("杨"))
                .skip(1);

        /*List<Actor> collect = Stream.concat(manList1, womanList1)
                .map(new Function<String, Actor>() {
                    @Override
                    public Actor apply(String s) {
                        String name = s.split("，")[0];
                        int age = Integer.parseInt(s.split("，")[1]);
                        return new Actor(name, age);
                    }
                })
                .collect(Collectors.toList());

        System.out.println(collect);*/

        List<Actor> collect1 = Stream.concat(manList1, womanList1)
                .map(s -> new Actor(s.split("，")[0], Integer.parseInt(s.split("，")[1])))
                .collect(Collectors.toList());
        System.out.println(collect1);

    }
}