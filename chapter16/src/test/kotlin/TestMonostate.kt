import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TestMonostate {
    @Test
    fun testInstance() {
        val m = Monostate()
        for (x: Int in 0..9) {
            m.setX(x)
            assertEquals(x, m.getX())
        }
    }

    @Test
    fun testInstaceBehaveAsOne() {
        val m1 = Monostate()
        val m2 = Monostate()
        for (x: Int in 0..9) {
            m1.setX(x)
            assertEquals(x, m2.getX())
        }
    }
}