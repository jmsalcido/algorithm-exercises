package org.otfusion.trees;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BinaryTreeTest {

    BinaryTree<Integer> tree;

    @Before
    public void setUp() {
        tree = new BinaryTree<>();
        tree.add(2);
        tree.add(1);
        tree.add(3);
    }

    @Test
    public void testAdd() {
        tree = new BinaryTree<>();
        tree.add(2);
        tree.add(1);
        tree.add(3);
        assertEquals(3, tree.getNodesCount());
    }

    @Test
    public void testSearch() {
        assertTrue(tree.search(1));
        assertTrue(tree.search(2));
        assertTrue(tree.search(3));
        assertFalse(tree.search(4));
    }
}
