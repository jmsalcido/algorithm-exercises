package study.sorting

import spock.lang.Specification
import spock.lang.Unroll

@Unroll
class MergeSortSpec extends Specification {

    MergeSort instance

    def setup() {
        instance = new MergeSort()
    }

    def "mySort"() {
        def values = input as int[]
        instance.mySort(values)

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
