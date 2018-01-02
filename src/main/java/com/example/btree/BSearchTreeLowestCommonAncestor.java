package com.example.btree;

import org.apache.commons.lang3.Validate;

public class BSearchTreeLowestCommonAncestor {

    public static BTreeNode<Integer> find(BTreeNode<Integer> root, int small, int large) {
        if (root == null) return null;
        Validate.isTrue(small < large);

        //从根节点遍历, 找到第一个根, 满足条件: node1 < root < node2
        BTreeNode<Integer> currentRoot = root;
        while (root != null) {
            if (root.data > small && root.data < large) {
                break;
            } else if (root.data > large) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return root;
    }
}
