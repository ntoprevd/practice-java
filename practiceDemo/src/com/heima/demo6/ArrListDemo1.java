package com.heima.demo6;

import java.util.ArrayList;

public class ArrListDemo1 {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        System.out.println(list);

        // 1. 增 Create
        list.add("aaa");
        System.out.println(list);

        list.add("bbb");
        list.add("ccc");
        list.add("ddd");
        System.out.println(list);

        // 2. 删 Delete
        boolean result1 = list.remove("aaa");
        System.out.println(result1);
        System.out.println(list);

        boolean result2 = list.remove("fff");
        System.out.println(result2);
        System.out.println(list);

        String str1 = list.remove(1);
        System.out.println(str1);
        System.out.println(list);

        list.add("DDD");
        list.add("KKK");
        System.out.println(list);

        // 3. 改 Update
        String str2 = list.set(1, "MMM");
        System.out.println(str2);
        System.out.println(list);

        // 4. 查 Read
        String str3 = list.get(2);
        System.out.println(str3);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
