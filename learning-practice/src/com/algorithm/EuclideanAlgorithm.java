package com.algorithm;

//欧几里得算法计算最大公约数
public class EuclideanAlgorithm {
    public static long gcd( long m , long n) {
        while ( n != 0) {
            long rem = m % n;
            m = n;
            n = rem;
        }
        return m;
    }

    public static void main(String[] args) {
        long x = gcd(1989,1590);
        System.out.println("最大公约数为：" + x);
    }
}
