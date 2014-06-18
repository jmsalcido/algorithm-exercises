package org.otfusion.unionfind;

public interface UnionFind {

    /**
     * connect component q and p
     * @param p component
     * @param q component
     */
    void union(int p, int q);

    /**
     * identifier for component p
     * @param p component
     * @return identifier for p
     */
    int find(int p);

    /**
     * check if components p and q are connected
     * @param p component
     * @param q component
     * @return true if p and q are connected components else false
     */
    boolean connected(int p, int q);

    /**
     * number of dots/components
     * @return n
     */
    int count();

}
