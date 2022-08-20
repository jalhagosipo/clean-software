package state

internal interface TurnstileState {
    fun coin(t: Turnstile)
    fun pass(t: Turnstile)
}

class LockedTurnstileState : TurnstileState {
    override fun coin(t: Turnstile) {
        t.setUnlocked()
        t.unlock()
    }

    override fun pass(t: Turnstile) {
        t.alarm()
    }
}

class UnlockedTurnstileState : TurnstileState {
    override fun coin(t: Turnstile) {
        t.thankyou()
    }

    override fun pass(t: Turnstile) {
        t.setLocked()
        t.lock()
    }
}