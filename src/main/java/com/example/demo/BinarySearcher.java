package com.example.demo;

class BinarySearcher {

    static int search(int[] arr, int key) {
        return searchInterval(arr, key, 0, arr.length - 1);
    }

    public void hello() {

    }

    private static int searchInterval(int[] arr, int key, int startIndex, int endIndex) {
        if (startIndex > endIndex) {
            return -1;
        }

        int middleIndex = startIndex + (endIndex - startIndex) / 2;
        if (arr[middleIndex] == key) {
            return middleIndex;
        } else if (arr[middleIndex] > key) {
            return searchInterval(arr, key, startIndex, middleIndex - 1);
        } else {
            return searchInterval(arr, key, middleIndex + 1, endIndex);
        }
    }
}
