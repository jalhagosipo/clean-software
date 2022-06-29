package transaction

import method.PaymentMethod
import schedule.PaymentSchedule
import PayrollDatabase
import classification.PaymentClassification
import employee.Employee
import method.HoldMethod

abstract class AddEmployeeTransaction internal constructor(
        private val empId: Int,
        private val name: String,
        private val address: String,

        ) : Transaction {

    override fun execute() {
        val pc: PaymentClassification = classification
        val ps: PaymentSchedule = schedule
        val pm: PaymentMethod = HoldMethod()
        val e = Employee(empId, name, address, pc, ps, pm)
        e.setClassification(pc)
        e.setSchedule(ps)
        e.setMethod(pm)
        PayrollDatabase.addEmployee(empId, e)
    }

    abstract val schedule: PaymentSchedule
    abstract val classification: PaymentClassification
}
