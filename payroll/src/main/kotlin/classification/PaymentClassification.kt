package classification

import DateUtils
import Paycheck
import java.util.*

interface PaymentClassification {
    fun calculatePay(pc: Paycheck): Double
    fun isInPayPeriod(payDate: Date, pc: Paycheck): Boolean {
        return DateUtils.between(payDate, pc.getPayPeriodStartDate(), pc.getPayPeriodEndDate())
    }
}