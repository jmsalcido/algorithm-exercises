package study;

public class Sorting {

    public void selectionSort(int[] arr) {

        if (arr == null) {
            return;
        }

        for(int i = 0; i < arr.length; i++) {

            int min = i;
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j] <= arr[min]) {
                    min = j;
                }
            }

            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
    }

    public void selectionSortDesc(int[] arr) {

        if (arr == null) {
            return;
        }

        for(int i = 0; i < arr.length; i++) {

            int min = i;
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j] >= arr[min]) {
                    min = j;
                }
            }

            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
    }

}
