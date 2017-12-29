package study;

public class BinarySearch {

    public int recursive(int[] ordered, int number) {
        return binarySearchRecursive(ordered, 0, ordered.length, number);
    }

    private int binarySearchRecursive(int[] list, int indexFrom, int indexTo, int key) {
        if (indexTo >= indexFrom) {
            int mid = (int) Math.floor((indexTo + indexFrom) / 2);

            int m = list[mid];

            if (m < key) {
                return binarySearchRecursive(list, mid + 1, indexTo, key);
            } else if (m > key) {
                return binarySearchRecursive(list, indexFrom, mid - 1, key);
            } else if (key == m) {
                return mid;
            }
        }

        return -1;
    }

    public int iterative(int[] ordered, int number) {
        return binarySearchIterative(ordered, number);
    }

    private int binarySearchIterative(int[] ordered, int key) {
        int left = 0;
        int right = ordered.length;
        while (right >= left) {
            int mid = (int) Math.floor((left + right) / 2);

            int m = ordered[mid];

            if (m < key) {
                left = mid + 1;
            } else if (m > key) {
                right = mid - 1;
            } else if (key == m) {
                return mid;
            }

        }

        return -1;
    }

}
