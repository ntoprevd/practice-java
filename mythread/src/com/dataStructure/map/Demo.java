package com.dataStructure.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Demo {

    static void main(String[] args) {

        // Map 集合遍历

        // 1. 通过键找值
        Map<String, String> map = new HashMap<>();

        map.put("张三", "李四");
        map.put("王五", "赵钱");
        map.put("孙立", "牧隗");

        Set<String> keyset = map.keySet();

        // 增强 for 遍历
        for(String key : keyset){

            String value = map.get(key);
            System.out.println(key + " = " + value);
        }
    }
}
