package com.ntuzy.recursion;

/**
 * @Author IamZY
 * @create 2020/2/4 14:30
 */
public class Queue8 {
    // 定义一个max 标识共有多少个皇后
    int max = 8;
    // 定义一个数组array 保存结果
    int[] array = new int[max];
    static int count = 0;

    public static void main(String[] args) {
        // 测试
        Queue8 queue8 = new Queue8();
        queue8.check(0);
        System.out.println(count);
    }

    // 写一个方法可以将皇后摆放的位置输出
    private void print() {
        count++;
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }


    // 放置第n个皇后
    private void check(int n) {
        if (n == max) { // n = 8
            print();
            return;
        }
        // 一次存放 并 判断是否冲突
        for (int i = 0; i < max; i++) {
            // 先把当前皇后 放到该行的第一列
            array[n] = i;
            // 判断当放置第n个皇后 是否冲突
            if (judge(n)) {  // 不冲突
                // 接着放置n+1个皇后
                check(n + 1);
            }
            // 如果冲突 就继续执行array[n] = i 即将第n个皇后 放着在本行的后移一个位置
        }
    }


    // 查看放置第n个皇后 检测该皇后是否和前面已经摆放的皇后冲突

    /**
     * @param n 标识摆放第n个皇后
     * @return
     */
    private boolean judge(int n) {
        for (int i = 0; i < n; i++) {
            // array[i] == array[n] 是否在同一列
            // Math.abs(n - i) == Math.abs(array[n] - array[i]  是否在同一斜线
            if (array[i] == array[n] || Math.abs(n - i) == Math.abs(array[n] - array[i])) {
                return false;
            }
        }
        return true;
    }


}
