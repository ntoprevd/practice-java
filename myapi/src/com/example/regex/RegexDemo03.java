package com.example.regex;

public class RegexDemo03 {

    static void main(String[] args) {

        // a123a   &45&
        // abc666abc  *((iii*((
        // aaa123aaa  &&&yu&&&

        String regex1 = "(.).+\\1";
        String regex2 = "(.+).+\\1";
        String regex3 = "((.)\\2+).+\\1";

        System.out.println("a123a".matches(regex1));
        System.out.println("&45&".matches(regex1));
        System.out.println("abc666abc".matches(regex2));
        System.out.println("*((iii*((".matches(regex2));
        System.out.println("aaa123aaa".matches(regex3));
        System.out.println("&&&yu&&&".matches(regex3));
        System.out.println("a123a".matches(regex3));
    }
}
