import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class DBTest {
    @BeforeEach
    fun setUp() {
        DB.init()
        DB.clear()
    }

    @Test
    fun testStoreProduct() {
        val storedProduct = ProductData("MyProduct", 1234, "999")
        DB.store(storedProduct)
        val retrievedProduct: ProductData? = DB.getProductData("999")
        assertEquals(storedProduct, retrievedProduct)
    }

    @Test
    fun testNoProduct() {
        val none: ProductData? = DB.getProductData("none")
        assertEquals(null, none)
    }

    @Test
    fun testStoreItem() {
        val storedItem = ItemData(1, 3, "sku")
        DB.store(storedItem)
        val retrievedItems: ArrayList<ItemData> = DB.getItemsForOrder(1)
        assertEquals(1, retrievedItems.size)
        assertEquals(storedItem, retrievedItems[0])
    }

    @Test
    fun testNoItems() {
        val id: ArrayList<ItemData> = DB.getItemsForOrder(42)
        assertEquals(0, id.size)
    }

    @Test
    fun testOrderKeyGeneration() {
        val o1: OrderData = DB.newOrder("Bob")
        val o2: OrderData = DB.newOrder("Bill")
        val firstOrderId: Int = o1.orderId
        val secondOrderId: Int = o2.orderId
        assertEquals(firstOrderId + 1, secondOrderId)
    }

    @Test
    fun testNoOrder() {
        val none: OrderData? = DB.getOrderData(0)
        assertEquals(null, none)
    }
}