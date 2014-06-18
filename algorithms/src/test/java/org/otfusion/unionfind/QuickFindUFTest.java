package org.otfusion.unionfind;

import org.junit.Test;

import static org.junit.Assert.*;

public class QuickFindUFTest {

    @Test
    public void testCount() {
        UnionFind quickFind = new QuickFindUF(10);
        assertEquals(10, quickFind.count());

        quickFind.union(1,9);
        assertEquals(9, quickFind.count());

        quickFind.union(1,8);
        assertEquals(8, quickFind.count());

        quickFind.union(8,1);
        assertEquals(8, quickFind.count());


    }

    @Test
    public void testFind() {
        UnionFind quickFind = new QuickFindUF(10);
        assertEquals(0, quickFind.find(0));
        assertEquals(1, quickFind.find(1));
        assertEquals(2, quickFind.find(2));
        assertEquals(3, quickFind.find(3));
        assertEquals(4, quickFind.find(4));
        assertEquals(5, quickFind.find(5));
        assertEquals(6, quickFind.find(6));
        assertEquals(7, quickFind.find(7));
        assertEquals(8, quickFind.find(8));
        assertEquals(9, quickFind.find(9));
    }

    @Test
    public void testUnion() {
        UnionFind quickFind = new QuickFindUF(10);
        quickFind.union(1,9);
        assertEquals(9, quickFind.find(1));
        assertEquals(9, quickFind.find(9));

        quickFind.union(1,2);
        assertEquals(2, quickFind.find(1));
        assertEquals(2, quickFind.find(9));

        quickFind.union(2,7);
        assertEquals(7, quickFind.find(2));
        assertEquals(7, quickFind.find(1));
        assertEquals(7, quickFind.find(9));

        quickFind.union(7,1); // should not change anything,.
        assertEquals(7, quickFind.find(2));
        assertEquals(7, quickFind.find(1));
        assertEquals(7, quickFind.find(9));
    }

    @Test
    public void testConnected() {
        UnionFind quickFind = new QuickFindUF(10);
        quickFind.union(1,9);
        quickFind.union(1,2);
        quickFind.union(3,5);
        quickFind.union(7,4);
        assertTrue(quickFind.connected(1,9));
        assertTrue(quickFind.connected(1,2));
        assertTrue(quickFind.connected(3,5));
        assertTrue(quickFind.connected(7,4));
        assertFalse(quickFind.connected(6,4));
        assertFalse(quickFind.connected(5,6));
        assertFalse(quickFind.connected(8,1));
        assertFalse(quickFind.connected(3,2));
    }

}
