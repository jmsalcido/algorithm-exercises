package study.sorting;

@SuppressWarnings("ManualArrayCopy")
public class MergeSort {

    // my own
    public void mySort(int arr[]) {
        if (arr != null) {
            mySort(arr, 0, arr.length - 1);
        }
    }

    private void mySort(int arr[], int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            mySort(arr, left, mid);
            mySort(arr, mid + 1, right);

            myMerge(arr, left, mid, right);
        }
    }

    private void myMerge(int[] arr, int left, int mid, int right) {
        int s1 = mid - left + 1;
        int s2 = right - mid;

        // create sub arrays
        int[] L = new int[s1];
        int[] R = new int[s2];

        // fill sub arrays
        for (int i = 0; i < s1; i++) {
            L[i] = arr[left + i];
        }

        for (int i = 0; i < s2; i++) {
            R[i] = arr[mid + 1 + i];
        }

        // initial values for each comparison
        int i = 0;
        int j = 0;

        // point to swap with actual array
        int k = left;

        while (i < s1 && j < s2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }

            // move in the array after swapping.
            k++;
        }

        // put the remaining items from L into arr actual space
        while (i < s1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < s2) {
            arr[k] = R[j];
            j++;
            k++;
        }

    }

}
