package com.example.btree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BTreeTraverseLoop {

    public static <T extends Comparable<?>> List<BTreeNode<T>> preOrderTraverse(BTreeNode<T> root) {
        List<BTreeNode<T>> list = new ArrayList<>();
        Stack<BTreeNode<T>> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                list.add(root);
                stack.push(root);//不管left是否为null, 先把自己入栈了. 下次循环的时候再检查left. 代码简洁
                root = root.left;
            } else {//root为null, 但stack中还有数据
                root = stack.pop().right;
            }
        }
        return list;
    }

    public static <T extends Comparable<?>> List<BTreeNode<T>> inOrderTraverse(BTreeNode<T> root) {
        List<BTreeNode<T>> list = new ArrayList<>();
        Stack<BTreeNode<T>> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {//root为null, 但stack中还有数据
                root = stack.pop();
                list.add(root);
                root = root.right;
            }
        }
        return list;
    }

    public static <T extends Comparable<?>> List<BTreeNode<T>> postOrderTraverse(BTreeNode<T> root) {
        List<BTreeNode<T>> list = new ArrayList<>();
        Stack<BTreeNode<T>> stack = new Stack<>();
        BTreeNode<T> previousPopNode = null;
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                root = root.left;//自己先缓存着, 先遍历左节点了来
            } else {//root为null, 但stack中还有数据
                if (stack.peek().right != null
                    && stack.peek().right != previousPopNode) {//如果不是叶节点, 而自己的右节点也还没有遍历过, 那么先遍历右节点
                    root = stack.peek().right;
                } else {//自己是叶节点, 或者自己的右节点已经遍历过
                    BTreeNode<T> node = stack.pop();
                    list.add(node);
                    previousPopNode = node;
                }
            }
        }
        return list;
    }


}
