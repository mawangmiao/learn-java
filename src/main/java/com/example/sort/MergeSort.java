package com.example.sort;

import java.util.Arrays;

import static com.example.sort.Data.NUMBERS;

public class MergeSort {

    public static void main(String[] args) {
        sort(NUMBERS, 0, NUMBERS.length - 1);
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
        int[] tmpArray = new int[array.length];
        int index1 = start;
        int index2 = middle + 1;
        int tmpIndex = start;

        while (index1 <= middle && index2 <= end) {
            //依次将2个数组中最小的数存进临时数据
            if (array[index1] < array[index2]) {
                tmpArray[tmpIndex++] = array[index1++];
            } else {
                tmpArray[tmpIndex++] = array[index2++];
            }
        }

        //如果数组1还有剩余, 全复制到临时数据
        while (index1 <= middle) {
            tmpArray[tmpIndex++] = array[index1++];
        }
        //如果数组2还有剩余, 全复制到临时数据
        while (index2 <= end) {
            tmpArray[tmpIndex++] = array[index2++];
        }

        while (start <= end) {
            array[start] = tmpArray[start];
            start++;
        }
    }
}
