package codefights;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import static codefights.ListNodeUtils.list;


@RunWith(JUnitParamsRunner.class)
public class RemoveKFromListTest {

    @SuppressWarnings("unused") // params
    static Object[][] parametersForTest() {
        return new Object[][]{
                {list(1, 2, 4, 5), list(3, 1, 2, 3, 4, 5), 3},
                {list(1, 2, 3, 4, 5, 6, 7), list(1, 2, 3, 4, 5, 6, 7), 10},
                {list(), list(), 1000},
                {list(), list(), -1000},
                {list(123, 456, 789), list(123, 456, 789, 0), 0},
//                I will not include the last 5 but those pass with this.
        };
    }


    @Test
    @Parameters
    public void test(ListNode<Integer> result, ListNode<Integer> l, int k) throws Exception {
        RemoveKFromList removeKFromList = new RemoveKFromList();

        Assert.assertEquals(result, removeKFromList.removeKFromList(l, k));
    }
}