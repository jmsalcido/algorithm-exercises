package org.otfusion.stacks;

import org.otfusion.nodes.Node;
import org.otfusion.nodes.SimpleNode;

public class LinkedStack<E> {

    private SimpleNode<E> first;
    private int size;

    public LinkedStack() {
    }

    public void push(E object) {
        Node<E> oldFirst = first;
        first = new SimpleNode<>(object, oldFirst);
        size++;
    }

    public E pop() {
        E data = first.getData();
        first = first.getNext();
        size--;
        return data;
    }

    public int size() {
        return size;
    }

}
