package com.zz.test.tree;

public class BinaryNode<T> {
     T data;
     BinaryNode<T> left;
     BinaryNode<T> right;

    BinaryNode(T data) {
        this(data, null, null);
    }

    public BinaryNode(T data, BinaryNode<T> left, BinaryNode<T> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}
