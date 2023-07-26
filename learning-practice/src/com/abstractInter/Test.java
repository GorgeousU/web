package com.abstractInter;

public class Test {
    public static void main(String[] args){
        PingpangSporter pps = new PingpangSporter("fan",21);
        BasketballSporter bbs = new BasketballSporter("jame",38);
        PingpangCoach ppc = new PingpangCoach("liu",50);
        BasketballCoach bbc = new BasketballCoach("john",40);
        System.out.println(pps.getName()+" "+pps.getAge());
        pps.study();
        pps.speakEnglish();
    }
}
