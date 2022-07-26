import kotlin.properties.Delegates

class MockTimeSource: TimeSource, Subject() {
    private var itsHours by Delegates.notNull<Int>()
    private var itsMinutes by Delegates.notNull<Int>()
    private var itsSeconds by Delegates.notNull<Int>()

    override fun getHours(): Int {
        return itsHours
    }

    override fun getMinutes(): Int {
        return itsMinutes
    }

    override fun getSeconds(): Int {
        return itsSeconds
    }

    fun setTime(hours: Int, minutes: Int, seconds: Int) {
        itsHours = hours
        itsMinutes = minutes
        itsSeconds = seconds
        notifyObservers()
    }
}

