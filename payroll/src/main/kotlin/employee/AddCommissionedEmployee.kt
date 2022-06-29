package employee

import transaction.AddEmployeeTransaction
import schedule.PaymentSchedule
import classification.CommissionedClassification
import classification.PaymentClassification
import schedule.BiWeaklySchedule

class AddCommissionedEmployee(
        empId: Int,
        name: String,
        address: String,
        private val salary: Int,
        private val commissionRate: Double
) : AddEmployeeTransaction(empId, name, address) {

    override val classification: PaymentClassification
        get() = CommissionedClassification(salary + 0.0, commissionRate)
    override val schedule: PaymentSchedule
        get() = BiWeaklySchedule()
}