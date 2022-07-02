package affiliation.transaction

import affiliation.AbstractAffiliation
import affiliation.UnionAffiliation


class ChangeMemberTransaction(
        empId: Int?,
        private val dues: Double
) : ChangeAffiliationTransaction(empId) {

    override val affiliation: AbstractAffiliation?
        get() = UnionAffiliation(dues)
}