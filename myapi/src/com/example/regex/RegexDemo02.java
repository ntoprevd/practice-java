package com.example.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexDemo02 {
    static void main(String[] args) {

        String text = "Java自从95年问世以来，经历了很多版本，目前企业中用的最多的是java8和java11， " +
                "因为这个两个是长期支持的版本，下一个长期支持的版本是Java17， 相信在未来不久java17也会登上历史的舞台" +
                "jAva13,,,Javs11,,,java9,,,qava6";

        // 1. 只要有8、11、17版本号的java，不要版本号
        // 2. 有8、11、17版本号的java，且有版本号
        // 3. 除了版本号为8、11、17的文本

        String regex1 = "((?i)java)(?=8|11|17)";
        String regex2 = "((?i)java)(?:8|11|17)";
        String regex3 = "((?i)java)(?!8|11|17)";

        // 获取正则表达式的对象
        Pattern p = Pattern.compile(regex3);
        // 获取文本匹配器的对象
        Matcher m = p.matcher(text);

        while (m.find()){
            String g = m.group();
            System.out.println(g);
        }
    }
}
