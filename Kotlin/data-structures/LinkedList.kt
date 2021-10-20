/**
 * Linked List Implemented in kotlin
 * @author Akshat Sahijpal
 */

/**
 * Basic Entity of a Linked List is a node
 * @param data: T
 * @param nextNode: Node
 */
data class Node<T>(
    var data: T,
    var nextNode: Node<T>? = null
)

/**
 * Main Linked List Class That takes a starting node as a parameter
 */
class LinkedList<T>(startData: T) {
    private var headNode: Node<T>? = Node<T>(startData, null)
    private var _size: Int = 0

    /**
     * Function adds elements at the front of the linked list
     */
    fun addAtFront(inputData: T) {
        var x = Node<T>(inputData, headNode)
        headNode = x
        _size++
    }
    /**
     * Function adds element at a specified position in the linked list
     */
    fun addAtPosition(inputData: T, position: Int) {
        var x = headNode
        var y:Node<T>? = Node<T>(inputData, null)
        var i = 0
        while (i != position-1){
            i++
            x = x!!.nextNode
        }
        y!!.nextNode = x!!.nextNode
        x!!.nextNode = y
    }

    /**
     * Returns the size of the LL
     */
    fun size() = _size

    /**
     * Displays the linked list elements
     */
    fun watch() {
        var y = headNode
        while (y != null) {
            print("${y.data}\t")
            y = y.nextNode
        }
    }

    /**
     * Finds the max value in LinkedList
     */
    fun max():T {
        var x = headNode
        var max = x.data
        while (x != null){
            if(max < x.data){
                max = x.data
            }
            x = x.nextNode
        }
        return max
    }
}

/**
 * @usage
 */
fun main() {
    var x: LinkedList<Int> = LinkedList(100)
    x.addAtFront(20)
    x.addAtFront(30)

    x.addAtFront(40)
    x.addAtFront(60)
    x.addAtPosition(69, 2)
    x.watch()
}