package schedule

import DateUtils
import java.util.*


class WeaklySchedule : PaymentSchedule {
    override fun isPayDate(payDate: Date): Boolean {
        return isFriday(payDate)
    }

    private fun isFriday(payDate: Date): Boolean {
        val payCalendar = Calendar.getInstance()
        payCalendar.time = payDate
        val dayOfWeek = payCalendar[Calendar.DAY_OF_WEEK]
        return dayOfWeek == Calendar.FRIDAY
    }

    override fun getPayPeriodStartDate(payPeriodEndDate: Date?): Date {
        val result = DateUtils.toCalendar(payPeriodEndDate)
        result.add(Calendar.DATE, -6)
        return result.time
    }
}
