package template_method

abstract class BubbleSorter {
    private var operations = 0
    protected var length = 0


    protected fun doSort(): Int {
        operations = 0
        if (length <= 1) {
            return operations
        }

        for (nextToLast: Int in length - 2 downTo 0 step (1)) {
            for (index: Int in 0.. nextToLast) {
                if(outOfOrder(index))
                    swap(index)
                operations++
            }
        }
        return operations
    }

    protected abstract fun swap(index: Int)
    protected abstract fun outOfOrder(index: Int): Boolean
}