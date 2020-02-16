package com.ntuzy.tree.binarysorttree;

/**
 * @Author IamZY
 * @create 2020/2/15 19:43
 */
public class BinarySortTreeDemo {
    public static void main(String[] args) {
        int[] arr = {7, 3, 10, 12, 5, 1, 9};
        BinarySortTree binarySortTree = new BinarySortTree();
        // 循环的添加节点到二叉排序树
        for (int i = 0; i < arr.length; i++) {
            binarySortTree.add(new Node(arr[i]));
        }

        binarySortTree.infixOrder();


    }
}

// 创建二叉排序树
class BinarySortTree {
    private Node root;

    // 查找要删除的节点
    public Node search(int target) {
        if (root == null) {
            return null;
        } else {
            return root.search(target);
        }
    }

    public Node searchParent(int target) {
        if (root == null) {
            return null;
        } else {
            return root.searchParent(target);
        }
    }


    /**
     * @param node 二叉排序树的根节点
     * @return
     */
    public int delRightTreeMin(Node node) {
        Node target = node;

        while (target.left != null) {
            target = target.left;
        }

        // 这时 target指向最小节点
        // 删除最小节点
        delNode(target.value);
        return target.value;
    }


    // 删除节点
    public void delNode(int value) {
        if (root == null) {
            return;
        } else {
            Node targetNode = search(value);
            if (targetNode == null) {
                return;
            }

            // 如果我们发现targetNode没有父节点
            if (root.left == null && root.right == null) {
                root = null;
                return;
            }

            // 去找到targetNode的父节点
            Node parent = searchParent(value);


            // 第一种情况
            if (targetNode.left == null && targetNode.right == null) {
                //
                if (parent.left != null && parent.left.value == value) {
                    parent.left = null;
                }

                if (parent.right != null && parent.right.value == value) {
                    parent.right = null;
                }

            } else if (targetNode.left != null && targetNode.right != null) {  // 第三种情况
                int minVal = delRightTreeMin(targetNode.right);
                targetNode.value = minVal;
            } else {

                if (targetNode.left != null) {
                    if (parent.left.value == value) {
                        parent.left = targetNode.left;
                    } else {
                        parent.right = targetNode.left;
                    }
                } else {
                    if (parent.left.value == value) {
                        parent.left = targetNode.right;
                    } else {
                        parent.right = targetNode.right;
                    }
                }

            }

        }
    }


    public void add(Node node) {
        if (node == null) {
            return;
        }

        if (root == null) {
            root = node;
        } else {
            root.add(node);
        }
    }


    public void infixOrder() {
        if (root == null) {
            return;
        } else {
            root.infixOrder();
        }
    }


}


class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

    // 添加节点
    public void add(Node node) {
        if (node == null) {
            return;
        }


        if (node.value < this.value) {
            if (this.left == null) {
                this.left = node;
            } else {
                this.left.add(node);
            }
        } else {
            if (this.right == null) {
                this.right = node;
            } else {
                this.right.add(node);
            }
        }

    }


    // 查找要删除节点的父节点
    public Node searchParent(int target) {
        if ((this.left != null && this.value == target) || (this.right != null && this.value == target)) {
            return this;
        } else {
            if (target < this.value && this.left != null) {
                return this.left.searchParent(target);
            } else if (target >= this.value && this.right != null) {
                return this.right.searchParent(target);
            } else {
                return null;
            }
        }
    }


    // 查找找删除的节点
    public Node search(int target) {
        if (value == target) {
            return this;
        } else if (target < this.value) {
            if (this.left != null) {
                return this.left.search(target);
            } else {
                return null;
            }
        } else {
            if (this.right != null) {
                return this.right.search(target);
            } else {
                return null;
            }
        }

    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    public void infixOrder() {
        if (this == null) {
            return;
        }


        if (this.left != null) {
            this.left.infixOrder();
        }

        System.out.println(this);

        if (this.right != null) {
            this.right.infixOrder();
        }

    }


}
