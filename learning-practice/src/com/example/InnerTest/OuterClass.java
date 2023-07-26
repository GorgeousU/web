package com.example.InnerTest;

public class OuterClass {
    String name;
    class Inner{

    }
    public Inner getInstance(){
        return new Inner();
    }
}
