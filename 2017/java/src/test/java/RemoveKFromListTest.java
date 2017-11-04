import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;


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


    private static RemoveKFromList.ListNode<Integer> list(int... numbers) {
        RemoveKFromList.ListNode<Integer> list = null;
        RemoveKFromList.ListNode<Integer> last = null;
        for (int n : numbers) {
            if (last != null) {
                last.next = new RemoveKFromList.ListNode<>(n);
                last = last.next;
            } else {
                last = new RemoveKFromList.ListNode<>(n);
            }

            if (list == null) {
                list = last;
            }
        }

        return list;
    }


    @Test
    @Parameters
    public void test(RemoveKFromList.ListNode<Integer> result, RemoveKFromList.ListNode<Integer> l, int k) throws Exception {
        RemoveKFromList removeKFromList = new RemoveKFromList();

        Assert.assertEquals(result, removeKFromList.removeKFromList(l, k));
    }
}