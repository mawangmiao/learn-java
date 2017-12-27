package com.example.btree;

import java.util.List;

public class BTreeDepthTest {

    public static void main(String[] args) {
        BTreeNode<Integer> root = createTree1();
        BTreePrinter.print(root);
        int depth = BTreeDepth.getMaxDepth(root);
        System.out.println("期望5, 实际" + depth);
        depth = BTreeDepth.getMinDepth(root);
        System.out.println("期望3, 实际" + depth);

        root = null;
        BTreePrinter.print(root);
        depth = BTreeDepth.getMaxDepth(root);
        System.out.println("期望0, 实际" + depth);
        depth = BTreeDepth.getMinDepth(root);
        System.out.println("期望0, 实际" + depth);

        root = new BTreeNode<Integer>(1);
        BTreePrinter.print(root);
        depth = BTreeDepth.getMaxDepth(root);
        System.out.println("期望1, 实际" + depth);
        depth = BTreeDepth.getMinDepth(root);
        System.out.println("期望1, 实际" + depth);

        root = createTree2();
        BTreePrinter.print(root);
        depth = BTreeDepth.getMaxDepth(root);
        System.out.println("期望2, 实际" + depth);
        depth = BTreeDepth.getMinDepth(root);
        System.out.println("期望2, 实际" + depth);

        root = createTree3();
        BTreePrinter.print(root);
        depth = BTreeDepth.getMaxDepth(root);
        System.out.println("期望4, 实际" + depth);
        depth = BTreeDepth.getMinDepth(root);
        System.out.println("期望4, 实际" + depth);

        root = createTree4();
        BTreePrinter.print(root);
        depth = BTreeDepth.getMaxDepth(root);
        System.out.println("期望4, 实际" + depth);
        depth = BTreeDepth.getMinDepth(root);
        System.out.println("期望4, 实际" + depth);
    }


    private static void print(List<BTreeNode<Integer>> list) {
        for (BTreeNode<Integer> node : list) {
            System.out.print(node.data + ", ");
        }
        System.out.println();
    }

    private static BTreeNode<Integer> createTree1() {
        BTreeNode<Integer> root = new BTreeNode<Integer>(9);
        BTreeNode<Integer> n11 = new BTreeNode<Integer>(3);
        BTreeNode<Integer> n12 = new BTreeNode<Integer>(11);
        BTreeNode<Integer> n21 = new BTreeNode<Integer>(1);
        BTreeNode<Integer> n22 = new BTreeNode<Integer>(5);
        BTreeNode<Integer> n23 = new BTreeNode<Integer>(10);
        BTreeNode<Integer> n24 = new BTreeNode<Integer>(20);
        BTreeNode<Integer> n31 = new BTreeNode<Integer>(4);
        BTreeNode<Integer> n32 = new BTreeNode<Integer>(7);
        BTreeNode<Integer> n41 = new BTreeNode<Integer>(6);
        BTreeNode<Integer> n42 = new BTreeNode<Integer>(8);

        root.left = n11;
        root.right = n12;

        n11.left = n21;
        n11.right = n22;

        n12.left = n23;
        n12.right = n24;

        n22.left = n31;
        n22.right = n32;

        n32.left = n41;
        n32.right = n42;

        return root;
    }

    private static BTreeNode<Integer> createTree2() {
        BTreeNode<Integer> root = new BTreeNode<Integer>(8);
        BTreeNode<Integer> n11 = new BTreeNode<Integer>(9);
        BTreeNode<Integer> n12 = new BTreeNode<Integer>(2);

        root.left = n11;
        root.right = n12;

        return root;
    }

    private static BTreeNode<Integer> createTree3() {
        BTreeNode<Integer> root = new BTreeNode<Integer>(8);
        BTreeNode<Integer> n11 = new BTreeNode<Integer>(9);
        BTreeNode<Integer> n21 = new BTreeNode<Integer>(3);
        BTreeNode<Integer> n31 = new BTreeNode<Integer>(4);

        root.left = n11;
        n11.left = n21;
        n21.left = n31;

        return root;
    }

    private static BTreeNode<Integer> createTree4() {
        BTreeNode<Integer> root = new BTreeNode<Integer>(8);
        BTreeNode<Integer> n11 = new BTreeNode<Integer>(9);
        BTreeNode<Integer> n21 = new BTreeNode<Integer>(3);
        BTreeNode<Integer> n31 = new BTreeNode<Integer>(4);

        root.right = n11;
        n11.right = n21;
        n21.right = n31;

        return root;
    }
}
