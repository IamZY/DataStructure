package com.ntuzy.tree;

import javax.print.attribute.standard.NumberOfInterveningJobs;

/**
 * 二叉树
 */
public class Tree {

    private Node root;

    public Tree() {
        root = null;  // 创建一个空树
    }

    // 查询
    public Node find(int key) {
        Node current = root; // 我们的查询是需要从root节点开始查询的

        while (key != current.iData) {

            if (key < current.iData) { // 如果小于当前的key 向左子树进行一个查找
                current = current.leftChild;
            } else {
                current = current.rightChild;  // 如果大于当前的key 则向右子树进行查找
            }

            if (current == null) {
                return null;   // 说明当前二叉树没有存储此值
            }

        }

        return current;
    }

    // 插入

    /**
     * @param id 代表索引
     * @param dd 代表值
     */
    public void insert(int id, double dd) {
        Node newNode = new Node();
        newNode.iData = id;
        newNode.dData = dd;

        if (root == null) { // 如果为空树 直接将新的节点赋予root节点
            root = newNode;
        } else {

            // 如果不为空
            Node current = root;  // 从root节点开始查找  满足左小右大
            Node parent; // 定义一个父节点 该父节点与current相关

            while (true) {

                parent = current;  // 初始化赋值
                if (id < current.iData) {
                    current = current.leftChild;
                    if (current == null) {  // 当前节点为空 则代表有位置插入节点
                        parent.leftChild = newNode;
                        return;
                    }
                } else {
                    current = current.rightChild;
                    if (current == null) {
                        parent.rightChild = newNode;
                        return;
                    }
                }

            }


        }


    }


}


class Node {
    public Node leftChild;
    public Node rightChild;  // 需要关联的时候进行一个数据指定 并且此属性代表二叉树利用了链表的结构
    public int iData;  // 定义一个索引  一个二叉树的节点 利用数组的索引结构 有利于快读的查询
    public double dData;


    public void displayNode() {
        System.out.println("{");
        System.out.println(iData);
        System.out.println(", ");
        System.out.println(dData);
        System.out.println("}");
    }
}
