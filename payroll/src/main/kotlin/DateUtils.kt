import java.text.SimpleDateFormat
import java.util.*

class DateUtils private constructor() {
    init {
        throw UnsupportedOperationException()
    }

    companion object {
        fun between(target: Date, start: Date?, end: Date?): Boolean {
            return !(target.before(start) || target.after(end))
        }

        fun toCalendar(date: Date?): Calendar {
            val result = Calendar.getInstance()
            result.time = date
            return result
        }
    }
}