class RotateSquareMatrixAntiClockwise {

    void rotate90(int arr[][]) {
        transpose(arr);
        reverse(arr);
    }

    private void transpose(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr[0].length; j++) {
                int temp = arr[j][i];
                arr[j][i] = arr[i][j];
                arr[i][j] = temp;
            }
        }
    }

    private void reverse(int[][] arr) {
        for(int i = 0; i < arr[0].length / 2; i++) { // I understand better this... ehhehehehehhe
            int[] aux = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = aux;
        }
    }

    void printMatrix(int arr[][]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }

            System.out.println("");

        }
    }

}
