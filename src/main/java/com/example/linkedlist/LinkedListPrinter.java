package com.example.linkedlist;

public class LinkedListPrinter {

    public static void print(LinkedListNode node) {
        StringBuilder builder = new StringBuilder();
        builder.append(node.getValue());
        LinkedListNode current = node;
        while (current.getNext() != null) {
            builder.append(" --> ");
            builder.append(current.getNext().getValue());
            current = current.getNext();
        }
        System.out.println(builder.toString());
    }
}
