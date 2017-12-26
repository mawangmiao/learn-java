package com.example.btree;

import lombok.AllArgsConstructor;
import lombok.Getter;

class BalancedBTree {

    private static final NodeResult IN_BALANCED_RESULT = new NodeResult(-1, false);

    static <T extends Comparable<?>> boolean isBalanced(BTreeNode<T> root) {
        if (root == null) return false;

        NodeResult nodeResult = postOrderTraverseInterval(root);
        return nodeResult.isBalanced;
    }

    private static <T extends Comparable<?>> NodeResult postOrderTraverseInterval(BTreeNode<T> root) {
        if (root == null) {
            return new NodeResult(0, true);
        }

        NodeResult leftResult = postOrderTraverseInterval(root.left);
        if (!leftResult.isBalanced) {
            return IN_BALANCED_RESULT;
        }

        NodeResult rightResult = postOrderTraverseInterval(root.right);
        if (!rightResult.isBalanced) {
            return IN_BALANCED_RESULT;
        }

        int depthDiff = leftResult.depth - rightResult.depth;
        if (depthDiff >= -1 && depthDiff <= 1) {//左右子树深度差小于等于1, 那当前节点是平衡的
            int depth = leftResult.depth > rightResult.depth ? leftResult.depth + 1 : rightResult.depth + 1;
            return new NodeResult(depth, true);
        } else {
            return IN_BALANCED_RESULT;
        }
    }

    @Getter
    @AllArgsConstructor
    private static class NodeResult {
        private int     depth;
        private boolean isBalanced;
    }
}
