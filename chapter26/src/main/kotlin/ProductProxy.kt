import DB.getProductData




class ProductProxy(
        override val sku: String
) : Product {

    override val price: Int
        get() {
            val pd = getProductData(sku)
            return pd!!.price
        }

    override val name: String
        get() {
            val pd = getProductData(sku)
            return pd!!.name
        }
}