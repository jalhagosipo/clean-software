package classification.transaction

import PayrollDatabase
import classification.SalesReceipt
import Transaction
import classification.CommissionedClassification
import employee.Employee
import java.util.*

class SalesReceiptTransaction(
        private val saleDate: Date,
        private val amount: Double,
        private val empId: Int
) : Transaction {

    override fun execute() {
        val e: Employee = PayrollDatabase.getEmployee(empId) ?: throw Exception("No such employee.")
        try {
            val cc: CommissionedClassification = e.pc as CommissionedClassification
            cc.addReceipt(SalesReceipt(saleDate, amount))
        } catch (e: Exception) {
            throw Exception("Tried to add sales receipt to non-commissioned employee")
        }
    }
}