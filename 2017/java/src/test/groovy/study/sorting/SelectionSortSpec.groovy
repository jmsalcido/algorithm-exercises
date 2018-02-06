package study.sorting

import spock.lang.Specification
import spock.lang.Unroll
import study.sorting.SelectionSort

@Unroll
class SelectionSortSpec extends Specification {

    SelectionSort instance

    def setup() {
        instance = new SelectionSort()
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

    def "selectionSortDesc"() {
        def values = input as int[]
        instance.selectionSortDesc(values)

        expect:
        assert values == output as int[]

        where:
        input                       | output
        [33, 44, 22, 22, 23, 21, 1] | [44, 33, 23, 22, 22, 21, 1]
        null                        | null
        [1]                         | [1]
        [1, 2, 3, 4]                | [4, 3, 2, 1]
        [4, 3, 2, 1]                | [4, 3, 2, 1]
        [1, 1, 1, 1, 1]             | [1, 1, 1, 1, 1]
    }


}
