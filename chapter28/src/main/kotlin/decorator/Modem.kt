package decorator

interface Modem {
    fun dial(pno: String)
    fun setSpeakerVolume(volume: Int)
    fun getPhoneNumber(): String?
    fun getSpeakerVolume(): Int
}