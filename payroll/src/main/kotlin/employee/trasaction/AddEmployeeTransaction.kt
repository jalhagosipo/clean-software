package employee.trasaction

import method.PaymentMethod
import schedule.PaymentSchedule
import PayrollDatabase
import classification.PaymentClassification
import employee.Employee
import method.HoldMethod
import Transaction

abstract class AddEmployeeTransaction (
    private val empId: Int,
    private val name: String,
    private val address: String,
) : Transaction {

    override fun execute() {
        val pc: PaymentClassification = classification
        val ps: PaymentSchedule = schedule
        val pm: PaymentMethod = HoldMethod()
        val e = Employee(empId, name, address, pc, ps, pm)
        e.pc = pc
        e.ps = ps
        e.pm = pm
        PayrollDatabase.addEmployee(empId, e)
    }

    abstract val schedule: PaymentSchedule
    abstract val classification: PaymentClassification
}
