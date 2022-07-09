package affiliation.transaction

import PayrollDatabase
import affiliation.AbstractAffiliation
import affiliation.UnionAffiliation
import employee.Employee


class ChangeMemberTransaction(
        empId: Int,
        var memberId: Int,
        private val dues: Double
) : ChangeAffiliationTransaction(empId) {

    override val affiliation: AbstractAffiliation
        get() = UnionAffiliation(memberId, dues)

    override fun recordMembership(e: Employee?) {
        PayrollDatabase.addUnionMember(memberId, e)
    }
}