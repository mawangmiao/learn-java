package com.example.btree;

import java.util.Queue;

public class BTreeLowestCommonParentTest {

    public static void main(String[] args) {
        BTreeNode<Integer> root = createTree1();
        BTreePrinter.print(root);
        System.out.println("------测试findPath开始------");
        Queue<BTreeNode<Integer>> path = BTreeLowestCommonParent.findPath(root, 9);
        System.out.print("期望path 9, 实际");
        BTreeLowestCommonParent.printPath(path);
        path = BTreeLowestCommonParent.findPath(root, 10);
        System.out.print("期望path 9,11,10, 实际");
        BTreeLowestCommonParent.printPath(path);
        path = BTreeLowestCommonParent.findPath(root, 6);
        System.out.print("期望path 9,3,5,7,6, 实际");
        BTreeLowestCommonParent.printPath(path);
        path = BTreeLowestCommonParent.findPath(root, 666);
        System.out.print("期望path为空 , 实际");
        BTreeLowestCommonParent.printPath(path);

        System.out.println("------测试findPath结束------");
        System.out.println("------测试find开始------");

        BTreeNode<Integer> node = BTreeLowestCommonParent.find(root, 3, 11);
        System.out.println("期望9, 实际" + node.data);
        node = BTreeLowestCommonParent.find(root, 10, 20);
        System.out.println("期望11, 实际" + node.data);
        node = BTreeLowestCommonParent.find(root, 1, 10);
        System.out.println("期望9, 实际" + node.data);
        node = BTreeLowestCommonParent.find(root, 1, 8);
        System.out.println("期望3, 实际" + node.data);
        node = BTreeLowestCommonParent.find(root, 8, 20);
        System.out.println("期望9, 实际" + node.data);
        node = BTreeLowestCommonParent.find(root, 6, 8);
        System.out.println("期望7, 实际" + node.data);
        node = BTreeLowestCommonParent.find(root, 4, 5);
        System.out.println("期望5, 实际" + node.data);
        node = BTreeLowestCommonParent.find(root, 4, 666);
        System.out.println("期望null, 实际" + node);

        root = createTree2();
        BTreePrinter.print(root);
        node = BTreeLowestCommonParent.find(root, 2, 9);
        System.out.println("期望8, 实际" + node.data);

        node = BTreeLowestCommonParent.find(null, 2, 9);
        System.out.println("期望null, 实际" + node);

        root = createTree3();
        BTreePrinter.print(root);
        node = BTreeLowestCommonParent.find(root, 3, 7);
        System.out.println("期望7, 实际" + node.data);

        root = createTree4();
        BTreePrinter.print(root);
        node = BTreeLowestCommonParent.find(root, 10, 11);
        System.out.println("期望10, 实际" + node.data);
    }


    private static void print(BTreeNode<Integer> head) {
        while (head != null) {
            System.out.print(head.data + ", ");
            head = head.right;
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
        BTreeNode<Integer> n11 = new BTreeNode<Integer>(2);
        BTreeNode<Integer> n12 = new BTreeNode<Integer>(9);

        root.left = n11;
        root.right = n12;

        return root;
    }

    private static BTreeNode<Integer> createTree3() {
        BTreeNode<Integer> root = new BTreeNode<Integer>(8);
        BTreeNode<Integer> n11 = new BTreeNode<Integer>(7);
        BTreeNode<Integer> n21 = new BTreeNode<Integer>(4);
        BTreeNode<Integer> n31 = new BTreeNode<Integer>(3);

        root.left = n11;
        n11.left = n21;
        n21.left = n31;

        return root;
    }

    private static BTreeNode<Integer> createTree4() {
        BTreeNode<Integer> root = new BTreeNode<Integer>(8);
        BTreeNode<Integer> n11 = new BTreeNode<Integer>(9);
        BTreeNode<Integer> n21 = new BTreeNode<Integer>(10);
        BTreeNode<Integer> n31 = new BTreeNode<Integer>(11);

        root.right = n11;
        n11.right = n21;
        n21.right = n31;

        return root;
    }
}
