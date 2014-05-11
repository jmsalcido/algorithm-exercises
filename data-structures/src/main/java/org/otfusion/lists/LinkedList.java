package org.otfusion.lists;

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
            rootNode.setIndex(0);
        } else {
            SimpleNode<E> nextNode = rootNode;
            int index = rootNode.getIndex();
            while(nextNode.getNext() != null) {
                nextNode = nextNode.getNext();
                index = nextNode.getIndex();
            }
            SimpleNode<E> newNode = new SimpleNode<E>(element, null);
            newNode.setIndex(index+1);
            nextNode.setNext(newNode);
        }
        size+=1;
    }

    @Override
    public void add(E element, int index) {
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
        if(index < 0) {
            throw new NumberFormatException("Index cant be less than 0.");
        }

        if(index > size-1) {
            throw new NumberFormatException("Index cant be larger than list size.");
        }

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
        if(index < 0) {
            throw new NumberFormatException("Index cant be less than 0.");
        }

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
