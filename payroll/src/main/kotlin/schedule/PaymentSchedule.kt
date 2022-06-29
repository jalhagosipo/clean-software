package schedule

import java.util.*

interface PaymentSchedule {
    fun isPayDate(payDate: Date): Boolean
    fun getPayPeriodStartDate(payPeriodEndDate: Date?): Date
}