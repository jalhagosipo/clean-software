package decorator

open class ModemDecorator(
        private val itsModem: Modem
) : Modem {
    override fun dial(pno: String) {
        itsModem.dial(pno)
    }

    override fun setSpeakerVolume(volume: Int) {
        itsModem.setSpeakerVolume(volume)
    }

    override fun getPhoneNumber(): String? {
        return itsModem.getPhoneNumber()
    }

    override fun getSpeakerVolume(): Int {
        return itsModem.getSpeakerVolume()
    }

    protected fun getModem(): Modem {
        return itsModem
    }
}