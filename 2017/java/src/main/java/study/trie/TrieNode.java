package study.trie;

public class TrieNode {

    static final int NUM_OF_CHARS = 26;

    TrieNode[] children = new TrieNode[NUM_OF_CHARS];

    boolean isEndOfTrie = false;

    char c;

    TrieNode() {
    }

    TrieNode(char c) {
        this.c = c;
    }
}
