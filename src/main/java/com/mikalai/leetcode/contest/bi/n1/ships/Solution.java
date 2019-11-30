package com.mikalai.leetcode.contest.bi.n1.ships;

public class Solution {
    public int countShips(Sea sea, int[] topRight, int[] bottomLeft) {
        if (!sea.hasShips(topRight, bottomLeft)) {
           return 0;
        }

        if (topRight[0] == bottomLeft[0] && topRight[1] == bottomLeft[1]) {
            return 1;
        }


        int middleX = (topRight[0] + bottomLeft[0]) / 2;
        int middleY = (topRight[1] + bottomLeft[1]) / 2;
        return
            countShips(sea, new int[]{middleX, middleY}, bottomLeft) +
            countShips(sea, new int[]{middleX,  topRight[1]}, new int[]{bottomLeft[0], middleY + 1}) +
            countShips(sea, topRight, new int[]{middleX + 1, middleY + 1}) +
            countShips(sea, new int[]{topRight[0], middleY}, new int[]{middleX + 1, bottomLeft[1]});
    }

    public static void main(String[] args) {

    }
}

class Sea {
    public boolean hasShips(int[] topRight, int[] bottomLeft) {
        return false;
    }
}
