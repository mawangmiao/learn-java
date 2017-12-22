package com.example.sort;

import java.util.Arrays;

import static com.example.sort.Data.NUMBERS;

public class SelectionSort {

    public static void main(String[] args) {
        int[] sortedNumbers = sort(NUMBERS);
        System.out.println(Arrays.toString(sortedNumbers));
    }

    private static int[] sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int smallestIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[smallestIndex]) {
                    smallestIndex = j;
                }
            }

            int temp = array[i];
            array[i] = array[smallestIndex];
            array[smallestIndex] = temp;
        }
        return array;
    }
}
