//@get:Throws(SQLException::class) // TODO research @get ??
object DB {

    private var maxOrderId: Int = 0
    private val productDataDB = HashMap<String, ProductData>()
    private val orderDataDB = HashMap<Int, OrderData>()
    private val itemDataDB = HashMap<Int, ArrayList<ItemData>>()

    fun init() {
        println("=== init DB ===")
    }

    fun store(pd: ProductData) {
        productDataDB[pd.sku] = ProductData(pd.name, pd.price, pd.sku)
    }

    fun getProductData(sku: String): ProductData? {
        return productDataDB[sku]
    }

    fun store(id: ItemData) {
        if (itemDataDB.containsKey(id.orderId)) {
            val originalList: ArrayList<ItemData> = itemDataDB[id.orderId]!!
            originalList.add(ItemData(id.orderId, id.qty, id.sku))
            itemDataDB[id.orderId] = originalList
        } else {
            itemDataDB[id.orderId] = arrayListOf(ItemData(id.orderId, id.qty, id.sku))
        }
    }

    fun getItemsForOrder(orderId: Int): ArrayList<ItemData> {
        return if (itemDataDB.containsKey(orderId)) {
            itemDataDB[orderId]!!
        } else {
            arrayListOf()
        }
    }

    fun newOrder(customerId: String?): OrderData {
        maxOrderId += 1
        val newOrderData = OrderData(maxOrderId, customerId)
        orderDataDB[maxOrderId] = newOrderData

        return newOrderData
    }

    fun getOrderData(orderId: Int): OrderData? {
        return orderDataDB[orderId]
    }

    fun clear() {
        productDataDB.clear()
    }
}