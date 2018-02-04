package com.example.sort;

import java.util.Arrays;

import static com.example.sort.TestData.NUMBERS;

public class QuickSort {

    public static void main(String[] args) {
        sort(NUMBERS, 0, NUMBERS.length - 1);
        System.out.println(Arrays.toString(NUMBERS));
    }

    private static void sort(int[] array, int start, int end) {
        if (start < end) {
            int middle = split(array, start, end);
            sort(array, start, middle - 1);
            sort(array, middle + 1, end);
        }
    }

    private static int split(int[] array, int start, int end) {
        int middleValue = array[start];
        while (start < end) {
            //从右往左找到比中间值小的第一个数(如果相等, 则跳过, 因为交换也两个相等的数是做无用功, 所以留到下一次递归时处理)
            while (start < end && array[end] >= middleValue) {
                end--;
                System.out.print(" end:" + end);
            }
            if (start < end) { //如果循环到最后start = end, 就不用自我赋值了.
                array[start] = array[end];
                System.out.println(" end交换");
                start++; //后面的从左往右查找时, 从下一个数开始找
            }

            //从左往右找到比中间值大的第一个数(如果相等, 则跳过, 留到下一次递归时处理)
            while (start < end && array[start] <= middleValue) {
                start++;
                System.out.print(" start:" + start);
            }

            if (start < end) {//如果循环到最后start = end, 就不用自我赋值了.
                array[end] = array[start];
                System.out.println(" start交换");
                end--;//后面的从右往左查找时, 从下一个数开始找
            }
        }
        System.out.println("--------start: " + start);
        array[start] = middleValue;
        System.out.println(Arrays.toString(array));
        return start;
    }
}
