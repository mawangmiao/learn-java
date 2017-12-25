package com.example.algorithm;

public class MaxSubArraySumTest {

    public static void main(String[] args) {
        int maximumSum = getMaximumSum(new int[]{1, -2, 3, 10, -4, 7, 2, -5});
        System.out.println(maximumSum);
        maximumSum = getMaximumSum(new int[]{-1, -2, -3});
        System.out.println(maximumSum);
        maximumSum = getMaximumSum(new int[]{-3, -2, -1});
        System.out.println(maximumSum);
    }

    private static int getMaximumSum(int[] data) {
        if (data.length <= 0) throw new IllegalArgumentException("data is empty");

        int start = 0, end = 0, currentSum = 0, maximumSum = Integer.MIN_VALUE;
        for (int i = 0; i < data.length; i++) {
            if (currentSum <= 0) {
                start = i;
                currentSum = data[i];
            } else {
                currentSum += data[i];
            }
            if (currentSum > maximumSum) {
                end = i;
                maximumSum = currentSum;
            }
        }
        System.out.println("start:" + start + ", end:" + end);
        return maximumSum;
    }
}
