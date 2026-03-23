package com.example.filedemo;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class FileDemo07 {

    static void main(String[] args) {

        File src = new File("E:\\A");
        System.out.println(getCount(src));

    }

    public static HashMap<String, Integer> getCount(File src) {

        // 定义集合用来统计
        HashMap<String, Integer> hm = new HashMap<>();
        // 进入src文件夹
        File[] files = src.listFiles();

        for (File file : files) {

            if(file.isFile()){
                // 文件

                // 获取文件名
                String name = file.getName();

                // 按.分割成数组
                String[] arr = name.split("\\.");

                // 长度至少为2，才有后缀名
                if(arr.length >= 2){
                    // 获取后缀名
                    String endName = arr[arr.length - 1];

                    if(hm.containsKey(endName)){
                        // 如果后缀名已存在表中

                        // 获取对应的次数，增加一次，再存放进表
                        Integer count = hm.get(endName);
                        count++;
                        hm.put(endName, count);

                    }else{
                        // 不存在

                        // 将后缀名以及1次存放进表
                        hm.put(endName, 1);
                    }
                }

            }else{
                // 文件夹

                HashMap<String, Integer> sonMap = getCount(file);

                Set<Map.Entry<String, Integer>> entries = sonMap.entrySet();

                for(Map.Entry<String, Integer> entry: entries){
                    String key = entry.getKey();
                    Integer value = entry.getValue();

                    if(hm.containsKey(key)){
                        Integer count = hm.get(key);
                        count += value;
                        hm.put(key, count);
                    }else{
                        hm.put(key, value);
                    }
                }
            }
        }

        return hm;

    }
}
