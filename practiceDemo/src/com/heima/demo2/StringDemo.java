package com.heima.demo2;

public class StringDemo {

    public static void main(String[] args) {

        String s1 = "zxcvb" ;
        System.out.println(s1);

        String s2 = new String();
        System.out.println("!" + s2 + "!");

        String s3 = new String("zxcvbnm");
        System.out.println(s3);

        char[] arr = {'z', 'x', 'c', 'b'};
        String s4 = new String(arr);
        System.out.println(s4);

        byte[] bytes = {97, 98, 99, 100};
        String s5 = new String(bytes);
        System.out.println(s5);
    }
}
