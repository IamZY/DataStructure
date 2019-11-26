package com.ntuzy.dynamic;

import java.util.function.IntPredicate;

public class KnapsackProblem {
    public static void main(String[] args) {
        int[] w = {1, 4, 3};
        int[] val = {1500, 3000, 2000}; // 这里的val[i] 就是前面讲的v[i]
        int m = 4;
        int n = val.length; // 物品的个数

        // 为了记录放入商品的情况 定义一个二位数组
        int[][] path = new int[n + 1][m + 1];

        // 创建二维数组
        int[][] v = new int[n + 1][m + 1];

        // 初始化第一行和第一列 这里再本程序中可以不去处理
        for (int i = 0; i < v.length; i++) {
            v[i][0] = 0;// 将第一列设置为0
        }

        for (int i = 0; i < v[0].length; i++) {
            v[0][i] = 0;// 将第一行设置为0
        }

        // 根据之前的公式进行动态规划处理
        for (int i = 1; i < v.length; i++) { // 不处理第一行
            for (int j = 1; j < v[0].length; j++) { // 不处理第一列
                // 公式
                if (w[i - 1] > j) {
                    v[i][j] = v[i - 1][j];
                } else {
                    // v[i][j] = Math.max(v[i - 1][j], val[i - 1] + v[i - 1][j - w[i - 1]]);
                    // 为了记录商品存放到背包的情况 不能使用上面的公式 需要if else处理
                    if (v[i - 1][j] < val[i - 1] + v[i - 1][j - w[i - 1]]) {
                        v[i][j] = val[i - 1] + v[i - 1][j - w[i - 1]]; //
                        path[i][j] = 1;
                    } else {
                        v[i][j] = v[i - 1][j];
                    }
                }
            }
        }


        // 输出一下v
        for (int i = 0; i < v.length; i++) {
            for (int j = 0; j < v[i].length; j++) {
                System.out.print(v[i][j] + " ");
            }
            System.out.println();
        }

        // 输出我们最后放入的是哪些商品


    }
}
