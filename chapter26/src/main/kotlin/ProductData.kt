class ProductData(
    val name: String,
    val price: Int,
    val sku: String
) {
    override fun equals(other: Any?): Boolean {
        val pd = other as ProductData
        return name == pd.name && sku == pd.sku && price == pd.price
    }

    override fun toString(): String {
        return "ProductData($sku,$name,$price)"
    }
}