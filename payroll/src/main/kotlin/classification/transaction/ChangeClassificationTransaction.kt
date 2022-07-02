package classification.transaction

import classification.PaymentClassification
import employee.Employee
import schedule.PaymentSchedule

import transaction.ChangeEmployeeTransaction


abstract class ChangeClassificationTransaction(
        empId: Int?
)
    : ChangeEmployeeTransaction(empId!!) {

    override fun change(e: Employee?) {
        e!!.setClassification(classification)
        e.setSchedule(schedule)
    }

    abstract val schedule: PaymentSchedule
    abstract val classification: PaymentClassification
}