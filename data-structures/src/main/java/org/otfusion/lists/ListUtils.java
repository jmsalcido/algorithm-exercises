package org.otfusion.lists;

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
}
