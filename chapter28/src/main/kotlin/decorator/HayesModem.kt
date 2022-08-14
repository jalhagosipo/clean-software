package decorator

class HayesModem: Modem {
    var itsPhoneNumber: String? = null
    var itsSpeakerVolume: Int = 0

    override fun dial(pno: String) {
        itsPhoneNumber = pno
    }

    override fun setSpeakerVolume(volume: Int) {
        itsSpeakerVolume = volume
    }

    override fun getPhoneNumber(): String? {
        return itsPhoneNumber
    }

    override fun getSpeakerVolume(): Int {
        return itsSpeakerVolume
    }
}