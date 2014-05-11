package org.otfusion.lists.nodes;

public class Node<E> {

    private final E data;
    private int index;

    public Node(E data) {
        this.data = data;
    }

    public E getData() {
        return data;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
