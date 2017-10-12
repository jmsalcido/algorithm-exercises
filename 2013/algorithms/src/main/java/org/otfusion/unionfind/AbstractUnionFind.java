package org.otfusion.unionfind;

public abstract class AbstractUnionFind implements UnionFind {

    int[] id;
    int count;

    public AbstractUnionFind(int n) {
        if(n <= 0) {
            throw new IllegalArgumentException("n should be greater than 0.");
        }
        id = new int[n];
        count = n;
        init();
    }

    protected abstract void init();

}
