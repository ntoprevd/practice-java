package com.myio.bufferstream;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Demo02 {

    static void main(String[] args) throws IOException {

        // 读取
        BufferedReader br = new BufferedReader(new FileReader("E:\\A\\e.txt"));

        // 创建一个集合来存放读取的字符串
        ArrayList<String> list = new ArrayList<>();

        String line;

        while((line = br.readLine()) != null){
            list.add(line);
        }

        // 进行排序
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {

                // 字符串按照.切割，成为字符串数组，取[0]，转换为int类型
                int i1 = Integer.parseInt(o1.split("\\.")[0]);
                int i2 = Integer.parseInt(o2.split("\\.")[0]);

                return i1 - i2;
            }
        });

        // 打印
        BufferedWriter bw = new BufferedWriter(new FileWriter("E:\\A\\copy.txt"));
        for (int i = 0; i < list.size(); i++) {

            bw.write(list.get(i));
            bw.newLine();
        }

        br.close();
        bw.close();

    }
}
