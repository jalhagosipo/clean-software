package method

import Paycheck


class HoldMethod : PaymentMethod {
    override fun pay(pc: Paycheck) {
        pc.setField("Disposition", "Hold")
    }
}