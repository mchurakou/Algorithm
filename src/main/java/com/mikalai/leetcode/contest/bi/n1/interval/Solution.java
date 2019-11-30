package com.mikalai.leetcode.contest.bi.n1.interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {
        int start = toBeRemoved[0];
        int end = toBeRemoved[1];

        List<List<Integer>> result = new ArrayList<>();

        for (int[] interval : intervals) {

            //interval before start or after end
            if (interval[1] <= start || interval[0] >= end) {
                result.add(Arrays.asList(interval[0], interval[1]));
            } else if (interval[0] < start && end < interval[1] ) { // inside interval
                result.add(Arrays.asList(interval[0], start));
                result.add(Arrays.asList(end, interval[1]));
            } else if (interval[0] < start && start < interval[1]) {
                result.add(Arrays.asList(interval[0], start));
            } else if (interval[0] < end && end < interval[1]) {
                result.add(Arrays.asList(end, interval[1]));
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.removeInterval(new int[][]{{0 ,2}, {3,4}, {5,7}}, new int[]{1,6}));
        System.out.println(s.removeInterval(new int[][]{{0 ,5}}, new int[]{2,3}));
        System.out.println(s.removeInterval(new int[][]{{0 ,5}}, new int[]{0,3}));
        System.out.println(s.removeInterval(new int[][]{{0 ,5}}, new int[]{3,5}));
        System.out.println(s.removeInterval(new int[][]{{0 ,5}}, new int[]{0,5}));



    }
}
