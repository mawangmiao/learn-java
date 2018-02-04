package com.example.sort;

import java.util.Arrays;

import static com.example.sort.TestData.NUMBERS;

public class InsertionSort {

    public static void main(String[] args) {
        int[] sortedNumbers = sort(NUMBERS);
        System.out.println(Arrays.toString(sortedNumbers));
    }

    private static int[] sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int currentValue = array[i];
            int j = i - 1;
            for (; j >= 0 && currentValue < array[j]; j--) {
                //将大于currentValue的值整体后移一个单位
                array[j + 1] = array[j];
            }
            array[j + 1] = currentValue;
        }
        return array;
    }
}
