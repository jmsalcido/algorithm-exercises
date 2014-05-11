package org.otfusion.lists;

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
        assertEquals("A", linkedList.get(0));
        assertEquals("B", linkedList.get(1));
        assertEquals("C", linkedList.get(2));
        try {
            linkedList.get(-1);
            fail("should not get here.");
        } catch(Exception e) {
            assertTrue(e.getMessage().contains("less than 0"));
        }

        try {
            linkedList.get(5);
        } catch(Exception e) {
            assertTrue(e.getMessage().contains("larger than"));
        }
    }

    @Test
    public void testRemove() {
        assertEquals(3, linkedList.size());
        linkedList.delete(1);
        assertEquals("C", linkedList.get(1));
        assertEquals(2, linkedList.size());
        linkedList.delete(1);
        assertEquals(null, linkedList.get(1));
    }

    @Test
    public void testRemoveIndex() {
        assertEquals(3, linkedList.size());
        String b = linkedList.get(1);
        linkedList.delete(1);
        assertEquals(2, linkedList.size());
        assertFalse(b.equals(linkedList.get(1)));
    }

    @Test
    public void testRemoveRoot() {
        String a = linkedList.get(0);
        linkedList.delete(0);
        assertEquals(2, linkedList.size());
        assertFalse(a.equals(linkedList.get(0)));
    }

    @Test
    public void testRemoveAll() {
        linkedList.delete(2);
        linkedList.delete(1);
        linkedList.delete(0);
        assertEquals(0, linkedList.size());
    }
}
