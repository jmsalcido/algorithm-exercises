package org.otfusion.nodes;

public class DoubleNode<E> extends Node<E> {

    private DoubleNode<E> next;
    private DoubleNode<E> before;

    public DoubleNode(E data, DoubleNode<E> next, DoubleNode<E> before) {
        super(data);
        this.next = next;
        this.before = before;
    }

    public DoubleNode<E> getBefore() {
        return before;
    }

    public void setBefore(DoubleNode<E> before) {
        this.before = before;
    }

    @Override
    public DoubleNode<E> getNext() {
        return next;
    }

    public void setNext(DoubleNode<E> next) {
        this.next = next;
    }
}
