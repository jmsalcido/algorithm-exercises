package study

import codefights.ListNode
import spock.lang.Specification
import spock.lang.Unroll

@Unroll
class LinkedListsIsLoopSpec extends Specification {

    LinkedLists instance

    def setup() {
        instance = new LinkedLists()
    }

    def "isLoopedList"() {
        expect:
        assert instance.isLoopedList(input) == output

        where:
        input            | output
        loopedList()     | true
        null             | false
        notLoopedList1() | false
        notLoopedList2() | false
        notLoopedList3() | false
        notLoopedList4() | false
        notLoopedList5() | false
    }

    private static def loopedList() {
        ListNode<Object> list = new ListNode<>(null)
        list.next = new ListNode<>(null)
        list.next.next = new ListNode<>(null)
        list.next.next.next = new ListNode<>(null)
        list.next.next.next.next = new ListNode<>(null)
        list.next.next.next.next.next = new ListNode<>(null)
        list.next.next.next.next.next.next = new ListNode<>(null)
        list.next.next.next.next.next.next.next = list.next.next.next.next
    }

    private static def notLoopedList1() {
        ListNode<Object> list = new ListNode<>(null)
        list.next = new ListNode<>(null)
        list.next.next = new ListNode<>(null)
        list.next.next.next = new ListNode<>(null)
        list.next.next.next.next = new ListNode<>(null)
        list.next.next.next.next.next = new ListNode<>(null)
        list.next.next.next.next.next.next = new ListNode<>(null)
        list.next.next.next.next.next.next.next = new ListNode<>(null)
    }

    private static def notLoopedList2() {
        new ListNode<>(null)
    }

    private static def notLoopedList3() {
        ListNode<Object> list = new ListNode<>(null)
        list.next = new ListNode<>(null)
    }

    private static def notLoopedList4() {
        ListNode<Object> list = new ListNode<>(null)
        list.next = new ListNode<>(null)
        list.next.next = new ListNode<>(null)
    }
    private static def notLoopedList5() {
        ListNode<Object> list = new ListNode<>(null)
        list.next = new ListNode<>(null)
        list.next.next = new ListNode<>(null)
        list.next.next.next = new ListNode<>(null)
    }

}
