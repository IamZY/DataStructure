package com.ntuzy.sort;


public class HeapSort {
    private static int len;

    public static void main(String[] args) {

    }

    //
    public static int[] heapSort(int[] arr) {
        len = arr.length;
        // 1 构建大顶堆  构建大顶堆中调整的递归方法
        buildMaxHeap(arr);
        // 2 将顶部的元素 与无序区的最后一个元素交换位置
        while (len > 0) {
            Utils.swap(arr, 0, len - 1);   // 0表示大顶元素 len-1表示最后一个元素
            len--; // 无序区的长度减少一位
            changeHeap(arr, 0);
        }
        return arr;
    }

    // 构建大顶堆
    public static void buildMaxHeap(int[] arr) {
        for (int i = len / 2; i < arr.length; i--) {
            // 调整大顶堆
            changeHeap(arr, i);
        }
    }

    /**
     * 调整大顶堆
     *
     * @param arr
     * @param i
     */
    private static void changeHeap(int[] arr, int i) {

        int maxIndex = i;
        // 如果有左子树且左子树大于父节点  那么将最大指针指向左子树
        if (i * 2 < len && arr[i] * 2 > arr[maxIndex]) {
            maxIndex = i * 2;
        }

        // 如果有右子树且右子树大于父节点  那么将最大指针指向右子树
        if (i * 2 + 1 < len && arr[i * 2 + 1] > arr[maxIndex]) {
            maxIndex = i * 2 + 1;
        }

        // 如果父节点不是最大值 则将父节点与最大值进行交换 这样才能保证我们的父节点是最大的 构建成一个大顶堆
        if (maxIndex != i) {
            Utils.swap(arr, maxIndex, i);
            changeHeap(arr, maxIndex);
        }


    }

}
