package org.otfusion.stacks;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class ResizingArrayStringStackTest {
    @Test
    public void testStack() throws Exception {
        ResizingArrayStringStack stack = new ResizingArrayStringStack();
        stack.push("Hi");
        stack.push("Hello");
        stack.push("Hola");
        stack.push("Konichiwa");
        stack.push("Begroeting");
        stack.push("Bonjour");
        stack.push("Salve est!");
        stack.push("A");
        stack.push("B");
        stack.push("C");
        stack.push("D");
        stack.push("E");
        stack.push("F");
        stack.push("G");
        stack.push("H");
        stack.push("I");
        stack.push("J");
        stack.push("K");
        stack.push("L");
        stack.push("M");
        stack.push("N");
        stack.push("O");
        stack.push("P");
        stack.push("Q");
        stack.push("R");
        stack.push("S");
        stack.push("T");
        stack.push("U");
        stack.push("V");
        stack.push("W");
        stack.push("X");
        stack.push("Y");
        stack.push("Z");
        assertEquals(33, stack.size());
        assertEquals("Z", stack.pop());
        assertEquals("Y", stack.pop());
        assertEquals("X", stack.pop());
        assertEquals("W", stack.pop());
        assertEquals("V", stack.pop());
        assertEquals("U", stack.pop());
        assertEquals("T", stack.pop());
        assertEquals("S", stack.pop());
        assertEquals("R", stack.pop());
        assertEquals("Q", stack.pop());
        assertEquals("P", stack.pop());
        assertEquals("O", stack.pop());
        assertEquals("N", stack.pop());
        assertEquals("M", stack.pop());
        assertEquals("L", stack.pop());
        assertEquals("K", stack.pop());
        assertEquals("J", stack.pop());
        assertEquals("I", stack.pop());
        assertEquals("H", stack.pop());
        assertEquals("G", stack.pop());
        assertEquals("F", stack.pop());
        assertEquals("E", stack.pop());
        assertEquals("D", stack.pop());
        assertEquals("C", stack.pop());
        assertEquals("B", stack.pop());
        assertEquals("A", stack.pop());
        assertEquals("Salve est!", stack.pop());
        assertEquals("Bonjour", stack.pop());
        assertEquals("Begroeting", stack.pop());
        assertEquals("Konichiwa", stack.pop());
        assertEquals("Hola", stack.pop());
        assertEquals("Hello", stack.pop());
        assertEquals("Hi", stack.pop());
        stack.push("Hi");
        assertEquals(1, stack.size());
        assertEquals("Hi", stack.pop());
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


}
