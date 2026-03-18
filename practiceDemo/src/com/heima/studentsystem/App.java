package com.heima.studentsystem;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class App {

    private static final String LOGIN = "1";
    private static final String REGISTER = "2";
    private static final String FORGETPASSWORD= "3";
    private static final String EXIT = "4";

    public static void main(String[] args) {

        // 用户集合
        ArrayList<User> list = new ArrayList<>();

        while (true) {
            // 登录注册界面
            System.out.println("欢迎来到学生管理系统！");
            System.out.println("请选择操作：1登录 2注册 3忘记密码 4退出系统");

            Scanner sc = new Scanner(System.in);
            String choose = sc.next();
            switch (choose) {
                case LOGIN-> login(list);
                case REGISTER -> register(list);
                case FORGETPASSWORD -> forgetPassword(list);
                case EXIT -> {
                    System.out.println("Exit!");
                    System.exit(0);
                }
                default -> System.out.println("Wrong choice!");
            }
        }
    }

    // 登录
    public static void login(ArrayList<User> list) {

        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {

            // 判断用户名
            System.out.println("请输入用户名：");
            String username = sc.next();
            boolean flag1 = isContain(list, username);
            if(!flag1){
                System.out.println("用户不存在，请先注册！");
                return;
            }

            // 密码
            System.out.println("请输入密码：");
            String password = sc.next();

            // 获取判断验证码
            while (true) {
                String rightCode = getCode();
                System.out.println("验证码：" + rightCode);
                System.out.println("请输入验证码：");
                String code = sc.next();
                boolean flag2 = code.equalsIgnoreCase(rightCode);

                if(!flag2){
                    System.out.println("验证码错误！请重试");
                }else{
                    break;
                }
            }

            // 判断密码和用户名是否正确，三次机会
            boolean flag3 = checkUserInfo(list, username, password);
            if(flag3){
                System.out.println("登录成功！");
                StudentSystem ss = new StudentSystem();
                ss.studentSystem();
                break;
            }else{
                System.out.println("用户名或密码错误！你还有" + (2 - i) + "次机会");
            }
        }
    }

    // 判断登录中的密码和用户名是否正确
    public static boolean checkUserInfo(ArrayList<User> list, String username, String password){
        for (int i = 0; i < list.size(); i++) {
            User u = list.get(i);
            boolean flag1 = u.getUsername().equals(username);
            boolean flag2 = u.getPassword().equals(password);
            if(flag1 && flag2){
                return true;
            }
        }
        return false;
    }

    // 获取验证码
    public static String getCode(){

        ArrayList<Character> list = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            list.add((char)('a' + i));
            list.add((char)('A' + i));
        }

        Random r = new Random();
        StringBuilder sb = new StringBuilder();

        // 四个随机字母
        for (int i = 0; i < 4; i++) {
            int index = r.nextInt(list.size());
            char c = list.get(index);
            sb.append(c);
        }

        // 一个随机数字
        int num = r.nextInt(10);
        sb.append(num);

        // 转换成数组再随机位置
        char[] arr = sb.toString().toCharArray();
        int randomIndex = r.nextInt(5);
        char temp = arr[randomIndex];
        arr[randomIndex] = arr[arr.length - 1];
        arr[arr.length - 1] = temp;

        // 转换成字符串并返回
        return new String(arr);
    }

    // 注册
    public static void register(ArrayList<User> list) {

        // 用户对象
        User u = new User();

        // 用户名
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String username;

        while (true) {
            username = sc.next();
            boolean flag1 = checkUsername(username);

            // 若用户名格式不正确，重新输入判断；若格式正确，判断是否唯一
            if(!flag1){
                System.out.println("用户名格式错误！请重新输入：");
                continue;
            }

            // 若用户名已存在，重新输入判断；若不存在，添加成功
            boolean flag2 = isContain(list, username);
            if(flag2){
                System.out.println("用户名已存在！请重新输入：");
            }else{
                u.setUsername(username);
                break;
            }
        }

        // 密码
        System.out.println("请输入密码：");
        String password;

        while (true) {
            password = sc.next();
            System.out.println("请再次输入密码：");
            String againPassword = sc.next();
            boolean flag1 = againPassword.equals(password);
            if(flag1){
                u.setPassword(password);
                break;
            }else{
                System.out.println("两次密码不一致！请重新输入：");
            }
        }

        // 身份证号
        System.out.println("请输入身份证号：");
        String personID;

        while (true) {
            personID = sc.next();
            boolean flag1 = checkPersonID(personID);
            if(!flag1){
                System.out.println("身份证号格式错误！请重新输入：");
            }else{
                u.setPersonID(personID);
                break;
            }
        }

        // 手机号
        System.out.println("请输入手机号：");
        String phoneNumber;

        while (true) {
            phoneNumber = sc.next();
            boolean flag1 = checkPhoneNumber(phoneNumber);
            if(!flag1){
                System.out.println("手机号格式错误！请重新输入：");
            }else{
                u.setPhoneNumber(phoneNumber);
                break;
            }
        }

        // 将用户存入集合
        list.add(u);
        System.out.println("注册成功！");
    }

    // 检查手机号格式是否正确
    public static boolean checkPhoneNumber(String phoneNumber){

        // 长度为11位
        if(phoneNumber.length() != 11){
            return false;
        }

        // 不能以0开头
        if(phoneNumber.startsWith("0")){
            return false;
        }

        // 必须是数字
        for (int i = 0; i < phoneNumber.length(); i++) {
            char c = phoneNumber.charAt(i);
            if(c > '9'  || c < '0'){
                return false;
            }
        }
        return true;
    }

    // 检查身份证号格式是否正确
    public static boolean checkPersonID(String personID){

        // 长度为18位
        if(personID.length() != 18){
            return false;
        }

        // 不能以0开头
        if(personID.startsWith("0")){
            return false;
        }

        // 前17位是数字
        for (int i = 0; i < personID.length() - 1; i++) {
            char c = personID.charAt(i);
            if(c > '9' || c < '0'){
                return false;
            }
        }

        // 最后一位数字或x或X
        char endChar = personID.charAt(17);
        if((endChar > '0' && endChar < '9') || (endChar == 'x') || (endChar == 'X')){
            return true;
        }

        return false;
    }

    // 检查用户名在用户集合中是否存在
    public static boolean isContain(ArrayList<User> list, String username){
        int index = findIndex(list, username);
        return index >= 0;
    }

    // 检查用户名格式是否正确
    public static boolean checkUsername(String username) {

        // 先检查格式是否正确

        // 用户名长度
        int length = username.length();
        if (length < 3 || length > 15) {
            return false;
        }

        // 字母加数字
        for (int i = 0; i < username.length(); i++) {
            char c = username.charAt(i);
            if((c < 'a' || c > 'z') && (c < '0' || c > '9') && (c < 'A' || c > 'Z') ){
                return false;
            }
        }

        // 不能是纯数字
        int count = 0;
        for (int i = 0; i < username.length(); i++) {
            char c = username.charAt(i);
            if((c > 'a' && c < 'z') || (c > 'A' && c < 'Z')){
                count++;
                break;
            }
        }
        return count > 0;
    }

    // 忘记密码
    public static void forgetPassword(ArrayList<User> list) {

        Scanner sc = new Scanner(System.in);

        System.out.println("请输入用户名：");
        String username = sc.next();

        // 用户是否存在
        boolean flag1 = isContain(list, username);
        if(!flag1){
            System.out.println("用户未注册！");
            return;
        }

        // 用户存在，则校验身份证号和手机号
        System.out.println("请输入身份证号：");
        String personID = sc.next();
        System.out.println("请输入手机号：");
        String phoneNumber = sc.next();

        int index = findIndex(list, username);
        User u = list.get(index);
        if(!(u.getPersonID().equals(personID) && u.getPhoneNumber().equals(phoneNumber))){
            System.out.println("账号信息不匹配，修改失败！");
            return;
        }

        // 账号信息匹配，修改信息
        String password;
        String againPassword;

        while (true) {
            System.out.println("请输入新密码：");
            password = sc.next();
            System.out.println("请再次输入密码：");
            againPassword = sc.next();

            if(!password.equals(againPassword)){
                System.out.println("两次密码不一致！请重新输入新密码：");
            }else{
                break;
            }
        }
        // 修改密码
        u.setPassword(password);
        System.out.println("密码修改成功！");
    }

    // 在集合中找到用户名的索引
    public static int findIndex(ArrayList<User> list, String username){
        for (int i = 0; i < list.size(); i++) {
            User u = list.get(i);
            if(u.getUsername().equals(username)){
                return i;
            }
        }
        return -1;
    }

}