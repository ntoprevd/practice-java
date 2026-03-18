package com.heima.demo6;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrListDemo5 {
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 3; i++) {

            System.out.println("请输入学生姓名：");
            String name = sc.next();
            System.out.println("请输入学生年龄：");
            int age = sc.nextInt();

            Student stu = new Student(name, age);

            list.add(stu);
        }

        for (int i = 0; i < list.size(); i++) {
            Student s = list.get(i);
            System.out.println(s.getName() + ":" + s.getAge() + "岁");
        }

    }
}
