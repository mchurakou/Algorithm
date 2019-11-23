package com.mikalai.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Palindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome(123));
        System.out.println(isPalindrome(12321));
        System.out.println(isPalindrome(-12321));
    }

    public static boolean isPalindrome(int x) {
        if (x < 0 ) {
            return false;
        }

        if (x < 10) {
            return true;
        }

        List<Integer> arr = new ArrayList<>();

        while (x > 0) {
            arr.add(x % 10);
            x /= 10;
        }

        for (int i = 0; i < arr.size() / 2; i++) {
            if (!arr.get(i).equals(arr.get(arr.size() - i - 1))) {
                return false;
            }
        }

        return true;


    }
}
