package com.example.btree;

public class BTreeContainTest {

    public static void main(String[] args) {
        BTreeNode<Integer> root1 = createTree1();
        BTreeNode<Integer> root2 = createTree2();
        BTreeNode<Integer> root3 = createTree3();

        BTreePrinter.print(root1);
        BTreePrinter.print(root2);
        BTreePrinter.print(root3);
        System.out.println("期望为true, 实际为" + contains(root1, root2));
        System.out.println("期望为false, 实际为" + contains(null, root2));
        System.out.println("期望为false, 实际为" + contains(root1, null));
        System.out.println("期望为false, 实际为" + contains(root1, root3));
        System.out.println("期望为true, 实际为" + contains(new BTreeNode<Integer>(8), new BTreeNode<Integer>(8)));
        System.out.println("期望为false, 实际为" + contains(new BTreeNode<Integer>(8), new BTreeNode<Integer>(1)));
    }

    private static boolean contains(BTreeNode<Integer> root1, BTreeNode<Integer> root2) {

        if (root1 == null || root2 == null) {
            return false;
        }

        if (isSameSubTree(root1, root2)) {
            return true;
        } else if (contains(root1.left, root2)) {
            return true;
        } else if (contains(root1.right, root2)) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean isSameSubTree(BTreeNode<Integer> subRoot1, BTreeNode<Integer> subRoot2) {
        if (subRoot2 == null) {
            return true;
        }
        if (subRoot1 == null) {
            return false;
        }
        if (subRoot1.data.equals(subRoot2.data)) {
            return isSameSubTree(subRoot1.left, subRoot2.left) && isSameSubTree(subRoot1.right, subRoot2.right);
        }
        return false;
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
        BTreeNode<Integer> n12 = new BTreeNode<Integer>(3);

        root.left = n11;
        root.right = n12;

        return root;
    }
}
