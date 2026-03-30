package com.myio.bytestream;

import java.io.FileInputStream;
import java.io.IOException;

public class Demo04 {

    static void main(String[] args) throws IOException {

        FileInputStream fis = new FileInputStream("E:\\A\\e.txt");

        int len;
        byte[] bytes = new byte[5];

        len = fis.read(bytes);
        System.out.println(new String(bytes, 0, len));

        len = fis.read(bytes);
        System.out.println(new String(bytes, 0, len));

        len = fis.read(bytes);
        System.out.println(new String(bytes));

        len = fis.read(bytes);
        System.out.println(len);
        System.out.println(new String(bytes, 0, len));

        len = fis.read(bytes);
        System.out.println(len);
        System.out.println(new String(bytes, 0, len));



    }
}
