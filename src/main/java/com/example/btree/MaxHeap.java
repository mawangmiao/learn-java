package com.example.btree;

public class MaxHeap {

    public static void main(String[] args) {
        int[] data = {5, 8, 10, 15, 18, 20};
        toMaxHeap(data);
        System.out.println(data[getLeftIndex(1)]);
        System.out.println(data[getRightIndex(1)]);
        System.out.println(data[getLeftIndex(2)]);
    }

    private static void toMaxHeap(int[] data) {

    }

    private static int getLeftIndex(int index) {
        return (index + 1) * 2;
    }

    private static int getRightIndex(int index) {
        return (index + 1) * 2 + 1;
    }

    private static int getParentIndex(int index) {
        return (index + 1) / 2 - 1;
    }

}
