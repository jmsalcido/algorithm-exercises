package codefights;

public class ListNodeUtils {

    public static ListNode<Integer> list(int... numbers) {
        ListNode<Integer> list = null;
        ListNode<Integer> last = null;
        for (int n : numbers) {
            if (last != null) {
                last.next = new ListNode<>(n);
                last = last.next;
            } else {
                last = new ListNode<>(n);
            }

            if (list == null) {
                list = last;
            }
        }

        return list;
    }

}
