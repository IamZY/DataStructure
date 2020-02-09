package com.ntuzy.sort;

import java.util.ArrayList;
import java.util.Arrays;

public class RadixSort {
    public static void main(String[] args) {
        int[] arr = {44, 22, 11, 35, 6, 734, 224, 1980, 1};
//        System.out.println(Arrays.toString(sort(arr)));
        radixSort(arr);
    }

    public static int[] sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return arr;
        }

        int max = arr[0];

        for (int i = 0; i < arr.length; i++) {
            max = Math.max(arr[i], max);
        }

        int maxDigit = 0; // 确定最大的数字一共有几位

        while (max != 0) {
            max /= 10;
            maxDigit++;
        }

        int mod = 10; // 每一位的倍数差距
        int div = 1;  // 除法一个除法的基准值

        //
        ArrayList<ArrayList<Integer>> bucketList = new ArrayList<ArrayList<Integer>>();  // 定义一个桶
        for (int i = 0; i < 10; i++) {
            bucketList.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < maxDigit; i++, mod *= 10, div *= 10) {
            for (int j = 0; j < arr.length; j++) {
                int num = (arr[j] % mod) / div;  // 第一次循环取出个位数字进行填充
                bucketList.get(num).add(arr[j]);
            }
            int index = 0;
            // 一个回填的操作
            for (int j = 0; j < bucketList.size(); j++) {
                for (int k = 0; k < bucketList.get(j).size(); k++) {
                    arr[index++] = bucketList.get(j).get(k);
                }
                bucketList.get(j).clear();
            }
        }

        return arr;
    }


    public static void radixSort(int[] arr) {

        // 根据前面的推导
        // 得到数组中最大数的位数
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }

        // 得到最大数的位数
        int maxLength = (max + "").length();

        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
            // 第i轮排序
            // 定义一个 10 二维数组代表一个桶

            int[][] bucket = new int[10][arr.length];

            // 为了记录每个桶实际存放了多少个数据  我们定义一个一维数组记录每次放入的数据个数
            // bucketElementCounts[0] 就是bucket[0] 放入数据的股份数
            int[] bucketElementCounts = new int[10];

            for (int j = 0; j < arr.length; j++) {
                int digitOfElement = arr[j] / n % 10;
                // 放入对应同
                bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
                bucketElementCounts[digitOfElement]++;
            }
            // 按照这个桶的的顺序 一维数组的下表一次取出数据 放入原来数组
            int index = 0;
            // 遍历每一桶 并将桶中数据放入到原数组中
            for (int k = 0; k < bucketElementCounts.length; k++) {
                // 如果桶中有数据 我们菜放入到原数组
                if (bucketElementCounts[k] != 0) {
                    // 循环该桶
                    for (int l = 0; l < bucketElementCounts[k]; l++) {
                        // 取出元素放入到arr
                        arr[index++] = bucket[k][l];
                    }
                }
                // 第i轮处理后 需要将每个buckElementCounts[k] 置 0
                bucketElementCounts[k] = 0;
            }
        }


        System.out.println(Arrays.toString(arr));

    }


}
