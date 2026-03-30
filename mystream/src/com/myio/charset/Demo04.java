package com.myio.charset;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Demo04 {

    static void main(String[] args) throws IOException {

        FileInputStream fis = new FileInputStream("E:\\A\\copy.txt");
        FileOutputStream fos = new FileOutputStream("E:\\A\\init.txt");

        int len;
        byte[] bytes = new byte[3];
        while((len = fis.read(bytes)) != -1){

            for (int i = 0; i < len; i++) {
                bytes[i] ^= 2;
            }

            fos.write(bytes);

        }

        fos.close();
        fis.close();
    }
}
