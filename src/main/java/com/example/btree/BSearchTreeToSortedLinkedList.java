package com.example.btree;

import java.util.ArrayList;
import java.util.List;

public class BSearchTreeToSortedLinkedList {


    public static <T extends Comparable<?>> BTreeNode<T> convert(BTreeNode<T> root) {
        if (root == null) {
            return null;
        }
        List<BTreeNode<T>> list = new ArrayList<>();
        convertInternal(root, list);
        return list.get(0);
    }

    private static <T extends Comparable<?>> void convertInternal(BTreeNode<T> root, List<BTreeNode<T>> list) {
        if (root == null) {
            return;
        }

        if (root.left != null) {
            convertInternal(root.left, list);
        }

        //对于二叉搜索树, 按照中序遍历,一定是按从小到大的顺序遍历和加入List的
        //所以新加入元素跟List中最后一个元素链接起来
        if (!list.isEmpty()) {
            list.get(list.size() - 1).right = root;
            root.left = list.get(list.size() - 1);
        }
        list.add(root);

        if (root.right != null) {
            convertInternal(root.right, list);
        }
    }


}
