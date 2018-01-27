package study

import spock.lang.Specification
import spock.lang.Unroll

@Unroll
class ArraysSpec extends Specification {

    Arrays instance

    def setup() {
        instance = Arrays.newInstance()
    }

    def "segregateArray"() {
        expect:
        assert instance.segregateArrayCounting(array as int[]) == output as int[]
        assert instance.segregateArraySameLoop(array as int[]) == output as int[]

        where:
        array              | output
        [0, 0, 0, 1, 1, 1] | [0, 0, 0, 1, 1, 1]
        [0, 0, 0, 1, 1, 0] | [0, 0, 0, 0, 1, 1]
        [0, 0, 0, 0, 0, 0] | [0, 0, 0, 0, 0, 0]
    }

    def "equilibriumIndex"() {
        expect:
        assert instance.equilibriumIndex(arr as int[]) == output

        where:
        arr                       | output
        [-7, 1, 5, 2, -4, 3, 0]   | 3
        [-7, 1, 5, 2, -4, 1, 0]   | 4
        [-7, 1, 5, 2, -4, 231, 0] | -1
    }

}
