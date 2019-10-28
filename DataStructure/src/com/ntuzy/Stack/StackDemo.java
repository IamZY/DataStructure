package com.ntuzy.Stack;

public class StackDemo {
    public static void main(String[] args) {
        String abc = reverse("abc");
        System.out.println(abc);
    }

    public static String reverse(String words) {
        java.util.Stack stack = new java.util.Stack();
        StringBuilder sb = new StringBuilder();
        char[] chars = words.toCharArray();

        for (Character c : chars) {
            stack.push(c);
        }

        while (!stack.empty()) {
            Character pop = (Character) stack.pop();
            sb.append(pop);
        }

        return sb.toString();
    }

}
