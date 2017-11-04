import java.util.Objects;

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

    static class ListNode<T> {
        ListNode(T x) {
            value = x;
        }

        T value;
        ListNode<T> next;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ListNode<?> listNode = (ListNode<?>) o;
            return Objects.equals(value, listNode.value) &&
                    Objects.equals(next, listNode.next);
        }

        @Override
        public int hashCode() {
            return Objects.hash(value, next);
        }

        @Override
        public String toString() {
            ListNode<T> actual = this;
            StringBuilder string = new StringBuilder("[");
            do {
                string.append(" ").append(actual.value).append(",");
                actual = actual.next;
            } while (actual.next != null);
            return string.append(" ").append(actual.value).append("]").toString();
        }
    }

}
