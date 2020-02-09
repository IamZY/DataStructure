package com.ntuzy.sort;

import javax.rmi.CORBA.Util;
import java.time.chrono.MinguoChronology;
import java.util.Arrays;

/**
 * 选择排序
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {11, 48, 15, 7};
//        sort(arr);
        sort2(arr);
    }

    public static void sort(int[] arr) {
        if (arr.length == 0) {
            return;
        }


        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            int min = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]) {
                    min = arr[j];
                    minIndex = j;
                }
            }

            // 交换
            arr[minIndex] = arr[i];
            arr[i] = min;
        }


        System.out.println(Arrays.toString(arr));

    }

    public static void sort2(int arr[]) {

        int min = 0;
        for (int i = 0; i < arr.length; i++) {
            min = arr[i];
//            System.out.println(i + "-" + min);
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                    min = arr[j];
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

}
