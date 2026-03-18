package com.heima.studentsystem;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentSystem {

    private static final String ADD_STUDENT = "1";
    private static final String DELETE_STUDENT = "2";
    private static final String UPDATE_STUDENT = "3";
    private static final String QUERY_STUDENT = "4";
    private static final String EXIT = "5";

    public static void studentSystem() {

        ArrayList<Student> list = new ArrayList<>();

        loop:
        while (true) {

            printHome();
            Scanner sc = new Scanner(System.in);
            String choice = sc.next();

            switch (choice) {
                case ADD_STUDENT -> addStudent(list);
                case DELETE_STUDENT -> deleteStudent(list);
                case UPDATE_STUDENT -> updateStudent(list);
                case QUERY_STUDENT -> queryStudent(list);
                case EXIT -> {
                    System.out.println("退出");
                    break loop;
                }
                default -> System.out.println("输入无效！");
            }
        }
    }

    // 打印主菜单
    public static void printHome() {
        System.out.println("------------------欢迎来到学生管理系统---------------------");
        System.out.println("1: 添加学生");
        System.out.println("2: 删除学生");
        System.out.println("3: 修改学生");
        System.out.println("4: 查询学生");
        System.out.println("5: 退出");
        System.out.println("请输入您的选择：");
    }

    // 添加学生信息
    public static void addStudent(ArrayList<Student> list) {

        // 键盘录入学生信息
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入id:");
        String id = null;

        while (true) {
            if (isIdContained(list, id)) {
                System.out.println("id已存在！请重新输入：");
            } else {
                id = sc.next();
                break;
            }
        }

        System.out.println("请输入姓名:");
        String name = sc.next();
        System.out.println("请输入年龄:");
        int age = sc.nextInt();
        System.out.println("请输入家庭住址:");
        String address = sc.next();

        // 创建学生对象
        Student stu = new Student(id, name, age, address);

        // 将学生对象存入集合并给出提示
        list.add(stu);
        System.out.println("学生信息录入成功！");
    }

    // 删除学生信息
    public static void deleteStudent(ArrayList<Student> list) {

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要删除的学生的id:");
        String id = sc.next();

        int index = getIndex(list, id);
        if (index < 0) {
            System.out.println("id不存在！");
        } else {
            list.remove(index);
            System.out.println("删除id为" + id + "的学生信息成功！");
        }
    }

    // 更改学生信息
    public static void updateStudent(ArrayList<Student> list) {

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入需要修改的学生的id：");
        String id = sc.next();

        int index = getIndex(list, id);

        if (index < 0) {
            System.out.println("id不存在！");
        } else {
            Student stu = list.get(index);

            System.out.println("请输入新姓名：");
            String newName = sc.next();
            stu.setName(newName);

            System.out.println("请输入新年龄：");
            int newAge = sc.nextInt();
            stu.setAge(newAge);

            System.out.println("请输入新家庭地址：");
            String newAddress = sc.next();
            stu.setAddress(newAddress);
            System.out.println("修改id为" + id + "的学生信息成功！");
        }
    }

    // 查询学生信息
    public static void queryStudent(ArrayList<Student> list) {

        // 如果没有学生信息则给出提示
        if (list.isEmpty()) {
            System.out.println("当前无学生信息，请添加后再查询！");
            return;
        }

        // 如果有学生信息则按格式输出
        System.out.println("id\t\t姓名\t\t年龄\t\t家庭住址");
        for (int i = 0; i < list.size(); i++) {
            Student stu = list.get(i);
            System.out.println(stu.getId() + "\t" + stu.getName() + "\t" + stu.getAge() + "\t" + stu.getAddress());
        }
    }

    // 查询学生id是否存在集合中
    public static boolean isIdContained(ArrayList<Student> list, String id) {

        return getIndex(list, id) >= 0;
    }

    // 获取id对应的集合中的索引
    public static int getIndex(ArrayList<Student> list, String id) {

        for (int i = 0; i < list.size(); i++) {
            Student stu = list.get(i);
            if (stu.getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }
}