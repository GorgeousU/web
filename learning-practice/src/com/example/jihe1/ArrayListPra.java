package com.example.jihe1;

import java.util.ArrayList;
public class ArrayListPra {
    public static void main(String[] args){
        ArrayList<Character> list = new ArrayList<>();
        list.add('a');
        list.add('b');
        list.add('c');

        for (int i = 0; i < list.size(); i++) {
            char l = list.get(i);
            System.out.print(l);
        }
    }
}
