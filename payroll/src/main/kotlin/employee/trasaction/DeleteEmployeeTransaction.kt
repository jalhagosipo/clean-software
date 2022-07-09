package employee.trasaction

import PayrollDatabase
import Transaction

class DeleteEmployeeTransaction(
        private val empId: Int
) : Transaction {

    companion object {
        private val payrollDatabase: PayrollDatabase = PayrollDatabase
    }

    override fun execute() {
        PayrollDatabase.deleteEmployee(empId)
    }
}
