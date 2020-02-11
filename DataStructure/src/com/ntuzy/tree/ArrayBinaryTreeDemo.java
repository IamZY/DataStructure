package com.ntuzy.tree;

import java.util.ArrayList;

/**
 * @Author IamZY
 * @create 2020/2/11 10:29
 */
public class ArrayBinaryTreeDemo {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7};
        ArrayBinaryTree abt = new ArrayBinaryTree(arr);
        abt.preOrder();
        System.out.println();
        abt.infixOrder(0);
    }
}


// 編寫一個ArrayBinaryTree
class ArrayBinaryTree {
    private int[] arr;

    public ArrayBinaryTree(int[] arr) {
        this.arr = arr;
    }

    public void preOrder() {
        this.preOrder(0);
    }

    public void preOrder(int index) {
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空 不能遍历二叉树的前序遍历");
        }
        // 输出当前元素
        System.out.println(arr[index]);
        // 向左递归遍历
        if (2 * index + 1 < arr.length) {
            preOrder(2 * index + 1);
        }

        if (2 * index + 2 < arr.length) {
            preOrder(2 * index + 2);
        }

    }


    public void infixOrder(int index) {
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空 不能遍历二叉树的前序遍历");
        }

        // 向左递归遍历
        if (2 * index + 1 < arr.length) {
            infixOrder(2 * index + 1);
        }

        // 输出当前元素
        System.out.println(arr[index]);

        if (2 * index + 2 < arr.length) {
            infixOrder(2 * index + 2);
        }

    }

}