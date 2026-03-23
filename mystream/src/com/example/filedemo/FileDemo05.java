package com.example.filedemo;

import java.io.File;
import java.io.IOException;

public class FileDemo05 {

    static void main(String[] args) throws IOException {

        File src = new File("E:\\AAA\\CCC");
        deleteFile(src);

    }

    public static void deleteFile(File file){

        File[] files = file.listFiles();

        if(files == null){
            return;
        }

        for (int i = 0; i < files.length; i++) {

            // 文件
            if(files[i].isFile()){
                files[i].delete();
            }else {
                deleteFile(files[i]);
            }
        }

        deleteFile(file);

    }
}
