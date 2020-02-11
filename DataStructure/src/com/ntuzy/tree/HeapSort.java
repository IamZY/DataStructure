package com.ntuzy.tree;

import java.util.Arrays;

/**
 * @Author IamZY
 * @create 2020/2/11 14:16
 */
public class HeapSort {
    public static void main(String[] args) {
        int arr[] = {4, 6, 8, 7, 5, 9};
        heapSort(arr);
    }

    // 编写一个堆排序算法
    public static void heapSort(int arr[]) {

        // 分布完成
//        adjustHeap(arr, 1, arr.length);
//        System.out.println(Arrays.toString(arr));  // 4 9 8 5 6
//
//        adjustHeap(arr, 0, arr.length);
//        System.out.println(Arrays.toString(arr));  // 9 6 8 5 4

        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }

        int temp;
        for (int i = arr.length - 1; i > 0; i--) {
            temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            adjustHeap(arr, 0, i);
        }


        System.out.println(Arrays.toString(arr));

    }

    // 将一个数组(二叉树) 调整成一个大顶堆

    /**
     * 完成将 以 i 指向的对应的非叶子节点 调整成大顶堆
     *
     * @param arr
     * @param i      标识非叶子节点在数组中的索引
     * @param length
     */
    public static void adjustHeap(int[] arr, int i, int length) {
        int temp = arr[i];
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            if (k + 1 < length && arr[k] < arr[k + 1]) {
                // 左子节点的值小于右子节点的值
                k++; // k指向右子节点
            }
            if (arr[k] > temp) {
                arr[i] = arr[k];
                i = k;
            } else {
                break;
            }
        }

        // for循环结束后 我们已经将i为父节点的树的最大值 放在了最顶
        arr[i] = temp;
    }

}
