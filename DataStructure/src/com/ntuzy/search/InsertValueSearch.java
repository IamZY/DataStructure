package com.ntuzy.search;

import java.util.Arrays;

/**
 * @Author IamZY
 * @create 2020/2/10 10:13
 */
public class InsertValueSearch {
    public static void main(String[] args) {
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }

        int index = insertValueSearch(arr, 0, arr.length - 1, 1);
        System.out.println(index);

    }


    public static int insertValueSearch(int[] arr, int left, int right, int target) {

        // target < arr[0] || target > arr[arr.length - 1] 必须设置
        if (left > right || target < arr[0] || target > arr[arr.length - 1]) {
            return -1;
        }

        int mid = left + (left + right) * (target - arr[left]) / (arr[right] - arr[left]);
        int midVal = arr[mid];

        if (target > midVal) {
            return insertValueSearch(arr, mid + 1, right, target);
        } else if (target < midVal) {
            return insertValueSearch(arr, left, mid - 1, target);
        } else {
            return mid;
        }


    }


}
