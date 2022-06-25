package template_method

class BubbleSorter_old {
    companion object {
        private var operations = 0
        fun sort(array: IntArray): Int {
            operations = 0
            if (array.size <= 1) {
                return operations
            }

            for (nextToLast in array.size - 2 downTo 0 step (1)) {
                for (index in 0.. nextToLast) {
                    compareAndSwap(array, index)
                }
            }
            return operations
        }

        private fun compareAndSwap(array: IntArray, index: Int) {
            if(array[index] > array[index + 1])
                swap(array, index)

            operations++
        }

        private fun swap(array: IntArray, index: Int) {
            val temp = array[index]
            array[index] = array[index + 1]
            array[index + 1] = temp
        }
    }
}