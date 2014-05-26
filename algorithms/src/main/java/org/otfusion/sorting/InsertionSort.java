package org.otfusion.sorting;

import java.util.List;

public class InsertionSort implements Sort {

    public void sort(List<Integer> listToSort) {
        for(int j = 1; j < listToSort.size(); j++) {
            Integer key = listToSort.get(j);
            Integer i = j - 1;
            while(i >= 0 && listToSort.get(i) > key) {
                listToSort.set(i+1, listToSort.get(i));
                i = i -1;
            }
            listToSort.set(i+1, key);
        }
    }

    @Override
    public void sortDecreased(List<Integer> listToSort) {
        for(int j = 1; j < listToSort.size(); j++) {
            Integer key = listToSort.get(j);
            Integer i = j - 1;
            while(i >= 0 && listToSort.get(i) < key) {
                listToSort.set(i+1, listToSort.get(i));
                i = i -1;
            }
            listToSort.set(i+1, key);
        }
    }
}
