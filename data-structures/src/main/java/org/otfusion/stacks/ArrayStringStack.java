package org.otfusion.stacks;

public class ArrayStringStack {

    private String[] array;
    int n = 0;

    public ArrayStringStack(int n) {
        array = new String[n];
    }

    public void push(String str) {
        array[n++] = str;
    }

    public String pop() {
        String str = array[--n];
        array[n] = null;
        return str;
    }

    public int size() {
        return n;
    }
}
