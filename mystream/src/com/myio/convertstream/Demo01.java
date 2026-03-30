package com.myio.convertstream;

import java.io.*;
import java.nio.charset.Charset;

public class Demo01 {

    static void main(String[] args) throws IOException {

        /*// 读取
        InputStreamReader isr = new InputStreamReader(new FileInputStream("E:\\A\\q.txt"), "GBK");

        // 写出
        OutputStreamWriter osr = new OutputStreamWriter(new FileOutputStream("E:\\A\\w.txt"), "UTF-8");
        int ch;
        while((ch = isr.read()) != -1){

            osr.write((char)ch);
        }

        osr.close();
        isr.close();*/

        FileReader fr = new FileReader("E:\\A\\q.txt", Charset.forName("GBK"));
        FileWriter fw = new FileWriter("E:\\A\\w.txt", Charset.forName("UTF-8"));

        int ch;
        while ((ch = fr.read()) != -1) {

            fw.write((char) ch);
        }

        fw.close();
        fr.close();
    }
}