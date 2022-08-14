package decorator

class LoudDialModemForMultiDecorator(itsModem: Modem) : ModemDecorator(itsModem) {
    override fun dial(pno: String) {
        getModem().setSpeakerVolume(10)
        getModem().dial(pno)
    }
}