package employee.trasaction

import employee.Employee


class ChangeNameTransaction(
        empId: Int,
        private val name: String
) : ChangeEmployeeTransaction(empId) {
    override fun change(e: Employee?) {
        e!!.name = name
    }
}