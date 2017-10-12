package org.otfusion.lists;

public class MedianIntegerList implements List{

    private List<Integer> list;
    private int sum;
    private double median;

    public MedianIntegerList() {
        list = new LinkedList<>();
        sum = 0;
        median = 0;
    }

    /**
     * O(1)
     * return the median pre-calculated from each insertion or if for any reason media is not set and the
     * cache sum is not 0: calculate it from the list.
     * @return the median
     */
    public double median() {
        if(sum != 0 && median == 0) {
            return calculateMedian();
        } else {
            return median;
        }
    }

    private double calculateMedian() {
        double sum = 0.0;
        for(int i = 0; i < size() ; i++) {
            sum += get(0);
        }
        return sum/size();
    }

    /**
     * O(1)
     * add an integer to our median list, with this approach because we are just adding the next element
     * to a precalculated sum (no sum each number always) and obtaining the size of the list (that is actually O(1))
     * @param element an integer
     * @param index an integer
     */
    private void addAndCalculateMedian(Object element, Integer index) {
        if(element instanceof Integer) {
            Integer integer = (Integer) element;
            sum += integer;
            if(index == null || index < 0) {
                list.add(integer);
            } else {
                list.add(integer, index);
            }
            median = sum/(double)size();
        } else {
            throw new AssertionError("Only integers in this list.");
        }
    }

    public void add(Object element) {
        addAndCalculateMedian(element, null);
    }

    public void add(Object element, int index) {
        // Not sure... I think we should throw AssertionError or NoSuchMethod
        addAndCalculateMedian(element, index);
    }

    public void delete(int index) {
        list.delete(index);
    }

    public Integer get(int index) {
        return list.get(index);
    }

    public int size() {
        return list.size();
    }
}
