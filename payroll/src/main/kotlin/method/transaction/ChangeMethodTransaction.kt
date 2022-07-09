package method.transaction

import employee.Employee

import employee.trasaction.ChangeEmployeeTransaction
import method.PaymentMethod


abstract class ChangeMethodTransaction(
        empId: Int
) : ChangeEmployeeTransaction(empId) {
    override fun change(e: Employee?) {
        e!!.pm = method
    }

    abstract val method: PaymentMethod
}