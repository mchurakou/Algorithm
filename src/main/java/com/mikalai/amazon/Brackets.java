package com.mikalai.amazon;

import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Brackets {
    static String isBalanced(String s) {
        Stack<Character> stack = new Stack<>();

        for (Character ch : s.toCharArray()) {
            if (ch.equals('(') || ch.equals('{') || ch.equals('[')) {
                stack.push(ch);
            } else if (!stack.empty()) {

                Character openBr = stack.pop();
                switch (openBr) {
                    case '(':
                        if (ch.equals(')'))
                            break;
                    case '{':
                        if (ch.equals('}'))
                            break;
                    case '[':
                        if (ch.equals(']'))
                            break;
                    default:
                        return "NO";

                }
            } else {
                return "NO";
            }

        }

        return stack.empty() ? "YES" : "NO";

    }
    public static void main(String[] args) {
        System.out.println(isBalanced("{[()]}"));
        System.out.println(isBalanced("))"));
        System.out.println(isBalanced("(("));

    }
}
