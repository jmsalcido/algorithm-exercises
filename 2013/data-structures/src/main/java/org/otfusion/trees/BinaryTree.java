package org.otfusion.trees;

import org.otfusion.nodes.BinaryTreeNode;

public class BinaryTree<E extends Comparable<E>> {

    private BinaryTreeNode<E> root;
    private int nodesCount;

    private int compare(E x, E y) {
        return x.compareTo(y);
    }

    public void add(E data) {
        root = insert(root, data);
        nodesCount++;
    }

    private BinaryTreeNode<E> insert(BinaryTreeNode<E> p, E data) {
        // BinaryNodes will be always be set on null values.
        if(p == null) {
            return new BinaryTreeNode<>(data);
        }

        // if data is the same.
        if(compare(data, p.getData()) == 0) {
            return p;
        }

        // if new data is less than the node data use the left child
        if(compare(data, p.getData()) < 0) {
            p.setLeft(insert(p.getLeft(), data));
        } else {

            // use the right child
            p.setRight(insert(p.getRight(), data));
        }

        return p;
    }

    public boolean search(E data) {
        return search(root, data);
    }

    private boolean search(BinaryTreeNode<E> p, E data) {
        if(p == null) {
            return false;
        }
        if(compare(data, p.getData()) == 0) {
            return true;
        }
        if(compare(data, p.getData()) < 0) {
            return search(p.getLeft(), data);
        } else {
            return search(p.getRight(), data);
        }
    }

    public void delete(E data) {
//        root = delete(root, data);
    }

    public int getNodesCount() {
        return nodesCount;
    }
}
