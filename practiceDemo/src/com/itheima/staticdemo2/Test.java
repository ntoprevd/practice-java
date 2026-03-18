package com.itheima.staticdemo2;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {

        // 创建一个学生集合
        ArrayList<Student> list = new ArrayList<>();

        // 创建学生对象
        Student stu1 = new Student("张三", 25, "男");
        Student stu2 = new Student("李四", 24, "女");
        Student stu3 = new Student("王五", 23, "女");

        // 学生对象加入集合
        list.add(stu1);
        list.add(stu2);
        list.add(stu3);

        // 调用方法
        int maxAgeStudent = StudentUtil.getMaxAgeStudent(list);
        System.out.println(maxAgeStudent);

    }
}
