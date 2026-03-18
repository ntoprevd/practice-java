package com.example.regex;

public class RegexDemo01 {

    static void main(String[] args) {

        // 手机号码
        String regex1 = "[1][3-9]\\d{9}";

        // 座机号码
        String regex2 = "[0]\\d{2,3}-?[1-9]\\d{4,9}";

        // 邮箱号
        String regex3 = "\\w+@[\\w&&[^-]]{2,6}(\\.[a-zA-Z]{2,3}){1,2}";

        // 24小时时间表示 00：00：00    23：59：59
        // 00 - 23      00-09 10-19 20-23
        // 00 - 59      00-09 10-19 20-29 ...50-59
        String regex4 = "([0-1]\\d)|(2[0-3])(:[0-5]\\d){2}";
        /*String time1 = "23:87:56";
        String time2 = "24:14:56";
        String time3 = "06:14:6";
        System.out.println(time1.matches(regex4));
        System.out.println(time2.matches(regex4));
        System.out.println(time3.matches(regex4));*/

        // 用户名
        String regex5 = "\\w{4,15}";

        // 身份证阉割版
        String regex6 = "[1-9]\\d{16}[\\dXx]";
        String regex7 = "[1-9]\\d{16}(\\d|X|x)";
        String regex8 = "[1-9]\\d{16}(\\d|(?i)x)";

        // 身份证校验
        String regex9 = "[1-9]\\d{5}(18|19|20)(\\d){2}(0[1-9]|1[0-2])(0[1-9]|[1-2]\\d|3[0-1])\\d{3}[\\dXx]";
    }
}
