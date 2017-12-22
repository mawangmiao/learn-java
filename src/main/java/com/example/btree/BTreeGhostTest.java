package com.example.btree;

public class BTreeGhostTest {

    public static void main(String[] args) {
        BTreeNode<Integer> root = createTree1();

        System.out.println("------原始------");
        BTreePrinter.print(root);
        ghost(root);
        System.out.println("------镜像------");
        BTreePrinter.print(root);

        System.out.println("------原始------");
        root = createTree2();
        BTreePrinter.print(root);
        ghost(root);
        System.out.println("------镜像------");
        BTreePrinter.print(root);

        System.out.println("------原始------");
        root = null;
        BTreePrinter.print(root);
        ghost(root);
        System.out.println("------镜像------");
        BTreePrinter.print(root);

        System.out.println("------原始------");
        root = new BTreeNode<Integer>(1);
        BTreePrinter.print(root);
        ghost(root);
        System.out.println("------镜像------");
        BTreePrinter.print(root);

        System.out.println("------原始------");
        root = createTree3();
        BTreePrinter.print(root);
        ghost(root);
        System.out.println("------镜像------");
        BTreePrinter.print(root);

        System.out.println("------原始------");
        root = createTree4();
        BTreePrinter.print(root);
        ghost(root);
        System.out.println("------镜像------");
        BTreePrinter.print(root);
    }

    private static void ghost(BTreeNode<Integer> node) {
        if (node == null) return;

        BTreeNode<Integer> tmp = node.left;
        node.left = node.right;
        node.right = tmp;

        ghost(node.left);
        ghost(node.right);
    }

    private static BTreeNode<Integer> createTree1() {
        BTreeNode<Integer> root = new BTreeNode<Integer>(8);
        BTreeNode<Integer> n11 = new BTreeNode<Integer>(8);
        BTreeNode<Integer> n12 = new BTreeNode<Integer>(7);
        BTreeNode<Integer> n21 = new BTreeNode<Integer>(9);
        BTreeNode<Integer> n22 = new BTreeNode<Integer>(8);
        BTreeNode<Integer> n31 = new BTreeNode<Integer>(9);
        BTreeNode<Integer> n32 = new BTreeNode<Integer>(8);
        BTreeNode<Integer> n41 = new BTreeNode<Integer>(9);
        BTreeNode<Integer> n42 = new BTreeNode<Integer>(2);

        root.left = n11;
        root.right = n12;

        n11.left = n21;
        n11.right = n22;

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
