package classification

import Paycheck
import java.util.*
import kotlin.collections.HashMap

class CommissionedClassification(
        val salary: Double,
        val commissionRate: Double
) : PaymentClassification {
    private var itsReceipts: MutableMap<Date, SalesReceipt> = HashMap()

    fun getSalesReceipt(saleDate: Date): SalesReceipt? {
        return itsReceipts[saleDate]
    }

    fun addReceipt(receipt: SalesReceipt) {
        itsReceipts[receipt.saleDate] = receipt
    }

    override fun calculatePay(pc: Paycheck): Double {
        var commission = 0.0

        for (receiptMap in itsReceipts) {
            val receipt = receiptMap.value
            if (isInPayPeriod(receipt.saleDate, pc)) {
                commission += receipt.amount * commissionRate
            }
        }
        return salary + commission
    }
}
