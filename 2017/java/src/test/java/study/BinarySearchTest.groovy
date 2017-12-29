package study

import spock.lang.Specification

class BinarySearchTest extends Specification {

    def "test"() {
        def instance = BinarySearch.newInstance()
        expect:
        assert instance.recursive(list as int[], key) == result
        assert instance.iterative(list as int[], key) == result

        where:
        list                               | key    | result
        [2, 3, 4]                          | 2      | 0
        [2, 3, 4]                          | 3      | 1
        [2, 3, 4]                          | 4      | 2
        [1, 2, 3, 4, 5, 9, 10, 11, 123123] | 123123 | 8
    }

}
