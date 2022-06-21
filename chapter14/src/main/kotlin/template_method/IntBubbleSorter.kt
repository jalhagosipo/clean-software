package template_method

class IntBubbleSorter: BubbleSorter() {
    private var array: IntArray? = null

    fun sort(theArray: IntArray): Int {
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