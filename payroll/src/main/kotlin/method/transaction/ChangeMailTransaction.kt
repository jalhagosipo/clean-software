package method.transaction

import method.MailMethod
import method.PaymentMethod


class ChangeMailTransaction(
        empId: Int?,
        private val address: String
) : ChangeMethodTransaction(empId) {

    override val method: PaymentMethod
        get() = MailMethod(address)
}