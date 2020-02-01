package com.mikalai.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class RunningMediana {

    static double[] runningMedian(int[] a) {
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> minQueue = new PriorityQueue<>();
        double prevMediana = 0;
        double[] result = new double[a.length];

        for (int i = 0; i < a.length; i++) {
            if (a[i] <= prevMediana) {
                maxQueue.add(a[i]);
            } else {
                minQueue.add(a[i]);
            }

            if (maxQueue.size() - minQueue.size() == 2) {
                minQueue.add(maxQueue.poll());
            }

            if (minQueue.size() - maxQueue.size() == 2) {
                maxQueue.add(minQueue.poll());
            }

            if (maxQueue.size() == minQueue.size()) {
                prevMediana = (minQueue.peek() + maxQueue.peek()) / 2f;
            } else if (maxQueue.size() > minQueue.size()){
                prevMediana = maxQueue.peek();
            } else {
                prevMediana = minQueue.peek();
            }
            result[i] = prevMediana;



        }

        return result;
    }



    public static void main(String[] args) {

//        System.out.println(Arrays.toString(runningMedian(new int[]{6, 12, 4, 5, 3, 8,7})));
        System.out.println(Arrays.toString(runningMedian(new int[]{

            1
            ,2
            ,3
            ,4
            ,5
            ,6
            ,7
            ,8
            ,9
            ,10})));



    }
}
