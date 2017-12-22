package com.example.btree;

import java.util.ArrayList;
import java.util.List;

public class BTreeTraverse {

    public static <T extends Comparable<?>> List<BTreeNode<T>> inOrderTraverse(BTreeNode<T> root) {
        List<BTreeNode<T>> list = new ArrayList<>();
        inOrderTraverseInterval(root, list);
        return list;
    }

    private static <T extends Comparable<?>> void inOrderTraverseInterval(BTreeNode<T> root, List<BTreeNode<T>> list) {
        if (root == null) {
            return;
        }
        inOrderTraverseInterval(root.left, list);
        list.add(root);
        inOrderTraverseInterval(root.right, list);
    }

    public static <T extends Comparable<?>> List<BTreeNode<T>> preOrderTraverse(BTreeNode<T> root) {
        List<BTreeNode<T>> list = new ArrayList<>();
        preOrderTraverseInterval(root, list);
        return list;
    }

    private static <T extends Comparable<?>> void preOrderTraverseInterval(BTreeNode<T> root, List<BTreeNode<T>> list) {
        if (root == null) {
            return;
        }
        list.add(root);
        preOrderTraverseInterval(root.left, list);
        preOrderTraverseInterval(root.right, list);
    }

    public static <T extends Comparable<?>> List<BTreeNode<T>> postOrderTraverse(BTreeNode<T> root) {
        List<BTreeNode<T>> list = new ArrayList<>();
        postOrderTraverseInternal(root, list);
        return list;
    }

    private static <T extends Comparable<?>> void postOrderTraverseInternal(
            BTreeNode<T> root,
            List<BTreeNode<T>> list
    ) {
        if (root == null) {
            return;
        }
        postOrderTraverseInternal(root.left, list);
        postOrderTraverseInternal(root.right, list);
        list.add(root);
    }
}
