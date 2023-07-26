package com.example.test3;

public class ArrayTest {
    public static void main(String[] args) {
        Array[] arr = new Array[3];
        Array p1 = new Array("huawei", 4000.1, 10);
        Array p2 = new Array("xiaomi", 2000.1, 20);
        Array p3 = new Array("vivo", 3000.2, 15);

        arr[0] = p1;
        arr[1] = p2;
        arr[2] = p3;

        double sum = 0;
        for (int i = 0; i < arr.length; i++) {
            Array array = arr[i];
            sum += array.getPrice();
        }
        double avg = sum / arr.length;
        System.out.println(avg);
    }
}
