public class Percolation {

    private final int[] unionfind;
    public final int N;

    public Percolation(int N) {
        this.N = N;
        unionfind = new int[N*N];
        for(int i = 0; i < N*N; i++) {
            unionfind[i] = i;
        }
    }

    public void open(int i, int j) {
        checkParameters(i,j);
    }

    public boolean isOpen(int i, int j) {
        checkParameters(i,j);
        return false;
    }

    public boolean isFull(int i, int j) {
        checkParameters(i,j);
        return false;
    }

    public boolean percolates() {
        return false;
    }

    private void checkParameters(int i, int j) {
        if (i <= 0 || i > N) throw new IndexOutOfBoundsException("row index i out of bounds");
        if (j <= 0 || j > N) throw new IndexOutOfBoundsException("row index j out of bounds");
    }
}
