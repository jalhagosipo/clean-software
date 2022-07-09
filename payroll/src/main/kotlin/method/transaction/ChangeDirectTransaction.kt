package method.transaction

import method.DirectMethod
import method.PaymentMethod


class ChangeDirectTransaction(
        empId: Int,
        private val bank: String,
        private val account: String
) : ChangeMethodTransaction(empId) {

    override val method: PaymentMethod
        get() = DirectMethod(bank, account)
}