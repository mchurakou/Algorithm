package com.mikalai.leetcode.regexp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MatrixClusterTest {

    @Test
    void isMatch() {
        assertFalse(Solution.isMatch("aa", "a"));
        assertTrue(Solution.isMatch("aa", "a*"));
        assertTrue(Solution.isMatch("ab", ".*"));
        assertTrue(Solution.isMatch("aab", "c*a*b"));
        assertFalse(Solution.isMatch("mississippi", "mis*is*p*."));
    }
}