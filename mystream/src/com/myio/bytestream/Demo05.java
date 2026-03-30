package com.myio.bytestream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Demo05 {

    static void main(String[] args) throws IOException {

        FileInputStream fis = new FileInputStream("E:\\A\\c.docx");
        FileOutputStream fos = new FileOutputStream("E:\\A\\f.docx");

        byte[] bytes = new byte[1024 * 1024 * 5];

        int len;
        while ((len = fis.read(bytes)) != -1) {

            fos.write(bytes);

        }

        fos.close();
        fis.close();

    }
}
