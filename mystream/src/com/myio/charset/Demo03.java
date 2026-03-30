package com.myio.charset;

import java.io.*;

public class Demo03 {

    static void main(String[] args) throws IOException {

        File src = new File("E:\\A");
        File dest = new File("E:\\C");

        copyDir(src, dest);

    }

    public static void copyDir(File src, File dest) throws IOException {

        dest.mkdirs();

        // 进入文件夹
        File[] files = src.listFiles();

        if(files == null){
            return;
        }

        // 遍历
        for(File file: files){

            // 文件,则拷贝
            if(file.isFile()){

                // 字节流
                FileInputStream fis = new FileInputStream(file);
                FileOutputStream fos = new FileOutputStream(new File(dest, file.getName()));

                byte[] bytes = new byte[1024];
                int len;

                while((len = fis.read(bytes)) != -1){
                    fos.write(bytes, 0, len);
                }

                fos.close();
                fis.close();

            }else{
                // 文件夹，则递归

                copyDir(file, new File(dest, file.getName()));

            }

        }
    }
}
