class OrderImp(
    override val customerId: String?
): Order {
    private val itsItems = ArrayList<Item>()

    override fun addItem(p: Product?, qty: Int) {
        val item = Item(p!!, qty)
        itsItems.add(item)
    }

    //    numbers.fold(10) { total, num -> total + num }
    override fun total(): Int {
        return itsItems.fold(0) { total, item ->
            val p = item.getProduct()
            val qty = item.getQuantity()
            total + p.price * qty
        }
    }
}