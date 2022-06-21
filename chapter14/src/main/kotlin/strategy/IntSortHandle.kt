package strategy

class IntSortHandle: SortHandle {
    private lateinit var array: IntArray

    override fun swap(index: Int) {
        val temp = array[index]
        array[index] = array[index + 1]
        array[index + 1] = temp
    }

    override fun outOfOrder(index: Int): Boolean {
        return (array[index] > array[index + 1])
    }

    override fun length(): Int {
        return array.size
    }

    override fun setArray(array: Any) {
        this.array = array as IntArray
    }


}