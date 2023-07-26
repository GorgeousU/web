package com.algorithm.search;

public class InterpolationSearch {
    public static int interpolationSearch(int[] arr,int target){
        int left = 0;
        int right = arr.length - 1;
        while(left <= right && target >= arr[left] && target <= arr[right]){
            int mid = (target - arr[left])*(right - left)/(arr[right] - arr[left]);
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
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        int target = 9;
        int i = interpolationSearch(arr,target);
        System.out.println("目标元素的下标为："+i+" 目标元素为："+arr[i]);
    }
}
