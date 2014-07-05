public class Percolation {

    private WeightedQuickUnionUF unionFind;
    private final int N;
    private final int TOP;
    private final int BOTTOM;
    private final boolean[] grid;

    public Percolation(final int N) {
        checkParameters(N);
        this.N = N;
        int nxn = N*N;
        TOP = nxn;
        BOTTOM = TOP+1;
        unionFind = new WeightedQuickUnionUF(nxn+2);

        // GRID STUFF.
        grid = new boolean[nxn+2];
        for (int i = 0; i < nxn+2; i++) {
            grid[i] = false;
        }
    }

    public void open(int i, int j) {
        checkParameters(i);
        checkParameters(j);
        if (!isOpen(i, j)) {
            int p = xyTo1D(i-1, j-1);
            grid[p] = true;
            if (p < N) {
                unionFind.union(p, TOP);
            }
            if (p >= (N*(N-1))) {
                unionFind.union(p, BOTTOM);
            }
            openSite(p, i-1, j);
            openSite(p, i+1, j);
            openSite(p, i, j-1);
            openSite(p, i, j+1);
        }
    }

    private void openSite(int p, int i, int j) {
        int q = xyTo1D(i-1, j-1);
        if (!(q < 0 || q >= N*N) && isOpen(i, j)) {
            unionFind.union(p, q);
        }
    }

    public boolean isOpen(int i, int j) {
        checkParameters(i);
        checkParameters(j);
        return grid[xyTo1D(i-1, j-1)];
    }

    public boolean isFull(int i, int j) {
        checkParameters(i);
        checkParameters(j);
        // BUG:
        return unionFind.connected(xyTo1D(i-1, j-1),TOP);
    }

    public boolean percolates() {
        return unionFind.connected(TOP, BOTTOM);
    }

    private int xyTo1D(int x, int y) {
        if (x < 0 || y < 0 || x >= N || y >= N) {
            return -1;
        }
        return (x*N)+y;
    }

    private void checkParameters(int i) {
        if (i <= 0 || i > N) throw new IndexOutOfBoundsException(String.format("row index %d out of bounds", i));
    }
}
