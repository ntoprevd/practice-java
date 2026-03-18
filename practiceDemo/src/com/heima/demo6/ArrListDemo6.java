package com.heima.demo6;

import java.util.ArrayList;

public class ArrListDemo6 {
    public static void main(String[] args) {
        // 1. 定义一个集合
        ArrayList<User> list = new ArrayList<>();

        // 2. 存在三个用户对象
        User u1 = new User("a0001", "zhangsan", "123456");
        User u2 = new User("a0002", "lisi", "123456qwer");
        User u3 = new User("a0003", "wangwu", "123456iuyt");

        // 3. 将用户对象存入集合
        list.add(u1);
        list.add(u2);
        list.add(u3);

        System.out.println(isContain(list, "a0001"));
        System.out.println(getIndex(list, "a0001"));
    }

    // 4. 定义一个方法查找对象信息并返回
    public static boolean isContain(ArrayList<User> list, String id){
        for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    // 5. 返回索引，无则-1
    public static int getIndex(ArrayList<User> list, String id){
        for (int i = 0; i < list.size(); i++) {
            User u = list.get(i);
            String uid = u.getId();
            if(uid.equals(id)){
                return i;
            }
        }
        return -1;
    }

}

