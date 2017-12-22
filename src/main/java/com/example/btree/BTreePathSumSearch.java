package com.example.btree;

import java.util.ArrayList;
import java.util.List;

public class BTreePathSumSearch {

    public static void search(BTreeNode<Integer> root, final int targetSum) {
        if (root == null || targetSum <= 0) {
            return;
        }
        System.out.println("-------开始查找" + targetSum + "-------");
        searchInternal(root, targetSum, new ArrayList<>());
    }

    private static void searchInternal(BTreeNode<Integer> node, final int targetSum, List<Integer> path) {
        if (node == null) {
            return;
        }
        System.out.print("[" + node.data + "]");
        int sum = getPathSum(path);
        if (sum + node.data == targetSum) {
            System.out.println("-------找到了, 打印-------");
            path.add(node.data);
            print(path);
            //移除当前节点
            path.remove(node.data);
        } else if (sum + node.data < targetSum) {
            System.out.println("没找到, 放入path, 继续找");
            path.add(node.data);
            //继续搜索叶子
            searchInternal(node.left, targetSum, path);
            searchInternal(node.right, targetSum, path);
            //移除当前节点
            path.remove(node.data);
        } else {
            System.out.println("当前和已超出目标值, 停止往下查找");
        }
        System.out.println("[" + node.data + "]结束查找, 回退父节点");
    }

    private static boolean isLeaf(BTreeNode<Integer> node) {
        return node.left == null && node.right == null;
    }

    private static int getPathSum(List<Integer> path) {
        int sum = 0;
        for (Integer data : path) {
            sum += data;
        }
        return sum;
    }

    private static void print(List<Integer> path) {
        for (Integer data : path) {
            System.out.print(data + ", ");
        }
        System.out.println();
    }
}
