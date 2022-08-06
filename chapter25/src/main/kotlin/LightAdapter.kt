class LightAdapter(
        private val thirdPartLight: ThirdPartLight
) : Switchable {
    override fun turnOn() {
        thirdPartLight.turnOn()
    }

    override fun turnOff() {
        thirdPartLight.turnOff()
    }
}