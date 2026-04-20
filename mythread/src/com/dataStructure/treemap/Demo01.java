package com.dataStructure.treemap;

import java.util.TreeMap;

public class Demo01 {

    static void main(String[] args) {

        // 创建学生对象
        Student s1 = new Student("zhangsan", 23);
        Student s2 = new Student("lisi", 24);
        Student s3 = new Student("wangwu", 25);
        Student s4 = new Student("zhaoqian", 25);

        // treemap
        TreeMap<Student, String> tm = new TreeMap<>();

        tm.put(s1, "湖北");
        tm.put(s2, "湖南");
        tm.put(s4, "河南");
        tm.put(s3, "河北");
        tm.put(s3, "河北");

        System.out.println(tm);


    }
}
