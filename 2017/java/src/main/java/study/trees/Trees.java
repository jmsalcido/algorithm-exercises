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

    public List<Integer> DFSPreorder(BinaryTreeNode root) {
        List<Integer> data = new LinkedList<>();
        preorder(root, data);

        return data;
    }

    public List<Integer> DFSInorder(BinaryTreeNode root) {
        List<Integer> data = new LinkedList<>();
        inorder(root, data);

        return data;
    }

    public List<Integer> DFSPostorder(BinaryTreeNode root) {
        List<Integer> data = new LinkedList<>();
        postorder(root, data);

        return data;
    }

    private void preorder(BinaryTreeNode node, List<Integer> data) {
        if (node != null) {
            data.add(node.data);

            preorder(node.left, data);

            preorder(node.right, data);
        }
    }

    private void inorder(BinaryTreeNode node, List<Integer> data) {
        if (node != null) {
            inorder(node.left, data);

            data.add(node.data);

            inorder(node.right, data);
        }
    }

    private void postorder(BinaryTreeNode node, List<Integer> data) {
        if (node != null) {
            postorder(node.left, data);
            postorder(node.right, data);

            data.add(node.data);
        }
    }

}
