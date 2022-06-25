import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertSame
import org.junit.jupiter.api.Test

class TestSimpleSingleton {
    @Test
    fun testCreateSingleton() {
        val s = Singleton
        val s2 = Singleton
        assertSame(s, s2)
    }

    @Test
    fun testNoPublicConstructors() {
        val singleton = Class.forName("Singleton")
        val constructors = singleton.constructors
        assertEquals(0, constructors.size)
    }
}