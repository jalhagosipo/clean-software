package schedule

import DateUtils
import java.util.*


class BiWeeklySchedule : PaymentSchedule {
    override fun isPayDate(payDate: Date): Boolean {
        return false
    }

    override fun getPayPeriodStartDate(payPeriodEndDate: Date?): Date {
        val result = DateUtils.toCalendar(payPeriodEndDate)
        result.add(Calendar.DATE, -13)
        return result.time
    }
}
