package strategy

class BubbleSorter(
    private val itsSortHandle: SortHandle
) {
    private var operations = 0
    private var length = 0


    fun sort(array: Any): Int {
        itsSortHandle.setArray(array)
        length = itsSortHandle.length()
        operations = 0
        if (length <= 1) {
            return operations
        }

        for (nextToLast: Int in length - 2 downTo 0 step (1)) {
            for (index: Int in 0.. nextToLast) {
                if(itsSortHandle.outOfOrder(index))
                    itsSortHandle.swap(index)
                operations++
            }
        }
        return operations
    }
}

fun main() {
    var arry = intArrayOf(1,3,2)
    println("before : ${arry.joinToString()}")
    BubbleSorter(IntSortHandle()).sort(arry)
    println("after : ${arry.joinToString()}")
}