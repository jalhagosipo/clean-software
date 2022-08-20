package swtich_case

class Turnstile(private val turnstileController: TurnstileController) {
    var state = LOCKED

    fun event(event: Int) {
        when (state) {
            LOCKED -> when (event) {
                COIN -> {
                    state = UNLOCKED
                    turnstileController.unlock()
                }
                PASS -> turnstileController.alarm()
            }
            UNLOCKED -> when (event) {
                COIN -> turnstileController.thankyou()
                PASS -> {
                    state = LOCKED
                    turnstileController.lock()
                }
            }
        }
    }

    companion object {
        // States
        const val LOCKED = 0
        const val UNLOCKED = 1

        // Events
        const val COIN = 0
        const val PASS = 1
    }
}