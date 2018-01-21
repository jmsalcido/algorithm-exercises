package study;

public class Strings {

    // stupid interview questions... - . -
    public boolean isStringMoved(String input, String otherString) {
        return (otherString + otherString).contains(input);
    }

}
