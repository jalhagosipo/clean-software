data class ItemData(
    var orderId: Int,
    var qty: Int,
    var sku: String = "junk"
) {
    override fun equals(o: Any?): Boolean {
        val itemData = o as ItemData?
        return orderId == itemData!!.orderId && qty == itemData.qty && sku == itemData.sku
    }
}