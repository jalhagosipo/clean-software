package method

import Paycheck


class DirectMethod(
        val bank: String,
        val account: String
) : PaymentMethod {

    override fun pay(pc: Paycheck) {
        pc.setField("Disposition", "Direct")
    }
}