package com.test.random_roll_call;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Test01 {

    public static void main(String[] args) throws IOException {

        // 创建 list 集合来存放获取的同学信息
        ArrayList<String> list = new ArrayList<>();

        // 从本地文件中读取
        BufferedReader br = new BufferedReader(new FileReader("infos.txt"));

        String line;

        while((line = br.readLine()) != null){
            list.add(line);
        }

        br.close();

        // 打乱集合中数据顺序
        Collections.shuffle(list);

        // 获取第一位
        String info = list.getFirst();

        String name = info.split("-")[0];

        System.out.println(name);

    }
}
