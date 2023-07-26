package com.algorithm;

import java.util.Arrays;

public class Test {
    public static void main(String[] args){
        int[] a = {1,3,5,2};
        int[] b = Arrays.copyOf(a,3);
        System.out.println(Arrays.toString(b));//[1, 3, 5]
        int[] c = Arrays.copyOf(a,5);
        System.out.println(Arrays.toString(c));//[1, 3, 5, 2, 0]
    }
}
