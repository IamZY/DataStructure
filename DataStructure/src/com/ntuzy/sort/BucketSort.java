package com.ntuzy.sort;

import java.util.ArrayList;

public class BucketSort {

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(5);
        arr.add(77);
        arr.add(11);
        arr.add(3);
        arr.add(76);
        arr.add(76);
        System.out.println(sort(arr, 3));
    }

    public static ArrayList<Integer> sort(ArrayList<Integer> arr, int bucketSize) {

        if (arr == null || arr.size() < 2) {
            return arr;
        }

        int min = arr.get(0), max = arr.get(0);
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) > max) {
                max = arr.get(i);
            }

            if (arr.get(i) < min) {
                min = arr.get(i);
            }
        }

        int bucketCount = (max - min) / bucketSize + 1; // 避免bucketCaunt为 0
        ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<>(bucketCount);

        ArrayList<Integer> resultArr = new ArrayList<>();   // 内层存放值的list
        // 初始化桶
        for (int i = 0; i < bucketCount; i++) {
            // 计数排序里面是数字的类型 桶排序里面是list
            bucketArr.add(new ArrayList<Integer>());
        }

        // 循环原始的数据 将原始数据填充到应该填充的位置
        for (int i = 0; i < arr.size(); i++) {
            bucketArr.get((arr.get(i) - min) / bucketSize).add(arr.get(i));
        }

        // 递归的将桶里的数据进行i排序并且回填我们的原数组中
        for (int i = 0; i < bucketCount; i++) {
            if (bucketSize == 1) { // 有重复数据出现的时候的进行判断
                for (int j = 0; j < bucketArr.get(i).size(); j++) {
                    resultArr.add(bucketArr.get(i).get(j));
                }
            } else {
                if (bucketCount == 1) {
                    bucketSize--;  // 也是为了避免递归操作中数据少 size大 导致桶的数量为1 这样就不能再继续排序了 bucketCount
                }
                // 递归式的进桶排序
                ArrayList<Integer> temp = sort(bucketArr.get(i), bucketSize);  // 递归操作 bucketSize不能为0 因为0不能做被除数
                // 将排序好的序列回填到 我们的结果list里面
                for (int j = 0; j < temp.size(); j++) {
                    resultArr.add(temp.get(j));
                }
            }
        }

        return resultArr;
    }


}
