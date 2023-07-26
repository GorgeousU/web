package com.abstractInter;

public class BasketballCoach extends Coach{
    @Override
    public void teach() {
        System.out.println("篮球教练教打篮球");
    }

    public BasketballCoach() {
    }

    public BasketballCoach(String name, int age) {
        super(name, age);
    }
}
