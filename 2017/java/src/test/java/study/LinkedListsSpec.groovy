package study

import spock.lang.Specification
import spock.lang.Unroll
import study.model.RandomSingleNode

@Unroll
class LinkedListsSpec extends Specification {

    def "cloneLinkedListWithRandomNode"() {
        def instance = new LinkedLists()

        def randomList = new RandomSingleNode(1)
        randomList.next = new RandomSingleNode(2)
        randomList.next.next = new RandomSingleNode(3)
        randomList.next.next.next = new RandomSingleNode(4)
        randomList.next.next.next.next = new RandomSingleNode(5)

        randomList.random = randomList.next.next.next.next
        randomList.next.random = randomList.next.next
        randomList.next.next.random = randomList.next.next
        randomList.next.next.next.random = randomList.next
        randomList.next.next.next.next.random = randomList

        def cloned = instance.cloneLinkedListWithRandomNode(randomList)
        def toStringList = "cloned: ${listToString(cloned)}, original: ${listToString(randomList)}"

        println(toStringList)

        expect:
        assert listToString(cloned) == listToString(randomList)
    }

    String listToString(RandomSingleNode rootNode) {
        RandomSingleNode node = rootNode
        StringBuilder sb = new StringBuilder("[")
        while (node != null) {
            sb.append("(").append(node.data).append(" -> ").append(node.random.data).append(")")

            if (node.next != null) {
                sb.append(", ")
            }

            node = node.next
        }
        sb.append("]")

        return sb.toString()
    }

}
