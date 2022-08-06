interface Order {
    val customerId: String?
    fun addItem(p: Product?, quantity: Int)
    fun total(): Int
}