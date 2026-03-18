package com.heima.demo6;

import java.util.ArrayList;

public class ArrListDemo7 {

    public static void main(String[] args) {
        // 1. 定义javabean类

        // 2. 定义一个集合
        ArrayList<Phone> list = new ArrayList<>();

        // 3. 三个手机对象
        Phone p1 = new Phone("小米", 1000);
        Phone p2 = new Phone("苹果", 8000);
        Phone p3 = new Phone("华为", 3999);

        // 4. 将对象存入集合
        list.add(p1);
        list.add(p2);
        list.add(p3);

        // 5. 查找并返回手机信息
        ArrayList<Phone> phoneList = getPhoneInfo(list);

        // 6. 打印正确的手机信息
        printPhoneInfo(phoneList);
    }

    public static ArrayList<Phone> getPhoneInfo(ArrayList<Phone> list) {

        ArrayList<Phone> phoneList = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getPrice() < 4000) {
                phoneList.add(list.get(i));
            }
        }
        return phoneList;
    }

    public static void printPhoneInfo(ArrayList<Phone> phoneList) {
        for (int i = 0; i < phoneList.size(); i++) {
            Phone p = phoneList.get(i);
            System.out.println(p.getBrand() + ":" + p.getPrice() + "￥");
        }
    }
    
}
