package method

import Paycheck

interface PaymentMethod {
    fun pay(pc: Paycheck)
}