package com.myio.charset;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class Demo01 {

    static void main(String[] args) throws UnsupportedEncodingException {

        String str1 = "Java已学崩溃";

        byte[] bytes = str1.getBytes();
        System.out.println(Arrays.toString(bytes));

        System.out.println(new String(bytes, "ASCII"));
        System.out.println(new String(bytes, "GBK"));
        System.out.println(new String(bytes, "UTF-8"));
    }
}
