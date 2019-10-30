package com.ntuzy;

import java.util.Arrays;

public class MergeSorted {
    public static void main(String[] args) {
        int[] arr = {3, 8, 1, 0, 2, 33};
        System.out.println(Arrays.toString(megerSort(arr)));
    }

    // 将整个数组进行一个递归式的分割治理
    public static int[] megerSort(int[] arr) {
        if (arr.length < 2) {
            return arr;
        }
        int mid = arr.length / 2;
        // 包含头不包含尾
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);

        return merge(megerSort(left), megerSort(right));
    }


    // 将两个排序好的数组合并为一个数组
    public static int[] merge(int[] left, int[] right) {

        int[] result = new int[left.length + right.length];
        for (int index = 0, i = 0, j = 0; index < result.length; index++) {
            if (i >= left.length) {
                result[index] = right[j++];
            } else if (j >= right.length) {
                result[index] = left[i++];
            } else if (left[i] > right[j]) {
                result[index] = right[j++];
            } else {
                result[index] = left[i++];
            }
        }

        return result;
    }


}
