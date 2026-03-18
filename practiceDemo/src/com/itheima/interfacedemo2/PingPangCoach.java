package com.itheima.interfacedemo2;

public class PingPangCoach extends Coach implements SpeakEnglish{
    @Override
    public void teach() {
        System.out.println("乒乓球教练教打乒乓球");
    }

    @Override
    public void speakEnglish() {
        System.out.println("乒乓球教练说英语");
    }

    public PingPangCoach() {
    }

    public PingPangCoach(String name, String age) {
        super(name, age);
    }
}
