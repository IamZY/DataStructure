package com.ntuzy.sort;


import java.util.Arrays;

public class CountingSort {
    public static void main(String[] args) {

    }

    public static int[] sort(int[] arr) {
        int min = arr[0], max = arr[0];
        for (int i = 0; i < arr.length; i++) {  // 找到最大最小的值
            if (arr[i] > max) {
                max = arr[i];
            }

            if (arr[i] < min) {
                min = arr[i];
            }
        }


        // 定义一个额外的数组
        int[] bucket = new int[max - min + 1];

        Arrays.fill(bucket, 0);
        for (int i = 0; i < arr.length; i++) {
            bucket[arr[i] - min]++;
        }
        //
        int index = 0, i = 0;
        while (index < arr.length) {
            if (bucket[i] != 0) {
                arr[index] = i + min;
                bucket[i]--;
                index++;
            } else {
                i++;
            }
        }

        return arr;
    }


}
