import kotlin.properties.Delegates

class MockTimeSink(
        private val itsSource: TimeSource
): Observer {
    private var itsHours by Delegates.notNull<Int>()
    private var itsMinutes by Delegates.notNull<Int>()
    private var itsSeconds by Delegates.notNull<Int>()

    fun getHours(): Int {
        return itsHours
    }

    fun getMinutes(): Int {
        return itsMinutes
    }

    fun getSeconds(): Int {
        return itsSeconds
    }

    override fun update() {
        itsHours = itsSource.getHours()
        itsMinutes = itsSource.getMinutes()
        itsSeconds = itsSource.getSeconds()
    }
}


