package codefights;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static codefights.ListNodeUtils.list;
import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class AddTwoHugeNumbersTest {

    @SuppressWarnings("unused")
    static Object[][] parametersForTest() {
        return new Object[][]{
                {
                        list(9876, 5432, 1999),
                        list(1, 8001),
                        list(9876, 5434, 0),
                },
                {
                        list(123, 4, 5),
                        list(100, 100, 100),
                        list(223, 104, 105),
                },
                {
                        list(0),
                        list(0),
                        list(0),
                }
        };
    }

    @Test
    @Parameters
    public void test(ListNode<Integer> a, ListNode<Integer> b, ListNode<Integer> result) throws Exception {
        AddTwoHugeNumbers test = new AddTwoHugeNumbers();

        assertEquals(result, test.addTwoHugeNumbers(a, b));
    }
}