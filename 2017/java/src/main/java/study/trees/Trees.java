package study.trees;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Trees {

    public List<Integer> BFS(BinaryTreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }

        Queue<BinaryTreeNode> queue = new LinkedList<>();
        List<Integer> data = new LinkedList<>(); // simply to return a value;

        queue.add(root);

        while (!queue.isEmpty()) {
            BinaryTreeNode temp = queue.poll();

            data.add(temp.data);

            if (temp.left != null) {
                queue.add(temp.left);
            }

            if (temp.right != null) {
                queue.add(temp.right);
            }

        }

        return data;
    }

}
