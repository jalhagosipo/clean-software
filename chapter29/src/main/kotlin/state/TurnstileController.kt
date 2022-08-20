package state

interface TurnstileController {
    fun lock()
    fun unlock()
    fun thankyou()
    fun alarm()
}