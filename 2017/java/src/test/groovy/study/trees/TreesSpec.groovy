package study.trees

import spock.lang.Specification
import spock.lang.Unroll

@Unroll
class TreesSpec extends Specification {

    Trees instance

    def setup() {
        instance = new Trees()
    }

    def "BFS"() {
        def bfs = instance.BFS(input)

        expect:
        assert bfs == output

        where:
        input       | output
        null        | [] as LinkedList<Integer>
        BFSinput1() | [1, 2, 3, 4, 5, 6, 7] as LinkedList<Integer>
        BFSinput2() | [0, 5, 1, 2, 1, 1, 2, 4, 7, 10] as LinkedList<Integer>
    }

    private static BinaryTreeNode BFSinput1() {
        BinaryTreeNode binaryTreeNode = new BinaryTreeNode(1)
        binaryTreeNode.left = new BinaryTreeNode(2)
        binaryTreeNode.right = new BinaryTreeNode(3)

        binaryTreeNode.left.left = new BinaryTreeNode(4)
        binaryTreeNode.left.right = new BinaryTreeNode(5)

        binaryTreeNode.right.left = new BinaryTreeNode(6)
        binaryTreeNode.right.right = new BinaryTreeNode(7)

        return binaryTreeNode
    }

    private static BinaryTreeNode BFSinput2() {
        BinaryTreeNode binaryTreeNode = new BinaryTreeNode(0)

        binaryTreeNode.left = new BinaryTreeNode(5)
        binaryTreeNode.left.left = new BinaryTreeNode(2)
        binaryTreeNode.left.right = new BinaryTreeNode(1)
        binaryTreeNode.left.right.left = new BinaryTreeNode(4)

        binaryTreeNode.right = new BinaryTreeNode(1)
        binaryTreeNode.right.left = new BinaryTreeNode(1)
        binaryTreeNode.right.right = new BinaryTreeNode(2)

        binaryTreeNode.right.left.right = new BinaryTreeNode(7)
        binaryTreeNode.right.left.right.right = new BinaryTreeNode(10)


        return binaryTreeNode
    }

}
