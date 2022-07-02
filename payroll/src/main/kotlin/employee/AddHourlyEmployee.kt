package employee

import employee.trasaction.AddEmployeeTransaction
import schedule.PaymentSchedule
import classification.HourlyClassification
import classification.PaymentClassification
import schedule.WeaklySchedule

class AddHourlyEmployee(
        empId: Int,
        name: String,
        address: String,
        private val hourlyWage: Double
) : AddEmployeeTransaction(empId, name, address) {

    override val schedule: PaymentSchedule
        get() = WeaklySchedule()
    override val classification: PaymentClassification
        get() = HourlyClassification(hourlyWage)
}