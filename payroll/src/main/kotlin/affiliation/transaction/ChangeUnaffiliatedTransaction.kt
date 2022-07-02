package affiliation.transaction

import affiliation.AbstractAffiliation


class ChangeUnaffiliatedTransaction constructor(
        empId: Int?
) : ChangeAffiliationTransaction(empId) {
    override val affiliation: AbstractAffiliation?
        get() = null
}