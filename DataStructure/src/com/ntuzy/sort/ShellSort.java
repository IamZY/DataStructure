package com.ntuzy.sort;

import java.util.Arrays;

/**
 * 希尔排序
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
//        sort(arr);
        sort2(arr);
    }

    public static void sort(int[] arr) {
        int len = arr.length;
        int temp;
        int gap = len / 2;
        while (gap > 0) {
            for (int i = gap; i < len; i++) {
                int preIndex = i - gap; // 此时为0

                temp = arr[i];
                while (preIndex >= 0 && arr[preIndex] > temp) {
                    arr[preIndex + gap] = arr[preIndex];
                    preIndex -= gap;
                }

                arr[preIndex + gap] = temp;
            }
            gap /= 2;
        }

        System.out.println(Arrays.toString(arr));

    }


    public static void sort2(int[] arr) {

        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                for (int j = i - gap; j >= 0; j -= gap) {
                    // 如果当前元素大于加上步长的那个元素 说明交换
                    if (arr[j] > arr[j + gap]) {
                        int temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
        }

        System.out.println(Arrays.toString(arr));




//        // shell排序的第一轮排序
//
//        // 因为第一轮排序 是将10个数据分成五组
//        for (int i = 5; i < arr.length; i++) {
//            for (int j = i - 5; j >= 0; j -= 5) {
//                // 如果当前元素大于加上步长的那个元素 说明交换
//                if (arr[j] > arr[j + 5]) {
//                    int temp = arr[j];
//                    arr[j] = arr[j + 5];
//                    arr[j + 5] = temp;
//                }
//            }
//        }
//
//        System.out.println(Arrays.toString(arr));
//
//
//        for (int i = 2; i < arr.length; i++) {
//            for (int j = i - 2; j >= 0; j -= 2) {
//                // 如果当前元素大于加上步长的那个元素 说明交换
//                if (arr[j] > arr[j + 2]) {
//                    int temp = arr[j];
//                    arr[j] = arr[j + 2];
//                    arr[j + 2] = temp;
//                }
//            }
//        }
//
//        System.out.println(Arrays.toString(arr));
//
//
//        for (int i = 1; i < arr.length; i++) {
//            for (int j = i - 1; j >= 0; j -= 1) {
//                // 如果当前元素大于加上步长的那个元素 说明交换
//                if (arr[j] > arr[j + 1]) {
//                    int temp = arr[j];
//                    arr[j] = arr[j + 1];
//                    arr[j + 1] = temp;
//                }
//            }
//        }
//
//        System.out.println(Arrays.toString(arr));

    }


}
