package template_method

class DoubleBubbleSorter: BubbleSorter() {
    private var array: DoubleArray? = null

    fun sort(theArray: DoubleArray): Int {
        array = theArray
        length = array!!.size
        return doSort()
    }

    override fun swap(index: Int) {
        val temp = array!![index]
        array!![index] = array!![index + 1]
        array!![index + 1] = temp
    }

    override fun outOfOrder(index: Int): Boolean {
        return (array!![index] > array!![index + 1])
    }
}