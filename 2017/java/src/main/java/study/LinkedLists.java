package study;

import study.model.RandomSingleNode;

public class LinkedLists {

    RandomSingleNode cloneLinkedListWithRandomNode(RandomSingleNode rootNode) {

        if (rootNode == null) {
            return null;
        }

        RandomSingleNode node = rootNode;
        RandomSingleNode temp;


        // put a reference in the next space.
        while (node != null) {
            temp = node.next;

            node.next = new RandomSingleNode(node.data);
            node.next.next = temp;

            node = temp;
        }

        node = rootNode;

        while (node != null) {

            // copy the random.next to the next.random
            // explanation:
            //
            // 1,2,3 (initial)
            // 1,1c,2,2c,3,3c (copy)
            // 1->3, 2->1, 3->2 (random pointers)
            // 1c.random = null (new node)
            // 1c.random -> 1.random.next -> 1->3.next = 3c (the random copy reference)
            //
            // something liek this:
            // [[1 -> 3], [1c -> 3c], [2 -> 1], [2c -> null], [3 -> 2], [3c -> null]]

            node.next.random = node.random.next;
            node = node.next.next;
        }

        node = rootNode;
        RandomSingleNode cloned = node.next;

        temp = cloned;

        while (node != null && temp != null) {
            if (node.next != null) {
                node.next = node.next.next;
            }

            if (temp.next != null) {
                temp.next = temp.next.next;
            }

            node = node.next;
            temp = temp.next;
        }

        return cloned;

    }

}
