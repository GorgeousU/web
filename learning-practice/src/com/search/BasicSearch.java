package com.search;


//{131,127,147,81,103,23,7,79,81}
//基本查找，查找81，并返回其所有索引值

import java.util.ArrayList;

public class BasicSearch {
    public static void main(String[] args){
        int[] arr = {131,127,147,81,103,23,7,79,81};
        int num = 81;
        System.out.println(search(arr,num));
    }


    public static ArrayList<Integer> search(int[] arr, int num){
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == num){
                list.add(i);
            }
        }
        return list;
    }
}
