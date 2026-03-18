package com.heima.demo6;

import java.util.ArrayList;

public class ArrListDemo4 {
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();
        Student stu1 = new Student("zhangsan", 15);
        Student stu2 = new Student("lisi", 16);
        Student stu3 = new Student("wangwu", 17);
        Student stu4 = new Student("zhaoliu", 15);

        list.add(stu1);
        list.add(stu2);
        list.add(stu3);
        list.add(stu4);

        for (int i = 0; i < list.size(); i++) {
            Student stu = list.get(i);
            System.out.println(stu.getName() + ":" + stu.getAge() + "岁");
        }
    }
}
