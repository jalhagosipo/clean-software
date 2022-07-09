package classification.transaction

import classification.CommissionedClassification
import classification.PaymentClassification
import schedule.BiWeeklySchedule
import schedule.PaymentSchedule


class ChangeCommissionedTransaction(
        empId: Int?,
        private val salary: Double,
        private val commissionRate: Double
) : ChangeClassificationTransaction(empId) {

    override val classification: PaymentClassification
        get() = CommissionedClassification(salary, commissionRate)
    override val schedule: PaymentSchedule
        get() = BiWeeklySchedule()
}