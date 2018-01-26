package study

import spock.lang.Specification
import spock.lang.Unroll

@Unroll
class StringsSpec extends Specification {

    def "isStringMoved() scenarios: #input is moved: #otherString"() {
        def instance = Strings.newInstance()

        expect:
        assert instance.isStringMoved(input, otherString)

        where:
        input    | otherString | output
        "string" | "trings"    | true
        "string" | "tringss"   | false
        "string" | "ringst"    | false
    }

    def "reverseString"() {
        def instance = Strings.newInstance()
        expect:
        assert instance.reverseString(string) == reversed

        where:
        string                   | reversed
        "cat"                    | "tac"
        "boom"                   | "moob"
        "boomabo"                | "obamoob"
        "asd asd asd asd asdasd" | "dsadsa dsa dsa dsa dsa"

    }

}
