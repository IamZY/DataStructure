package com.ntuzy.tree.huffmantree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TooManyListenersException;

/**
 * @Author IamZY
 * @create 2020/2/11 15:08
 */
public class HuffmanTree {
    public static void main(String[] args) {
        int arr[] = {13, 7, 8, 3, 29, 6, 1};
        Node root = createHuffmanTree(arr);
        System.out.println(root.value);
        System.out.println();
        preOrder(root);

    }


    public static Node createHuffmanTree(int[] arr) {
        // 第一步为了操作方便
        // 遍历array数组
        // 将arr的每个元素构建成一个Node
        // 将node放入到ArrayList

        List<Node> nodes = new ArrayList<>();

        for (int value : arr) {
            nodes.add(new Node(value));
        }


        while (nodes.size() > 1) {
            // 排序
            Collections.sort(nodes);
//        System.out.println(nodes);
            // 取出权值最小的两个数
            Node left = nodes.get(0);
            Node right = nodes.get(1);

            // 构建一颗新的二叉树
            Node parent = new Node(left.value + right.value);
            parent.left = left;
            parent.right = right;

            nodes.remove(left);
            nodes.remove(right);

            nodes.add(parent);
        }


        return nodes.get(0);
    }

    public static void preOrder(Node node) {
        if (node == null) {
            System.out.println("空树");
        } else {
            node.preOrder();
        }
    }

}


// 创建节点类
// 为了让node 对象持续排序
class Node implements Comparable<Node> {
    int value;
    Node left;
    Node right;


    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    @Override
    public int compareTo(Node o) {
        return this.value - o.value;
    }

    // 写一个前序遍历
    public void preOrder() {
        System.out.println(this);

        if (this.left != null) {
            this.left.preOrder();
        }

        if (this.right != null) {
            this.right.preOrder();
        }
    }

}
