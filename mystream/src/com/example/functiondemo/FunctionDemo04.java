package com.example.functiondemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class FunctionDemo04 {

    static void main(String[] args) {

        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, "张无忌-15", "周芷若-20", "赵敏-25", "张强-100", "张三丰-35", "张翠山-40", "张良-45", "王二麻子-50", "谢广坤-55");

        /*Student[] array = list.stream()
                .map(new Function<String, Student>() {
                    @Override
                    public Student apply(String s) {

                        String name = s.split("-")[0];
                        int age = Integer.parseInt(s.split("-")[1]);

                        return new Student(name, age);
                    }
                })
                .toArray(new IntFunction<Student[]>() {
                    @Override
                    public Student[] apply(int value) {
                        return new Student[value];
                    }
                });*/

        // 引用Student类中的构造方法，将流中的数据变成Student对象
        // 引用数组方法，创建一个Student类型的数组，并把流里面的数据放到数组中
        Student[] array1 = list.stream().map(Student::new).toArray(Student[]::new);

        System.out.println(Arrays.toString(array1));
    }
}
