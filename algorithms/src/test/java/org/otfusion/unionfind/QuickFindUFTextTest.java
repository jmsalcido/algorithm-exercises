package org.otfusion.unionfind;

import org.apache.commons.io.IOUtils;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;

import static org.junit.Assert.assertEquals;

public class QuickFindUFTextTest {

    private QuickFindUFText _quickFind;

    @Before
    public void setUp() {
        _quickFind = new QuickFindUFText();
    }

    @Test
    public void testReadFile() throws Exception{
        InputStream inputStream = getClass().getResourceAsStream("tinyUF.txt");
        _quickFind.parseDescription(IOUtils.readLines(inputStream));
        assertEquals("4 3\n" +
                "3 8\n" +
                "6 5\n" +
                "9 4\n" +
                "2 1\n" +
                "5 0\n" +
                "7 2\n" +
                "6 1", _quickFind.toString());
    }

}
