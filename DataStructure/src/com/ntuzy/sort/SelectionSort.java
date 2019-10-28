package com.ntuzy.sort;

import javax.rmi.CORBA.Util;
import java.util.Arrays;

/**
 * 选择排序
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {11, 48, 15, 7};
        sort(arr);
    }

    public static void sort(int[] arr) {
        if (arr.length == 0) {
            return;
        }

        // 定义选择排序需要的轮数 数组的长度
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            // 每一轮选择数据排序进行数据比较
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }

                Utils.swap(arr, i, j);
            }
        }

        System.out.println(Arrays.toString(arr));

    }

}
