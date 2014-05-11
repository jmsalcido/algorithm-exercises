package org.otfusion.lists;

import org.otfusion.lists.nodes.SimpleNode;

public class LinkedList<E> implements List<E> {

    private SimpleNode<E> rootNode;
    private int size;

    public LinkedList() {
        rootNode = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    // add at the end of the list
    public void add(E element) {
        if(element == null) {
            return;
        }
        SimpleNode<E> newNode = new SimpleNode<>(element, null);
        if(rootNode == null) {
            rootNode = newNode;
        } else {
            SimpleNode<E> actualNode = rootNode;
            int index = 0;
            while(actualNode.getNext() != null) {
                actualNode = actualNode.getNext();
                index = actualNode.getIndex();
            }
            newNode.setIndex(index+1);
            actualNode.setNext(newNode);
        }
        size++;
    }

    @Override
    public void add(E element, int index) {
        ListUtils.checkIndex(size(), index);
        SimpleNode<E> actualNode = rootNode;
        if(index == 0) {
            rootNode = new SimpleNode<>(element, actualNode);
            rootNode.setIndex(index);
            moveIndex(true, rootNode.getNext());
        } else {
            SimpleNode<E> nextNode = actualNode.getNext();
            while(nextNode != null) {
                if(nextNode.getIndex() == index) {
                    actualNode.setNext(new SimpleNode<>(element, nextNode));
                    nextNode = actualNode.getNext();
                    nextNode .setIndex(index);
                    moveIndex(true, nextNode.getNext());
                    break;
                }
                actualNode = nextNode;
                nextNode = nextNode.getNext();
            }
        }
        size++;
    }

    private void removeNode(SimpleNode<E> actual, SimpleNode<E> delete) {
        if(delete == null) {
            actual.setNext(null);
        } else {
            actual.setNext(delete.getNext());
        }
        moveIndex(false, actual.getNext());
    }

    @Override
    public void delete(int index) {
        ListUtils.checkIndex(size(), index);

        if(index == 0) {
            rootNode = rootNode.getNext();
            moveIndex(false, rootNode);
        } else {
            SimpleNode<E> deleteNode = rootNode;
            SimpleNode<E> actualNode = deleteNode;
            boolean delete = false;
            while(deleteNode != null) {
                actualNode = deleteNode;
                deleteNode = actualNode.getNext();
                if(deleteNode != null && deleteNode.getIndex() == index) {
                    delete = true;
                    break;
                }
            }
            if(delete) {
                removeNode(actualNode, deleteNode);
            }
        }
        size-=1;
    }

    private void moveIndex(boolean increase, SimpleNode<E> node) {
        if(node != null) {
            do {
                int value = increase ? 1 : -1;
                node.setIndex(node.getIndex() + value);
                node = node.getNext();
            } while (node != null);
        }
    }

    @Override
    public E get(int index) {
        ListUtils.checkIndex(size(), index);

        if(size == 0) {
            return null;
        }

        if(index == 0) {
            if(rootNode != null) {
                return rootNode.getData();
            }
        } else {
            SimpleNode<E> nextNode = rootNode;
            while(nextNode.getNext() != null) {
                if(nextNode.getIndex() == index) {
                    return nextNode.getData();
                }
                nextNode = nextNode.getNext();
            }
            // we are at the last node then.
            return nextNode.getIndex() == index ? nextNode.getData() : null;
        }
        return null;
    }
}
