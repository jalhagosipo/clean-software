package state

class Turnstile(private val turnstileController: TurnstileController) {
    private var state: TurnstileState = lockedState

    fun coin() {
        state.coin(this)
    }

    fun pass() {
        state.pass(this)
    }

    fun setLocked() {
        state = lockedState
    }

    fun setUnlocked() {
        state = unlockedState
    }

    val isLocked: Boolean
        get() = state === lockedState
    val isUnlocked: Boolean
        get() = state === unlockedState

    fun thankyou() {
        turnstileController.thankyou()
    }

    fun alarm() {
        turnstileController.alarm()
    }

    fun lock() {
        turnstileController.lock()
    }

    fun unlock() {
        turnstileController.unlock()
    }

    companion object {
        private val lockedState: TurnstileState = LockedTurnstileState()
        private val unlockedState: TurnstileState = UnlockedTurnstileState()
    }
}