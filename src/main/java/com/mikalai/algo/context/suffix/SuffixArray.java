package com.mikalai.algo.context.suffix;

import com.mikalai.algo.string.sort.quick3.Quick3String;

public class SuffixArray {
    private final String[] suffixes;
    private final int N;

    public SuffixArray(String s) {
        N = s.length();
        suffixes = new String[N];
        for (int i = 0; i < s.length(); i++) {
            suffixes[i] = s.substring(i);
        }

        Quick3String.sort(suffixes);
    }

    private static int lcp(String s, String t){
        int n = Math.min(s.length(), t.length());
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != t.charAt(i)) return i;
        }
        return n;
    }


    public static void main(String[] args) {
        SuffixArray sa = new SuffixArray("aacaagtttacaagc");
        System.out.println(sa.lcp());

        sa = new SuffixArray("a");
        System.out.println(sa.lcp());

        sa = new SuffixArray("");
        System.out.println(sa.lcp());

        sa = new SuffixArray("aba");
        System.out.println(sa.lcp());
    }

    private String lcp() {
        int max = 0;
        String result = "";
        for (int i = 1; i < suffixes.length; i++) {
            int length = lcp(suffixes[i], suffixes[i - 1]);
            if (max < length) {
                max = length;
                result = suffixes[i].substring(0, length);
            }
        }

        return result;
    }
}
