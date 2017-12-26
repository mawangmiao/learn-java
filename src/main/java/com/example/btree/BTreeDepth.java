package com.example.btree;

public class BTreeDepth {

    public static <T extends Comparable<?>> int getDepth(BTreeNode<T> root) {
        return postOrderTraverseInterval(root);
    }

    private static <T extends Comparable<?>> int postOrderTraverseInterval(BTreeNode<T> root) {
        if (root == null) {
            return 0;
        }

        int leftLength = postOrderTraverseInterval(root.left);
        int rightLength = postOrderTraverseInterval(root.right);
        return leftLength > rightLength ? leftLength + 1 : rightLength + 1;
    }
}
