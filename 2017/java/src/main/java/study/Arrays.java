package study;

public class Arrays {

    // problem:
    // given: {0,0,1,0,1,0,1}
    // sort it to return an array with 0s as the first digits and 1 as the last parts.
    public int[] segregateArrayCounting(int[] array) {

        // this solution is O(n*2)
        // why?
        // we count first O(n) -> number of zeros.
        // then we create a new array size n
        // and go over each space and see if we already have the number of zeros added.
        // we could make it faster this way:
        // second for: i = zeros.

        int zeros = 0;
        for (int d : array) {
            if (d == 0) {
                zeros++;
            }
        }

        int[] newArray = new int[array.length];

        for (int i = zeros; i < array.length; i++) {
            newArray[i] = 1;
        }

        return newArray;
    }

    // this one is weird for me
    // 2 references
    // one to left
    // one to right
    // start left on 0
    // start right on last element
    // read while left is less than right
    // read all left and if it is 0 AND left is still less than right, increment left
    // read all right and if it is 1 AND left is still less than right, decrement right
    // if left is still less than right
    // put a 0 in left reference
    // put a 1 in right reference
    // increment left
    // decrement right

    // Aha!, got it:
    // {0, 1, 0, 1, 1, 0}
    // look at left side 0s first: if it is 0, move one, if it is not, keep the reference.
    // look at the right side, if it is 1, go back 1, if it is not, keep the reference.
    // if left reference index is less than right reference index
    // SWAP and move one on left and go back on right
    // continue while positions are not yet crossed.

    // damn...
    public int[] segregateArraySameLoop(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            while (arr[left] == 0 && left < right) {
                left++;
            }

            while (arr[right] == 1 && left < right) {
                right--;
            }

            if (left < right) {
                arr[left] = 0;
                arr[right] = 1;
                left++;
                right--;
            }
        }

        // 0 , 1, 0, 1
        // 0 (size-1)
        // left < right = true
        // increment left
        // 1
        // decrement right
        // 2
        // 0, 0, 1, 1

        return arr;
    }

    // From an array, Need to find an index in which sum of left elements & sum of right elements are same.
    // return -1 if not found.
    //  {-7, 1, 5, 2, -4, 3, 0}
    //  == -7 + 1 + 5 + 2 - 4 + 3 + 0 ?
    //  -7 == 1 + 5 + 2 - 4 + 3 + 0 ?
    //  -7 + 1 == 5 + 2 - 4 + 3 + 0 ?
    //  -7 + 1 + 5 == 2 - 4 + 3 + 0 ?
    //  -7 + 1 + 5 + 2 == -4 + 3 + 0 ?
    public int equilibriumIndex(int[] arr) {
        int leftSum = 0;

        int sum = 0;
        for (int i : arr) {
            sum += i;
        }

        for (int i = 0; i < arr.length - 1; i++) {
            sum -= arr[i];

            if (leftSum == sum) {
                return i;
            }

            leftSum += arr[i];
        }

        return -1;
    }

}
