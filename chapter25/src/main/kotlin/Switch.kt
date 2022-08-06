class Switch(
        private val switchable: Switchable
) {
    fun turnOn() {
        println("Switch Turn On")
        switchable.turnOn()
    }

    fun turnOff() {
        println("Switch Turn Off")
        switchable.turnOn()
    }
}