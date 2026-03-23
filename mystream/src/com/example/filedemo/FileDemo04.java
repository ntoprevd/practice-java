package com.example.filedemo;

import java.io.File;

public class FileDemo04 {

    public static void main(String[] args){

        findMovie();
    }

    public static void findMovie(){

        File[] src = File.listRoots();

        for (int i = 0; i < src.length; i++) {
            findMovie(src[i]);
        }
    }

    public static void findMovie(File src){

        File[] files = src.listFiles();

        if(files == null){
            return;
        }

        for (int i = 0; i < files.length; i++) {

            if(files[i].isFile() && files[i].getName().endsWith(".avi")){

                System.out.println(files[i].getAbsolutePath());

            }else if (files[i].isDirectory()) {

                findMovie(files[i]);
            }

        }
    }
}
