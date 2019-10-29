package com.ntuzy.List;

import com.sun.corba.se.impl.activation.ProcessMonitorThread;

import javax.swing.*;
import java.util.Date;

/**
 * 双向链表
 */
public class DoubleLinkedTest<T> {
    public static void main(String[] args) {
        DoubleLinkedTest<Integer> link = new DoubleLinkedTest<>();
        link.add(1);
        link.add(2);
        link.add(3);
        link.add(4);
        link.add(5);
        link.printList();
    }

    private class Node<T> {
        private T data;
        private Node pre;
        private Node next;

        public Node(T data) {
            this.data = data;
        }
    }


    private Node<T> head;
    private Node<T> last;
    private Node<T> otherNode;
    private int length;


    public DoubleLinkedTest() {
        head = new Node<T>(null);
        last = head;
        this.length = 0;
    }

    public DoubleLinkedTest(T data) {
        head = new Node<T>(data);
        last = head;
        this.length = 0;
    }

    public boolean isEmpty() {
        if (this.length == 0) {
            return true;
        }
        return false;
    }

    // 添加
    public void add(T data) {
        if (this.isEmpty()) {
            head = new Node<>(data);
            last = head;
            this.length++;
        } else {
            otherNode = new Node<>(data);
            otherNode.pre = last;
            otherNode.pre.next = otherNode;  // 与原来尾部的节点进行关联
            last = otherNode;
            this.length++;
        }
    }


    // 在指定的数据后边添加节点
    public void addAfter(T data, T insertData) {
        otherNode = head;

        while (otherNode != null) {
            if (otherNode.data.equals(data)) {
                Node<T> t = new Node<>(insertData);
                t.pre = otherNode;
                t.next = otherNode.next;  // 对新插入的数据进行指向的定义
                otherNode.next = t;

                if (t.next == null) {
                    last = t;
                } else {
                    length++;
                }
            }


            otherNode = otherNode.next;

        }


    }


    public void remove(T data) {
        otherNode = head; // 假定链表不为空

        while (otherNode != null) {
            if (otherNode.data.equals(data)) {
                otherNode.pre.next = otherNode.next;
                length--;
            }
            otherNode = otherNode.next;
        }
    }

    public void printList() {
        otherNode = head;
        for (int i = 0;i < this.length ; i++) {
            System.out.println(otherNode.data + " ");
            otherNode = otherNode.next;
        }
    }

}
