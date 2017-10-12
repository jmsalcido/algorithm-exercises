package org.otfusion.sorting;

import java.util.List;

/**
 * Insertion Sort is a sorting algorithm O(n) that sorts elements like a hand of cards.
 */
public class InsertionSort implements Sort {

    public void sort(List<Integer> listToSort) {
        insertionSort(listToSort, false);
    }

    private void insertionSort(List<Integer> listToSort, boolean revert) {
        for(int j = 1; j < listToSort.size(); j++) {
            Integer key = listToSort.get(j);
            Integer i = j - 1;
            while(i >= 0 && compare(listToSort.get(i), key, revert)) {
                listToSort.set(i+1, listToSort.get(i));
                i = i -1;
            }
            listToSort.set(i + 1, key);
        }
    }

    private boolean compare(Integer key, Integer element, boolean revert) {
        if(revert) {
            return element > key;
        } else {
            return element < key;
        }
    }

    @Override
    public void sortDecreased(List<Integer> listToSort) {
        insertionSort(listToSort, true);
    }
}
