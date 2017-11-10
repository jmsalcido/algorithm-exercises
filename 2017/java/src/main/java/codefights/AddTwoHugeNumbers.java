package codefights;

import java.math.BigInteger;
import java.util.Stack;

public class AddTwoHugeNumbers {

    ListNode<Integer> addTwoHugeNumbers(ListNode<Integer> a, ListNode<Integer> b) {
        BigInteger sum = getBigInteger(a).add(getBigInteger(b));
        String number = sum.toString();

        return toNodeList(number);
    }

    private ListNode<Integer> toNodeList(String number) {
        Stack<ListNode<Integer>> stack = new Stack<>();
        for (int i = number.length(); i > 0; i-=4) {
            int tmp = i - 4;
            if (tmp < 0) {
                tmp = 0;
            }

            Integer num = Integer.valueOf(number.substring(tmp, i));

            ListNode<Integer> node =
                    new ListNode<>(num);
            stack.push(node);
        }

        ListNode<Integer> actual = null;
        ListNode<Integer> head = null;

        while(!stack.isEmpty()) {
            if (head != null) {
                actual.next = stack.pop();
                actual = actual.next;
            } else {
                actual = stack.pop();
                head = actual;
            }
        }
        return head;
    }

    private BigInteger getBigInteger(ListNode<Integer> head) {
        if (head == null) {
            return BigInteger.ZERO;
        }

        ListNode<Integer> next = head;

        StringBuilder str = new StringBuilder();

        while(next != null) {
            str.append(number(next));
            next = next.next;
        }

        return new BigInteger(str.toString());
    }

    private String number(ListNode<Integer> node) {
        Integer value = node.value;

        StringBuilder sb = new StringBuilder();
        if(value < 10 && sb.length() == 0) {
            sb.append("0").append("0").append("0");
        }

        if(value < 100 && sb.length() == 0) {
            sb.append("0").append("0");
        }

        if(value < 1000 && sb.length() == 0) {
            sb.append("0");
        }

        return sb.append(value).toString();
    }
}
