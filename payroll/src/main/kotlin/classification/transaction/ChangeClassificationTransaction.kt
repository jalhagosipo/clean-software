package classification.transaction

import classification.PaymentClassification
import employee.Employee
import schedule.PaymentSchedule

import employee.trasaction.ChangeEmployeeTransaction


abstract class ChangeClassificationTransaction(
        empId: Int
) : ChangeEmployeeTransaction(empId) {

    override fun change(e: Employee?) {
        e!!.pc = classification
        e.ps = schedule
    }

    abstract val schedule: PaymentSchedule
    abstract val classification: PaymentClassification
}