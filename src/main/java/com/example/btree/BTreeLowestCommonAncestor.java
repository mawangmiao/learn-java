package com.example.btree;

public class BTreeLowestCommonAncestor {

    public static BTreeNode<Integer> find(BTreeNode<Integer> root, int first, int second) {
        if (root == null) return null;

        if (root.data == first || root.data == second) return root;

        // 检查左子树是否包含first或second
        BTreeNode<Integer> left = find(root.left, first, second);
        // 检查右子树是否包含first或second
        BTreeNode<Integer> right = find(root.right, first, second);
        // 如果first和second分别位于左右子树
        if (left != null && right != null) return root;

        return left != null ? left : right;
    }
}
