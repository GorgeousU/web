package com.abstractInter;

public class PingpangSporter extends Sporter implements English{
    public PingpangSporter() {
    }

    public PingpangSporter(String name, int age) {
        super(name, age);
    }
    @Override
    public void study() {
        System.out.println("乒乓球运动员学打乒乓球");
    }
    @Override
    public void speakEnglish() {
        System.out.println("乒乓球运动员说英语");
    }



}
