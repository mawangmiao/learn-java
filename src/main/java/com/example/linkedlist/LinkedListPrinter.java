package com.example.linkedlist;

public class LinkedListPrinter {

    public static void print(LinkedListNode node) {
        if (node == null) {
            System.out.println("null");
            return;
        }

        StringBuilder builder = new StringBuilder();
        builder.append(node.getValue());

        LinkedListNode first = node;
        LinkedListNode current = node;
        while (current.getNext() != null && current.getNext() != first) {
            builder.append(" --> ");
            builder.append(current.getNext().getValue());
            current = current.getNext();
        }
        if (current.getNext() == first) {
            builder.append(" --> head");
        }
        System.out.println(builder.toString());
    }
}
