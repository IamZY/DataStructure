package com.ntuzy.Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author IamZY
 * @create 2020/2/3 16:40
 */
public class PolandNotation {
    public static void main(String[] args) {
        // 数字和符号使用空格隔开
        String suffixExpression = "3 4 + 5 * 6 - ";  // (3+4)*5-6


        List<String> list = getListString(suffixExpression);
        System.out.println(list);

        System.out.println(calculate(list));

    }

    // 将一个逆波兰表达式
    public static List<String> getListString(String suffixExpression) {
        String[] split = suffixExpression.split(" ");

        List<String> list = new ArrayList<>();


        for (String ele : split) {
            list.add(ele);
        }

        return list;
    }

    // 完成对逆波兰表达式的运算
    public static int calculate(List<String> ls) {
        // 创建一个栈
        Stack<String> stack = new Stack();

        // 遍历list
        for (String item : ls) {
            // 使用正则表达式
            if (item.matches("\\d+")) {
                stack.push(item);
            } else {
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int res = 0;
                if (item.equals("+")) {
                    res = num1 + num2;
                } else if (item.equals("-")) {
                    res = num1 - num2;
                } else if (item.equals("*")) {
                    res = num1 * num2;
                } else if (item.equals("/")) {
                    res = num1 / num2;
                } else {
                    throw new RuntimeException("运算符有错");
                }
                stack.push(res + "");
            }
        }


        return Integer.parseInt(stack.pop());
    }

}
