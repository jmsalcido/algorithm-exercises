package org.otfusion.lists;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DoubleLinkedListTest {

    List<Integer> doubleLinkedList;

    @Before
    public void setUp() {
        doubleLinkedList = new DoubleLinkedList<>();
        doubleLinkedList.add(1);
        doubleLinkedList.add(2);
        doubleLinkedList.add(3);
    }

    @Test
    public void testAdd() {
        List<Integer> list = new DoubleLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(3, list.size());
    }

    @Test
    public void testAddIndex() {
        doubleLinkedList = new DoubleLinkedList<>();
        doubleLinkedList.add(4);
        doubleLinkedList.add(5);
        doubleLinkedList.add(6);
        assertEquals(4, doubleLinkedList.get(0));
        assertEquals(5, doubleLinkedList.get(1));
        assertEquals(6, doubleLinkedList.get(2));

        doubleLinkedList.add(1,0);
        doubleLinkedList.add(2,1);
        doubleLinkedList.add(3,2);
        assertEquals(1, doubleLinkedList.get(0));
        assertEquals(2, doubleLinkedList.get(1));
        assertEquals(3, doubleLinkedList.get(2));
        assertEquals(4, doubleLinkedList.get(3));
        assertEquals(5, doubleLinkedList.get(4));
        assertEquals(6, doubleLinkedList.get(5));

        doubleLinkedList.add(null,0);
        assertEquals(null, doubleLinkedList.get(0));

        try {
            doubleLinkedList.add(5, -1);
        } catch(Exception e) {
            assertTrue(e.getMessage().contains("less"));
        }

        try {
            doubleLinkedList.add(5, 100);
        } catch(Exception e) {
            assertTrue(e.getMessage().contains("larger"));
        }
    }

    @Test
    public void testRemoveRoot() {
        Integer n = doubleLinkedList.get(0);
        doubleLinkedList.delete(0);
        assertEquals(2, doubleLinkedList.size());
        assertFalse(n == doubleLinkedList.get(0));
        assertEquals(2, doubleLinkedList.get(0));
        assertEquals(3, doubleLinkedList.get(1));
    }

    @Test
    public void testRemoveLast() {
        Integer n = doubleLinkedList.get(doubleLinkedList.size()-1);
        doubleLinkedList.delete(doubleLinkedList.size()-1);
        assertEquals(2, doubleLinkedList.size());
        assertFalse(n == doubleLinkedList.get(doubleLinkedList.size()-1));
        assertEquals(1, doubleLinkedList.get(0));
        assertEquals(2, doubleLinkedList.get(1));
    }

    @Test
    public void testRemoveAll() {
        doubleLinkedList.delete(2);
        doubleLinkedList.delete(1);
        doubleLinkedList.delete(0);
        assertEquals(0, doubleLinkedList.size());
    }
}
