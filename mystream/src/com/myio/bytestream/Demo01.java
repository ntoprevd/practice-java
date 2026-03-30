package com.myio.bytestream;

import java.io.FileOutputStream;
import java.io.IOException;

public class Demo01 {

    static void main(String[] args) throws IOException {

        FileOutputStream fos = new FileOutputStream("E:\\A\\e.txt", false);

        fos.write(97);

        String str = "\r\n";
        byte[] bytes = str.getBytes();
        fos.write(bytes);

        byte[] arr = {97, 98, 99, 100, 101};
        fos.write(arr);

        fos.write(bytes);

        String str1 = "hellohellohellohellohello";
        byte[] byte2 = str1.getBytes();
        fos.write(byte2);

        fos.close();
    }
}
