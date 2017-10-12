package org.otfusion.stacks;

public class ResizingArrayStringStack {

    private String array[];
    private int n;

    public ResizingArrayStringStack() {
        array = new String[5];
        n = 0;
    }

    public void push(String str) {
        if (array.length == n) {
            resize(array.length * 2);
        }
        array[n++] = str;
    }

    public String pop() {
        String pop = array[--n];
        array[n] = null;
        if(n > 0 && n == array.length/4) {
            resize(array.length/2);
        }
        return pop;
    }

    public int size() {
        return n;
    }

    private void resize(int n) {
        String newArray[] = new String[n];
        for (int i = 0; i < size(); i++) {
            newArray[i] = array[i];
        }
        array = newArray;
    }
}
