package com.myio.bytestream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Demo03 {

    static void main(String[] args) throws IOException {

        FileInputStream fis = new FileInputStream("E:\\A\\c.docx");
        FileOutputStream fos = new FileOutputStream("E:\\A\\g.docx");

        long start = System.currentTimeMillis();

        int read;
        while((read = fis.read()) != -1){
            fos.write(read);
        }

        long end = System.currentTimeMillis();

        fos.close();
        fis.close();

        System.out.println(end - start);
    }
}
