package com.example.btree;

class BSearchTree {

    static boolean isBSearchTree(BTreeNode<Integer> root) {
        if (root == null) return false;

        return isBTreeInternal(root);
    }

    private static boolean isBTreeInternal(BTreeNode<Integer> root) {
        if (root == null) {
            return true;
        }

        if (root.left != null) {
            if (root.left.data >= root.data) {
                return false;
            }
        }
        if (root.right != null) {
            if (root.right.data < root.data) {
                return false;
            }
        }

        return isBTreeInternal(root.left) && isBTreeInternal(root.right);
    }
}
