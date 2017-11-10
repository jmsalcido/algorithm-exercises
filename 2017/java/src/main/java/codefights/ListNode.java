package codefights;

import java.util.Objects;

public class ListNode<T> {
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
            string.append(" ").append(actual.value);
            actual = actual.next;
            if (actual != null) {
                string.append(",");
            }
        } while (actual != null);

        string.append(" ]");
        return string.toString();
    }
}