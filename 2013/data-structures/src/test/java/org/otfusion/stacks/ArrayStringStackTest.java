package org.otfusion.stacks;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class ArrayStringStackTest {
    @Test
    public void testStack() throws Exception {
        ArrayStringStack stack = new ArrayStringStack(10);
        stack.push("Hello");
        stack.push("how");
        stack.push("are");
        stack.push("you");
        stack.push("?");
        assertEquals(5, stack.size());
        assertEquals("?", stack.pop());
        assertEquals("you", stack.pop());
        assertEquals("are", stack.pop());
        assertEquals("how", stack.pop());
        assertEquals("Hello", stack.pop());
        stack.push("BOOM!");
        assertEquals(1, stack.size());
        assertEquals("BOOM!", stack.pop());
        assertEquals(0, stack.size());
    }

    @Test
    public void testArraySize() throws Exception {
        ResizingArrayStringStack stack = new ResizingArrayStringStack();
        try {
            assertEquals(null, stack.pop());
            fail("Bang, there are no data in an array!");
        } catch(ArrayIndexOutOfBoundsException e) {
            assertTrue(true);
        }
    }

    @Test
    public void testStackWithStackOverflow() throws Exception {
        try {
            // Size = 10, only 10 spaces for the array
            ArrayStringStack stack = new ArrayStringStack(10);
            stack.push("Hello");
            stack.push("how");
            stack.push("are");
            stack.push("you");
            stack.push("?");
            stack.push("?");
            stack.push("?");
            stack.push("?");
            stack.push("?");
            stack.push("?");
            stack.push("?");
            assertEquals(11, stack.size());
            assertEquals("?", stack.pop());
            assertEquals("?", stack.pop());
            assertEquals("?", stack.pop());
            assertEquals("?", stack.pop());
            assertEquals("?", stack.pop());
            assertEquals("?", stack.pop());
            assertEquals("?", stack.pop());
            assertEquals("you", stack.pop());
            assertEquals("are", stack.pop());
            assertEquals("how", stack.pop());
            assertEquals("Hello", stack.pop());
            fail("No excpetion thrown");
        } catch (ArrayIndexOutOfBoundsException e) {
            assertTrue(true);
        }
    }
}
