import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class ObserverTest {

    private lateinit var source: MockTimeSource
    private lateinit var sink: MockTimeSink

    @BeforeEach
    fun setUp() {
        source = MockTimeSource()
        sink = MockTimeSink(source)
        source.registerObserver(sink)
    }


    private fun assertSinkEquals(sink: MockTimeSink, hours: Int, minutes: Int, seconds: Int) {
        assertEquals(hours, sink.getHours())
        assertEquals(minutes, sink.getMinutes())
        assertEquals(seconds, sink.getSeconds())
    }

    @Test
    fun testTimeChange() {
        source.setTime(3, 4, 5)
        assertSinkEquals(sink, 3, 4, 5)

        source.setTime(7, 8, 9)
        assertSinkEquals(sink, 7, 8, 9)
    }

    @Test
    fun testMultipleSinks() {
        val sink2 = MockTimeSink(source)
        source.registerObserver(sink2)

        source.setTime(12, 13, 14)
        assertSinkEquals(sink, 12, 13, 14)
        assertSinkEquals(sink2, 12, 13, 14)
    }
}