package com.myio.objectstream;

import java.io.*;

public class Demo01 {

    static void main(String[] args) throws IOException {

        // 序列化
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("E:\\A\\e.txt"));

        Student s = new Student("zhangsan", 23, "南京");

        oos.writeObject(s);

        oos.close();
    }
}
