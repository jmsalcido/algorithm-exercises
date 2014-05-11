package org.otfusion.lists;

import org.otfusion.lists.nodes.DoubleNode;

public class DoubleLinkedList<E> implements List<E>{

    private DoubleNode<E> rootNode;
    private int size;

    @Override
    public void add(E element) {
        if(element == null) {
            return;
        }

        int index = 0;
        DoubleNode<E> newNode;
        if(rootNode == null) {
            newNode = new DoubleNode<E>(element, null, rootNode);
            newNode.setIndex(index);
            rootNode = newNode;
        } else {
            DoubleNode<E> actualNode = rootNode;
            DoubleNode<E> nextNode = rootNode.getNext();
            while(true) {
                if(nextNode == null) {
                    newNode = new DoubleNode<E>(element, null, actualNode);
                    newNode.setIndex(index+1);
                    actualNode.setNext(newNode);
                    break;
                }
                index++;
                actualNode = actualNode.getNext();
                nextNode = actualNode.getNext();
            }
        }
        size++;
    }

    @Override
    public void add(E element, int index) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void delete(int index) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public E get(int index) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public int size() {
        return size;
    }
}