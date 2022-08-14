import decorator.HayesModem
import decorator.LoudDialModem
import decorator.Modem
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TestModemDecorator {
    @Test
    fun testCreateHayes() {
        val m: Modem = HayesModem()
        assertEquals(null, m.getPhoneNumber())
        m.dial("5551212")
        assertEquals("5551212", m.getPhoneNumber())
        assertEquals(0, m.getSpeakerVolume())
        m.setSpeakerVolume(10)
        assertEquals(10, m.getSpeakerVolume())
    }

    @Test
    fun testLoudDialModem() {
        val m: Modem = HayesModem()
        val d: Modem = LoudDialModem(m)
        assertEquals(null, d.getPhoneNumber())
        assertEquals(0, d.getSpeakerVolume())
        d.dial("5551212")
        assertEquals("5551212", d.getPhoneNumber())
        assertEquals(10, d.getSpeakerVolume())
    }
}