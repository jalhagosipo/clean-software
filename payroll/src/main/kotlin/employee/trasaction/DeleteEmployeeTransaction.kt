package employee.trasaction

import PayrollDatabase
import transaction.Transaction

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
