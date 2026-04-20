package com.dataStructure.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Demo02 {

    static void main(String[] args) {

        // 2. 键值对
        Map<String, String> map = new HashMap<>();

        map.put("张三", "李四");
        map.put("王五", "赵钱");
        map.put("符常安", "牧隗");

        Set<Map.Entry<String, String>> entries = map.entrySet();

        // 迭代器遍历

        Iterator<Map.Entry<String, String>> iterator = entries.iterator();

        while(iterator.hasNext()){

            Map.Entry<String, String> next = iterator.next();
            String key = next.getKey();
            String value = next.getValue();

            System.out.println(key + " = " + value);
        }

    }
}
