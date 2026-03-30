package com.myio.charset;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class Demo06 {

    public static void main() throws IOException {

        // 读取数据，进行各种操作
        FileReader fr = new FileReader("E:\\A\\e.txt");
        StringBuilder sb = new StringBuilder();

        int ch;     // 当read是空参，一个字节一个字节来读时，ch用来存放读取的每一个字节对应的编码
        while ((ch = fr.read()) != -1) {

            // 每读取一个字符，就将这个字节存放进sb容器
            sb.append((char) ch);
        }

        fr.close();

        // 先将sb转换成字符串，然后通过split切割转换成字符串数组
        // 利用Arrays工具，将字符串数组放进流
        // 通过map转换将字符串数组中的每一个字符串数据转换成int类型
        // 通过sort给数据默认升序排序
        // 通过toArray将每个数据放进new的int数组
        Integer[] array = Arrays.stream(sb
                        .toString()
                        .split("-"))
                .map(Integer::parseInt)
                .sorted()
                .toArray(Integer[]::new);

        // 输出
        FileWriter fw = new FileWriter("E:\\A\\z.txt");

        // 把数组array转换成字符串，成为[1, 2, 3, 4, 5, 6]之类形式
        // 通过调用字符串的方法replace,替换","
        // 调用substring方法，截取字符串，注意：返回的是新的字符串，原来的字符串没有改变
        String s = Arrays.toString(array)
                .replace(",", "-");
        String result = s.substring(1, s.length() - 1);

        // 写入结果
        fw.write(result);
        fw.close();

    }
}
