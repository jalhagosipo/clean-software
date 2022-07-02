package transaction

import employee.Employee


class ChangeNameTransaction(
        empId: Int,
        private val name: String
) : ChangeEmployeeTransaction(empId) {
    override fun change(e: Employee?) {
        e!!.setName(name)
    }
}