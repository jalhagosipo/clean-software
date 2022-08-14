import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import visit.ErnieModem
import visit.HayesModem
import visit.UnixModemConfigurator
import visit.ZoomModem

class TestModemVisitor {
    private lateinit var v: UnixModemConfigurator
    private lateinit var h: HayesModem
    private lateinit var z: ZoomModem
    private lateinit var e: ErnieModem

    @BeforeEach
    fun setUp() {
        v = UnixModemConfigurator()
        h = HayesModem()
        z = ZoomModem()
        e = ErnieModem()
    }

    @Test
    fun testHayesForUnix() {
        h.accept(v)
        assertEquals("&s1=4&D=3", h.configurationString)
    }

    @Test
    fun testZoomForUnix() {
        z.accept(v)
        assertEquals(42, z.configurationValue)
    }

    @Test
    fun testErnieForUnix() {
        e.accept(v)
        assertEquals("C is too slow", e.internalPattern)
    }
}