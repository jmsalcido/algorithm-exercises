package org.otfusion.stacks;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class LinkedStackTest {
    @Test
    public void testStack() throws Exception {
        LinkedStack<String> stringLinkedStack = new LinkedStack<>();
        stringLinkedStack.push("hi");
        stringLinkedStack.push("how");
        stringLinkedStack.push("are");
        stringLinkedStack.push("you");
        stringLinkedStack.push("today");
        stringLinkedStack.push("?");
        assertEquals(6, stringLinkedStack.size());
        assertEquals("?", stringLinkedStack.pop());
        assertEquals("today", stringLinkedStack.pop());
        assertEquals("you", stringLinkedStack.pop());
        assertEquals("are", stringLinkedStack.pop());
        assertEquals("how", stringLinkedStack.pop());
        assertEquals("hi", stringLinkedStack.pop());
        assertEquals(0, stringLinkedStack.size());
        stringLinkedStack.push("BOOM!");
        assertEquals(1, stringLinkedStack.size());
        assertEquals("BOOM!", stringLinkedStack.pop());
        assertEquals(0, stringLinkedStack.size());
    }

    @Test
    public void testListSize() throws Exception {
        LinkedStack<String> stack = new LinkedStack<>();
        try {
            assertEquals(null, stack.pop());
            fail("Bang, there should not be data in the magic list!");
        } catch(NullPointerException e) {
            assertTrue(true);
        }
    }

}
