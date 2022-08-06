import DB.clear
import DB.init
import DB.store
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class ProxyTest {

    @BeforeEach
    fun setUp() {
        init()
        clear()
        store(ProductData("ProxyTestName1", 456, "ProxyTest1"))
    }

    @Test
    fun testProductProxy() {
        val p: Product = ProductProxy("ProxyTest1")
        assertEquals(456, p.price)
        assertEquals("ProxyTestName1", p.name)
        assertEquals("ProxyTest1", p.sku)
    }

    @Test
    fun testOrderProxyCustomerId() {
        val od: OrderData = DB.newOrder("testOrderProxyCustomerId")
        val op: Order = OrderProxy(od.orderId)
        assertEquals(od.customerId, op.customerId)
    }

    @Test
    fun testOrderProxyTotal() {
        store(ProductData("Wheaties", 349, "wheaties"))
        store(ProductData("Crest", 258, "crest"))
        val wheaties = ProductProxy("wheaties")
        val crest = ProductProxy("crest")
        val od: OrderData = DB.newOrder("testOrderProxy")
        val order = OrderProxy(od.orderId)
        order.addItem(crest, 1)
        order.addItem(wheaties, 2)
        assertEquals(956, order.total())
    }
}