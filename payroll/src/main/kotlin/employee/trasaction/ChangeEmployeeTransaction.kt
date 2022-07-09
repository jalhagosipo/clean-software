package employee.trasaction

import PayrollDatabase
import employee.Employee
import Transaction
import java.util.*


abstract class ChangeEmployeeTransaction(
        private val empId: Int
) : Transaction {

    override fun execute() {
        val e: Employee = PayrollDatabase.getEmployee(empId) ?:
            throw IllegalArgumentException("Not found employee : $empId")
        change(e)
    }

    abstract fun change(e: Employee?)
}