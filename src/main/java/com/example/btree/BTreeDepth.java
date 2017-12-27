package com.example.btree;

public class BTreeDepth {

    public static <T extends Comparable<?>> int getMaxDepth(BTreeNode<T> root) {
        return postOrderTraverseToFindMaxDepth(root);
    }

    private static <T extends Comparable<?>> int postOrderTraverseToFindMaxDepth(BTreeNode<T> root) {
        if (root == null) {
            return 0;
        }

        int leftLength = postOrderTraverseToFindMaxDepth(root.left);
        int rightLength = postOrderTraverseToFindMaxDepth(root.right);
        return leftLength > rightLength ? leftLength + 1 : rightLength + 1;
    }

    public static <T extends Comparable<?>> int getMinDepth(BTreeNode<T> root) {
        if (root == null) {
            return 0;
        }
        return postOrderTraverseToFindMinDepth(root);
    }

    private static <T extends Comparable<?>> int postOrderTraverseToFindMinDepth(BTreeNode<T> root) {
        if (root == null) {//处理斜树
            return Integer.MAX_VALUE;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }

        int leftLength = postOrderTraverseToFindMinDepth(root.left);
        int rightLength = postOrderTraverseToFindMinDepth(root.right);

        return leftLength < rightLength ? leftLength + 1 : rightLength + 1;
    }
}
