package org.otfusion.lists;

import org.otfusion.lists.List;
import org.otfusion.lists.nodes.SimpleNode;

public class LinkedList<E> implements List<E> {

    private SimpleNode<E> rootNode;
    private int size;

    public LinkedList() {
        rootNode = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    @Override
    // add at the end of the list
    public void add(E element) {
        if(element == null) {
            return;
        }

        if(rootNode == null) {
            rootNode = new SimpleNode<E>(element, null);
        } else {
            SimpleNode<E> nextNode = rootNode;
            while(nextNode.getNext() != null) {
                nextNode = nextNode.getNext();
            }
            nextNode.setNext(new SimpleNode<E>(element, null));
        }
        size+=1;
    }

    @Override
    public void remove(E element) {
        // failsafe check
        if(element == null || size == 0) {
            return;
        }

        if(rootNode.getData().equals(element)) {
            if(rootNode.getNext() != null) {
                rootNode = rootNode.getNext();
            }
        } else {
            SimpleNode<E> nextNode = rootNode;
            while(nextNode.getNext() != null) {
                SimpleNode<E> actualNode = nextNode;
                nextNode = actualNode.getNext();
                if(nextNode.getData().equals(element)) {
                    actualNode.setNext(nextNode.getNext());
                    break;
                }
            }
        }
        size -= 1;
    }

    @Override
    public E get(E element) {
        // failsafe check
        if(element == null || size == 0) {
            return null;
        }

        if(rootNode.getData().equals(element)) {
            return rootNode.getData();
        } else {
            SimpleNode<E> nextNode = rootNode;
            while(nextNode.getNext() != null) {
                SimpleNode<E> actualNode = nextNode;
                nextNode = actualNode.getNext();
                if(nextNode.getData().equals(element)) {
                    return nextNode.getData();
                }
            }
        }
        return null;
    }
}
