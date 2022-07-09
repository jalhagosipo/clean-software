package employee

import employee.trasaction.AddEmployeeTransaction
import schedule.PaymentSchedule
import classification.HourlyClassification
import classification.PaymentClassification
import schedule.WeeklySchedule

class AddHourlyEmployee(
        empId: Int,
        name: String,
        address: String,
        private val hourlyRate: Double
) : AddEmployeeTransaction(empId, name, address) {

    override val schedule: PaymentSchedule
        get() = WeeklySchedule()
    override val classification: PaymentClassification
        get() = HourlyClassification(hourlyRate)
}