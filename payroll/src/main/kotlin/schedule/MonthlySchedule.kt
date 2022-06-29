package schedule

import DateUtils
import java.util.*


class MonthlySchedule : PaymentSchedule {
    override fun isPayDate(payDate: Date): Boolean {
        return isLastDayOfMonth(payDate)
    }

    private fun isLastDayOfMonth(payDate: Date): Boolean {
        val payCalendar = Calendar.getInstance()
        payCalendar.time = payDate
        val month = payCalendar[Calendar.MONTH]
        payCalendar.add(Calendar.DATE, 1)
        val monthByAdded1Day = payCalendar[Calendar.MONTH]
        return month != monthByAdded1Day
    }

    override fun getPayPeriodStartDate(payPeriodEndDate: Date?): Date {
        val result = DateUtils.toCalendar(payPeriodEndDate)
        result[Calendar.DAY_OF_MONTH] = 1
        return result.time
    }
}