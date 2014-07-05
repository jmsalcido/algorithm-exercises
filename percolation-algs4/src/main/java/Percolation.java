public class Percolation {

    private WeightedQuickUnionUF unionFind;
    private final int N;
    private final int TOP;
    private final int BOTTOM;
    private final boolean[] grid;

    public Percolation(final int N) {
        if (N <= 0) {
            throw new IllegalArgumentException("N cant be 0 or less.");
        }
        this.N = N;
        int nxn = N*N;
        TOP = nxn;
        BOTTOM = TOP+1;
        int size = nxn;
        unionFind = new WeightedQuickUnionUF(size+2);

        // Initialize grid to closed.
        grid = new boolean[size];
    }

    public void open(int i, int j) {
        checkParameters(i, j);
        if (!isOpen(i, j)) {
            int p = xyTo1D(i-1, j-1);
            grid[p] = true;
            if (p < N) {
                unionFind.union(p, TOP);
            }
            boolean n1 = openSite(p, i - 1, j);
            boolean n2 = openSite(p, i + 1, j);
            boolean n3 = openSite(p, i, j - 1);
            boolean n4 = openSite(p, i, j + 1);
            if (n1 || n2 || n3 || n4) {
                for (int b = grid.length-1; b >= grid.length-N; b--) {
                    if (grid[b] && unionFind.connected(TOP, b)) {
                        unionFind.union(b, BOTTOM);
                        break;
                    }
                }
            }
            if (grid.length == 1) {
                unionFind.union(TOP, BOTTOM);
            }
        }
    }

    private boolean openSite(int p, int i, int j) {
        int q = xyTo1D(i-1, j-1);
        if (!(q < 0 || q >= N*N) && isOpen(i, j)) {
            unionFind.union(p, q);
            return true;
        }
        return false;
    }

    public boolean isOpen(int i, int j) {
        checkParameters(i, j);
        return grid[xyTo1D(i-1, j-1)];
    }

    public boolean isFull(int i, int j) {
        checkParameters(i, j);
        return unionFind.connected(TOP, xyTo1D(i-1, j-1));
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

    private void checkParameters(int i, int j) {
        if (i <= 0 || i > N) throw new IndexOutOfBoundsException(String.format("row index i: %d out of bounds", i));
        if (j <= 0 || j > N) throw new IndexOutOfBoundsException(String.format("row index j: %d out of bounds", j));
    }
}
