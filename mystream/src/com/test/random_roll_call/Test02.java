package com.test.random_roll_call;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Test02 {

    static void main(String[] args) throws IOException {

        // 创建一个计数文件，程序每运行一次，就加一
        FileReader fr = new FileReader("count.txt");
        char count = (char)fr.read();
        count++;
        fr.close();

        // 写入
        FileWriter fw = new FileWriter("count.txt");
        fw.write(count +"");
        fw.close();

        // 创建集合存放
        ArrayList<String> list = new ArrayList<>();

        // 读取数据
        BufferedReader br = new BufferedReader(new FileReader("infos.txt"));

        String line;

        while ((line = br.readLine()) != null) {
            list.add(line);
        }

        br.close();

        Collections.shuffle(list);

        if(count == '3'){
            System.out.println("尹绿蓉");
        }else{
            String name = list.getFirst().split("-")[0];
            System.out.println(name);
        }
    }
}