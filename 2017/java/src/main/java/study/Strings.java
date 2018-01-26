package study;

public class Strings {

    public boolean isStringMoved(String input, String otherString) {
        // explanation:
        // if `input` is: "astring" and `otherString` is `stringa`, if you sum em up:
        // `stringastring`, it should contain the `input` string.

        // why?
        // cause you are repeating the SAME string twice.
        // same as `astringastring` should contain `stringa` somwhere in the word.

        // this method would work even if there are spaces.
        return (otherString + otherString).contains(input);
    }

    public String reverseString(String string) {
        char[] arr = string.toCharArray();

        // time complexity: o(n/2) -> only loop for the half of the array.
        // space: o(1) -> array is already on String so, I would not count it. Only a `tmp` var created and
        //  reused as reference.
        for (int i = 0; i < ((arr.length) / 2); i++) {
            char tmp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = tmp;
        }

        return new String(arr);
    }

}
