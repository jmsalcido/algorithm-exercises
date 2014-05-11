package org.otfusion.lists;

// Using enums just to not use Objects
public class SimpleNode<T> {

    private final T data;
    private SimpleNode<T> next;

    public SimpleNode(T data, SimpleNode<T> next) {
        this.data = data;
        this.next = next;
    }

    public SimpleNode<T> getNext() {
        return next;
    }

    public void setNext(SimpleNode<T> next) {
        this.next = next;
    }

    public T getData() {
        return data;
    }
}
