package strategy

class QuickBubbleSorter(
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

        var thisPassInOrder = false
        (length - 2 downTo 0).takeWhile {
            !thisPassInOrder
        }.forEach {
            thisPassInOrder = true
            for (index: Int in 0.. it) {
                if (itsSortHandle.outOfOrder(index)) {
                    itsSortHandle.swap(index)
                    thisPassInOrder = false
                }
                operations++
            }
        }
        return operations
    }
}