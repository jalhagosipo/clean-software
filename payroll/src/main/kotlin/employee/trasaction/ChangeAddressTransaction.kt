package employee.trasaction

import employee.Employee


class ChangeAddressTransaction(
        empId: Int,
        private val address: String
) : ChangeEmployeeTransaction(empId) {
    override fun change(e: Employee?) {
        e!!.address = address
    }
}