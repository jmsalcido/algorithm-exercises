package org.otfusion.sorting;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class InsertionSortTest {

    @Test
    public void testSort() throws Exception {
        List<Integer> sorted = new ArrayList<>();
        sorted.add(1);
        sorted.add(2);
        sorted.add(3);
        sorted.add(4);
        sorted.add(5);
        sorted.add(6);

        List<Integer> unsorted = new ArrayList<>();
        unsorted.add(5);
        unsorted.add(2);
        unsorted.add(4);
        unsorted.add(3);
        unsorted.add(1);
        unsorted.add(6);

        Sort sorter = new InsertionSort();
        sorter.sort(unsorted);
        for(int i = 0; i < sorted.size(); i++) {
            assertEquals(sorted.get(i), unsorted.get(i));
        }

    }

    @Test
    public void testSortDecreased() throws Exception {
        List<Integer> sorted = new ArrayList<>();
        sorted.add(6);
        sorted.add(5);
        sorted.add(4);
        sorted.add(3);
        sorted.add(2);
        sorted.add(1);

        List<Integer> unsorted = new ArrayList<>();
        unsorted.add(5);
        unsorted.add(2);
        unsorted.add(4);
        unsorted.add(3);
        unsorted.add(1);
        unsorted.add(6);

        Sort sorter = new InsertionSort();
        sorter.sortDecreased(unsorted);
        for(int i = 0; i < sorted.size(); i++) {
            assertEquals(sorted.get(i), unsorted.get(i));
        }

    }

}
