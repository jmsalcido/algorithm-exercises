package study.trie

import spock.lang.Specification

class TrieSpec extends Specification {

    Trie instance

    def setup() {
        instance = new Trie()
    }

    def "test"() {
        instance.insert("foo")
        instance.insert("bar")


        expect:
        assert instance.search("foo")
        assert instance.search("bar")
        assert !instance.search("barnot")
    }

    def "findWords"() {
        instance.insert("foo")
        instance.insert("foobar")
        instance.insert("foolool")
        instance.insert("fooloolz")

        def words = instance.allWords("foo")

        expect:
        assert words[0] == "foo"
        assert words[1] == "foobar"
        assert words[2] == "foolool"
        assert words[3] == "fooloolz"
    }

}
