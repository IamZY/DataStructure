package com.ntuzy.Stack;

import java.util.UUID;

/**
 * @Author IamZY
 * @create 2020/2/3 14:57
 */
public class Calculator {
    public static void main(String[] args) {
        String expression = "30+2*6-7";
        ArrayStack2 numStack = new ArrayStack2(10);
        ArrayStack2 operStack = new ArrayStack2(10);

        int index = 0;

        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        int res = 0;

        char ch = ' ';

        String keyNum = "";

        while (true) {
            ch = expression.substring(index, index + 1).charAt(0);
            if (operStack.isOper(ch)) {
                if (!operStack.isEmpty()) {
                    if (operStack.priority(ch) <= operStack.priority(operStack.peek())) {
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operStack.pop();
                        res = numStack.cal(num1, num2, oper);
                        numStack.push(res);
                        operStack.push(ch);
                    } else {
                        operStack.push(ch);
                    }
                } else {
                    operStack.push(ch);
                }
            } else {
                // 如果是数字
//                numStack.push(ch - 48);
                // 如果是多位数  需要向后在扫描
                keyNum += ch;

                // 如果ch是expression的最后一位就直接入站
                if (index == expression.length() - 1) {
                    numStack.push(Integer.parseInt(keyNum));
                } else {

                    // 判断下一位是否还是数字  如果是运算符就入站
                    if (operStack.isOper(expression.substring(index + 1, index + 2).charAt(0))) {
                        numStack.push(Integer.parseInt(keyNum));
                        keyNum = "";
                    }

                }


            }

            index++;
            if (index > expression.length() - 1) {
                break;
            }

        }


        while (true) {
            // 如果符号栈为空 计算到最后一个结果
            if (operStack.isEmpty()) {
                break;
            }

            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = operStack.pop();
            res = numStack.cal(num1, num2, oper);
            numStack.push(res);
        }

        System.out.println(numStack.pop());

    }
}


// 定义一个栈
class ArrayStack2 {
    private int maxSize; // 栈大小
    private int[] stack;  // 数组模拟栈
    private int top = -1;  // top表示栈顶

    public ArrayStack2(int maxSize) {
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

    // 返回运算符优先级 优先级是程序员定义的  优先级使用数字表示 数字越大 优先级越高
    public int priority(int oper) {
        if (oper == '*' || oper == '/') {
            return 1;
        } else if (oper == '+' || oper == '-') {
            return 0;
        } else {
            return -1;
        }
    }

    public boolean isOper(char val) {
        return val == '+' || val == '-' || val == '*' || val == '/';
    }

    // 计算方法
    public int cal(int num1, int num2, int oper) {
        int res = 0;

        switch (oper) {
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1;
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num2 / num1;
                break;
            default:
                break;
        }

        return res;
    }


    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("empty");
        }

        return stack[top];
    }


}

