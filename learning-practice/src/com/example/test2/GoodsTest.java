package com.example.test2;

public class GoodsTest {
    public static void main(String[] args){
        Goods g = new Goods("food",12.2,10);
        System.out.println(g.getName());
        System.out.println(g.getPrice());
        System.out.println(g.getCount());
    }
}
