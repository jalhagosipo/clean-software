package affiliation.transaction

import affiliation.AbstractAffiliation

import employee.Employee

import employee.trasaction.ChangeEmployeeTransaction


abstract class ChangeAffiliationTransaction(
        empId: Int
) : ChangeEmployeeTransaction(empId) {
    override fun change(e: Employee?) {
        e!!.affiliation = affiliation
    }

    abstract val affiliation: AbstractAffiliation
    abstract fun recordMembership(e: Employee?)
}