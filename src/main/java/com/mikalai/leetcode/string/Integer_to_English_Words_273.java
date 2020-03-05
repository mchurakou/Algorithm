package com.mikalai.leetcode.string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Integer_to_English_Words_273 {
    private String[] suffixes = new String[]{"", " Thousand", " Million", " Billion"};


    private String numberToWords(int n) {
        if (n == 0) {
            return "Zero";
        }

        List<String> strs = new ArrayList<>();
        for (int i = 0, m = n % 1000; n > 0 ; n /= 1000, i++, m = n % 1000) {
            String s = convertHundredPart(m);

            if (!s.isEmpty()) {
                strs.add(s + suffixes[i]);
            }
        }

        Collections.reverse(strs);

        return String.join(" ", strs);

    }

    private String convertDecimalPart(final int n) {
        if (n < 20) {
            return convertLessTwentyDecimal(n);
        } else {
            return convertGreaterTwentyDecimal(n);
        }
    }

    private String convertGreaterTwentyDecimal(final int n) {
        int decimal = n / 10;
        int digit = n % 10;



        String decimalStr = convertDecimal(decimal);
        String digitalStr = convertDigitPart(digit);

        StringBuilder sb = new StringBuilder();
        sb.append(decimalStr);
        if (!digitalStr.isEmpty()) {
            sb.append(" " + digitalStr);
        }

        return sb.toString();
    }

    private String convertDecimal(final int decimal) {
        switch (decimal) {
            case 2:
                return "Twenty";
            case 3:
                return "Thirty";
            case 4:
                return "Forty";
            case 5:
                return "Fifty";
            case 6:
                return "Sixty";
            case 7:
                return "Seventy";
            case 8:
                return "Eighty";
            case 9:
                return "Ninety";
            default:
                return "";
        }
    }

    private String convertHundredPart(final int n) {
        String s = convertDigitPart(n / 100);
        StringBuilder sb = new StringBuilder();
        sb.append(s);

        if (sb.length() > 0) {
            sb.append(" Hundred");

        }

        s = convertDecimalPart(n % 100);

        if (!s.isEmpty()) {
            if (sb.length() > 0){
                sb.append(" ");
            }
            sb.append(s);
        }

        return sb.toString();
    }


    private String convertLessTwentyDecimal(final int n) {
        if (n < 10) {
            return convertDigitPart(n);
        } else {
            switch (n) {
                case 10:
                    return "Ten";
                case 11:
                    return "Eleven";
                case 12:
                    return "Twelve";
                case 13:
                    return "Thirteen";
                case 14:
                    return "Fourteen";
                case 15:
                    return "Fifteen";
                case 16:
                    return "Sixteen";
                case 17:
                    return "Seventeen";
                case 18:
                    return "Eighteen";
                case 19:
                    return "Nineteen";
                default:
                    return "";
            }
        }
    }

    private String convertDigitPart(final int n) {
        switch (n) {
            case 1:
                return "One";
            case 2:
                return "Two";
            case 3:
                return "Three";
            case 4:
                return "Four";
            case 5:
                return "Five";
            case 6:
                return "Six";
            case 7:
                return "Seven";
            case 8:
                return "Eight";
            case 9:
                return "Nine";
            default:
                return "";
        }
    }

    public static void main(String[] args) {
        Integer_to_English_Words_273 i = new Integer_to_English_Words_273();
        System.out.println(i.numberToWords(0));
        System.out.println(i.numberToWords(10));
        System.out.println(i.numberToWords(100));
        System.out.println(i.numberToWords(1000));
        System.out.println(i.numberToWords(123));
        System.out.println(i.numberToWords(12345));
        System.out.println(i.numberToWords(1_234_567));
        System.out.println(i.numberToWords(1_234_567_891));

    }
}
