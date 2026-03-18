package com.example.functiondemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Function;

public class FunctionDemo05 {

    static void main(String[] args) {

        ArrayList<Student> list = new ArrayList<>();
        list.add(new Student("zhangsan", 23));
        list.add(new Student("lisi", 24));
        list.add(new Student("wangwu", 25));

        String[] array = list.stream()
                .map(new Function<Student, String>() {
                    @Override
                    public String apply(Student s) {
                        return s.getName() + "-" + s.getAge();
                    }
                })
                .toArray(String[]::new);
        System.out.println(Arrays.toString(array));

        // 匿名内部类

        /*String[] array = list.stream()
                .map(new Function<Student, String>() {
                    @Override
                    public String apply(Student s) {
                        return s.getName();
                    }
                })
                .toArray(new IntFunction<String[]>() {
                    @Override
                    public String[] apply(int value) {
                        return new String[value];
                    }
                });*/

        // 类名::成员方法

       /* String[] array1 = list.stream().map(Student::getName).toArray(String[]::new);

        System.out.println(Arrays.toString(array1));*/
    }
}
