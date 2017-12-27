package com.example.btree;

import lombok.NonNull;

import java.util.LinkedList;
import java.util.Queue;

class BTreeLowestCommonParent {

    static BTreeNode<Integer> find(BTreeNode<Integer> root, int value1, int value2) {
        if (root == null) return null;

        Queue<BTreeNode<Integer>> path1 = findPath(root, value1);
        Queue<BTreeNode<Integer>> path2 = findPath(root, value2);

        BTreeNode<Integer> lowestCommonParent = null;

        while (!path1.isEmpty() && !path2.isEmpty()) {
            BTreeNode<Integer> head1 = path1.poll();
            BTreeNode<Integer> head2 = path2.poll();
            if (head1 == head2) {
                lowestCommonParent = head1;//可能找到了, 先存着
            } else {
                break;//发现不等, 上次循环找到的那个就是了
            }
        }
        return lowestCommonParent;
    }

    static Queue<BTreeNode<Integer>> findPath(BTreeNode<Integer> root, int value) {
        Queue<BTreeNode<Integer>> path = new LinkedList<>();
        findPath(root, value, path);
        return path;
    }

    private static boolean findPath(BTreeNode<Integer> root, int value, Queue<BTreeNode<Integer>> path) {
        if (root == null) return false;

        path.offer(root);//可能是路径中的节点, 先加入path再说
        if (root.data == value) {
            return true;
        }

        if (findPath(root.left, value, path) || findPath(root.right, value, path)) {
            return true;
        } else {
            path.remove(root);//确定不是路径中的节点, 从path中移除
            return false;
        }

    }

    static void printPath(@NonNull Queue<BTreeNode<Integer>> path) {
        if (path.isEmpty()) {
            System.out.println("path为空");
            return;
        }

        StringBuilder stringBuilder = new StringBuilder();
        path.forEach(node -> {
            stringBuilder.append(node.data);
            stringBuilder.append(",");
        });
        stringBuilder.delete(stringBuilder.length() - 1, stringBuilder.length());

        System.out.println("path " + stringBuilder.toString());
    }
}
