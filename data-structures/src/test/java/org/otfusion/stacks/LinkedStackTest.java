package org.otfusion.stacks;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

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
        assertEquals("?",stringLinkedStack.pop());
        assertEquals("today",stringLinkedStack.pop());
        assertEquals("you",stringLinkedStack.pop());
        assertEquals("are",stringLinkedStack.pop());
        assertEquals("how",stringLinkedStack.pop());
        assertEquals("hi",stringLinkedStack.pop());
    }
}
