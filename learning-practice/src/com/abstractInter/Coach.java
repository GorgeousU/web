package com.abstractInter;

public abstract class Coach extends Persion{
    public Coach() {
    }

    public Coach(String name, int age) {
        super(name, age);
    }
    public abstract void teach();
}
