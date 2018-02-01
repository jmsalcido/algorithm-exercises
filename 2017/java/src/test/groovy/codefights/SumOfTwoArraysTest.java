package codefights;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class SumOfTwoArraysTest {

    @SuppressWarnings("unused")
    static Object[][] parametersForTest() {
        return new Object[][]{
                {
                        new int[]{1, 2, 3},
                        new int[]{10, 20, 30, 40},
                        42,
                        true
                },
                {
                        new int[]{1, 2, 3},
                        new int[]{10, 20, 30, 40},
                        50,
                        false
                },
                {
                        new int[]{},
                        new int[]{1, 2, 3, 4},
                        4,
                        false
                },
                {
                        new int[]{17, 72, 18, 72, 73, 15, 83, 90, 8, 18},
                        new int[]{100, 27, 33, 51, 2, 71, 76, 19, 16, 43},
                        37,
                        true
                }
        };
    }

    @Test
    @Parameters
    public void test(int[] a, int[] b, int result, boolean output) throws Exception {
        assertEquals(output, new SumOfTwoArrays().sumOfTwo(a, b, result));
    }
}