package com.myio.charset;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Demo05 {

    static void main(String[] args) throws IOException {

        // 读取数据，进行各种操作
        FileReader fr = new FileReader("E:\\A\\e.txt");

        StringBuilder sb = new StringBuilder();

        // 读取
        int b;
        while ((b = fr.read()) != -1) {
            sb.append((char) b);
        }

        // 将StringBuilder转换为字符串类
        String str = sb.toString();
        // 字符串按照-分割成字符串数组，并且将字符串类型转换成int类型
        // 需要有数组或者集合来接收，为啥不是数组？集合非常适合动态扩容
        ArrayList<Integer> list = new ArrayList<>();
        String[] arrStr = str.split("-");

        for (int i = 0; i < arrStr.length; i++) {
            int num = Integer.parseInt(arrStr[i]);
            list.add(num);
        }

        // 按照升序排列集合
        Collections.sort(list);

        // 输出数据
        FileWriter fw = new FileWriter("E:\\A\\f.txt");

        // 循环遍历集合，按照指定格式输出
        for (int i = 0; i < list.size(); i++) {

            if (i == list.size() - 1) {
                fw.write(list.get(list.size() - 1) + "");
            } else {
                fw.write(list.get(i) + "-");
            }
        }

        fw.close();
        fr.close();

    }
}
