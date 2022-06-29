package classification

import Paycheck


class SalariedClassification(
        private val salary: Double
) : PaymentClassification {
    fun getSalary(): Double {
        return salary
    }
    override fun calculatePay(pc: Paycheck): Double {
        return salary
    }
}
