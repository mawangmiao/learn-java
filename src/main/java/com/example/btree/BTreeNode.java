package com.example.btree;

class BTreeNode<T extends Comparable<?>> {
    BTreeNode<T> left, right;
    T data;

    public BTreeNode(T data) {
        this.data = data;
    }
}
