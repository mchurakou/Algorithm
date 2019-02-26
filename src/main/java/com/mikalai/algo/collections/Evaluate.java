package com.mikalai.algo.collections;


import java.util.Stack;

public class Evaluate {

    public static void main(String[] args) {
        Stack<String> ops = new Stack<>();
        Stack<Double> vals = new Stack<>();

        String input = "((1 + 4) + ((2 + 3) * (4 * 5)))";

        for (int i = 0; i < input.length(); i++) {
            String str = input.substring(i, i + 1);

            if ("( ".contains(str)){
            } else if ("+-/*".contains(str)){
                ops.push(str);
            } else if (")".equals(str)){
                String op = ops.pop();
                double v = vals.pop();

                switch (op) {
                    case "+" :
                        v = vals.pop() + v;
                        break;
                    case "-" :
                        v = vals.pop() - v;
                        break;
                    case "*" :
                        v = vals.pop() * v;
                        break;
                    case "/" :
                        v = vals.pop() / v;
                        break;
                };

                vals.push(v);
            } else {
                vals.push(Double.parseDouble(str));
            }


        }

        System.out.println("Res:" + vals.pop());

    }
}
