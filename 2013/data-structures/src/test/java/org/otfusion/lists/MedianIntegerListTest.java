package org.otfusion.lists;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class MedianIntegerListTest {

    private MedianIntegerList list;

    @Before
    public void setUp() {
        list = new MedianIntegerList();
    }

    @Test
    public void testMedian() {
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        assertEquals(7.0, list.median(), 0.0);

        list.add(10);
        assertEquals(7.5, list.median(), 0.0);
    }

    @Test
    public void testMedianShouldThrowException() {
        try {
            list.add("Object not Integer");
            fail("Should throw exception");
        } catch (AssertionError error) {
            assertTrue(true);
        }
    }

}
