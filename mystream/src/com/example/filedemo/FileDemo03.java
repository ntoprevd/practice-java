package com.example.filedemo;

import java.io.File;

public class FileDemo03 {

    public static void main(String[] args){

        File f = new File("E:\\javaLearing\\notes");
        boolean b = hasMovie(f);
        System.out.println(b);

    }

    public static boolean hasMovie(File file){

        File[] files = file.listFiles();

        for (int i = 0; i < files.length; i++) {

            if(files[i].isFile() && files[i].getName().endsWith(".md")){
                return true;
            }
        }
        return false;
    }
}
