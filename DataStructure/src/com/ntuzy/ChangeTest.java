package com.ntuzy;

public class ChangeTest {

    static int size;
    static int count;
    static char[] ch = new char[100];

    public static void main(String[] args) {

    }

    /**
     * @param n 代表字母的长度
     */
    public static void doChange(int n) {
        if (n == 1) {
            return;
        } else {
            for (int i = 0; i < n; i++) {  // 向前移动n-1次
                doChange(n - 1);
                if (n == 2) {
                    // 打印
                    display();
                }
                // 移动的函数
                move(n);
            }
        }
    }

    private static void display() {
        if (count < 99) {
            System.out.println(" ");
        }
        if (count < 9) {
            System.out.println("  ");
        }

        System.out.println(++count + ":");
        for (int i = 0; i < size; i++) {
            System.out.print(ch[i]);
        }
        System.out.print("  ");
        System.out.flush();
        if (count % 6 == 0) {
            System.out.println();
        }
    }

    private static void move(int n) {
        // 把最后的字母向前移动n-1位
        int j;
        int position = size - n;
        char temp = ch[position];
        for (j = position + 1; j < size; j++) {
            ch[j - 1] = ch[j];
        }
        ch[j - 1] = temp;
    }

}
