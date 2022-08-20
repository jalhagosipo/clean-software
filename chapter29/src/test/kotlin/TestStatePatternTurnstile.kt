import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import state.Turnstile
import state.TurnstileController

class TestStatePatternTurnstile {
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
        assert(t.isLocked)
    }

    @Test
    fun testCoinInLockedState() {
        t.setLocked()
        t.coin()
        assert(t.isUnlocked)
        assert(unlockCalled)
    }

    @Test
    fun testCoinInUnlockedState() {
        t.setUnlocked()
        t.coin()
        assert(t.isUnlocked)
        assert(thankyouCalled)
    }

    @Test
    fun testPassInLockedState() {
        t.setLocked()
        t.pass()
        assert(t.isLocked)
        assert(alarmCalled)
    }

    @Test
    fun testPassInUnlockedState() {
        t.setUnlocked()
        t.pass()
        assert(t.isLocked)
        assert(lockCalled)
    }
}