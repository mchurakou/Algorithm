package com.mikalai.algo.sorting;


//bucketSort(arr[], n)
//    1) Create n empty buckets (Or lists).
//    2) Do following for every array element arr[i].
//    .......a) Insert arr[i] into bucket[n*array[i]]
//    3) Sort individual buckets using insertion sort.
//    4) Concatenate all sorted buckets.

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BucketSort {
    static void  bucketSort(float arr[], int bucketCount) {

        // 1) Create bucketCount empty buckets
        List<List<Float>> buckets = new ArrayList<>(bucketCount);
        for (int i = 0; i < bucketCount; i++) {
            buckets.add(new ArrayList<>());
        }


        // 2) Put array elements in different buckets
        for (int i = 0; i < arr.length; i++) {
            int bi = (int) (bucketCount * arr[i]); // Index in buckets
            buckets.get(bi).add(arr[i]);
        }

        // 3) Sort individual buckets
        for (int i = 0; i < bucketCount; i++) {
            Collections.sort(buckets.get(i)); // should be insertion sort
        }

        // 4) Concatenate all buckets into arr[]
        int index = 0;
        for (int i = 0; i < bucketCount; i++) {
            List<Float> bucket = buckets.get(i);
            for (int j = 0; j < bucket.size(); j++) {
                arr[index++] = bucket.get(j);
            }
        }
    }


    public static void main(String[] args) {
        float[] arr = new float[100];

        for (int i = 0; i < 100; i++) {
            arr[i] = (float) Math.random();
        }

        bucketSort(arr, 10);


        for (float f : arr){
            System.out.println(f);
        }


    }
}
