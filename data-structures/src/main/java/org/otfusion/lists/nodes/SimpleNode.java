package org.otfusion.lists.nodes;

// Using enums just to not use Objects
public class SimpleNode<E> extends Node<E>{

    private SimpleNode<E> next;

    public SimpleNode(E data, SimpleNode<E> next) {
        super(data);
        this.next = next;
    }

    @Override
    public SimpleNode<E> getNext() {
        return next;
    }

    public void setNext(SimpleNode<E> next) {
        this.next = next;
    }
}
