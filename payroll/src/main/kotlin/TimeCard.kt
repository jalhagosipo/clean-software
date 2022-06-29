import java.util.Date

class TimeCard(
        private val itsDate: Date,
        private val itsHours: Double
) {
    fun getDate(): Date {
        return itsDate
    }

    fun getHours(): Double {
        return itsHours
    }
}
