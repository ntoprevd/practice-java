package com.myio.bufferstream;

import java.io.*;

public class Demo04 {

    static void main(String[] args) throws IOException {

        // 读取
        BufferedReader br = new BufferedReader(new FileReader("E:\\A\\count.txt"));

        int count = Integer.parseInt(br.readLine());

        br.close();

        // 运行一次，加一次
        count++;

        // 判断使用次数
        if(count <=3 ){
            System.out.println("第"+ count +"次免费使用此软件");
        }else{
            System.out.println("只能免费使用三次此软件，您已超出");
        }

        // 写入
        BufferedWriter bw = new BufferedWriter(new FileWriter("E:\\A\\count.txt"));
        bw.write(count + "");

        bw.close();
    }
}
