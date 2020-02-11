package com.ntuzy.tree.threadedbinarytree;

/**
 * @Author IamZY
 * @create 2020/2/11 10:52
 */
public class ThreadedBinaryTreeDemo {
    public static void main(String[] args) {

        HeroNode root = new HeroNode(1, "1");
        HeroNode node2 = new HeroNode(3, "2");
        HeroNode node3 = new HeroNode(8, "3");
        HeroNode node4 = new HeroNode(10, "4");
        HeroNode node5 = new HeroNode(6, "5");
        HeroNode node6 = new HeroNode(14, "5");

        root.setLeft(node2);
        root.setRight(node5);
        node2.setLeft(node3);
        node2.setRight(node4);
        node5.setLeft(node6);

        BTree bTree = new BTree();
        bTree.setRoot(root);

        bTree.threadedNodes();

        System.out.println(node3.getLeft());
        System.out.println(node3.getRight());

    }
}

class BTree {

    private HeroNode root;
    // 实现线索化 指向指向当前节点的前驱节点的指针
    // 在递归进行线索化时
    private HeroNode pre = null;

    public HeroNode getRoot() {
        return root;
    }

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    public void threadedNodes() {
        this.threadedNodes(this.root);
    }

    // 编写对二叉树进行中序线索化的方法
    public void threadedNodes(HeroNode node) {
        // 如果node == null 不能线索化
        if (node == null) {
            return;
        }

        // 先线索化左子树
        threadedNodes(node.getLeft());
        // 再线索化当前节点

        // 处理当前节点的前驱节点
        if (node.getLeft() == null) {
            // 让当前节点的做指针指向前驱节点
            node.setLeft(pre);
            node.setLeftType(1);
        }

        // 处理后继节点
        if (pre != null && pre.getRight() == null) {
            pre.setRight(node);
            pre.setRightType(1);
        }

        // 每处理一个节点后 让当前节点指向下一个节点的前驱节点
        pre = node;

        // 最后线索化右子树
        threadedNodes(node.getRight());


    }


    public void preOrder() {
        if (this.root != null) {
            this.root.preOrder();
        } else {
            throw new RuntimeException("binary tree is null");
        }
    }


    public void infixOrder() {
        if (this.root != null) {
            this.root.infixOrder();
        } else {
            throw new RuntimeException("binary tree is null");
        }
    }


    public void postOrder() {
        if (this.root != null) {
            this.root.postOrder();
        } else {
            throw new RuntimeException("binary tree is null");
        }
    }

    public HeroNode preOrderSearch(int no) {
        if (root != null) {
            return root.preOrderSearch(no);
        } else {
            return null;
        }
    }

    public HeroNode infixOrderSearch(int no) {
        if (root != null) {
            return root.infixOrderSearch(no);
        } else {
            return null;
        }
    }

    public HeroNode postOrderSearch(int no) {
        if (root != null) {
            return root.postOrderSearch(no);
        } else {
            return null;
        }
    }


    // 删除节点
    public void delNode(int no) {
        if (root != null) {
            if (root.getNo() == no) {
                root = null;
                return;
            } else {
                root.delNode(no);
            }
        } else {
            throw new RuntimeException("空树");
        }
    }


}

class HeroNode {
    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;


    // 如果leftType == 0 指向左子树  == 1 指向前驱结点
    // 如果rightType == 1 指向右子树 == 1 指向后继节点
    private int leftType;
    private int rightType;

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }


    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    // 递归删除节点
    public void delNode(int no) {
        if (this.left != null && this.left.no == no) {
            this.left = null;
            return;
        }

        if (this.right != null && this.right.no == no) {
            this.right = null;
            return;
        }

        if (this.left != null) {
            this.left.delNode(no);
        }

        if (this.right != null) {
            this.right.delNode(no);
        }

    }


    // 前序遍历
    public void preOrder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }

        if (this.right != null) {
            this.right.preOrder();
        }

    }

    // 中序遍历
    public void infixOrder() {
        if (this.left != null) {
            this.left.infixOrder();
        }

        System.out.println(this);

        if (this.right != null) {
            this.right.infixOrder();
        }

    }

    // 后序遍历
    public void postOrder() {
        if (this.left != null) {
            this.left.postOrder();
        }

        if (this.right != null) {
            this.right.postOrder();
        }

        System.out.println(this);
    }

    // 前序遍历查找
    public HeroNode preOrderSearch(int no) {
        if (this.no == no) {
            return this;
        }

        HeroNode resNode = null;
        if (this.left != null) {
            resNode = this.left.preOrderSearch(no);
        }

        if (resNode != null) {
            return resNode;
        }

        if (this.right != null) {
            resNode = this.right.preOrderSearch(no);
        }

        if (resNode != null) {
            return resNode;
        }

        return resNode;
    }


    public HeroNode infixOrderSearch(int no) {

        HeroNode resNode = null;
        if (this.left != null) {
            resNode = this.left.infixOrderSearch(no);
        }

        if (resNode != null) {
            return resNode;
        }

        if (this.no == no) {
            return this;
        }

        if (this.right != null) {
            resNode = this.right.infixOrderSearch(no);
        }

        if (resNode != null) {
            return resNode;
        }

        return resNode;
    }

    public HeroNode postOrderSearch(int no) {
        HeroNode resNode = null;
        if (this.left != null) {
            resNode = this.left.postOrderSearch(no);
        }

        if (resNode != null) {
            return resNode;
        }

        if (this.right != null) {
            resNode = this.right.postOrderSearch(no);
        }

        if (resNode != null) {
            return resNode;
        }

        if (this.no == no) {
            return this;
        }

        return resNode;
    }

}