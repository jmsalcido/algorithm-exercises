package org.otfusion.lists;

import org.otfusion.nodes.Node;

public class ListUtils {
    private ListUtils() {}

    public static void checkIndex(final int size, final int index) {
        if(index < 0) {
            throw new NumberFormatException("Index cant be less than 0.");
        }

        if(index > size-1) {
            throw new NumberFormatException("Index cant be larger than list size.");
        }
    }

    public static void moveIndex(boolean increase, Node node) {
        if(node != null) {
            do {
                int value = increase ? 1 : -1;
                node.setIndex(node.getIndex() + value);
                node = node.getNext();
            } while (node != null);
        }
    }
}
