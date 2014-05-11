package org.otfusion.lists.nodes;

// Using enums just to not use Objects
public class SimpleNode<E> {

    private final E data;
    private SimpleNode<E> next;

    public SimpleNode(E data, SimpleNode<E> next) {
        this.data = data;
        this.next = next;
    }

    public SimpleNode<E> getNext() {
        return next;
    }

    public void setNext(SimpleNode<E> next) {
        this.next = next;
    }

    public E getData() {
        return data;
    }
}
