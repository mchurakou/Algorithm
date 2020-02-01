package com.mikalai.amazon;

public class GCD {
       // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public static int generalizedGCD(int num, int[] arr)
    {
        int result = arr[0];
        for (int i = 0; i < num; i++ ) {
            result = gcd(result, arr[i]);

        }

        return result;
    }

    private static int gcd(int a, int b) {
        while (a != 0 && b != 0) {
            if (a > b) {
                a = a % b;
            } else {
                b = b % a;

            }
        }

        return a + b;

    }
    public static void main(String[] args) {
        System.out.println(generalizedGCD(5, new int[]{2,4,6,8,10}));
    }
}
