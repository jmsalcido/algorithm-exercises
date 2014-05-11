package org.otfusion.lists.linkedlist;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedListTest {

    private LinkedList<String> linkedList;

    @Before
    public void setUp() {
        linkedList = new LinkedList<String>();
        linkedList.add("A");
        linkedList.add("B");
        linkedList.add("C");
    }

    @Test
    public void testNewLinkedList() {
        linkedList = new LinkedList<String>();
        assertNotNull(linkedList);
        assertEquals(0, linkedList.size());
    }

    @Test
    public void testAdd() {
        linkedList = new LinkedList<String>();
        linkedList.add("A");
        assertEquals(1, linkedList.size());

        linkedList.add("B");
        assertEquals(2, linkedList.size());

        linkedList.add("C");
        assertEquals(3, linkedList.size());

        linkedList.add("D");
        assertEquals(4, linkedList.size());
    }

    @Test
    public void testAddDuplicates() {
        linkedList = new LinkedList<String>();
        linkedList.add("A");
        linkedList.add("A");
        linkedList.add("A");
        linkedList.add("A");
        assertEquals(4, linkedList.size());
    }

    @Test
    public void testAddNull() {
        linkedList = new LinkedList<String>();
        linkedList.add(null);
        assertEquals(0, linkedList.size());
    }

    @Test
    public void testGet() {
        assertEquals("A", linkedList.get("A"));
        assertEquals("B", linkedList.get("B"));
        assertEquals("C", linkedList.get("C"));
        assertEquals(null, linkedList.get("D"));
        assertEquals(null, linkedList.get(null));
    }

    @Test
    public void testRemove() {
        assertEquals(3, linkedList.size());
        linkedList.remove("B");
        assertEquals(null, linkedList.get("B"));
        assertEquals(2, linkedList.size());
    }

    @Test
    public void testRemoveRoot() {
        linkedList.remove("A");
        assertEquals(null, linkedList.get("A"));
        assertEquals(2, linkedList.size());
    }

    @Test
    public void testRemoveAll() {
        linkedList.remove("A");
        linkedList.remove("B");
        linkedList.remove("C");
        assertEquals(null, linkedList.get("A"));
        assertEquals(null, linkedList.get("B"));
        assertEquals(null, linkedList.get("C"));
        assertEquals(0, linkedList.size());
    }
}
