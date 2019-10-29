package com.ntuzy;

/**
 * 伪递归
 */
public class NumberTest {
    public static void main(String[] args) {
        System.out.println(getSum(5));
        System.out.println(getX(5));
        System.out.println(getX(5, 1));
    }

    // 三角数字
    public static int getSum(int n) {
        int total = 0;
        if (n == 1) {
            return 1;
        } else {
            total = n + getSum(n - 1);
            return total;
        }
    }

    // 阶乘
    public static int getX(int n) {
        if (n == 1) {
            return 1;
        } else {
            int totle = n * getX(n - 1);
            return totle;
        }
    }

    // 尾递归
    public static int getX(int n, int a) {
        if (n == 1) {
            return a;
        } else {
            int total = getX(n - 1, n * a);
            return total;
        }
    }


}
