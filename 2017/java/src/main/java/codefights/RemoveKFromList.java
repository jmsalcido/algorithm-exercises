package codefights;

class RemoveKFromList {

    ListNode<Integer> removeKFromList(ListNode<Integer> l, int k) {
        if (l == null) {
            return null;
        }

        ListNode<Integer> root = l;
        ListNode<Integer> previous = null;

        while (l != null) {
            if (root.value == k) {
                root = root.next;
            }

            if (previous != null && l.value == k) {
                previous.next = l.next;
            } else {
                previous = l;
            }
            l = l.next;
        }

        return root;
    }

}
