class SimpleUF {

    int[] p;

    SimpleUF(int n) {
        p = new int[n];
        // missing
        for (int i = 0; i < p.length; i++) {
            p[i] = i;
        }
    }

    boolean connected(int a, int b) {
        return p[a] == p[b];
    }

    void union(int a, int b) {
        int temp = p[a];
        p[a] = p[b];
        for (int i = 0; i < p.length; i++) {
            if (p[i] == temp) {
                p[i] = p[b];
            }
        }
    }


}
