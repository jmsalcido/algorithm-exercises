package org.otfusion.lists;

public class LinkedList<T> {

    private SimpleNode<T> rootNode;
    private int size;

    public LinkedList() {
        rootNode = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    // add at the end of the list
    public void add(T element) {
        if(element == null) {
            return;
        }

        if(rootNode == null) {
            rootNode = new SimpleNode<T>(element, null);
        } else {
            SimpleNode<T> nextNode = rootNode;
            while(nextNode.getNext() != null) {
                nextNode = nextNode.getNext();
            }
            nextNode.setNext(new SimpleNode<T>(element, null));
        }
        size+=1;
    }

    public void remove(T element) {
        // failsafe check
        if(element == null || size == 0) {
            return;
        }

        if(rootNode.getData().equals(element)) {
            if(rootNode.getNext() != null) {
                rootNode = rootNode.getNext();
            }
        } else {
            SimpleNode<T> nextNode = rootNode;
            while(nextNode.getNext() != null) {
                SimpleNode<T> actualNode = nextNode;
                nextNode = actualNode.getNext();
                if(nextNode.getData().equals(element)) {
                    actualNode.setNext(nextNode.getNext());
                    break;
                }
            }
        }
        size -= 1;
    }

    public T get(T element) {
        // failsafe check
        if(element == null || size == 0) {
            return null;
        }

        if(rootNode.getData().equals(element)) {
            return rootNode.getData();
        } else {
            SimpleNode<T> nextNode = rootNode;
            while(nextNode.getNext() != null) {
                SimpleNode<T> actualNode = nextNode;
                nextNode = actualNode.getNext();
                if(nextNode.getData().equals(element)) {
                    return nextNode.getData();
                }
            }
        }
        return null;
    }
}
