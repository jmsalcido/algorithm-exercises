package org.otfusion.unionfind;

public class QuickFindUF extends AbstractUnionFind {

    public QuickFindUF(int n) {
        super(n);
    }

    @Override
    protected void init() {
        for(int i = 0; i < id.length; i++) {
            id[i] = i;
        }
    }

    @Override
    public void union(int p, int q) {
        if(!connected(p,q)) {
            int pid = id[p];
            for(int i = 0; i < id.length; i++) {
                if(id[i] == pid) {
                    id[i] = id[q];
                }
            }
            count--;
        }
    }

    @Override
    public int find(int p) {
        if(p > id.length) {
            throw new IndexOutOfBoundsException("There are only " + id.length + " components.");
        }
        return id[p];
    }

    @Override
    public boolean connected(int p, int q) {
        if(p >= id.length ||  q >= id.length) {
            throw new IndexOutOfBoundsException("There are only " + id.length + " components.");
        }
        return id[p] == id[q];
    }

    @Override
    public int count() {
        return count;
    }
}
