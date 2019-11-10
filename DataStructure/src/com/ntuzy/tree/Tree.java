package com.ntuzy.tree;

import javax.print.attribute.standard.NumberOfInterveningJobs;
import java.util.Calendar;
import java.util.Stack;

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


    // 删除
    public boolean delete(int key) {

        Node current = root;
        Node parent = root;
        boolean isLeftChild = false;

        // 查找到想要删除的节点
        while (current.iData != key) {
            parent = current;

            if (key < current.iData) {
                isLeftChild = true;
                current = current.leftChild;
            } else {
                isLeftChild = false;
                current = current.rightChild;
            }

            // 叶子节点 没有节点
            if (current == null) {
                return false;
            }

        }

        // 查找到想要删除的节点结束

        // 删除操作
        // 1. 没有左右子树
        if (current.leftChild == null && current.rightChild == null) {
            if (current == root) {
                root = null;
            } else if (isLeftChild) {  // 如果删除的左子节点 那么父节点的左子节点不为空
                parent.leftChild = null;
            } else {
                parent.rightChild = null;
            }
        }
        // 2. 只有左子树 没有右节点
        else if (current.rightChild == null && current.leftChild != null) {
            if (current == root) {
                root = current.leftChild;
            } else if (isLeftChild) {
                parent.leftChild = current.leftChild;  // 如果删除当前节点 需要将当前节点的父节点的指向进行一个修改
            } else {
                parent.rightChild = current.leftChild;  //
            }
        }
        // 3. 只有右节点 没有左节点
        else if (current.rightChild != null && current.leftChild == null) {
            if (current == root) {
                root = current.leftChild;
            } else if (isLeftChild) {
                parent.leftChild = current.rightChild;  //
            } else {
                parent.rightChild = current.rightChild;  //
            }
        }
        // 既有左节点也有右节点
        /**
         * 节点的继承者 肯定在右子树。（因为要保证，继承者的值要大于左节点
         * 继承者肯定是右子树中最小的节点。（因为要保证，继承者的值小于右子树
         * 总结：找到被删除节点的右节点后，一路向左寻找子节点，直到最后一个叶子节点，即为继承者
         */
        else {
            Node successor = getSuccessor(current);  // 寻找继承者
            if (current == root) {
                root = successor;
            } else if (isLeftChild) {
                parent.leftChild = successor;  // 当前被删除节点的父类的一个赋值操作
            } else {
                parent.rightChild = successor; //
            }

            successor.leftChild = current.leftChild;  // 给successor继承者的左节点进行了一个赋值  右节点赋值 ??

        }


        return true;
    }

    // 寻找继承者
    private Node getSuccessor(Node delNode) {

        Node successorParent = delNode;
        Node successor = delNode; // 初始化

        Node current = delNode.rightChild;  // 先向右节点寻找一次
        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.leftChild;   // 一路向左进行查找
        }

        if (successor != delNode.rightChild) {  // 如果继承者不是当前被删除节点的右子节点 说明右节点不是只有一层 -> 右子树
            successorParent.leftChild = successor.rightChild; // 继承者的右子树成为了父类的左子树
            successor.rightChild = delNode.rightChild;  // 右节点赋值
        }

        return successor;
    }


    // 遍历
    // 前序
    private void preOrder(Node localNode) {
        if (localNode != null) {
            System.out.println(localNode.iData + "     ");
            preOrder(localNode.leftChild);
            preOrder(localNode.rightChild);
        }
    }

    // 中序遍历
    private void inOrder(Node localNode) {
        if (localNode != null) {
            inOrder(localNode.leftChild);
            System.out.println(localNode.iData + "     ");
            inOrder(localNode.rightChild);
        }
    }

    // 后序遍历
    private void postOrder(Node localNode) {
        if (localNode != null) {
            postOrder(localNode.leftChild);
            postOrder(localNode.rightChild);
            System.out.println(localNode.iData + "     ");
        }
    }

    public void tranverse(int type) {
        switch (type) {
            case 1:
                System.out.println("pre:");
                preOrder(root);
                break;
            case 2:
                System.out.println("in:");
                inOrder(root);
                break;
            case 3:
                System.out.println("post:");
                postOrder(root);
                break;
        }
    }


    // 打印树
    public void displayTree() {
        Stack globalStack = new Stack();
        globalStack.push(root);
        int nBlanks = 32;
        getClass();
        boolean isRowEmpty = false;
        System.out.println("=========================================================================");
        while (isRowEmpty == false) {
            Stack localStack = new Stack();
            isRowEmpty = true;
            for (int j = 0; j < nBlanks; j++) {
                System.out.print(" ");
            }

            while (globalStack.isEmpty() == false) {
                Node temp = (Node) globalStack.pop();
                if (temp != null) {
                    System.out.print(temp.iData);
                    localStack.push(temp.leftChild);
                    localStack.push(temp.rightChild);
                    if (temp.leftChild != null || temp.rightChild != null) {
                        isRowEmpty = false;
                    }
                } else {
                    System.out.print("--");
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int j = 0; j < nBlanks * 2 - 2; j++) {
                    System.out.print(" ");
                }
            }
            System.out.println();
            nBlanks /= 2;
            while (localStack.isEmpty() == false) {
                globalStack.push(localStack.pop());
            }
        }
        System.out.println("=========================================================================");
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
