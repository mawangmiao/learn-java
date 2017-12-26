package com.example.linkedlist;

public class LinkedList {

    static LinkedListNode init(int[] values) {
        if (values == null || values.length == 0) {
            return null;
        }

        LinkedListNode first = new LinkedListNode();
        first.setValue(values[0]);

        LinkedListNode current = first;
        for (int i = 1; i < values.length; i++) {
            LinkedListNode next = new LinkedListNode();
            next.setValue(values[i]);
            current.setNext(next);
            current = next;
        }

        return first;
    }

}
