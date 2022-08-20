import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class TestTurnstile {
    private lateinit var t: Turnstile
    private var lockCalled = false
    private var unlockCalled = false
    private var thankyouCalled = false
    private var alarmCalled = false

    @BeforeEach
    fun setUp() {
        val controllerSpoof: TurnstileController = object : TurnstileController {
            override fun lock() {
                lockCalled = true
            }

            override fun unlock() {
                unlockCalled = true
            }

            override fun thankyou() {
                thankyouCalled = true
            }

            override fun alarm() {
                alarmCalled = true
            }
        }
        t = Turnstile(controllerSpoof)
    }

    @Test
    fun testInitialConditions() {
        assertEquals(Turnstile.LOCKED, t.state)
    }

    @Test
    fun testCoinInLockedState() {
        t.state = Turnstile.LOCKED
        t.event(Turnstile.COIN)
        assertEquals(Turnstile.UNLOCKED, t.state)
        assert(unlockCalled)
    }

    @Test
    fun testCoinInUnlockedState() {
        t.state = Turnstile.UNLOCKED
        t.event(Turnstile.COIN)
        assertEquals(Turnstile.UNLOCKED, t.state)
        assert(thankyouCalled)
    }

    @Test
    fun testPassInLockedState() {
        t.state = Turnstile.LOCKED
        t.event(Turnstile.PASS)
        assertEquals(Turnstile.LOCKED, t.state)
        assert(alarmCalled)
    }

    @Test
    fun testPassInUnlockedState() {
        t.state = Turnstile.UNLOCKED
        t.event(Turnstile.PASS)
        assertEquals(Turnstile.LOCKED, t.state)
        assert(lockCalled)
    }
}