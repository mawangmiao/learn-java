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

}
