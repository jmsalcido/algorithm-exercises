public class PercolationStats {

    private double mean;
    private double stddev;
    private double confidenceHi;
    private double confidenceLo;

    public PercolationStats(int N, int T) {
        if (N <= 0 || T <= 0) {
            throw new IllegalArgumentException("initial parameters can't be equal or less than 0.");
        }
        double[] thresholds = new double[T];
        double thresholdsCount = 0.0;
        double nxn = N*N;
        for (int i = 0; i < T; i++) {
            int openCount = 0;
            Percolation percolation = new Percolation(N);
            while (!percolation.percolates()) {
                int x = StdRandom.uniform(N) + 1;
                int y = StdRandom.uniform(N) + 1;
                if (!(percolation.isOpen(x, y))) {
                    percolation.open(x, y);
                    openCount++;
                }
            }
            double threshold = openCount / nxn;
            thresholdsCount += threshold;
            thresholds[i] = threshold;
        }
        mean = thresholdsCount / T;
        double stdDevCount = 0;
        for (int i = 0; i < T; i++) {
            double partialStdDev = thresholds[i] - mean;
            stdDevCount += partialStdDev * partialStdDev;
        }
        stddev = Math.sqrt(stdDevCount / (T - 1));
        double confidenceConstant = (1.96 * stddev) / Math.sqrt(T);
        confidenceLo = mean - confidenceConstant;
        confidenceHi = mean + confidenceConstant;
    }

    public double mean() {
        return mean;
    }

    public double stddev() {
        return stddev;
    }

    public double confidenceLo() {
        return confidenceLo;
    }

    public double confidenceHi() {
        return confidenceHi;
    }

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        PercolationStats stats = new PercolationStats(N, Integer.parseInt(args[1]));
        System.out.println("mean\t\t= " + stats.mean());
        System.out.println("stddev\t\t= " + stats.stddev());
        System.out.println("95% confidence interval = " + stats.confidenceLo() + ", " + stats.confidenceHi());
    }
}
