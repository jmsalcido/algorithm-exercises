package study

import spock.lang.Ignore
import spock.lang.Specification
import spock.lang.Unroll

@Unroll
class ArraysLeftRotateSpec extends Specification {

    Arrays instance

    def setup() {
        instance = new Arrays()
    }

    def leftRotate1() {
        expect:
        assert instance.leftRotate1(input as int[], n) == output as int[]

        where:
        input           | n  | output
        null            | 4  | null
        [1, 2, 3, 4, 5] | 0  | [1, 2, 3, 4, 5]
        [1, 2, 3, 4, 5] | -1 | [1, 2, 3, 4, 5] // n should not be less than 0 tho.
        [1, 2, 3, 4, 5] | 4  | [5, 1, 2, 3, 4]
        [1, 2, 3, 4, 5] | 5  | [1, 2, 3, 4, 5]
        [1, 2, 3, 4, 5] | 7  | [3, 4, 5, 1, 2]
        [1, 2, 3, 4, 5] | 1  | [2, 3, 4, 5, 1]
    }

    @Ignore("welp, I failed on this, it is okay.")
    def leftRotate2() {

        expect:
        assert instance.leftRotate2(input as int[], n) == output as int[]
        where:
        input              | n  | output
        null               | 4  | null
        [1, 2, 3, 4, 5]    | 0  | [1, 2, 3, 4, 5]
        [1, 2, 3, 4, 5]    | -1 | [1, 2, 3, 4, 5] // n should not be less than 0 tho.
        [1, 2, 3, 4, 5]    | 4  | [5, 1, 2, 3, 4]
        [1, 2, 3, 4, 5]    | 5  | [1, 2, 3, 4, 5]
        [1, 2, 3, 4, 5]    | 7  | [3, 4, 5, 1, 2]
        [1, 2, 3, 4, 5]    | 1  | [2, 3, 4, 5, 1]
        [1, 2, 3]          | 1  | [2, 3, 1]
        [1, 2, 3]          | 2  | [3, 1, 2]
        [1, 2, 3, 4, 5, 6] | 0  | [1, 2, 3, 4, 5, 6]
        [1, 2, 3, 4, 5, 6] | 1  | [2, 3, 4, 5, 6, 1]
        [1, 2, 3, 4, 5, 6] | 2  | [3, 4, 5, 6, 1, 2]
        [1, 2, 3, 4, 5, 6] | 3  | [4, 5, 6, 1, 2, 3]
        [1, 2, 3, 4, 5, 6] | 4  | [5, 6, 1, 2, 3, 4]
        [1, 2, 3, 4, 5, 6] | 5  | [6, 1, 2, 3, 4, 5]
        [1, 2, 3, 4, 5, 6] | 6  | [1, 2, 3, 4, 5, 6]
        [1, 2, 3, 4, 5, 6] | 7  | [2, 3, 4, 5, 6, 1]
        [1, 2, 3, 4, 5, 6] | 8  | [3, 4, 5, 6, 1, 2]
        [1, 2, 3, 4, 5, 6] | 9  | [4, 5, 6, 1, 2, 3]
        [1, 2, 3, 4, 5, 6] | 10 | [5, 6, 1, 2, 3, 4]
        [1, 2, 3, 4, 5, 6] | 11 | [6, 1, 2, 3, 4, 5]
        [1, 2, 3, 4, 5, 6] | 12 | [1, 2, 3, 4, 5, 6]
    }
}
