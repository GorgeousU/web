package com.example.test4;

public class BoyTest {
    public static void main(String[] args){
        Boy[] arr = new Boy[3];
    }

    public static Boy[] createNewArr(Boy[] arr){
        Boy[] newArr = new Boy[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        return newArr;
    }
}
