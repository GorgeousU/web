package com.example.test5;

public class PracticeTest {
    public static void main(String[] args){
        Practice[] arr = new Practice[2];
        Practice p1 = new Practice("xiao",10);
        Practice p2 = new Practice("da",5);
        arr[0] = p1;
        arr[1] = p2;
        for (int i = 0; i < arr.length; i++) {
            Practice array = arr[i];
            System.out.println(array.getName());
        }
    }
}
