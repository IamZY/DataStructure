package com.ntuzy.List;

import com.sun.xml.internal.ws.util.xml.NodeListIterator;

public class SortedLinkTest {
    public static void main(String[] args) {

    }

    private class Node {
        private Object data;
        private Node next;

        public Node(Object data) {
            this.data = data;
        }


        private Node root;

        private void insert(Object data) {
            Node node = new Node(data);
            Node pre = null;
            Node cur = root;
            while (cur != null && Integer.valueOf(node.data.toString()).intValue() > Integer.valueOf(cur.data.toString()).intValue()) {
                pre = cur;
                cur = cur.next;
            }

            if (pre == null) {
                root = node;
            } else {
                pre.next = node;
            }

            node.next = root;
        }

        public void display() {
            if (root == null) {
                System.out.println("NULL");
            }

            Node node = root;

            while (node != null) {
                System.out.println(node.data.toString() + "->");
                node = node.next;
            }

        }


    }

}
