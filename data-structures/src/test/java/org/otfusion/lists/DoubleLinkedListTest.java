package org.otfusion.lists;

import org.junit.Before;

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

    public void testAdd() {
        List<Integer> list = new DoubleLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(3, list.size());
    }
}
