package com.dataStructure.hashmap;

import java.util.*;

public class Demo02 {

    static void main(String[] args) {

        // 1. 初始投票
        String[] arr = {"A", "B", "C", "D"};

        // 容器存储投票结果
        ArrayList<String> list = new ArrayList<>();

        // 模拟学生随机投票
        Random r = new Random();

        for(int i = 0; i < 80; i++){

            int nextInt = r.nextInt(arr.length);
            list.add(arr[nextInt]);
        }

        // 2. 计数
        HashMap<String, Integer> hm = new HashMap<>();

        // 遍历 list，判断键是否存在
        for (String name : list){

            // 若存在，++
            if(hm.containsKey(name)){

                // 获取value
                Integer value = hm.get(name);
                // 增加次数
                value++;
                // 放回hm
                hm.put(name, value);

            }else{
                hm.put(name, 1);
            }

        }

        // 3. 获取最大投票数
        int max = 0;
        Set<String> keySet = hm.keySet();

        for(String key : keySet){

            int value = hm.get(key);
            if(value > max){
                max = value;
            }
        }

        // 4.  打印选项
        Set<Map.Entry<String, Integer>> entries = hm.entrySet();

        for (Map.Entry<String, Integer> entry : entries){

            Integer value = entry.getValue();

            if(value == max){
                System.out.println(entry.getKey());
            }
        }
    }

}
