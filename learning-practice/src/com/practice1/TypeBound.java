package com.practice1;

public class TypeBound {
    public static <Integer extends Comparable<? super Integer>> Integer findMax( Integer[] arr) {
        int maxIndex = 0;
        for (int i = 1; i < arr.length; i++) {
            if( arr[i].compareTo( arr[ maxIndex ]) > 0)
                maxIndex = i;
        }
        return arr[ maxIndex ];
    }
}
