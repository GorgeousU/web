package com.example.InnerTest;

public class Test {
    public static void main(String[] args){
        new Swim() {

            @Override
            public void swim() {
                System.out.println("重写Swim的方法");
            }
        };
    }
}
