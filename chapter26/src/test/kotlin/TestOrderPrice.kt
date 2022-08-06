import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TestOrderPrice {

    @Test
    fun testOrderPrice() {
        val o = OrderImp("Bob")
        val toothpaste: Product = ProductImp("sku1", "Toothpaste", 129)
        o.addItem(toothpaste, 1)
        assertEquals(129, o.total())
        val mouthwash: Product = ProductImp("sku2", "Mouthwash", 342)
        o.addItem(mouthwash, 2)
        assertEquals(813, o.total())
    }
}