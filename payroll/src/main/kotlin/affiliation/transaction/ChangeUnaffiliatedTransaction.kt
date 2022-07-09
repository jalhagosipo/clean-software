package affiliation.transaction

import PayrollDatabase
import affiliation.AbstractAffiliation
import affiliation.Affiliation
import affiliation.UnionAffiliation
import employee.Employee


class ChangeUnaffiliatedTransaction (
        empId: Int
) : ChangeAffiliationTransaction(empId) {
    override val affiliation: AbstractAffiliation
        get() = AbstractAffiliation.NONE

    override fun recordMembership(e: Employee?) {
        val a: AbstractAffiliation = e?.affiliation!!
        if(a is UnionAffiliation) {
            PayrollDatabase.removeUnionMember(a.memberId)
        }

    }
}