package com.heima.demo3;

public class StringDemo1 {

    public static void main(String[] args) {

        String s1 = "abc";
        String s2 = "abc";
        boolean result = s1.equals(s2);
        System.out.println(result);

        String s3 = "Abc";
        boolean result2 = s1.equals(s3);
        System.out.println(result2);

        boolean result3 = s1.equalsIgnoreCase(s3);
        System.out.println(result3);

        String s4 = new String("abc");
        System.out.println(s4 == s1);

        boolean result4 = s1.equalsIgnoreCase(s4);
        System.out.println(result4);
    }
}
