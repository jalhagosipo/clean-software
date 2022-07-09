package method.transaction

import method.HoldMethod
import method.PaymentMethod


class ChangeHoldTransaction constructor(
        empId: Int
) : ChangeMethodTransaction(empId) {
    override val method: PaymentMethod
        get() = HoldMethod()
}