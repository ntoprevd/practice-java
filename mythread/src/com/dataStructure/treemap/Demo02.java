package com.dataStructure.treemap;

import java.util.Comparator;
import java.util.TreeMap;
import java.util.function.BiConsumer;

public class Demo02 {

    static void main(String[] args) {

        // 1. 定义字符串
        String s = "aababcabcdbcdbebdebdeeee";

        // 2. TreeMap
        TreeMap<Character, Integer> tm = new TreeMap<>(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return o1.compareTo(o2);
            }
        });

        // 3. 循环遍历字符串，以此判断是否存在于map
        for (int i = 0; i < s.length(); i++){

            char c = s.charAt(i);

            // 若存在
            if(tm.containsKey(c)){

                // 获取value 自增 放回
                Integer value = tm.get(c);
                value++;
                tm.put(c, value);

            }else{
                // 不存在
                tm.put(c, 1);
            }
        }

        // 遍历集合并按照指定格式打印 键值对方式
        /*Set<Map.Entry<Character, Integer>> entries = tm.entrySet();

        for(Map.Entry<Character, Integer> entry : entries){

            System.out.print(entry.getKey() + "(" + entry.getValue() + ")");
        }*/

        // forEach方式

        StringBuilder sb = new StringBuilder();

        tm.forEach(new BiConsumer<Character, Integer>() {
            @Override
            public void accept(Character character, Integer integer) {
                sb.append(character).append("(").append(integer).append(")");
            }
        });

        System.out.println(sb.toString());
    }
}
