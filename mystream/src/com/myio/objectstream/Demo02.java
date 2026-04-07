package com.myio.objectstream;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Demo02 {

    static void main(String[] args) throws IOException, ClassNotFoundException {

        // 反序列化
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("E:\\A\\e.txt"));

        Object stu = ois.readObject();

        System.out.println(stu);

        ois.close();
    }
}
