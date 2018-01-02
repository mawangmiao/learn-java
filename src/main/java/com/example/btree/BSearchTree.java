package com.example.btree;

class BSearchTree {

    static boolean isBSearchTree(BTreeNode<Integer> root) {
        if (root == null) return false;

        return isBSearchTreeInternal(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean isBSearchTreeInternal(BTreeNode<Integer> root, int min, int max) {
        if (root == null) {
            return true;
        }
        System.out.println("root.data: " + root.data + ", min: " + min + ", max: " + max);
        if (root.data < min || root.data > max) {
            System.out.println("发现问题, 结束");
            return false;
        }
        return isBSearchTreeInternal(root.left, min, root.data - 1)
               && isBSearchTreeInternal(root.right, root.data, max);
    }
}
