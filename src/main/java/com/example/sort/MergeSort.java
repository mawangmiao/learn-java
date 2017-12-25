package com.example.sort;

import java.util.Arrays;

import static com.example.sort.Data.NUMBERS;

public class MergeSort {

    public static void main(String[] args) {
        sort(NUMBERS, 0, NUMBERS.length);
        System.out.println(Arrays.toString(NUMBERS));
    }

    private static void sort(int[] array, int start, int end) {
        if (start >= end) return;

        int middle = (start + end) / 2;
        //左边排序
        sort(array, start, middle);
        //右边排序
        sort(array, middle + 1, end);
        //合并
        merge(array, start, middle, end);
    }

    private static void merge(int[] array, int start, int middle, int end) {
        //TODO
    }
}
