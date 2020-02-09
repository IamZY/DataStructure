package com.ntuzy.sort;


import java.util.Arrays;

/**
 * 插入排序
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] arr = {11, 7, 48, 15};
        sort2(arr);
    }


    public static void sort(int[] arr) {

        if (arr.length == 0) {
            return;
        }

        // 设置当前的元素
        int current;
        for (int i = 0; i < arr.length - 1; i++) {
            current = arr[i + 1];
            int preIndex = i;
            while (preIndex >= 0 && current < arr[preIndex]) {
                // 需要将上一元素进行下移操作
                arr[preIndex + 1] = arr[preIndex];
                preIndex--;
            }
            arr[preIndex + 1] = current;
        }

        System.out.println(Arrays.toString(arr));

    }


    public static void sort2(int[] arr) {


        for (int i = 0; i < arr.length; i++) {
            // 定义第一个插入的数
            int insertVal = arr[i];
            int insertIndex = i - 1; // arr[1] 的前面这个数的下标

            // insertVal
            // 保证在insertVal 找插入位置时不越界
            // 说明待插入的数没有找到适当的位置
            // 就需要将insertIndex 向后移动
            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }

            arr[insertIndex + 1] = insertVal;
        }


        System.out.println(Arrays.toString(arr));

    }


}
