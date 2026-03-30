package com.myio.charset;

import java.io.FileReader;
import java.io.IOException;

public class Demo02 {

    static void main(String[] args) throws IOException {

        FileReader fr = new FileReader("E:\\A\\e.txt");

        // 空参read

        /*int ch;
        while((ch = fr.read()) != -1){
            System.out.print((char) ch);
        }*/

        // 有参read
        char[] chars = new char[2];
        int len;
        while((len = fr.read(chars)) != -1){

            System.out.print(new String(chars, 0, len));
        }

        fr.close();
    }
}
