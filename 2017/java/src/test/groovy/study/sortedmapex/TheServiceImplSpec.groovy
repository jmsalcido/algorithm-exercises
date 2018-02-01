package study.sortedmapex

import spock.lang.Specification

class TheServiceImplSpec extends Specification {

    def "view"() {
        given:
        TheService foo = new TheServiceImpl()

        when:
        foo.view("id")

        then:
        noExceptionThrown()
    }


    def "order"() {
        given:
        TheService foo = new TheServiceImpl()
        foo.view("id")
        foo.view("id2")
        foo.view("id2")

        when:
        def val = foo.order("id")

        then:
        assert val == 2
    }

    def "top10"() {
        given:
        TheService foo = new TheServiceImpl()
        foo.view("id")
        foo.view("id2")
        foo.view("id2")
        foo.view("id3")
        foo.view("id4")
        foo.view("id5")
        foo.view("id6")
        foo.view("id7")
        foo.view("id8")
        foo.view("id9")
        foo.view("id10")
        foo.view("id21")
        foo.view("id2")
        foo.view("id2")
        foo.view("id2")
        foo.view("id2")
        foo.view("id2")
        foo.view("id2")
        foo.view("id2")
        foo.view("id2")
        foo.view("id2")
        foo.view("id2")

        when:
        def val = foo.top10()

        then:
        assert val == ["id2", "id", "id3", "id4", "id5", "id6", "id7", "id8", "id9", "id10"]
    }


    def "integration"() {
        given:
        TheService foo = new TheServiceImpl()
        foo.view("id")
        foo.view("id2")
        foo.view("id2")
        foo.view("id3")
        foo.view("id4")
        foo.view("id5")
        foo.view("id6")
        foo.view("id7")
        foo.view("id8")
        foo.view("id9")
        foo.view("id10")
        foo.view("id21")
        foo.view("id2")
        foo.view("id2")
        foo.view("id2")
        foo.view("id2")
        foo.view("id2")
        foo.view("id2")
        foo.view("id2")
        foo.view("id2")
        foo.view("id2")
        foo.view("id2")

        when:
        def val = foo.top10()
        def id2 = foo.order("id2")
        def id10 = foo.order("id10")
        def id21 = foo.order("id21")

        then:
        assert val == ["id2", "id", "id3", "id4", "id5", "id6", "id7", "id8", "id9", "id10"]
        assert id2 == 1
        assert id10 == 10
        assert id21 == 11
    }
}
