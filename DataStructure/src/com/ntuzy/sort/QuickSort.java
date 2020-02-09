package com.ntuzy.sort;

import java.util.Arrays;
import java.util.Map;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {-9, 78, 24, 23, -567, 70};
//        int[] ints = quickSort(arr, 0, arr.length - 1);
//        System.out.println(Arrays.toString(ints));
        System.out.println(Arrays.toString(quickSort2(arr, 0, arr.length - 1)));
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


    public static int[] quickSort2(int[] arr, int left, int right) {
        int l = left;
        int r = right;
        int pivot = arr[(left + right) / 2];
        int temp = 0;
        while (l < r) {
            // 在pivot左边一直找 找到大于等于pivot的值 才退出
            while (arr[l] < pivot) {
                l += 1;
            }

            while (arr[r] > pivot) {
                r -= 1;
            }

            // 如果 l>=r成立 说明pivot左右两边的值已经按照左边全部都是小于等于pivot的值 右边大于等于pivot的值
            if (l >= r) {
                break;
            }

            // 交换
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            // 如果交换完后 发现arr[l] == pivot的值 r-- 前移
            if (arr[l] == pivot) {
                r -= 1;
            }

            // 如果交换完后 发现arr[] == pivot的值 l++ 前移
            if (arr[r] == pivot) {
                l += 1;
            }
        }

        // 如果 l==r 必须l++ r-- 否则栈溢出
        if (l == r) {
            l += 1;
            r -= 1;
        }

        // 向左递归
        if (left < r) {
            quickSort2(arr, left, r);
        }

        // 向右递归
        if (right > l) {
            quickSort2(arr, l, right);
        }

//        System.out.println(Arrays.toString(arr));

        return arr;

    }


}
