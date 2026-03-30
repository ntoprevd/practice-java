package com.myio.bufferstream;

import java.io.*;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Demo03 {

    static void main(String[] args) throws IOException {

        // 读取
        BufferedReader br = new BufferedReader(new FileReader("E:\\A\\e.txt"));

        // treeMap
        TreeMap<Integer, String> tm = new TreeMap<>();

        String line;
        while((line = br.readLine()) != null){

            String[] arr = line.split("\\.");
            tm.put(Integer.parseInt(arr[0]), line);
        }

        // 写出
        BufferedWriter bw = new BufferedWriter(new FileWriter("E:\\A\\f.txt"));
        Set<Map.Entry<Integer, String>> entries = tm.entrySet();

        for(Map.Entry<Integer, String> entry: entries){

            String value = entry.getValue();
            bw.write(value);
            bw.newLine();
        }

        bw.close();
        br.close();
    }
}
