package com.ntuzy.sort;

import java.util.Arrays;
import java.util.Map;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {11, 48, 15, 7};
        int[] ints = quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(ints));
    }

    // 快排
    public static int[] quickSort(int[] arr, int start, int end) {
        //
        int smallIndex = partition(arr, start, end);  // 最终这个位置是smallIndex的值
        // 左半部分
        if (smallIndex > start) {
            quickSort(arr, start, smallIndex - 1);
//            PartSort(arr, start, smallIndex - 1);
        }

        // 右半部分
        if (smallIndex < end) {
            quickSort(arr, smallIndex + 1, end);
//            PartSort(arr, smallIndex + 1, end);
        }
        return arr;
    }

    // 分区操作
    public static int partition(int[] arr, int start, int end) {
        // 设定基准值
        int pivot = (int) (start + Math.random() * (end - start + 1));
        // 将基准移动到数组后面
        Utils.swap(arr, pivot, end);
        int smallIndex = start - 1;   // 比基准数大的索引角标 用于交换位置

        for (int i = start; i <= end; i++) {
            if (arr[i] <= arr[end]) {  // 将第i个元素与基准值进行对比
                smallIndex++;
                if (i > smallIndex) {
                    Utils.swap(arr, i, smallIndex);
                }
            }
        }

        return smallIndex;
    }


    public static int PartSort(int[] array, int left, int right) {
        if (left < right) {
            int key = array[right];
            int cur = left;
            int pre = cur - 1;
            while (cur < right) {
                while (array[cur] < key && ++pre != cur)//如果找到小于key的值，并且cur和pre之间有距离时则进行交换。注意两个条件的先后位置不能更换，可以参照评论中的解释
                {
                    Utils.swap(array, array[cur], array[pre]);
                }
                ++cur;
            }
            Utils.swap(array, array[++pre], array[right]);
            return pre;
        }
        return -1;
    }


}
