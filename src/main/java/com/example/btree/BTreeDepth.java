package com.example.btree;

public class BTreeDepth {

    public static <T extends Comparable<?>> int getDepth(BTreeNode<T> root) {
        return inOrderTraverseInterval(root);
    }

    private static <T extends Comparable<?>> int inOrderTraverseInterval(BTreeNode<T> root) {
        if (root == null) {
            return 0;
        }

        int leftLength = inOrderTraverseInterval(root.left);
        int rightLength = inOrderTraverseInterval(root.right);
        return leftLength > rightLength ? leftLength + 1 : rightLength + 1;
    }
}
