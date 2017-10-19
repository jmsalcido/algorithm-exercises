import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(JUnitParamsRunner.class)
public class RotateSquareMatrixAntiClockwiseTest {

    @SuppressWarnings("unused")
    private Object[] parametersForTest() {
        return new Object[][]{
                {new int[][]{
                        {1, 2, 3},
                        {5, 6, 7},
                        {9, 10, 11}
                }, new int[][]{
                        {3, 7, 11},
                        {2, 6, 10},
                        {1, 5, 9}
                }},
                {new int[][]{
                        {1, 2, 3, 4},
                        {5, 6, 7, 8},
                        {9, 10, 11, 12},
                        {13, 14, 15, 16}
                }, new int[][]{
                        {4, 8, 12, 16},
                        {3, 7, 11, 15},
                        {2, 6, 10, 14},
                        {1, 5, 9, 13}
                }}
        };
    }

    @Test
    @Parameters
    public void test(int[][] foo, int[][] result) throws Exception {
        RotateSquareMatrixAntiClockwise test = new RotateSquareMatrixAntiClockwise();
        test.rotate90(foo);
        assertThat(foo, is(equalTo(result)));

        test.printMatrix(foo);
        System.out.println("");
    }

    @Test
    public void foo() throws Exception {
        int[][] foo = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int[] aux = foo[0];
        foo[0] = foo[2];
        foo[2] = aux;

        System.out.println(Arrays.toString(foo[0]));
    }
}