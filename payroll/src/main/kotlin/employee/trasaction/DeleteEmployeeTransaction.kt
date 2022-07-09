package employee.trasaction

import PayrollDatabase
import Transaction

class DeleteEmployeeTransaction(
        private val empId: Int
) : Transaction {

    override fun execute() {
        PayrollDatabase.deleteEmployee(empId)
    }
}
