package org.otfusion.strings;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AnagramFinderTest {
    private AnagramFinder anagramFinder;

    @Before
    public void setUp() {
        anagramFinder = new AnagramFinderImpl();
    }

    @Test
    public void testAreAnagrams() {
        assertFalse(anagramFinder.areAnagrams(null, "null"));
        assertTrue(anagramFinder.areAnagrams("XXXYYX", "YYXXXX"));
        assertTrue(anagramFinder.areAnagrams("jose", "oesj"));
        assertTrue(anagramFinder.areAnagrams("jose", "jose"));
        assertTrue(anagramFinder.areAnagrams("ZZYZX", "X Y ZZZ"));
        assertTrue(anagramFinder.areAnagrams("stamp store", "postmaster"));
        assertTrue(anagramFinder.areAnagrams("to see place", "a telescope"));
        assertTrue(anagramFinder.areAnagrams("4.a.r.3. a", "a.a.3.r.4"));
        assertTrue(anagramFinder.areAnagrams("aabbccc    ", "aabbccc"));
        assertTrue(anagramFinder.areAnagrams("a bbc", "a  bb c"));
        assertTrue(anagramFinder.areAnagrams("        a bbc", " a   b  b  c "));

        assertFalse(anagramFinder.areAnagrams("aabbccc", "aabbccd"));
        assertFalse(anagramFinder.areAnagrams("different", "words"));
        assertFalse(anagramFinder.areAnagrams("Mayus","mayus"));
    }
}
