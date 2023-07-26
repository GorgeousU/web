package com.example.test5;

public class StringTest {
    public static void main(String[] args){
        String s1 = new String("abc");
        String s2 = "abc";
        System.out.println(s1 == s2);

        boolean result1 = s1.equals(s2);
        System.out.println(result1);
    }
}
