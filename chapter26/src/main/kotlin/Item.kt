class Item(
        private val itsProduct: Product,
        private val itsQuantity: Int
) {
    fun getProduct(): Product {
        return itsProduct
    }

    fun getQuantity(): Int {
        return itsQuantity
    }
}