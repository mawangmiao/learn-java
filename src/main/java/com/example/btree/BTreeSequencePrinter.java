package com.example.btree;

import java.util.ArrayList;
import java.util.List;

public class BTreeSequencePrinter {

    public static <T extends Comparable<?>> void print(BTreeNode<T> root) {
        if (root == null) return;

        List<List<T>> list = new ArrayList<>();
        addNodeToList(list, root, 1);
        System.out.println("------顺序打印------");
        list.forEach(subList -> subList.forEach(data -> System.out.print(data + ", ")));
        System.out.println();
    }


    private static <T extends Comparable<?>> void addNodeToList(
            List<List<T>> list,
            BTreeNode<T> node,
            int depth
    ) {
        if (node == null) return;

        if (list.size() < depth) {
            list.add(new ArrayList<>());
        }
        list.get(depth - 1).add(node.data);
        addNodeToList(list, node.left, depth + 1);
        addNodeToList(list, node.right, depth + 1);
    }


}
