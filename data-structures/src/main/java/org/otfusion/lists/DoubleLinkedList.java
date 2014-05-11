package org.otfusion.lists;

import org.otfusion.nodes.DoubleNode;

public class DoubleLinkedList<E> implements List<E>{

    private DoubleNode<E> rootNode;
    private int size;

    @Override
    public void add(E element) {
        int index = 0;
        DoubleNode<E> newNode;
        if(rootNode == null) {
            newNode = new DoubleNode<>(element, null, rootNode);
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
        ListUtils.checkIndex(size(), index);

        if(index == 0) {
            DoubleNode<E> node = new DoubleNode<>(element, rootNode, null);
            rootNode.setBefore(node);
            rootNode = node;
            ListUtils.moveIndex(true, rootNode.getNext());
        } else {
            DoubleNode<E> actualNode = rootNode;
            DoubleNode<E> newNode;
            while(actualNode != null) {
                if(actualNode.getIndex() == index) {
                    newNode = new DoubleNode<>(element, actualNode, actualNode.getBefore());
                    newNode.setIndex(index);
                    actualNode.getBefore().setNext(newNode);
                    actualNode.setBefore(newNode);
                    ListUtils.moveIndex(true, newNode.getNext());
                }
                actualNode = actualNode.getNext();
            }
        }
        size++;
    }

    @Override
    public void delete(int index) {
        ListUtils.checkIndex(size(), index);
        if(index == 0) {
            rootNode = rootNode.getNext();
            if(rootNode == null) {
                size--;
                return;
            }
            rootNode.setBefore(null);
            rootNode.setIndex(index);
            ListUtils.moveIndex(false, rootNode.getNext());
        } else {
            DoubleNode<E> actualNode = rootNode;
            while(actualNode != null) {
                if(actualNode.getIndex() == index) {
                    actualNode.getBefore().setNext(actualNode.getNext());
                    if(actualNode.getNext() != null) {
                        actualNode.getNext().setBefore(actualNode.getBefore());
                    }
                    ListUtils.moveIndex(false, actualNode.getNext());
                }
                actualNode = actualNode.getNext();
            }
        }
        size--;
    }

    @Override
    public E get(int index) {
        ListUtils.checkIndex(size(), index);
        if(size() == 0) {
            return null;
        }

        if(index == 0) {
            return rootNode.getData();
        }

        DoubleNode<E> actualNode = rootNode;
        while(actualNode != null) {
            if(actualNode.getIndex() == index) {
                return actualNode.getData();
            }
            actualNode = actualNode.getNext();
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}