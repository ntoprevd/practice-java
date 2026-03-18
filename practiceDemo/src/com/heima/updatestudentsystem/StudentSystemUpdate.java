package com.heima.updatestudentsystem;

import java.util.ArrayList;
import java.util.Scanner;

// 唉。。。。为什么我不会
public class StudentSystemUpdate {
    public static void main(String[] args) {

        // 集合
        ArrayList<User> list = new ArrayList<>();
        User u = new User();

        // 初始界面
        while (true) {
            System.out.println("欢迎来到学生管理系统！");
            System.out.println("请选择操作：");
            System.out.println("1. 登录");
            System.out.println("2. 注册");
            System.out.println("3. 忘记密码");

            // 用户输入选择，跳转相应界面
            Scanner sc = new Scanner(System.in);
            String choice = sc.next();

            switch(choice){
                case "1" -> login(list);
                case "2" -> register(list, u);
                case "3" -> System.out.println("忘记密码");
                case "4" -> {
                    System.out.println("退出！");
                    System.exit(0);
                }
                default -> System.out.println("没有这个选项！");
            }
        }
    }

    // 注册界面
    public static void register(ArrayList<User> list, User u){

        Scanner sc = new Scanner(System.in);

        // 检查用户名
        System.out.println("请输入用户名：");
        String name = sc.next();

        // 检查用户名
        while((isContain(list, name)) || (!checkUsername(name))){
            if(isContain(list, name)){
                System.out.println("用户名已存在！请重新输入：");
            }
            if(!checkUsername(name)){
                System.out.println("用户名格式错误！请重新输入：");
            }
            name = sc.next();
        }

        // 将名字赋予用户名
        u.setUsername(name);

        // 检查密码
        System.out.println("请输入密码：");
        String password = sc.next();
        System.out.println("请再次输入密码：");
        String passwordagain = sc.next();
        while(!password.equals(passwordagain)){
            System.out.println("密码不一致！请重新输入密码：");
            password = sc.next();
            System.out.println("请再次输入密码：");
            passwordagain = sc.next();
        }
        // 将密码赋予密码
        u.setPassword(password);

        // 检查身份证号
        System.out.println("请输入身份证号：");
        String personid = sc.next();
        while(!checkPersonid(personid)){
            System.out.println("身份证号格式错误！请重新输入：");
            personid = sc.next();
        }
        // 将身份证号赋予身份证号
        u.setPersonid(personid);

        // 检查手机号
        System.out.println("请输入手机号：");
        String phonenumber = sc.next();
        while(!checkPhonenumber(phonenumber)){
            System.out.println("手机号格式错误！请重新输入：");
            phonenumber = sc.next();
        }
        // 将手机号赋予手机号
        u.setPhonenumber(phonenumber);

        // 将用户信息添加至集合
        list.add(u);

        System.out.println("注册成功！");
    }

    // 登录界面
    public static void login(ArrayList<User> list){

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String name = sc.next();

        if(!isContain(list, name)){
            System.out.println("用户不存在！请先注册");
            return;
        }

        // 验证码不会
        for (int i = 0; i < 3; i++) {
            System.out.println("请输入密码：");
            String password = sc.next();
            User u = list.get(getIndex(list, name));
            boolean result = u.getPassword().equals(password);
            if(result){
                System.out.println("登录成功！");
                return;
            }
            else{
                System.out.println("您还有" + (2 - i) +"次机会");
            }
        }
        System.out.println("登录失败！");
    }

    // 忘记密码界面
    public static void passwordForget(){

    }


    // 用户名是否唯一，是否存在于集合中
    public static boolean isContain(ArrayList<User> list, String name){
        return getIndex(list, name) >= 0;
    }

    // 获取用户名相同的索引
    public static int getIndex(ArrayList<User> list, String name){
        for (int i = 0; i < list.size(); i++) {
            User u = list.get(i);
            boolean result = u.getUsername().equals(name);
            if(result){
                return i;
            }
        }
        return -1;
    }

    // 检查用户名字符格式
    public static boolean checkUsernameChar(String name){
        int count = 0;
        for (int i = 0; i < name.length(); i++) {
            char c = name.charAt(i);
            if(c > '0' && c < '9'){
                count++;
            }
            if((c < 'a' || c > 'z') && (c < 'A' || c > 'Z') && (c < '0' || c > '9')){
                return false;
            }
        }
        if(count == name.length()){
            return false;
        }
        return true;
    }

    // 检查用户名格式
    public static boolean checkUsername(String name){
        boolean boolength = name.length() < 15 && name.length() > 3;
        return boolength && checkUsernameChar(name);
    }

    // 检查身份证号格式
    public static boolean checkPersonid(String personid){
        boolean length = personid.length() == 18;
        boolean first = (personid.charAt(0) != 0);
        char end = personid.charAt(personid.length() - 1);
        boolean boolend = false;
        if((end > '0' && end < '9') || end == 'x' || end == 'X'){
            boolend = true;
        }
        boolean boolbegin = true;
        for (int i = 0; i < personid.length() - 1; i++) {
            if(personid.charAt(i) > '9' || personid.charAt(i) < '0'){
                boolbegin = false;
            }
        }
        return length && first && boolend && boolbegin;
    }

    // 检查手机号格式
    public static boolean checkPhonenumber(String phonenumber){
    boolean boolength = phonenumber.length() == 11;
    boolean boolfirst = phonenumber.charAt(0) != 0;
    boolean boolnumber = true;
    for (int i = 0; i < phonenumber.length(); i++) {
        if(phonenumber.charAt(i) > '9' || phonenumber.charAt(i) < '0'){
            boolnumber = false;
        }
    }
    return boolength && boolfirst && boolnumber;
    }

}