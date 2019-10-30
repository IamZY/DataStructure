package com.ntuzy;

/**
 * 二分查找
 */
public class BinSearchTest {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        Integer index = binSearch(arr, 0, arr.length - 1, 2);
        System.out.println(index);
    }


    public static Integer binSearch(int[] arr, int low, int high, int keyValue) {

        if (low <= high) {
            int mid = (low + high) / 2;
            if (keyValue == arr[mid]) {
                return mid;
            } else if (keyValue < arr[mid]) {
                return binSearch(arr, low, mid - 1, keyValue);
            } else {
                return binSearch(arr, mid + 1, high, keyValue);
            }
        } else {
            return -1;
        }

    }


}
