package affiliation.transaction

import affiliation.AbstractAffiliation

import employee.Employee

import employee.trasaction.ChangeEmployeeTransaction


abstract class ChangeAffiliationTransaction(
        empId: Int?
) : ChangeEmployeeTransaction(empId!!) {
    override fun change(e: Employee?) {
        e!!.setAffiliation(affiliation)
    }

    abstract val affiliation: AbstractAffiliation?
}