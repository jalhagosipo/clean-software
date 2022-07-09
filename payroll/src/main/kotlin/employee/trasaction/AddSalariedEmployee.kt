package employee.trasaction

import employee.trasaction.AddEmployeeTransaction
import schedule.PaymentSchedule
import classification.PaymentClassification
import classification.SalariedClassification
import schedule.MonthlySchedule

class AddSalariedEmployee(
        empId: Int,
        name: String,
        address: String,
        private val salary: Double
) : AddEmployeeTransaction(empId, name, address) {

    override val classification: PaymentClassification
        get() = SalariedClassification(salary)
    override val schedule: PaymentSchedule
        get() = MonthlySchedule()
}