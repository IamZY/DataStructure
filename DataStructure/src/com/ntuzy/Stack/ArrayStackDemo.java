package com.ntuzy.Stack;

import java.util.Scanner;

/**
 * @Author IamZY
 * @create 2020/2/3 14:28
 */
public class ArrayStackDemo {
    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(4);

        stack.push(1);
        stack.push(3);
        stack.push(2);
        stack.push(4);

        stack.display();

        int value = stack.pop();
        System.out.println(value);

    }
}


// 定义一个栈
class ArrayStack {
    private int maxSize; // 栈大小
    private int[] stack;  // 数组模拟栈
    private int top = -1;  // top表示栈顶

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }


    public boolean isFull() {
        if (top == maxSize - 1) {
            return true;
        }
        return false;
    }

    public boolean isEmpty() {
        return top == -1;
    }


    public void push(int value) {
        if (isFull()) {
            return;
        }

        this.stack[++top] = value;
    }

    public int pop() {

        if (isEmpty()) {
            throw new RuntimeException("stack empty");
        }

        int value = this.stack[top];
        top--;
        return value;
    }


    // 需要从栈顶开始显示
    public void display() {
        if (isEmpty()) {
            return;
        }

        for (int i = top; i >= 0; i--) {
            System.out.printf("stack[%d] = %d\n", i, stack[i]);
        }

    }


}
