package classification

import Paycheck


class SalariedClassification(
        val salary: Double
) : PaymentClassification {
    override fun calculatePay(pc: Paycheck): Double {
        return salary
    }
}
