package com.example.linkedlist;

class CircularLinkedList {

    static LinkedListNode init(int[] values) {
        if (values == null || values.length == 0) {
            return null;
        }

        LinkedListNode first = new LinkedListNode();
        first.setValue(values[0]);

        LinkedListNode current = first;
        if (values.length == 1) {
            first.setNext(first);
            return first;
        }

        for (int i = 1; i < values.length; i++) {
            LinkedListNode next = new LinkedListNode();
            next.setValue(values[i]);
            current.setNext(next);
            current = next;

            if (i == values.length - 1) {
                current.setNext(first);
            }
        }

        return first;
    }
}
