package org.otfusion.lists;

import org.otfusion.lists.nodes.Node;

public interface List<E> {

    void add(E element);
    void add(E element, int index);
    void delete(int index);
    E get(int index);
}
