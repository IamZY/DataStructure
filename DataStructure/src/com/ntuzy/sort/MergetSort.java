package com.ntuzy.sort;

import java.util.Arrays;

/**
 * @Author IamZY
 * @create 2020/2/9 13:32
 */
public class MergetSort {
    public static void main(String[] args) {
        int[] arr = {8, 4, 5, 7, 1, 3, 6, 2};
        int[] temp = new int[arr.length];
//        System.out.println(1 << 3);
        mergeSort(arr, 0, arr.length - 1, temp);


//        System.out.println(Arrays.toString(arr));

    }


    // 分+合
    public static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (right + left) / 2;
            // 先向左递归
            mergeSort(arr, left, mid, temp);
            // 向右递归分解
            mergeSort(arr, mid + 1, right, temp);

            // 到合并
            merge(arr, left, mid, right, temp);
        }
    }


    /**
     * 合并
     *
     * @param arr   排序的原始数组
     * @param left  左边后续徐立德初始索引
     * @param mid   中间索引
     * @param right 右边索引
     * @param temp  左中转的数组
     */
    public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;  // 初始化i 左边有序序列的索引
        int j = mid + 1;
        int t = 0;

        // 先把左边两边的数据按照规则填充到temp数组
        // 直到左右两边的有序序列 有一边处理完毕为止
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[t] = arr[i];
                t += 1;
                i += 1;
            } else {
                temp[t] = arr[j];
                t += 1;
                j += 1;
            }
        }


        // 把有剩余数据的一边的数据一次全部填充到temp
        while (i <= mid) { // 左边的有序序列还有剩余的数组
            temp[t] = arr[i];
            t += 1;
            i += 1;
        }

        while (j <= right) {
            temp[t] = arr[j];
            t += 1;
            j += 1;
        }

        System.out.println(Arrays.toString(arr));

        // 将temp数组元素拷贝到arr
        t = 0;
        int tempLeft = left;
        while (tempLeft <= right) {
            arr[tempLeft] = temp[t];
            t += 1;
            tempLeft += 1;
        }

    }

}
