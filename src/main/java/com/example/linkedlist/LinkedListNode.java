package com.example.linkedlist;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LinkedListNode {
    private int            value;
    private LinkedListNode next;

    LinkedListNode(int value) {
        this.value = value;
    }

    static LinkedListNode from(int[] values) {
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
