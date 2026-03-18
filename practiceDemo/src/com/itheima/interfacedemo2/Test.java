package com.itheima.interfacedemo2;

public class Test {
    public static void main(String[] args) {
        PingPangSporter pps = new PingPangSporter("小红", "23");
        pps.study();
        pps.speakEnglish();
        System.out.println(pps.getName() + pps.getAge() + "岁了");

        PingPangCoach ppc = new PingPangCoach("大蓝", "34");
        ppc.teach();
        ppc.speakEnglish();
        System.out.println(ppc.getName() + ppc.getAge() + "岁了");

        BasketballSporter bs = new BasketballSporter("小绿", "24");
        bs.study();
        System.out.println(bs.getName() + bs.getAge() + "岁了");

        BasketballCoach bc = new BasketballCoach("大紫", "45");
        bc.teach();
        System.out.println(bc.getName() + bc.getAge() + "岁了");
    }
}
