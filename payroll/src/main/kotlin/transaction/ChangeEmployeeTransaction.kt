package transaction

import PayrollDatabase
import employee.Employee
import java.util.*


abstract class ChangeEmployeeTransaction(private val empId: Int) : Transaction {

    override fun execute() {
        val e: Employee = Optional.ofNullable(PayrollDatabase.getEmployee(empId))
                .orElseThrow { IllegalArgumentException("Not found employee : $empId") }
        change(e)
    }

    protected abstract fun change(e: Employee?)
}