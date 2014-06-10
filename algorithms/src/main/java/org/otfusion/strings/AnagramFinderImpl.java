package org.otfusion.strings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AnagramFinderImpl implements AnagramFinder {

    @Override
    public boolean areAnagrams(String s1, String s2) {
        if(s1.equals(s2)) {
            return true;
        }

        // replace all white space from the string
        s1 = s1.replaceAll("\\s+","");
        s2 = s2.replaceAll("\\s+","");

        // if lengths are not the same the strings are not anagrams.
        if(s1.length() != s2.length()) {
            return false;
        }

        int length = s1.length();

        List<Character> listString1 = stringToCharList(s1);
        List<Character> listString2 = stringToCharList(s2);
        Collections.sort(listString1);
        Collections.sort(listString2);

        for(int i = 0; i < length; i++) {
            if(listString1.get(i) != listString2.get(i)) {
                return false;
            }
        }

        return true;

    }

    private List<Character> stringToCharList(String str) {
        List<Character> list = new ArrayList();
        for(Character c : str.toCharArray()) {
            list.add(c);
        }
        return list;
    }
}
