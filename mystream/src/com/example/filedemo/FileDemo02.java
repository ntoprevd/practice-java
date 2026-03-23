package com.example.filedemo;

import java.io.File;
import java.io.IOException;

public class FileDemo02 {

    static void main(String[] args) throws IOException {

        File f = new File("aaa");
        f.mkdirs();

        File f2 = new File("aaa\\a.txt");
        boolean newFile = f2.createNewFile();

        if(newFile){
            System.out.println("创建成功");
        }else{
            System.out.println("创建失败");
        }

        f2.delete();
        f.delete();
    }
}
