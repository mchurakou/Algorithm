package com.mikalai.leetcode.string;

import java.util.Stack;

public class Minimum_Remove_to_Make_Valid_Parentheses_1249 {

    public String minRemoveToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();

        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(c);
                sb.append(c);
            } else if (c == ')') {
                if (!stack.empty()) {
                    stack.pop();
                    sb.append(c);
                }
            } else {
                sb.append(c);
            }
        }

        s = sb.toString();

        sb = new StringBuilder();
        stack.clear();

        for (int i = s.length() - 1; i >= 0 ; i--) {
            char c = s.charAt(i);
            if (c == ')') {
                stack.push(c);
                sb.append(c);
            } else if (c == '(') {
                if (!stack.empty()) {
                    stack.pop();
                    sb.append(c);
                }
            } else {
                sb.append(c);
            }
        }


        return sb.reverse().toString();

    }

    public static void main(String[] args) {
        Minimum_Remove_to_Make_Valid_Parentheses_1249 m = new Minimum_Remove_to_Make_Valid_Parentheses_1249();
        System.out.println(m.minRemoveToMakeValid("lee(t(c)o)de)"));
        System.out.println(m.minRemoveToMakeValid("a)b(c)d"));
        System.out.println(m.minRemoveToMakeValid("))(("));
        System.out.println(m.minRemoveToMakeValid("(a(b(c)d)"));
    }
}
