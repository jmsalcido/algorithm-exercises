package org.otfusion.nodes;

// Using generics just to not use Objects
public class SimpleNode<E> extends Node<E>{

    private Node<E> next;

    public SimpleNode(E data, Node<E> next) {
        super(data);
        this.next = next;
    }

    @Override
    public SimpleNode<E> getNext() {
        return (SimpleNode<E>)next;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }
}
