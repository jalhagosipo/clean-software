package classification.transaction

import classification.PaymentClassification
import classification.SalariedClassification
import schedule.MonthlySchedule
import schedule.PaymentSchedule


class ChangeSalariedTransaction(
        empId: Int,
        private val salary: Double
) : ChangeClassificationTransaction(empId) {

    override val classification: PaymentClassification
        get() = SalariedClassification(salary)
    override val schedule: PaymentSchedule
        get() = MonthlySchedule()
}