package com.example.sort;

import java.util.Arrays;

import static com.example.sort.Data.NUMBERS;

public class BubbleSort {

    public static void main(String[] args) {
        int[] sortedNumbers = sort(NUMBERS);
        System.out.println(Arrays.toString(sortedNumbers));
    }

    private static int[] sort(int[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            boolean exchanged = false;
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                    exchanged = true;
                }
            }
            if (!exchanged) break;
        }
        return array;
    }
}
