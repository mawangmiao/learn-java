package com.example.btree;

import java.util.ArrayList;
import java.util.Collections;
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
        //TODO
        return Collections.emptyList();
    }


}
