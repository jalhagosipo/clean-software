package method

import Paycheck


class MailMethod(
    val address: String? = null
) : PaymentMethod {

    override fun pay(pc: Paycheck) {
        pc.setField("Disposition", "Mail")
    }
}