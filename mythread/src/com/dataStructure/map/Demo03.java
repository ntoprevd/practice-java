package com.dataStructure.map;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class Demo03 {
    static void main(String[] args) {

        // 3. lambda 表达式
        Map<String, String> map = new HashMap<>();

        map.put("张三", "李四");
        map.put("王五", "赵钱");
        map.put("符常安", "牧隗");

        map.forEach(new BiConsumer<String, String>() {
            @Override
            public void accept(String key, String value) {

                System.out.println(key + " = " + value);
            }
        });
    }
}
