package com.example.filedemo;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class FileDemo01 {

    public static void main(String[] args) throws IOException {

        File f = new File("E:\\javaLearing\\notes\\a");

        File[] files = f.listFiles();

        /*for (int i = 0; i < files.length; i++) {
            System.out.println(files[i]);
        }*/

        System.out.println(Arrays.toString(files));
    }
}
