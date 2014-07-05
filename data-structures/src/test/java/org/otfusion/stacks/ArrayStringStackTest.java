package org.otfusion.stacks;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ArrayStringStackTest {
    @Test
    public void testStack() throws Exception {
        ArrayStringStack stack = new ArrayStringStack(10);
        stack.push("Hello");
        stack.push("how");
        stack.push("are");
        stack.push("you");
        stack.push("?");
        assertEquals(5,stack.size());
        assertEquals("?", stack.pop());
        assertEquals("you", stack.pop());
        assertEquals("are", stack.pop());
        assertEquals("how", stack.pop());
        assertEquals("Hello", stack.pop());
    }
}
