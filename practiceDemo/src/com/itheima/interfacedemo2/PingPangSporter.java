package com.itheima.interfacedemo2;

public class PingPangSporter extends Sporter implements SpeakEnglish{
    @Override
    public void speakEnglish() {
        System.out.println("乒乓球运动员说英语");
    }

    @Override
    public void study() {
        System.out.println("乒乓球运动员在学习打乒乓球");
    }

    public PingPangSporter() {
    }

    public PingPangSporter(String name, String age) {
        super(name, age);
    }
}
