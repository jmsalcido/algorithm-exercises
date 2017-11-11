package codefights;

import java.util.HashSet;
import java.util.Set;

public class SumOfTwoArrays {

    // Given 2 unordered arrays and a result, find if there is a pair that gives the result.

    boolean sumOfTwo(int[] a, int[] b, int v) {
        Set<Integer> hashes = new HashSet<>();

        for (int x : a) {
            hashes.add(x);
        }

        for (int x : b) {
            if(hashes.contains(v-x)){
                return true;
            }
        }

        return false;
    }
}
