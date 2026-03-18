package com.itheima.staticdemo2;

import java.util.ArrayList;

public class StudentUtil {

    // 私有化构造方法
    private StudentUtil(){}

    // 方法
    public static int getMaxAgeStudent(ArrayList<Student> list){

        int maxAge = list.getFirst().getAge();

        for (int i = 1; i < list.size(); i++) {
            int age = list.get(i).getAge();
            maxAge = Math.max(age, maxAge);
        }
        return maxAge;
    }
}
