package affiliation.transaction

import PayrollDatabase
import affiliation.AbstractAffiliation
import affiliation.UnionAffiliation
import employee.Employee


class ChangeUnaffiliatedTransaction (
        empId: Int?
) : ChangeAffiliationTransaction(empId) {
    override val affiliation: AbstractAffiliation?
        get() = null

    override fun recordMembership(e: Employee?) {
        val ua: UnionAffiliation? = e?.getAffiliation(UnionAffiliation::class.java)
        if (ua != null) {
            val memberId = ua.memberId
            PayrollDatabase.removeUnionMember(memberId)
        }
    }
}