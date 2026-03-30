package com.myio.bytestream;

import java.io.FileInputStream;
import java.io.IOException;

public class Demo02 {

    static void main(String[] args) throws IOException {

        FileInputStream fis = new FileInputStream("E:\\A\\e.txt");

        int read;
        while((read = fis.read()) != -1){

            System.out.println((char) read);

        }

        fis.close();
    }
}
