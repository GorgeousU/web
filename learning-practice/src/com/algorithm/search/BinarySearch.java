package com.algorithm.search;

//折半查找
public class BinarySearch {
    public static int binarySearch(int[] arr,int target){
        int left = 0;
        int right = arr.length - 1;
        while (left <= right){
            int mid = (left + right)/2;
            if(arr[mid] == target){
                return mid;
            }else if(arr[mid] < target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        int[] arr ={1,2,3,4,5,6};
        int t = 5;
        int i = binarySearch(arr,t);
        System.out.println("返回的值为："+arr[i]+" 查找返回的下标为："+i);
    }
}
