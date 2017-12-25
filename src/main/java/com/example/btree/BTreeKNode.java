package com.example.btree;

public class BTreeKNode {

    public static <T extends Comparable<?>> BTreeNode<T> findKNode(BTreeNode<T> root, int k) {
        if (k <= 0) return null;

        FindResult findResult = new FindResult();
        findResult.k = k;
        inOrderTraverseInterval(root, findResult);
        return findResult.node;
    }

    private static <T extends Comparable<?>> void inOrderTraverseInterval(
            BTreeNode<T> root,
            FindResult findResult
    ) {
        if (root == null || findResult.k <= 0) {
            return;
        }

        inOrderTraverseInterval(root.left, findResult);

        findResult.k--;
        if (findResult.k == 0) {
            findResult.node = root;
            return;
        }

        inOrderTraverseInterval(root.right, findResult);
    }

    static class FindResult<T extends Comparable<?>> {
        BTreeNode<T> node;
        int          k;
    }
}
