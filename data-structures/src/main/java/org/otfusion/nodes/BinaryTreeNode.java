package org.otfusion.nodes;

public class BinaryTreeNode<E> extends Node<E>{

    private BinaryTreeNode<E> left;
    private BinaryTreeNode<E> right;

    public BinaryTreeNode(E data) {
        super(data);
    }

    public BinaryTreeNode(E data, BinaryTreeNode<E> left, BinaryTreeNode<E> right) {
        super(data);
        this.left = left;
        this.right = right;
    }

    @Override
    public Node<E> getNext() {
        throw new  AssertionError("Method not used.");
    }

    public BinaryTreeNode<E> getRight() {
        return right;
    }

    public void setRight(BinaryTreeNode<E> right) {
        this.right = right;
    }

    public BinaryTreeNode<E> getLeft() {
        return left;
    }

    public void setLeft(BinaryTreeNode<E> left) {
        this.left = left;
    }
}
