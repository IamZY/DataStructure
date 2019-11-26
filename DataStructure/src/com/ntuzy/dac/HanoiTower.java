package com.ntuzy.dac;

public class HanoiTower {
    public static void main(String[] args) {
        hanoiTower(5, 'A', 'B', 'C');
    }


    // 汉诺塔的移动的方法
    // 使用分治算法

    public static void hanoiTower(int num, char a, char b, char c) {
        // 如果只有一个盘
        if (num == 1) {
            System.out.println("第1个盘从" + a + "移动到" + c);
        } else {
            // 总书大于1的时候 将除了最下面的那个盘记为1,除了最下面的那个剩下的就是1个盘
            // 移动过程会使用到c
            hanoiTower(num - 1, a, c, b);
            // 最下面的盘移动到c
            System.out.println("第" + num + "个盘从" + a + "移动到" + c);
            // 把b塔的所有盘移动到c
            hanoiTower(num - 1, b, a, c);
        }
    }

}
