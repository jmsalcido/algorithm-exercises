package study.trie;

import java.util.LinkedList;
import java.util.List;

public class Trie {

    private TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    void insert(String key) {

        TrieNode actual = root;

        for (int level = 0; level < key.length(); level++) {
            char c = key.charAt(level);
            int index = c - 'a';
            if (actual.children[index] == null) {
                actual.children[index] = new TrieNode(c);
            }

            actual = actual.children[index];
        }

        actual.isEndOfTrie = true;
    }

    boolean search(String key) {
        TrieNode actual = root;

        for (int level = 0; level < key.length(); level++) {
            int index = key.charAt(level) - 'a';
            if (actual.children[index] == null) {
                return false;
            }

            actual = actual.children[index];
        }

        return (actual != null && actual.isEndOfTrie);
    }

    List<String> allWords(String prefix) {
        List<String> allWords = new LinkedList<>();

        TrieNode prefixNode = findChild(prefix);

        if (prefixNode != null) {
            getSuggestions(prefixNode, allWords, prefix);
        }

        return allWords;
    }

    private void getSuggestions(TrieNode prefixNode, List<String> allWords, String prefix) {
        if (prefixNode.isEndOfTrie) {
            allWords.add(prefix);
        }

        for (int i = 0; i < TrieNode.NUM_OF_CHARS; i++) {
            TrieNode child = prefixNode.children[i];
            if (child != null) {
                getSuggestions(child, allWords, prefix + child.c);
            }
        }
    }

    TrieNode findChild(String prefix) {
        TrieNode actual = root;

        for (char s : prefix.toCharArray()) {
            int index = s - 'a';
            if (actual.children[index] == null) {
                return null;
            }

            actual = actual.children[index];
        }

        return actual;
    }

}
