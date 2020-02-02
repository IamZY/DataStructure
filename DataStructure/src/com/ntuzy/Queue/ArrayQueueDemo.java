package com.ntuzy.Queue;

import java.util.Scanner;

/**
 * @Author IamZY
 * @create 2020/2/2 11:02
 */
public class ArrayQueueDemo {
    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(3);
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.println("s(show): 显示队列");
            System.out.println("e(exit): 退出程序");
            System.out.println("a(add): 添加数据");
            System.out.println("g(get): 取出数据");
            System.out.println("h(head): 显示队列头");
            key = scanner.next().charAt(0);
            switch (key) {
                case 's':
                    arrayQueue.display();
                    break;
                case 'a':
                    System.out.println("输入一个数据....");
                    int value = scanner.nextInt();
                    arrayQueue.addQueue(value);
                    break;
                case 'g':
                    try {
                        int ret = arrayQueue.getQueue();
                        System.out.println(ret);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int head = arrayQueue.headQueue();
                        System.out.println(head);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;

            }
        }
    }
}


// 使用数组模拟队列 编写ArrayQueue的类
class ArrayQueue {
    private int maxSize; // 数组最大容量
    private int front;  // 队首
    private int rear; //
    private int[] arr;  // 模拟队列


    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        this.arr = new int[maxSize];
        this.front = -1;  // 指向队列头的前一个位置
        this.rear = -1; // 指向队列尾部
    }

    public boolean isFull() {
        if (rear == maxSize - 1) {
            return true;
        }
        return false;
    }

    public boolean isEmpty() {
        if (rear == front) {
            return true;
        }
        return false;
    }


    //
    public void addQueue(int n) {
        if (isFull()) {
            System.out.println("Queue is full...");
            return;
        }
        rear++;
        this.arr[rear] = n;
    }

    public int getQueue() {
        // 判断为空
        if (isEmpty()) {
            throw new RuntimeException("队列为空不能取数据");
        }
        front++;
        return this.arr[front];
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("队列空...");
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d] = %d\t", i, arr[i]);
        }

    }

    // 显示数据头
    public int headQueue() {
        // Panduan
        if (isEmpty()) {
            System.out.println("Queue is empty..");
            throw new RuntimeException("队列空没有数据");
        }
        return arr[front + 1];
    }


}
