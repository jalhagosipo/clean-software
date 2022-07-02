import java.util.*
import kotlin.collections.HashMap

class Paycheck(
        private val payPeriodStartDate: Date,
        private val payPeriodEndDate: Date
) {
    var grossPay: Double = 0.0
    var deductions: Double = 0.0
    var netPay: Double = 0.0
    private val fields: MutableMap<String, String> = HashMap()

    fun getField(key: String): String? {
        return fields[key]
    }

    fun setField(key: String, value: String) {
        fields[key] = value
    }

    fun getPayPeriodStartDate(): Date? {
        return payPeriodStartDate.clone() as Date
    }

    fun getPayPeriodEndDate(): Date? {
        return payPeriodEndDate.clone() as Date
    }

    fun details(grossPay: Double, deductions: Double) {
        this.grossPay = grossPay
        this.deductions = deductions
        netPay = grossPay - deductions
    }
}