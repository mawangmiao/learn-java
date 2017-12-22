package com.example.demo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class IntCollection {
    public static void main(String[] args) {
        fun(new int[]{1});
        fun(new int[]{1, 2});
        fun(new int[]{1, 2, 3});
        fun(new int[]{1, 2, 3, 4});
//        fun(new int[]{1, 2, 3, 4, 5});
    }

    static void fun(int[] arr) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            list.add(String.valueOf(arr[i]));
        }
        List<String> result = funInternal(list);
        result = result.stream().sorted().collect(Collectors.toList());
        System.out.println(result);
    }

    static List<String> funInternal(List<String> list) {
        if (list.size() <= 1) return list;

        List<String> result = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            List<String> subList = new ArrayList<>(list);
            String currentValue = subList.remove(i);
            result.add(currentValue);

            List<String> subResult = funInternal(subList);
            for (String subStr : subResult) {
                result.add(currentValue + subStr);
            }
        }
        return result;
    }
}
