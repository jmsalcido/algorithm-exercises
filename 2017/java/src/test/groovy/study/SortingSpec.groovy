package study

import spock.lang.Specification
import spock.lang.Unroll

@Unroll
class SortingSpec extends Specification {

    Sorting instance

    def setup() {
        instance = new Sorting()
    }

    def "selectionSort"() {
        def values = input as int[]
        instance.selectionSort(values)

        expect:
        assert values == output as int[]

        where:
        input                       | output
        [33, 44, 22, 22, 23, 21, 1] | [1, 21, 22, 22, 23, 33, 44]
        null                        | null
        [1]                         | [1]
        [1, 2, 3, 4]                | [1, 2, 3, 4]
        [4, 3, 2, 1]                | [1, 2, 3, 4]
        [1, 1, 1, 1, 1]             | [1, 1, 1, 1, 1]
    }


}
