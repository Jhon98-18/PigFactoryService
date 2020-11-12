package com.zz.test.tree;

public class BinaryTree<E extends Comparable<? super E>> {

    private BinaryNode<E> root;


    private boolean contains(E e, BinaryNode<E> binaryNode) {
        if (e == null) {
            return false;
        }
        int i = e.compareTo(binaryNode.data);
        if (i > 0) {
            return contains(e, binaryNode.right);
        } else if (i < 0) {
            return contains(e, binaryNode.right);
        } else {
            return true;
        }
    }

    public void remove(E e) {
        root = remove(e, root);
    }

    private BinaryNode<E> remove(E e, BinaryNode<E> binaryNode) {
        if (binaryNode == null) {
            return binaryNode;
        }
        int i = e.compareTo(binaryNode.data);
        if (i > 0) {
            binaryNode.right = remove(e, binaryNode.right);
        } else if (i < 0) {
            binaryNode.left = remove(e, binaryNode.left);
        } else if (binaryNode.left != null && binaryNode.right != null) {
            //binaryNode.data = findMin(binaryNode.right);
            binaryNode.right = remove(binaryNode.data, binaryNode.right);

        } else {
            binaryNode = (binaryNode.left != null) ? binaryNode.left : binaryNode.right;


        }
        return binaryNode;
    }
}
