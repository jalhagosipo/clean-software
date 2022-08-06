
import DB.store
import java.sql.SQLException


class OrderProxy(
    val orderId: Int
) : Order {

    override val customerId: String?
        get() = try {
            val orderData = DB.getOrderData(orderId)
            orderData!!.customerId
        } catch (e: SQLException) {
            throw Error(e.toString())
        }

    override fun total(): Int {
        return try {
            val imp = OrderImp(customerId)
            val itemDataArray: ArrayList<ItemData> = DB.getItemsForOrder(orderId)
            for (i in itemDataArray.indices) {
                val item: ItemData = itemDataArray[i]
                imp.addItem(ProductProxy(item.sku), item.qty)
            }
            imp.total()
        } catch (e: Exception) {
            throw Error(e.toString())
        }
    }

    override fun addItem(p: Product?, quantity: Int) {
        try {
            val id = ItemData(orderId, quantity, p!!.sku!!)
            store(id)
        } catch (e: Exception) {
            // 인터페이스를 throws 문으로 안하려고 Error로 감쌈
            throw Error(e.toString())
        }
    }
}