package com.example.btree;

import java.util.LinkedList;
import java.util.Queue;

class CompleteBTree {


    static <T extends Comparable<?>> boolean isComplete(BTreeNode<T> root) {
        if (root == null) return false;

        Queue<BTreeNode<T>> queue = new LinkedList<>();
        queue.offer(root);

        while (queue.peek() != null) {//如果是完全二叉树, 碰到第一个null时, 一定已经遍历了所有节点
            BTreeNode<T> node = queue.poll();
            queue.offer(node.left);
            queue.offer(node.right);
        }

        boolean isComplete = true;
        while (!queue.isEmpty()) {
            BTreeNode<T> node = queue.poll();
            if (node != null) {
                isComplete = false;
            }
        }
        return isComplete;
    }
}
