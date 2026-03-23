package com.example.filedemo;

import java.io.File;

public class FileDemo06 {

    static void main(String[] args) {

        File src = new File("E:\\A");
        System.out.println(getLen(src));

    }

    public static long getLen(File src) {

        long len = 0;
        File[] files = src.listFiles();

        for (File file : files) {      // for(int i = 0; i < files.length(); i++)

            if (file.isFile()) {
                len += file.length();
            } else {
                len += getLen(file);
            }
        }
        return len;
    }
}
