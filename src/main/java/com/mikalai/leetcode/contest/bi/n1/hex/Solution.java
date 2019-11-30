package com.mikalai.leetcode.contest.bi.n1.hex;

import java.util.Arrays;
import java.util.List;

public class Solution {



    private static List<Character> validChars = Arrays.asList('A', 'B', 'C', 'D', 'E', 'F', 'I', 'O', '1', '0');



    public static String toHexspeak(String num) {


        char[] chars = Long.toHexString(Long.parseLong(num)).toUpperCase().toCharArray();

        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            if (!validChars.contains(ch)) {
                return "ERROR";
            }

            if (ch == '0') {
                chars[i] = 'O';
            } else if (ch == '1') {
                chars[i] = 'I';
            }
        }


        return String.valueOf(chars);
    }

    public static void main(String[] args) {
//        System.out.println(toHexspeak("257"));
//        System.out.println(toHexspeak("3"));
//        System.out.println(toHexspeak("1"));
//        System.out.println(toHexspeak("1000000000000"));
        System.out.println(toHexspeak("747823223228"));
//        "AEIDBCDIBC"


    }
}
