package com.dataStructure.hashmap;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Demo01 {

    static void main(String[] args) {

        HashMap<Student, String> hm = new HashMap<>();

        Student s1 = new Student("zhangsan", 23);
        Student s2 = new Student("lisi", 24);
        Student s3 = new Student("wangwu", 25);

        hm.put(s1, "湖南");
        hm.put(s2, "湖北");
        hm.put(s3, "河南");

        // 键找值
        Set<Student> keys = hm.keySet();
        for(Student key : keys){

            String value = hm.get(key);
            System.out.println(key + " = " + value);
        }

        hm.put(s3, "河北");

        // 键值对
        Set<Map.Entry<Student, String>> entries = hm.entrySet();

        for(Map.Entry<Student, String> entry : entries){

            Student key = entry.getKey();
            String value = entry.getValue();

            System.out.println(key + " = " + value);
        }

    }
}
